public class IsbnNormalizerValidator {

    // Trim spaces, then uppercase only the first 3 characters (substring + concatenation)
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    // Validates length, publisher letters, then digit body; returns formatted line or the reason
    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: year and catalog number must be digits";
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(code.substring(0, 3)).append("] YEAR: ")
          .append(code.substring(3, 7))
          .append(" | CATALOG: ").append(code.substring(7));
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] inputs = {" pen2026004251 ", "12N2026004251"};
        for (String raw : inputs) {
            System.out.println(validateAndFormat(normalizeCode(raw)));
        }
    }
}
