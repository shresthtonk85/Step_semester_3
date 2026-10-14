public class Question4 {
    public static String normalizeCode(String raw) {
        String code = raw.trim().replace(" ", "");
        return code;
    }

    public static String validateAndFormat(String code) {
        String normalized = normalizeCode(code);

        if (normalized.length() != 13) {
            return "Invalid";
        }

        if (!Character.isLetter(normalized.charAt(0)) || !Character.isLetter(normalized.charAt(1)) || !Character.isLetter(normalized.charAt(2))) {
            return "Invalid";
        }

        for (int i = 3; i < normalized.length(); i++) {
            if (!Character.isDigit(normalized.charAt(i))) {
                return "Invalid";
            }
        }

        return "[" + normalized.substring(0, 3).toUpperCase() + "] YEAR: " + normalized.substring(3, 7) + " | CATALOG: " + normalized.substring(7);
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(" pen2026004251 "));
    }
}
