public class PayrollAccount {

    private double basicSalary; // private: no public setter exists
    private double bonus;       // private: no public setter exists

    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            System.out.println("Warning: negative salary not allowed, starting at Rs 0.0");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingBasicSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Rejected: bonus must be greater than 0");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Rejected: tax percent must be between 0 and 100");
            return;
        }
        basicSalary -= basicSalary * percent / 100;
        // Show whole numbers without the trailing ".0" (10 -> "10%")
        String shown = (percent == (long) percent) ? String.valueOf((long) percent) : String.valueOf(percent);
        System.out.println("Tax deducted: " + shown + "%");
    }

    // Read-only access to the combined figure
    public double getNetSalary() {
        return basicSalary + bonus;
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary()); // Rs 50000.0

        System.out.println("--- validation checks ---");
        PayrollAccount negative = new PayrollAccount(-100);
        negative.creditBonus(0);
        negative.creditBonus(-50);
        negative.deductTax(150);
        negative.deductTax(-5);
        System.out.println("Net salary: Rs " + negative.getNetSalary()); // Rs 0.0
    }
}
