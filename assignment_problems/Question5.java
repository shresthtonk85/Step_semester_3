import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Question5 {
    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        Map<String, Integer> wordCount = new HashMap<>();

        String cleaned = feedback.toLowerCase().replaceAll("[.,]", "");
        String[] words = cleaned.split("\\s+");

        for (String word : words) {
            if (Arrays.asList(stopWords).contains(word)) {
                continue;
            }

            if (word.isEmpty()) {
                continue;
            }

            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        wordCount.entrySet()
            .stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {
        String feedback = "The mentor was great, the session was great and clear.";
        printFilteredWordFrequency(feedback);
    }
}
