import java.io.*;
import java.util.*;

abstract class Question {
    protected String text, correct, student;
    protected int points;
    Question(String text, String correct, String student, int points) {
        this.text = text; this.correct = correct; this.student = student; this.points = points;
    }
    abstract double grade();
}

class McqQuestion extends Question {
    McqQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
    double grade() { return student.trim().equals(correct.trim()) ? points : 0; }
}

class TrueFalseQuestion extends Question {
    TrueFalseQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
    double grade() { return student.trim().equals(correct.trim()) ? points : 0; }
}

class EssayQuestion extends Question {
    EssayQuestion(String t, String c, String s, int p) { super(t, c, s, p); }
    double grade() {
        String ans = student.toLowerCase();
        int hits = 0;
        for (String k : correct.split(",")) {
            k = k.trim().toLowerCase();
            if (!k.isEmpty() && ans.contains(k)) hits++;
        }
        if (hits >= 2) return points * 0.75;
        if (hits == 1) return points * 0.50;
        return 0;
    }
}

public class Problem4_ExamGrader {
    // Splits a line into tokens; "quoted text" stays as one token (quotes removed)
    static List<String> tokenize(String line) {
        List<String> t = new ArrayList<>();
        int i = 0, n = line.length();
        while (i < n) {
            char c = line.charAt(i);
            if (Character.isWhitespace(c)) { i++; continue; }
            if (c == '"') {
                int j = line.indexOf('"', i + 1);
                if (j < 0) j = n;
                t.add(line.substring(i + 1, j));
                i = j + 1;
            } else {
                int j = i;
                while (j < n && !Character.isWhitespace(line.charAt(j))) j++;
                t.add(line.substring(i, j));
                i = j;
            }
        }
        return t;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        List<String> names = new ArrayList<>();
        List<Question> qs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> t = tokenize(br.readLine());
            String type = t.get(0).toUpperCase();
            int pts = Integer.parseInt(t.get(4));
            Question q;
            switch (type) {
                case "MCQ":   q = new McqQuestion(t.get(1), t.get(2), t.get(3), pts); break;
                case "TF":    q = new TrueFalseQuestion(t.get(1), t.get(2), t.get(3), pts); break;
                case "ESSAY": q = new EssayQuestion(t.get(1), t.get(2), t.get(3), pts); break;
                default: throw new IllegalArgumentException("Unknown type: " + type);
            }
            names.add(type);
            qs.add(q);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double s = qs.get(i).grade();
            total += s;
            System.out.println(names.get(i) + ": " + String.format(Locale.US, "%.2f", s));
        }
        System.out.println("Total Score: " + String.format(Locale.US, "%.2f", total));
    }
}
