import java.io.*;
import java.util.*;

// Capability: only some appliances have a saver mode
interface SaverMode {
    double SAVER_REDUCTION = 0.25;
}

abstract class Appliance {
    private static final double RATE_PER_UNIT = 8;
    protected final double hours;
    protected boolean saverOn = false;

    Appliance(double hours) { this.hours = hours; }

    protected abstract double powerWatts();

    void enableSaver() { saverOn = true; }          // only called after checking SaverMode

    double units() {
        double u = powerWatts() * hours / 1000.0;
        return saverOn ? u * (1 - SaverMode.SAVER_REDUCTION) : u;
    }

    double cost() { return units() * RATE_PER_UNIT; }
}

class Fridge extends Appliance {
    Fridge(double h) { super(h); }
    protected double powerWatts() { return 150; }
}

class AirConditioner extends Appliance implements SaverMode {
    AirConditioner(double h) { super(h); }
    protected double powerWatts() { return 1500; }
}

class Tv extends Appliance {
    Tv(double h) { super(h); }
    protected double powerWatts() { return 100; }
}

class WashingMachine extends Appliance implements SaverMode {
    WashingMachine(double h) { super(h); }
    protected double powerWatts() { return 500; }
}

public class Problem5_ApplianceEnergyReport {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        double total = 0;
        for (int i = 0; i < n; i++) {
            String[] t = br.readLine().trim().split("\\s+");
            String type = t[0].toUpperCase();
            double hours = Double.parseDouble(t[1]);
            boolean wantsSaver = t.length > 2 && t[2].equalsIgnoreCase("SAVER");

            Appliance a;
            switch (type) {
                case "FRIDGE": a = new Fridge(hours); break;
                case "AC":     a = new AirConditioner(hours); break;
                case "TV":     a = new Tv(hours); break;
                case "WASHER": a = new WashingMachine(hours); break;
                default: throw new IllegalArgumentException("Unknown appliance: " + type);
            }
            if (wantsSaver) {
                if (a instanceof SaverMode) {
                    a.enableSaver();
                } else {
                    System.out.println(type + ": saver mode not supported");
                    continue;
                }
            }
            total += a.cost();
            System.out.println(type + ": Units=" + f(a.units()) + " Cost=" + f(a.cost()));
        }
        System.out.println("Total Cost: " + f(total));
    }

    static String f(double d) { return String.format(Locale.US, "%.2f", d); }
}
