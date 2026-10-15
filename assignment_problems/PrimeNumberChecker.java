package main.java.week_3.assigment_problems;

public class PrimeNumberChecker {
    
    void checkPrime(int number) {
        boolean isPrime = true;
        
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        
        if (isPrime && number > 1) {
            System.out.println("Prime");
        } else {
            System.out.println("Not Prime");
        }
    }

    public static void main(String[] args) {
        PrimeNumberChecker checker = new PrimeNumberChecker();
        
        checker.checkPrime(17);
        checker.checkPrime(18);
    }
}
