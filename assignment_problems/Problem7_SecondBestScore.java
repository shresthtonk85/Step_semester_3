import java.util.*;

/*
 * Input format:
 *   n
 *   s1 s2 ... sn
 *
 * Complexity: O(n) time, O(1) space (one pass, two variables).
 * Sorting first would cost O(n log n) time (and O(n) space for some sorts), and it is not
 * allowed here. For n up to 1000 both are fast, but the single pass does less work and
 * leaves the input untouched.
 */
public class Problem7_SecondBestScore {

    static int secondHighest(int[] scores) {
        int highest = -1, second = -1;             // scores are >= 0, so -1 means "none yet"
        for (int s : scores) {
            if (s == highest) continue;            // skip duplicates of the current highest
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s > second) {               // s < highest and better than current second
                second = s;
            }
        }
        return second;                             // stays -1 if all scores are equal
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        System.out.println(secondHighest(scores));
    }
}
