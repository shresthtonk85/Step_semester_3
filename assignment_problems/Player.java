import java.util.Arrays;

public class Player implements Comparable<Player> {

    // Draft rule thresholds (my own choice, as the brief allows)
    private static final int ESTABLISHED_MATCHES = 10; // enough on experience alone
    private static final int MIN_MATCHES_NEWER = 5;    // newer players need this many AND to be fit

    private final String name;
    private final int matchesPlayed;
    private final double battingAverage;
    private final boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() {
        return name;
    }

    // Fantasy points are driven by batting average
    public double getFantasyPoints() {
        return battingAverage;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public boolean isInjured() {
        return injured;
    }

    // Established players: experience alone is enough
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= ESTABLISHED_MATCHES;
    }

    // Everyone else: reasonably experienced AND currently fit
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= MIN_MATCHES_NEWER && !injured;
    }

    // Descending by fantasy points, so Arrays.sort() alone ranks the array
    @Override
    public int compareTo(Player other) {
        return Double.compare(other.getFantasyPoints(), this.getFantasyPoints());
    }

    static String draftAndRank(Player[] players) {
        // First pass: count who qualifies under either rule
        int count = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                count++;
            }
        }

        // Second pass: collect them
        Player[] draftable = new Player[count];
        int index = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable[index++] = p;
            }
        }

        Arrays.sort(draftable); // uses compareTo — no hand-written sort

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(draftable[i].name);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Player[] batch = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(batch)); // 1. Rahul | 2. Virat | 3. Dev
    }
}
