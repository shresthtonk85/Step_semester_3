import java.util.Scanner;

public class Problem5_DigitSumReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long sum = 0, rev = 0;
        while (n > 0) {
            long digit = n % 10;
            sum += digit;
            rev = rev * 10 + digit;
            n /= 10;
        }
        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + rev);
    }
}
