class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int id, String name,
                    String position, double salary) {
        this.employeeId = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return employeeId + " - " + name + " (" + position + "), Salary: " + salary;
    }
}
