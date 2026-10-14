import java.util.Random;

public class BmiCalculator {

    // Classifies a BMI value into a health status
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Prints the full wellness table for the team
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.printf("%-10s%-14s%-14s%-10s%-15s%n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10s%-14.2f%-14.1f%-10.2f%-15s%n",
                    "Person " + (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];

        Random rng = new Random();
        for (int i = 0; i < teamSize; i++) {
            heights[i] = 1.50 + rng.nextDouble() * (2.00 - 1.50); // 1.50m to 2.00m
            weights[i] = 45 + rng.nextDouble() * (110 - 45);      // 45kg to 110kg
        }

        printWellnessReport(heights, weights);
    }
}
