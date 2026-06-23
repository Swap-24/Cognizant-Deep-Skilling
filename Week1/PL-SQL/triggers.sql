CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    :NEW.LastModified := SYSDATE;
END;
/

CREATE TABLE AuditLog(
    LogID NUMBER GENERATED ALWAYS AS IDENTITY,
    TransactionID NUMBER,
    LogDate DATE
);
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog(
        TransactionID,
        LogDate
    )
    VALUES(
        :NEW.TransactionID,
        SYSDATE
    );
END;
/

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = :NEW.AccountID;

    IF :NEW.TransactionType = 'Withdrawal'
       AND :NEW.Amount > v_balance THEN

       RAISE_APPLICATION_ERROR(
           -20002,
           'Withdrawal exceeds balance'
       );
    END IF;

    IF :NEW.TransactionType = 'Deposit'
       AND :NEW.Amount <= 0 THEN

       RAISE_APPLICATION_ERROR(
           -20003,
           'Deposit must be positive'
       );
    END IF;
END;
/