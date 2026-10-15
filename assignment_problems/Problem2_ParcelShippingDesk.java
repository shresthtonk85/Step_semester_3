import java.util.*;

// Capability: only parcels that implement this can be insured
interface Insurable {
    double insurance();
}

abstract class Parcel {
    protected final double weight, declaredValue;
    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }
    abstract double charge();                       // every parcel answers this
}

class StandardParcel extends Parcel {               // NOT insurable
    StandardParcel(double w, double v) { super(w, v); }
    double charge() { return 40 + 10 * weight; }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double w, double v) { super(w, v); }
    double charge() { return 80 + 15 * weight; }
    public double insurance() { return 0.02 * declaredValue; }
}

class FragileParcel extends StandardParcel implements Insurable {
    FragileParcel(double w, double v) { super(w, v); }
    double charge() { return super.charge() + 50; } // standard charge + handling fee
    public double insurance() { return 0.02 * declaredValue; }
}

public class Problem2_ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grand = 0;
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double w = sc.nextDouble(), v = sc.nextDouble();
            Parcel p;
            switch (type) {
                case "STANDARD": p = new StandardParcel(w, v); break;
                case "EXPRESS":  p = new ExpressParcel(w, v); break;
                case "FRAGILE":  p = new FragileParcel(w, v); break;
                default: throw new IllegalArgumentException("Unknown type: " + type);
            }
            double charge = p.charge();
            double ins = (p instanceof Insurable) ? ((Insurable) p).insurance() : 0;
            double total = charge + ins;
            grand += total;
            System.out.println(type + ": Charge=" + f(charge) + " Insurance=" + f(ins) + " Total=" + f(total));
        }
        System.out.println("Grand Total: " + f(grand));
    }

    static String f(double d) { return String.format(Locale.US, "%.2f", d); }
}
