public class SeatingGridOptimizer {

    // Only job: compute one row's average (works for jagged rows of any length)
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return (double) sum / row.length;
    }

    // The outer loop alone decides Quiet vs Buzzing; rowAverage is called once per row
    static String classifyRows(int[][] seatingScores, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            double average = rowAverage(seatingScores[i]);
            String zone = (average < threshold) ? "Quiet Zone" : "Buzzing Zone";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Row ").append(i).append(": ").append(zone);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        System.out.println(classifyRows(grid, 60));
        // Row 0: Quiet Zone | Row 1: Buzzing Zone | Row 2: Quiet Zone

        int[][] jagged = {{80}, {10, 20}, {70, 90, 60, 100}};
        System.out.println(classifyRows(jagged, 60));
    }
}
