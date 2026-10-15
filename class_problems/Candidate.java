import java.util.Arrays;

public class Candidate implements Comparable<Candidate> {

    // Eligibility thresholds
    private static final double CGPA_DIRECT = 7.0;      // CGPA alone is enough
    private static final double CGPA_BORDERLINE = 6.5;  // borderline CGPA floor...
    private static final int CODING_MIN = 60;           // ...must be backed by this coding score

    private final String name;
    private final double cgpa;
    private final int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public String getName() {
        return name;
    }

    // Composite score = CGPA weighted x10 plus half the coding score
    public double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    // Quick filter: CGPA alone
    static boolean isEligible(double cgpa) {
        return cgpa >= CGPA_DIRECT;
    }

    // Combined filter: borderline CGPA rescued by a strong coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= CGPA_BORDERLINE && codingScore >= CODING_MIN;
    }

    // Descending by composite score, so Arrays.sort() alone ranks the array
    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    static String shortlistAndRank(Candidate[] candidates) {
        // First pass: count who qualifies under either rule
        int count = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                count++;
            }
        }

        // Second pass: collect them
        Candidate[] shortlisted = new Candidate[count];
        int index = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted[index++] = c;
            }
        }

        Arrays.sort(shortlisted); // uses compareTo — no hand-written sort

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ")
                  .append(shortlisted[i].name)
                  .append(" (").append(shortlisted[i].getCompositeScore()).append(")");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] batch = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(batch));
        // 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }
}
