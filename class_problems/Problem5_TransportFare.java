import java.util.*;

abstract class Journey {
    protected double distance;
    Journey(double d) { distance = d; }
    abstract double fare();
}

class BusJourney extends Journey {
    BusJourney(double d) { super(d); }
    double fare() { return Math.min(10.0, 2 + 0.10 * distance); }   // capped at $10
}

class TrainJourney extends Journey {
    TrainJourney(double d) { super(d); }
    double fare() { return 3 + 0.15 * distance; }
}

class MetroJourney extends Journey {
    private double peak;
    MetroJourney(double d, double p) { super(d); peak = p; }
    double fare() { return (1.50 + 0.20 * distance) * peak; }
}

public class Problem5_TransportFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> names = new ArrayList<>();
        List<Journey> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double d = sc.nextDouble();
            switch (type) {
                case "BUS":   list.add(new BusJourney(d)); break;
                case "TRAIN": list.add(new TrainJourney(d)); break;
                case "METRO": list.add(new MetroJourney(d, sc.nextDouble())); break;
                default: throw new IllegalArgumentException("Unknown type: " + type);
            }
            names.add(type);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = list.get(i).fare();
            total += f;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}
