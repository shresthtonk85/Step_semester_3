public class ReverseCustomerName {

    // Returns the reversed name; the original string passed in is never modified
    // (Java Strings are immutable, so this is guaranteed automatically)
    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        String customerName = "Sunil";
        String reversed = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversed);
    }
}
