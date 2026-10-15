public class MatchDayGridAnalyzer {

    // Only job: compute one match's average (rows may have different lengths)
    private static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }
        return (double) sum / row.length;
    }

    // The outer loop alone decides Power Surge vs Normal; rowAverage is called once per match
    static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);
            String label = (average >= threshold) ? "Power Surge" : "Normal";

            if (i > 0) {
                result.append(" | ");
            }
            result.append("Match ").append(i).append(": ").append(label);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        System.out.println(classifyMatches(grid, 8));
        // Match 0: Normal | Match 1: Power Surge | Match 2: Normal

        int[][] jagged = {{9, 9}, {5}, {10, 8, 9, 7}};
        System.out.println(classifyMatches(jagged, 8));
    }
}
