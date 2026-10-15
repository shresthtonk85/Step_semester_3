import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Base type: every item knows its own borrowing period
abstract class LibraryItem {
    protected final String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int borrowDays();

    LocalDate dueDate(LocalDate today) {
        return today.plusDays(borrowDays());
    }

    String getTitle() {
        return title;
    }
}

class Book extends LibraryItem {
    Book(String title) { super(title); }

    @Override
    int borrowDays() { return 14; }
}

class Dvd extends LibraryItem {
    Dvd(String title) { super(title); }

    @Override
    int borrowDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String title) { super(title); }

    @Override
    int borrowDays() { return 3; }
}

public class LibraryDueDates {

    static final LocalDate TODAY = LocalDate.of(2023, 10, 26);

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
    static LibraryItem create(String type, String title) {
        switch (type) {
            case "BOOK":     return new Book(title);
            case "DVD":      return new Dvd(title);
            case "MAGAZINE": return new Magazine(title);
            default: throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine().trim());

        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> tokens = tokenize(in.readLine().trim());
            items.add(create(tokens.get(0).toUpperCase(), tokens.get(1)));
        }

        // Uniform processing: no type checks
        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.dueDate(TODAY)); // LocalDate prints as YYYY-MM-DD
        }
    }
}
