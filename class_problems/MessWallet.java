public class MessWallet {

    private double balance; // private: no public setter exists

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: negative opening balance not allowed, starting at 0");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than 0");
            return;
        }
        balance += amount;
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be greater than 0");
            return;
        }
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
    }

    // Read-only access
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance()); // 700.0
        wallet.deduct(1000);                                                 // rejected
        System.out.println("Final balance: " + wallet.getBalance());         // 700.0

        System.out.println("--- validation checks ---");
        MessWallet negative = new MessWallet(-50);
        negative.topUp(0);
        negative.deduct(10);
        System.out.println("Final balance: " + negative.getBalance()); // 0.0
    }
}
