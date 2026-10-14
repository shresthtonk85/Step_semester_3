public class MovieReviewWordLengthProfiler {

    // Splits the review into words and classifies each by length
    public static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");

        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            int length = word.length();
            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else { // 9+
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
        // Short: 3 | Medium: 1 | Long: 3
    }
}
