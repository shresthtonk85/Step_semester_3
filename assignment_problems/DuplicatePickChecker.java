public class DuplicatePickChecker {

    // Plain nested loops, no Collections; each name is compared only with the names after it
    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) { // case-sensitive
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Kohli", "Rohit"}));
        // Duplicate Found: Kohli
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Rohit"}));
        // No Duplicates Found
    }
}
