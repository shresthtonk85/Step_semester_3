public class VowelConsonantCounter {

    // Counts vowels and consonants (case-insensitive), ignoring spaces
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                continue;
            }
            char lower = (c >= 'A' && c <= 'Z') ? (char) (c + 32) : c;
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels + " | Consonants: " + consonants);
    }

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming"); // Vowels: 5 | Consonants: 10
    }
}
