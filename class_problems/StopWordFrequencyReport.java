import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StopWordFrequencyReport {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    private static boolean isStopWord(String word) {
        for (String stop : STOP_WORDS) {
            if (stop.equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void printFilteredWordFrequency(String feedback) {
        // Normalize: lowercase and strip punctuation
        String cleaned = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "");

        String[] words = cleaned.trim().split("\\s+");

        // Count every non-stop word
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty() || isStopWord(word)) {
                continue;
            }
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        // Sort entries by count, descending (ties in any order)
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
        // great: 2, then mentor / session / clear: 1 each
    }
}
