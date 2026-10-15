import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // Sort, then for each element run two pointers inward — O(n^2), duplicates skipped at every level
    public static int[][] threeSum(int[] nums) {
        int[] sorted = nums.clone(); // don't mutate the caller's array
        Arrays.sort(sorted);
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < sorted.length - 2; i++) {
            if (sorted[i] > 0) {
                break; // smallest value already positive -> no triplet can reach 0
            }
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue; // skip duplicate first element
            }

            int left = i + 1, right = sorted.length - 1;
            while (left < right) {
                int sum = sorted[i] + sorted[left] + sorted[right];

                if (sum == 0) {
                    result.add(new int[]{sorted[i], sorted[left], sorted[right]});
                    left++;
                    right--;
                    while (left < right && sorted[left] == sorted[left - 1]) {
                        left++;   // skip duplicate second element
                    }
                    while (left < right && sorted[right] == sorted[right + 1]) {
                        right--;  // skip duplicate third element
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(threeSum(new int[]{-1, 0, 1, 2, -1, -4}))); // [[-1, -1, 2], [-1, 0, 1]]
        System.out.println(Arrays.deepToString(threeSum(new int[]{0, 0, 0})));             // [[0, 0, 0]]
        System.out.println(Arrays.deepToString(threeSum(new int[]{-2, 0, 0, 2, 2})));      // [[-2, 0, 2]]
    }
}
