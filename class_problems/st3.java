import java.util.Scanner;

public class st3 {
    public static void main(String[] args) {
        int n, digit, rev = 0;
        Scanner sc = new Scanner(System.in);  
        n = sc.nextInt();
        
        // Negative numbers are not palindromes
        if (n < 0) {
            System.out.println("it is not a palindrome number");
            return;
        }

        int original = n;
        while (n != 0) {
            digit = n % 10;
            rev = rev * 10 + digit;
            n = n / 10;
        }
        
        if (rev == original) {
            System.out.println("it is a palindrome number");
        } else {
            System.out.println("it is not a palindrome number");
        }
    }
}
