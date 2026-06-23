CREATE OR REPLACE FUNCTION CalculateAge(
    p_dob DATE
)
RETURN NUMBER
IS
BEGIN
    RETURN FLOOR(
        MONTHS_BETWEEN(SYSDATE,p_dob)/12
    );
END;
/

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan NUMBER,
    p_rate NUMBER,
    p_years NUMBER
)
RETURN NUMBER
IS
    v_monthly NUMBER;
BEGIN
    v_monthly :=
      (p_loan * (p_rate/1200)) /
      (1 - POWER(1 + (p_rate/1200),
      -(p_years*12)));

    RETURN ROUND(v_monthly,2);
END;
/

CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_accountid NUMBER,
    p_amount NUMBER
)
RETURN BOOLEAN
IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_accountid;

    RETURN v_balance >= p_amount;
END;
/