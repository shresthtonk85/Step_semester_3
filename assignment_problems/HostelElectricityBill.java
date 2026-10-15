import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Base type: every room calculates its own bill
abstract class Room {
    protected final String type;
    protected final int units;

    Room(String type, int units) {
        this.type = type;
        this.units = units;
    }

    abstract double bill();

    String getType() {
        return type;
    }
}

class SingleRoom extends Room {
    SingleRoom(String type, int units) { super(type, units); }

    @Override
    double bill() { return 8.0 * units; }
}

class SharedRoom extends Room {
    private final int occupants; // the one extra value this room type needs, stored here

    SharedRoom(String type, int units, int occupants) {
        super(type, units);
        this.occupants = occupants;
    }

    @Override
    double bill() { return (6.0 * units) / occupants; }
}

class AcRoom extends Room {
    AcRoom(String type, int units) { super(type, units); }

    @Override
    double bill() { return 10.0 * units + 200.0; }
}

public class HostelElectricityBill {

    // The only place the type string is inspected: object creation
    static Room create(String[] p) {
        String type = p[0].toUpperCase();
        int units = Integer.parseInt(p[1]);

        switch (type) {
            case "SINGLE": return new SingleRoom(type, units);
            case "SHARED": return new SharedRoom(type, units, Integer.parseInt(p[2]));
            case "AC":     return new AcRoom(type, units);
            default: throw new IllegalArgumentException("Unknown room type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rooms.add(create(in.readLine().trim().split("\\s+")));
        }

        // Uniform processing: no type checks
        double total = 0;
        for (Room r : rooms) {
            double result = r.bill();
            total += result;
            System.out.println(String.format(Locale.US, "%s: %.2f", r.getType(), result));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
