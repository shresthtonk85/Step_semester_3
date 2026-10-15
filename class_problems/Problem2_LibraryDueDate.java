import java.io.*;
import java.time.LocalDate;
import java.util.*;

abstract class LibraryItem {
    protected String title;
    LibraryItem(String title) { this.title = title; }
    abstract int loanDays();
    LocalDate dueDate(LocalDate today) { return today.plusDays(loanDays()); }
    String getTitle() { return title; }
}

class Book extends LibraryItem {
    Book(String t) { super(t); }
    int loanDays() { return 14; }
}

class Dvd extends LibraryItem {
    Dvd(String t) { super(t); }
    int loanDays() { return 7; }
}

class Magazine extends LibraryItem {
    Magazine(String t) { super(t); }
    int loanDays() { return 3; }
}

public class Problem2_LibraryDueDate {
    static LibraryItem create(String type, String title) {
        switch (type.toUpperCase()) {
            case "BOOK":     return new Book(title);
            case "DVD":      return new Dvd(title);
            case "MAGAZINE": return new Magazine(title);
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        LocalDate today = LocalDate.of(2023, 10, 26);
        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine().trim();
            int sp = line.indexOf(' ');
            String type = line.substring(0, sp);
            String title = line.substring(sp + 1).trim();
            if (title.length() >= 2 && title.startsWith("\"") && title.endsWith("\""))
                title = title.substring(1, title.length() - 1);
            items.add(create(type, title));
        }
        for (LibraryItem it : items)
            System.out.println(it.getTitle() + ": " + it.dueDate(today));  // ISO = YYYY-MM-DD
    }
}
