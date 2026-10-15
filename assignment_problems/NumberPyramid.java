package main.java.week_3.assigment_problems;

public class NumberPyramid {
    void printNumberPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NumberPyramid pyramid = new NumberPyramid();
        pyramid.printNumberPyramid(4);
    }
}
