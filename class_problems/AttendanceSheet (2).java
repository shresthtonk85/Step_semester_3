package week_7.class_problems;

public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxStudents) {
        if (maxStudents <= 0) {
            throw new IllegalArgumentException("Class size must be greater than 0.");
        }
        this.presentStudents = new String[maxStudents];
    }

    public void markPresent(String studentName) {
        if (studentName == null || isPresent(studentName) || count >= presentStudents.length) {
            return;
        }
        presentStudents[count] = studentName;
        count++;
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String studentName) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equals(studentName)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
    }
}
