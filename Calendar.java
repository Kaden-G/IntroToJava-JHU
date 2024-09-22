import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask the user for a month and year
        System.out.print("Enter the month (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter the year (e.g., 2022): ");
        int year = input.nextInt();

        // Call the method to print the calendar for the given month and year
        printMonthCalendar(month, year);

        input.close();
    }
}
