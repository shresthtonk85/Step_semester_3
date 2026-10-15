import java.util.*;

public class Problem3_EvenOddCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\\[\\],]", " ").trim();   // "[3, 8, 12]" -> "3 8 12"
        List<Integer> list = new ArrayList<>();
        if (!line.isEmpty())
            for (String t : line.split("\\s+")) list.add(Integer.parseInt(t));

        int even = 0, odd = 0;
        for (int x : list) {
            if (x % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }
}
