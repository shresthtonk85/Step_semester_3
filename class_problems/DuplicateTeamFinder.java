public class DuplicateTeamFinder {

    // Plain nested loops, no Collections; each name is only compared with the names after it
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) { // case-sensitive
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "ByteForce"}));
        // Duplicate Found: ByteForce
        System.out.println(findDuplicateTeam(new String[]{"ByteForce", "CodeCrafters", "NullPointers"}));
        // No Duplicates Found
    }
}
