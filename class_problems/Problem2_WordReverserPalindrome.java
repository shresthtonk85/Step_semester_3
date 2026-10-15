import java.util.Scanner;

public class Problem2_WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {                       // handles one or many words
            String word = sc.next();
            String reversed = new StringBuilder(word).reverse().toString();
            boolean pal = word.equalsIgnoreCase(reversed);   // case-insensitive check
            System.out.println(reversed + " - " + (pal ? "palindrome" : "not a palindrome"));
        }
    }
}
