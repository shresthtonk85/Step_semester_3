public class IdCard {

    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;      // same object, second reference — not a new card
        duplicate.booksIssued = 3;    // change made through the second variable

        IdCard separate = new IdCard("Ravi", 3); // identical values, different object

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));   // true: same object
        System.out.println("separate == ravi: " + (separate == ravi));     // false: different object
    }
}
