import java.util.*;

/*
 * Input format:
 *   n
 *   d1 d2 ... dn   (each 0 or 1)
 *
 * Complexity: O(n) time, O(1) extra space.
 * Yes, both answers come from a single pass: count every 1, and keep a running streak that
 * grows on 1 and resets on 0, remembering the largest value it reaches.
 */
public class Problem6_AttendanceTracker {

    static int[] attendanceSummary(int[] days) {
        int present = 0, streak = 0, longest = 0;
        for (int d : days) {
            if (d == 1) {
                present++;
                streak++;
                if (streak > longest) longest = streak;
            } else {
                streak = 0;
            }
        }
        return new int[]{present, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] days = new int[n];
        for (int i = 0; i < n; i++) days[i] = sc.nextInt();
        int[] r = attendanceSummary(days);
        System.out.println("Present: " + r[0] + ", Longest streak: " + r[1]);
    }
}
