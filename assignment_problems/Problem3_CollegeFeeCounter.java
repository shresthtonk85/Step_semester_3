import java.io.*;
import java.util.*;

// Capability: students who use the college bus
interface BusUser {
    double TRANSPORT_FEE = 12000;                   // kept in one place
}

abstract class Student {
    protected final String name;
    Student(String name) { this.name = name; }

    abstract double tuition();

    String getName() { return name; }

    double totalFee() {
        double fee = tuition();
        if (this instanceof BusUser) fee += BusUser.TRANSPORT_FEE;
        return fee;
    }
}

class DayScholar extends Student implements BusUser {
    DayScholar(String n) { super(n); }
    double tuition() { return 40000; }
}

class Hosteller extends Student {                   // lives on campus: no bus
    Hosteller(String n) { super(n); }
    double tuition() { return 40000 + 60000; }      // tuition + hostel fee
}

class ScholarshipStudent extends Student implements BusUser {
    ScholarshipStudent(String n) { super(n); }
    double tuition() { return 40000 / 2.0; }
}

public class Problem3_CollegeFeeCounter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            int sp = line.indexOf(' ');
            String type = line.substring(0, sp).toUpperCase();
            String name = line.substring(sp + 1).trim();
            switch (type) {
                case "DAY_SCHOLAR": students.add(new DayScholar(name)); break;
                case "HOSTELLER":   students.add(new Hosteller(name)); break;
                case "SCHOLAR":     students.add(new ScholarshipStudent(name)); break;
                default: throw new IllegalArgumentException("Unknown type: " + type);
            }
        }
        double total = 0;
        for (Student s : students) {
            double fee = s.totalFee();
            total += fee;
            System.out.println(s.getName() + ": " + String.format(Locale.US, "%.2f", fee));
        }
        System.out.println("Total Collected: " + String.format(Locale.US, "%.2f", total));
    }
}
