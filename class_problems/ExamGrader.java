import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Base type: every question grades its own answer
abstract class Question {
    protected final String type;
    protected final String correctAnswer;
    protected final String studentAnswer;
    protected final double points;

    Question(String type, String correctAnswer, String studentAnswer, double points) {
        this.type = type;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();

    String getType() {
        return type;
    }
}

class McqQuestion extends Question {
    McqQuestion(String type, String correct, String student, double points) {
        super(type, correct, student, points);
    }

    @Override
    double grade() { return studentAnswer.equals(correctAnswer) ? points : 0; }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String type, String correct, String student, double points) {
        super(type, correct, student, points);
    }

    @Override
    double grade() { return studentAnswer.equals(correctAnswer) ? points : 0; }
}

class EssayQuestion extends Question {
    EssayQuestion(String type, String correct, String student, double points) {
        super(type, correct, student, points);
    }

    // 2+ keywords -> 75%, exactly 1 -> 50%, none -> 0 (case-insensitive)
    @Override
    double grade() {
        String answer = studentAnswer.toLowerCase();
        int matched = 0;

        for (String keyword : correctAnswer.split(",")) {
            String k = keyword.trim().toLowerCase();
            if (!k.isEmpty() && answer.contains(k)) {
                matched++;
            }
        }

        if (matched >= 2) return points * 0.75;
        if (matched == 1) return points * 0.50;
        return 0;
    }
}

public class ExamGrader {

    // Splits a line on spaces but keeps "quoted text" together and strips the quotes
    static List<String> tokenize(String line) {
        List<String> tokens = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ' ' && !inQuotes) {
                if (current.length() > 0) {
                    tokens.add(current.toString());
                    current.setLength(0);
                }
            } else {
                current.append(c);
            }
        }
        if (current.length() > 0) {
            tokens.add(current.toString());
        }
        return tokens;
    }

    // The only place the type string is inspected: object creation
    // Tokens: type, questionText, correctAnswer, studentAnswer, points
    static Question create(List<String> t) {
        String type = t.get(0).toUpperCase();
        String correct = t.get(2);
        String student = t.get(3);
        double points = Double.parseDouble(t.get(4));

        switch (type) {
            case "MCQ":   return new McqQuestion(type, correct, student, points);
            case "TF":    return new TrueFalseQuestion(type, correct, student, points);
            case "ESSAY": return new EssayQuestion(type, correct, student, points);
            default: throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            questions.add(create(tokenize(in.readLine().trim())));
        }

        // Uniform grading: no type checks
        double total = 0;
        for (Question q : questions) {
            double score = q.grade();
            total += score;
            System.out.println(String.format(Locale.US, "%s: %.2f", q.getType(), score));
        }
        System.out.println(String.format(Locale.US, "Total Score: %.2f", total));
    }
}
