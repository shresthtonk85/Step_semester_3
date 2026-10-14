public class ExamHallSeatChecker {

    // Compares every seat number against every other one — arrays and loops only, no Collections
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        boolean[] alreadyReported = new boolean[seatNumbers.length]; // avoid reporting the same value twice

        for (int i = 0; i < seatNumbers.length; i++) {
            if (alreadyReported[i]) {
                continue;
            }
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    alreadyReported[j] = true;
                }
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] hallA = {101, 102, 103, 102, 105};
        checkDuplicateSeats(hallA); // Duplicate Seat Number Found: 102

        int[] hallB = {101, 102, 103, 104, 105};
        checkDuplicateSeats(hallB); // No Duplicate Seats Found
    }
}
