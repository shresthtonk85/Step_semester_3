public class TypingAccuracyChecker {

    // Compares two equal-length strings position by position
    public static void checkTypingAccuracy(String original, String typed) {
        int total = original.length();
        int matched = 0;
        int firstMismatchIndex = -1; // -1 means no mismatch found yet

        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchIndex == -1) {
                firstMismatchIndex = i;
            }
        }

        double accuracy = (matched * 100.0) / total;

        if (firstMismatchIndex == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, total, accuracy);
        } else {
            // Reported as a 1-based position, matching the sample ("position 11")
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, total, accuracy, firstMismatchIndex + 1,
                    original.charAt(firstMismatchIndex), typed.charAt(firstMismatchIndex));
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
