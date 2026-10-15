import java.util.Arrays;

public class TopThreePodiumFinder {

    // Single left-to-right pass, no sorting; ties are kept (both 90s appear)
    static int[] findTopThreeScores(int[] scores) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score >= first) {
                third = second;   // shift everyone down one place
                second = first;
                first = score;
            } else if (score >= second) {
                third = second;
                second = score;
            } else if (score > third) {
                third = score;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findTopThreeScores(new int[]{45, 82, 79, 90, 33, 90, 61}))); // [90, 90, 82]
        System.out.println(Arrays.toString(findTopThreeScores(new int[]{10, 20, 30})));                 // [30, 20, 10]
    }
}
