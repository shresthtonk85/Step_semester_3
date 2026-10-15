public class Student {

    // Instance fields: each student has their own
    private String name;
    private int attendance;

    // Static fields: one shared copy for the whole class
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++; // increments exactly once per object created
    }

    // Static method: touches only static fields, never an instance field
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {
        new Student("Ravi", 92);
        new Student("Anitha", 88);

        Student.printCollegeInfo(); // called through the class name
    }
}
