import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Base type: every customer calculates their own final amount
abstract class Customer {
    protected final String type;
    protected final double amount;

    Customer(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double finalAmount();

    String getType() {
        return type;
    }
}

class Student extends Customer {
    Student(String type, double amount) { super(type, amount); }

    @Override
    double finalAmount() { return amount * 0.90; } // 10% discount
}

class Staff extends Customer {
    Staff(String type, double amount) { super(type, amount); }

    @Override
    double finalAmount() { return amount * 0.95; } // 5% discount
}

class Guest extends Customer {
    Guest(String type, double amount) { super(type, amount); }

    @Override
    double finalAmount() { return amount + 10; } // full amount + service charge
}

public class CanteenBilling {

    // The only place the type string is inspected: object creation
    static Customer create(String type, double amount) {
        switch (type) {
            case "STUDENT": return new Student(type, amount);
            case "STAFF":   return new Staff(type, amount);
            case "GUEST":   return new Guest(type, amount);
            default: throw new IllegalArgumentException("Unknown customer type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        List<Customer> bills = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = in.readLine().trim().split("\\s+");
            bills.add(create(p[0].toUpperCase(), Double.parseDouble(p[1])));
        }

        // Uniform processing: no type checks
        double total = 0;
        for (Customer c : bills) {
            double result = c.finalAmount();
            total += result;
            System.out.println(String.format(Locale.US, "%s: %.2f", c.getType(), result));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
