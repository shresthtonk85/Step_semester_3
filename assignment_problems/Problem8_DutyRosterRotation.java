import java.util.*;

/*
 * Input format:
 *   n
 *   name1 name2 ... namen
 *   k
 *
 * Complexity: O(n) time, O(n) extra space for the result array
 * (the value of k does not matter, because k % n is used).
 *
 * Why rotating one place at a time, k times, is slow: each single rotation touches all n
 * names, so the total work is O(n * k). With k up to 10^9 and n up to 100 that is about
 * 10^11 operations. But rotating by n places returns the roster to where it started, so
 * only k % n (less than n) places ever matter.
 */
public class Problem8_DutyRosterRotation {

    static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        int shift = (int) (k % n);
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[(i + shift) % n] = names[i];    // name at i moves to (i + k) % n
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = sc.next();
        long k = sc.nextLong();
        System.out.println(Arrays.toString(rotateRoster(names, k)));
    }
}
