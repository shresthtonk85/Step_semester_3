import java.io.*;
import java.util.*;

class Student {
    private final String name;
    private final int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double average() {
        int sum = 0;
        for (int m : marks) sum += m;
        return (double) sum / marks.length;
    }

    String grade() {
        double avg = average();
        if (avg >= 90)      return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else                return "F";
    }

    String report() {
        return name.toUpperCase() + ": Average " + String.format(Locale.US, "%.1f", average())
                + ", Grade " + grade();
    }
}

public class Problem10_ResultCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            int open = line.indexOf('[');
            String name = line.substring(0, open).trim();
            String[] parts = line.substring(open + 1, line.indexOf(']')).split(",");
            int[] marks = new int[parts.length];
            for (int i = 0; i < parts.length; i++) marks[i] = Integer.parseInt(parts[i].trim());
            System.out.println(new Student(name, marks).report());
        }
    }
}
