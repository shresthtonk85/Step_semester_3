package week_7.assignment_problems;

public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        if (maxItems <= 0) {
            throw new IllegalArgumentException("Cart capacity must be greater than 0.");
        }
        this.cartId = cartId;
        this.prices = new double[maxItems];
    }

    public void addItem(double price) {
        if (itemCount >= prices.length) {
            return;
        }
        prices[itemCount] = price;
        itemCount++;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Count: " + cart.getItemCount());
    }
}
