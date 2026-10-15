import java.util.Scanner;

public class Problem6_PrimeChecker {
    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long n = sc.nextLong();
            System.out.println(n + (isPrime(n) ? " is prime" : " is not prime"));
        }
    }
}
