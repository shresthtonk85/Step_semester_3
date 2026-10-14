import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    // Returns the first character with frequency exactly 1, or '\0' if none exists
    public static char findFirstNonRepeatingChar(String text) {
        Map<java.lang.Character, Integer> frequency = new LinkedHashMap<>();

        // Count how often each character appears
        for (char c : text.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }

        // Scan left to right, stop at the first character seen exactly once
        for (char c : text.toCharArray()) {
            if (frequency.get(c) == 1) {
                return c;
            }
        }

        return '\0'; // sentinel meaning "not found"
    }

    private static void printResult(String input) {
        char result = findFirstNonRepeatingChar(input);
        if (result == '\0') {
            System.out.println("\"" + input + "\" -> No Non-Repeating Character Found");
        } else {
            System.out.println("\"" + input + "\" -> First Non-Repeating Character: '" + result + "'");
        }
    }

    public static void main(String[] args) {
        printResult("swiss");
        printResult("aabbcc");
    }
}
