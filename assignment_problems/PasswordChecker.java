package week_7.assignment_problems;

public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        if (password == null) {
            return "Weak";
        }

        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker weak = new PasswordChecker("abcd");
        PasswordChecker medium = new PasswordChecker("abcdefgh");
        PasswordChecker strong = new PasswordChecker("abcdefghij");

        System.out.println(weak.getStrength());
        System.out.println(medium.getStrength());
        System.out.println(strong.getStrength());
    }
}
