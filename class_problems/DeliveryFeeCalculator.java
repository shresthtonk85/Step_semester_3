import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Base type: every delivery calculates its own fee
abstract class Delivery {
    protected final String type;
    protected final double weight;
    protected final double distance;

    Delivery(String type, double weight, double distance) {
        this.type = type;
        this.weight = weight;
        this.distance = distance;
    }

    abstract double calculateFee();

    String getType() {
        return type;
    }
}

class StandardDelivery extends Delivery {
    StandardDelivery(String type, double weight, double distance) { super(type, weight, distance); }

    @Override
    double calculateFee() { return 5 + 0.50 * weight + 0.10 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(String type, double weight, double distance) { super(type, weight, distance); }

    @Override
    double calculateFee() { return 15 + 1.00 * weight + 0.20 * distance; }
}

class InternationalDelivery extends Delivery {
    private final double customsFee;

    InternationalDelivery(String type, double weight, double distance, double customsFee) {
        super(type, weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee() { return 25 + 2.00 * weight + 0.50 * distance + customsFee; }
}

public class DeliveryFeeCalculator {

    // The only place the type string is inspected: object creation
    static Delivery create(String[] p) {
        String type = p[0].toUpperCase();
        double weight = Double.parseDouble(p[1]);
        double distance = Double.parseDouble(p[2]);

        switch (type) {
            case "STANDARD":      return new StandardDelivery(type, weight, distance);
            case "EXPRESS":       return new ExpressDelivery(type, weight, distance);
            case "INTERNATIONAL": return new InternationalDelivery(type, weight, distance, Double.parseDouble(p[3]));
            default: throw new IllegalArgumentException("Unknown delivery type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            deliveries.add(create(in.readLine().trim().split("\\s+")));
        }

        // Uniform processing: no type checks
        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            total += fee;
            System.out.println(String.format(Locale.US, "%s: %.2f", d.getType(), fee));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
