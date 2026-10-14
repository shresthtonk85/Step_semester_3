public class MaskedPhoneFormatter {

    // Returns XXXXXX-<last 4 digits>, or an error message if not exactly 10 digits
    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }
        for (int i = 0; i < phone.length(); i++) {
            char c = phone.charAt(i);
            if (c < '0' || c > '9') {
                return "Invalid phone number";
            }
        }

        StringBuilder sb = new StringBuilder(phone.substring(6)); // last 4 digits
        sb.insert(0, "-");
        sb.insert(0, "XXXXXX");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210")); // XXXXXX-3210
        System.out.println(maskPhoneNumber("98765"));      // Invalid phone number
    }
}
