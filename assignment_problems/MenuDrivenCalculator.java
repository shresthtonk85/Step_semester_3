package main.java.week_3.assigment_problems;

import java.util.Scanner;

public class MenuDrivenCalculator {
    
    void calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                System.out.println("Result: " + (a + b));
                break;
            case '-':
                System.out.println("Result: " + (a - b));
                break;
            case '*':
                System.out.println("Result: " + (a * b));
                break;
            case '/':
                if (b == 0) {
                    System.out.println("Cannot divide by zero");
                } else {
                    System.out.println("Result: " + (a / b));
                }
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuDrivenCalculator calculator = new MenuDrivenCalculator();
        
        System.out.print("Enter first number (a): ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter second number (b): ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        
        calculator.calculate(a, b, operator);
        
        scanner.close();
    }
}