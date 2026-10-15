public class Course {

    private String code;
    private String title;
    private int credits;
    private int labCredits;

    // Full constructor: sets all four fields directly
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Theory-only: chains to the four-argument constructor with labCredits = 0
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }

    String getCode() {
        return code;
    }

    public static void main(String[] args) {
        Course theory = new Course("21CSC201J", "Data Structures", 4);
        Course lab = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theory.getCode() + " total credits: " + theory.totalCredits()); // 4
        System.out.println(lab.getCode() + " total credits: " + lab.totalCredits());       // 4
    }
}
