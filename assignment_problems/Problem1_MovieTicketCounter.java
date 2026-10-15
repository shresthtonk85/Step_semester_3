import java.util.*;

// Abstract: a plain "ticket" with no seat type can never be created.
abstract class Ticket {
    private static final double CONVENIENCE_FEE = 20;   // written in ONE place only
    private final int count;

    Ticket(int count) { this.count = count; }

    protected abstract double pricePerTicket();          // only this varies by seat type

    // Shared, unchanging logic lives here once
    final double amount() { return count * (pricePerTicket() + CONVENIENCE_FEE); }
}

class RegularTicket extends Ticket {
    RegularTicket(int c) { super(c); }
    protected double pricePerTicket() { return 150; }
}

class PremiumTicket extends Ticket {
    PremiumTicket(int c) { super(c); }
    protected double pricePerTicket() { return 250; }
}

class ReclinerTicket extends Ticket {
    ReclinerTicket(int c) { super(c); }
    protected double pricePerTicket() { return 400; }
}

public class Problem1_MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> names = new ArrayList<>();
        List<Ticket> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();
            switch (seat) {
                case "REGULAR":  bookings.add(new RegularTicket(count)); break;
                case "PREMIUM":  bookings.add(new PremiumTicket(count)); break;
                case "RECLINER": bookings.add(new ReclinerTicket(count)); break;
                default: throw new IllegalArgumentException("Unknown seat: " + seat);
            }
            names.add(seat);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double a = bookings.get(i).amount();
            total += a;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", a));
        }
        System.out.println("Total: " + String.format(Locale.US, "%.2f", total));
    }
}
