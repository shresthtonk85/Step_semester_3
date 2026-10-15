import java.util.*;

/*
 * Input format:
 *   r c
 *   r lines of c integers each
 *
 * Complexity: O(r * c) time (every cell is visited once), O(1) additional space.
 * The best row is replaced only when a total is strictly larger, so ties keep the
 * smaller index.
 */
public class Problem10_BusiestBusRow {

    static int[] busiestRow(int[][] grid) {
        int bestRow = 0, bestTotal = -1;
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < grid[i].length; j++) total += grid[i][j];
            if (total > bestTotal) {               // strictly larger only
                bestTotal = total;
                bestRow = i;
            }
        }
        return new int[]{bestRow, bestTotal};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) grid[i][j] = sc.nextInt();
        int[] res = busiestRow(grid);
        System.out.println("Row " + res[0] + ", Total " + res[1]);
    }
}
