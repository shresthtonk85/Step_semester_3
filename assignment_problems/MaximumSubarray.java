public class MaximumSubarray {

    // Kadane's algorithm — O(n) time, O(1) space
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0]; // best sum of a subarray ending at the current index
        int best = nums[0];       // best sum seen anywhere so far

        for (int i = 1; i < nums.length; i++) {
            // Extend the running subarray, or abandon it and restart at nums[i]
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            best = Math.max(best, currentSum);
        }

        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
        System.out.println(maxSubArray(new int[]{-3, -1, -2}));                    // -1
    }
}
