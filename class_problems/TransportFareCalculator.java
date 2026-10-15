import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Base type: every transport mode calculates its own fare
abstract class Transport {
    protected final String type;
    protected final double distance;

    Transport(String type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    abstract double calculateFare();

    String getType() {
        return type;
    }
}

class Bus extends Transport {
    Bus(String type, double distance) { super(type, distance); }

    @Override
    double calculateFare() { return Math.min(2 + 0.10 * distance, 10); } // capped at $10
}

class Train extends Transport {
    Train(String type, double distance) { super(type, distance); }

    @Override
    double calculateFare() { return 3 + 0.15 * distance; }
}

class Metro extends Transport {
    private final double peakHourFactor;

    Metro(String type, double distance, double peakHourFactor) {
        super(type, distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    double calculateFare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
}

public class TransportFareCalculator {

    // The only place the type string is inspected: object creation
    static Transport create(String[] p) {
        String type = p[0].toUpperCase();
        double distance = Double.parseDouble(p[1]);

        switch (type) {
            case "BUS":   return new Bus(type, distance);
            case "TRAIN": return new Train(type, distance);
            case "METRO": return new Metro(type, distance, Double.parseDouble(p[2]));
            default: throw new IllegalArgumentException("Unknown transport type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        List<Transport> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            journeys.add(create(in.readLine().trim().split("\\s+")));
        }

        // Uniform processing: no type checks
        double total = 0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            total += fare;
            System.out.println(String.format(Locale.US, "%s: %.2f", t.getType(), fare));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
