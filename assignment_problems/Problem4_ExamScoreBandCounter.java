import java.util.*;

/*
 * Input format:
 *   n
 *   s1 s2 ... sn      (sorted ascending)
 *   low high
 *
 * Complexity
 *   Linear scan : O(n) time, O(1) space.
 *   Binary search (this solution): O(log n) time, O(1) space.
 *
 * Duplicates: an ordinary binary search stops at ANY match, which could be the middle of a
 * run of equal scores. The answer needs the FIRST index with score >= low and the FIRST index
 * with score > high, so the search keeps narrowing even after finding a match
 * (lowerBound / upperBound). The count is the difference of the two positions.
 */
public class Problem4_ExamScoreBandCounter {

    // first index whose value is >= target (n if none)
    static int firstAtLeast(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= target) hi = mid;      // keep looking left, even on a match
            else lo = mid + 1;
        }
        return lo;
    }

    // first index whose value is > target (n if none)
    static int firstGreaterThan(int[] a, int target) {
        int lo = 0, hi = a.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    static int countInBand(int[] scores, int low, int high) {
        return firstGreaterThan(scores, high) - firstAtLeast(scores, low);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        int low = sc.nextInt(), high = sc.nextInt();
        System.out.println(countInBand(scores, low, high));
    }
}
