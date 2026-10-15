import java.util.*;

abstract class Delivery {
    protected double weight, distance;
    Delivery(double w, double d) { weight = w; distance = d; }
    abstract double fee();
}

class StandardDelivery extends Delivery {
    StandardDelivery(double w, double d) { super(w, d); }
    double fee() { return 5 + 0.50 * weight + 0.10 * distance; }
}

class ExpressDelivery extends Delivery {
    ExpressDelivery(double w, double d) { super(w, d); }
    double fee() { return 15 + 1.00 * weight + 0.20 * distance; }
}

class InternationalDelivery extends Delivery {
    private double customs;
    InternationalDelivery(double w, double d, double c) { super(w, d); customs = c; }
    double fee() { return 25 + 2.00 * weight + 0.50 * distance + customs; }
}

public class Problem3_DeliveryFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> names = new ArrayList<>();
        List<Delivery> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double w = sc.nextDouble(), d = sc.nextDouble();
            switch (type) {
                case "STANDARD":      list.add(new StandardDelivery(w, d)); break;
                case "EXPRESS":       list.add(new ExpressDelivery(w, d)); break;
                case "INTERNATIONAL": list.add(new InternationalDelivery(w, d, sc.nextDouble())); break;
                default: throw new IllegalArgumentException("Unknown type: " + type);
            }
            names.add(type);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double f = list.get(i).fee();
            total += f;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", f));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}
