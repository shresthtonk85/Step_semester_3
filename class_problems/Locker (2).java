package week_7.class_problems;

public class Locker {
    private final int lockerNumber;
    private String combination;

    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (currentCode == null || newCode == null) {
            return false;
        }

        if (!currentCode.equals(combination)) {
            return false;
        }

        combination = newCode;
        return true;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        System.out.println(l.changeCode("1234", "5678"));
        System.out.println(l.changeCode("0000", "9999"));
    }
}
