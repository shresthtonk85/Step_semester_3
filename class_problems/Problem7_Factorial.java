import java.math.BigInteger;
import java.util.Scanner;

public class Problem7_Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            BigInteger result = BigInteger.ONE;          // 0! = 1 handled naturally
            for (int i = 2; i <= n; i++) result = result.multiply(BigInteger.valueOf(i));
            System.out.println(result);
        }
    }
}
