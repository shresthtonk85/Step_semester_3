import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Base type: every payment can compute its own final amount
abstract class Payment {
    protected final String type;
    protected final double amount;

    Payment(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    abstract double finalAmount();

    String getType() {
        return type;
    }
}

class CardPayment extends Payment {
    CardPayment(String type, double amount) { super(type, amount); }

    @Override
    double finalAmount() { return amount * 1.02; } // 2% fee
}

class WalletPayment extends Payment {
    WalletPayment(String type, double amount) { super(type, amount); }

    @Override
    double finalAmount() { return amount * 1.01; } // 1% fee
}

class BankTransferPayment extends Payment {
    BankTransferPayment(String type, double amount) { super(type, amount); }

    @Override
    double finalAmount() { return amount; } // no fee
}

public class PaymentProcessor {

    // The only place the type string is inspected: object creation
    static Payment create(String type, double amount) {
        switch (type) {
            case "CARD":         return new CardPayment(type, amount);
            case "WALLET":       return new WalletPayment(type, amount);
            case "BANKTRANSFER": return new BankTransferPayment(type, amount);
            default: throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        List<Payment> payments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = in.readLine().trim().split("\\s+");
            payments.add(create(parts[0].toUpperCase(), Double.parseDouble(parts[1])));
        }

        // Uniform processing: no type checks, each object applies its own fee
        double total = 0;
        for (Payment p : payments) {
            double result = p.finalAmount();
            total += result;
            System.out.println(String.format(Locale.US, "%s: %.2f", p.getType(), result));
        }
        System.out.println(String.format(Locale.US, "Total: %.2f", total));
    }
}
