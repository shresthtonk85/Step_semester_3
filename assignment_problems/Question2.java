public class Question2 {
    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word);
            result.append(reversedWord.reverse());
            result.append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }
}
