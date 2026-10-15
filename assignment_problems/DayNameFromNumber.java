package main.java.week_3.assigment_problems;

public class DayNameFromNumber {

    void printDayName(int dayNumber) {
        switch (dayNumber) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day number");
                break;
        }
    }

    public static void main(String[] args) {
        DayNameFromNumber dayNamePrinter = new DayNameFromNumber();
        
        dayNamePrinter.printDayName(3);
        dayNamePrinter.printDayName(9);
    }
}
