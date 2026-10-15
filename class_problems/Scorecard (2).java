package week_7.class_problems;

public class Scorecard {
    private final boolean[] answers;
    private int questionCount;

    public Scorecard(int totalQuestions) {
        if (totalQuestions <= 0) {
            throw new IllegalArgumentException("Question count must be greater than 0.");
        }
        this.answers = new boolean[totalQuestions];
    }

    public void recordAnswer(boolean isCorrect) {
        if (questionCount >= answers.length) {
            return;
        }
        answers[questionCount] = isCorrect;
        questionCount++;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < questionCount; i++) {
            if (answers[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println(sc.getScore());
    }
}
