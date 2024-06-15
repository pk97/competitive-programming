package interview;

public class Transaction {
    private final String department;
    private final String employeeName;
    private final int salary;

    Transaction(String department, String employeeName, int salary) {
        this.department = department;
        this.employeeName = employeeName;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getSalary() {
        return salary;
    }
}