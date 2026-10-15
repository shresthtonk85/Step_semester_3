package week_7.assignment_problems;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Maximum health must be greater than 0.");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            return;
        }
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        if (amount <= 0) {
            return;
        }
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After damage: " + c.getHealth());
        c.heal(50);
        System.out.println("After heal: " + c.getHealth());
        c.takeDamage(150);
        System.out.println("After heavy damage: " + c.getHealth());
    }
}
