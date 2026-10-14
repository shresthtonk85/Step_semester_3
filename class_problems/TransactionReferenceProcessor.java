public class TransactionReferenceProcessor {

    // Trim spaces, then uppercase only the first 3 characters (substring + concatenation)
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    // Validates length, bank code letters, and digit body; returns formatted line or the reason
    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: date and sequence must be digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);   // ddMMyy
        String seq = reference.substring(9);       // 5 digits

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(date.substring(0, 2)).append("/")
          .append(date.substring(2, 4)).append("/")
          .append(date.substring(4, 6))
          .append(" | SEQ: ").append(seq);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] inputs = {" hdf03022600042 ", "12F03022600042"};
        for (String raw : inputs) {
            String normalized = normalizeReference(raw);
            System.out.println(validateAndFormat(normalized));
        }
    }
}
