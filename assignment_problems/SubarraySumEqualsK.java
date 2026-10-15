import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // Prefix sums + hash map of prefix-sum frequencies — O(n) time, O(n) space
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // base case: the empty prefix has sum 0

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // A subarray ending here sums to k if an earlier prefix equals (currentSum - k)
            count += prefixCount.getOrDefault(currentSum - k, 0);

            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));  // 2
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0)); // 3
    }
}
