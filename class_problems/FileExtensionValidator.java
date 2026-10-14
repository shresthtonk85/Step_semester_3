public class FileExtensionValidator {

    // Accepts only pdf, docx, zip (case-insensitive)
    public static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');

        // No dot, or dot is the last character -> no usable extension
        if (dot == -1 || dot == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dot + 1);

        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }
        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF")); // Accepted
        System.out.println(validateFileExtension("notes.txt"));       // Rejected — invalid file type
    }
}
