import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Base type: every vehicle calculates its own parking charge
abstract class Vehicle {
    protected final String type;
    protected final int hours;

    Vehicle(String type, int hours) {
        this.type = type;
        this.hours = hours;
    }

    abstract double charge();

    String getType() {
        return type;
    }
}

class Bike extends Vehicle {
    Bike(String type, int hours) { super(type, hours); }

    @Override
    double charge() { return 10.0 * hours; }
}

class Car extends Vehicle {
    Car(String type, int hours) { super(type, hours); }

    @Override
    double charge() { return 30.0 + 20.0 * Math.max(0, hours - 1); }
}

class Truck extends Vehicle {
    Truck(String type, int hours) { super(type, hours); }

    @Override
    double charge() { return Math.max(50.0 * hours, 100.0); }
}

public class ParkingChargeCalculator {

    // The only place the type string is inspected: object creation
    static Vehicle create(String type, int hours) {
        switch (type) {
            case "BIKE":  return new Bike(type, hours);
            case "CAR":   return new Car(type, hours);
            case "TRUCK": return new Truck(type, hours);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] p = in.readLine().trim().split("\\s+");
            vehicles.add(create(p[0].toUpperCase(), Integer.parseInt(p[1])));
        }

        // Uniform processing: no type checks
        double total = 0;
        for (Vehicle v : vehicles) {
            double result = v.charge();
            total += result;
            System.out.println(String.format(Locale.US, "%s: %.2f", v.getType(), result));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
