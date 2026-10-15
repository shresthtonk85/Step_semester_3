public class Employee {

    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    // Permanent employee: salary known from day one
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Intern: chains to the constructor above with salary 0, then flips isIntern
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }

    public static void main(String[] args) {
        Employee permanent = new Employee("E-101", "Divya", 65000);
        Employee intern = new Employee("E-102", "Arjun");

        permanent.printProfile(); // E-101 | Divya | Rs 65000.0 | Intern: false
        intern.printProfile();    // E-102 | Arjun | Rs 0.0 | Intern: true
    }
}
