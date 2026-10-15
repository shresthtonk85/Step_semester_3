public class FindMinRotatedArray {

    // Modified binary search — O(log n)
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;  // minimum is in the right half (mid itself can't be it)
            } else {
                right = mid;     // minimum is at mid or in the left half
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));       // 1
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // 0
        System.out.println(findMin(new int[]{11, 13, 15, 17}));      // 11 (no rotation)
        System.out.println(findMin(new int[]{7}));                   // 7 (single element)
    }
}
