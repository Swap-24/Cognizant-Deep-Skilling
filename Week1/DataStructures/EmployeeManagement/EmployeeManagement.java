
public class EmployeeManagement {

    private Employee[] employees = new Employee[100];
    private int count = 0;

    public void addEmployee(Employee emp) {
        employees[count++] = emp;
    }

    public Employee searchEmployee(int id) {

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id)
                return employees[i];
        }
        return null;
    }

    public void traverseEmployees() {

        for (int i = 0; i < count; i++) {
            System.out.println(employees[i].name);
        }
    }

    public void deleteEmployee(int id) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == id) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                count--;
                break;
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();

        management.addEmployee(new Employee(1, "Alice", "Developer", 60000));
        management.addEmployee(new Employee(2, "Bob", "Tester", 50000));
        management.addEmployee(new Employee(3, "Charlie", "Manager", 75000));

        System.out.println("All employees:");
        management.traverseEmployees();

        System.out.println("\nSearch result:");
        System.out.println(management.searchEmployee(2));

        management.deleteEmployee(1);

        System.out.println("\nAfter deleting employee 1:");
        management.traverseEmployees();
    }
}
