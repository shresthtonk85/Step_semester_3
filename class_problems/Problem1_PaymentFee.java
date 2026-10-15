import java.util.*;

abstract class Payment {
    protected double amount;
    Payment(double amount) { this.amount = amount; }
    abstract double finalAmount();
}

class CardPayment extends Payment {
    CardPayment(double a) { super(a); }
    double finalAmount() { return amount * 1.02; }   // 2% fee
}

class WalletPayment extends Payment {
    WalletPayment(double a) { super(a); }
    double finalAmount() { return amount * 1.01; }   // 1% fee
}

class BankTransferPayment extends Payment {
    BankTransferPayment(double a) { super(a); }
    double finalAmount() { return amount; }          // no fee
}

public class Problem1_PaymentFee {
    static Payment create(String type, double amt) {
        switch (type.toUpperCase()) {
            case "CARD":         return new CardPayment(amt);
            case "WALLET":       return new WalletPayment(amt);
            case "BANKTRANSFER": return new BankTransferPayment(amt);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> names = new ArrayList<>();
        List<Payment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double amt = sc.nextDouble();
            names.add(type);
            list.add(create(type, amt));
        }
        double total = 0;
        for (int i = 0; i < n; i++) {          // uniform processing, no type checks
            double v = list.get(i).finalAmount();
            total += v;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", v));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}
