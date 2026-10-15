public class HallTicket {

    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;   // same object, second reference — not a new ticket
        copy.seatNumber = 45;      // change made through the second variable

        HallTicket separate = new HallTicket("Priya", 45); // identical values, different object

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));         // true: same object
        System.out.println("separate == priya: " + (separate == priya)); // false: different object
    }
}
