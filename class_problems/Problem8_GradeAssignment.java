import java.util.Scanner;

public class Problem8_GradeAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextDouble()) {
            double m = sc.nextDouble();
            String grade;
            if (m >= 90)      grade = "A";
            else if (m >= 75) grade = "B";
            else if (m >= 60) grade = "C";
            else if (m >= 40) grade = "D";
            else              grade = "F";
            System.out.println("Grade " + grade);
        }
    }
}
