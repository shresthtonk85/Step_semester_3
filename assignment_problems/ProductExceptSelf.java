import java.util.Arrays;

public class ProductExceptSelf {

    // O(n) time, no division: forward pass = product of everything to the left,
    // backward pass multiplies in the product of everything to the right
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1]; // product of all elements left of i
        }

        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;  // multiply in product of all elements right of i
            rightProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));      // [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3}))); // [0, 0, 9, 0, 0]
    }
}
