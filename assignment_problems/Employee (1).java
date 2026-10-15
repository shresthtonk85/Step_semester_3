public class Employee {

    // Instance fields: each employee has their own
    private String empName;
    private double salary;

    // Static fields: one shared copy for the whole class
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++; // increments exactly once per object created
    }

    // Static method: touches only static fields, never an instance field
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new Employee("Divya", 65000);
        new Employee("Arjun", 30000);
        new Employee("Meera", 48000);

        Employee.printCompanyInfo(); // called through the class name
    }
}
