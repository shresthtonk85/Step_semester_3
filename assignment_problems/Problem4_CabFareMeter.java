import java.util.*;

// Capability: only some cabs can run at night
interface NightService {
    double NIGHT_SURCHARGE = 0.20;
    default double applyNight(double fare) { return fare * (1 + NIGHT_SURCHARGE); }
}

abstract class Cab {
    private static final double MIN_FARE = 100;     // shared rule, written once
    protected abstract double ratePerKm();

    final double fare(double km) { return Math.max(MIN_FARE, km * ratePerKm()); }
}

class MiniCab extends Cab {                         // no night service
    protected double ratePerKm() { return 10; }
}

class SedanCab extends Cab implements NightService {
    protected double ratePerKm() { return 14; }
}

class SuvCab extends Cab implements NightService {
    protected double ratePerKm() { return 18; }
}

public class Problem4_CabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double km = sc.nextDouble();
            String time = sc.next().toUpperCase();
            Cab cab;
            switch (type) {
                case "MINI":  cab = new MiniCab(); break;
                case "SEDAN": cab = new SedanCab(); break;
                case "SUV":   cab = new SuvCab(); break;
                default: throw new IllegalArgumentException("Unknown cab: " + type);
            }
            double fare = cab.fare(km);
            if (time.equals("NIGHT")) {
                if (cab instanceof NightService) {
                    fare = ((NightService) cab).applyNight(fare);   // after minimum fare
                } else {
                    System.out.println(type + ": night service not available");
                    continue;
                }
            }
            total += fare;
            System.out.println(type + ": " + String.format(Locale.US, "%.2f", fare));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}
