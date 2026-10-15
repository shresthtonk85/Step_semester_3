import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Base type: every employee calculates their own bonus
abstract class Employee {
    protected final String name;
    protected final double monthlySalary;

    Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    abstract double bonus();

    String getName() {
        return name;
    }
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name, double salary) { super(name, salary); }

    @Override
    double bonus() { return monthlySalary * 0.10; }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name, double salary) { super(name, salary); }

    @Override
    double bonus() { return monthlySalary * 0.05; }
}

class Intern extends Employee {
    Intern(String name, double salary) { super(name, salary); }

    @Override
    double bonus() { return 2000.0; } // fixed, regardless of salary
}

public class FestivalBonusCalculator {

    // The only place the type string is inspected: object creation
    static Employee create(String type, String name, double salary) {
        switch (type) {
            case "FULLTIME": return new FullTimeEmployee(name, salary);
            case "PARTTIME": return new PartTimeEmployee(name, salary);
            case "INTERN":   return new Intern(name, salary);
            default: throw new IllegalArgumentException("Unknown employee type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = in.readLine().trim().split("\\s+");
            employees.add(create(p[0].toUpperCase(), p[1], Double.parseDouble(p[2])));
        }

        // Uniform processing: no type checks
        double total = 0;
        for (Employee e : employees) {
            double result = e.bonus();
            total += result;
            System.out.println(String.format(Locale.US, "%s: %.2f", e.getName(), result));
        }
        System.out.println(String.format(Locale.US, "Total Bonus: %.2f", total));
    }
}
