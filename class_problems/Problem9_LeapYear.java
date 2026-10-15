import java.util.Scanner;

public class Problem9_LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int y = sc.nextInt();
            boolean leap = (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
            System.out.println(leap ? "Leap year" : "Not a leap year");
        }
    }
}
