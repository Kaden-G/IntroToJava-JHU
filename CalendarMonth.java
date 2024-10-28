import java.util.Scanner;

public class CalendarMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int month = getValidMonth(input); // Get a valid month from user
        int year = getValidYear(input);   // Get a valid year from user

        // Call the method to print the calendar for the given month and year
        printMonthCalendar(month, year);

        input.close();
    }

    // Method to get a valid month input from the user
    public static int getValidMonth(Scanner input) {
        int month = 0;
        while (true) {
            System.out.print("Enter the month (1-12): ");
            if (input.hasNextInt()) {
                month = input.nextInt();
                if (month >= 1 && month <= 12) {
                    break; // Valid input
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 12.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next(); // Clear the invalid input
            }
        }
        return month;
    }

    // Method to get a valid year input from the user
    public static int getValidYear(Scanner input) {
        int year = 0;
        while (true) {
            System.out.print("Enter the year (AD years only, positive integers, e.g., 2022): ");
            if (input.hasNextInt()) {
                year = input.nextInt();
                if (year > 0) {
                    break; // Valid input
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                input.next(); // Clear the invalid input
            }
        }
        return year;
    }

    public static void printMonthCalendar(int month, int year) {
        printMonthHeader(month, year);
        printMonthBody(month, year);
    }

    public static void printMonthHeader(int month, int year) {
        // Print the month name and year
        System.out.println("     " + getMonthName(month) + " " + year);
        System.out.println("----------------------------");
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
    }

    public static void printMonthBody(int month, int year) {
        // Get the start day of the month (1 = Monday, 7 = Sunday)
        int startDay = getStartDay(month, year);

        // Get the number of days in the month
        int numDays = getNumDaysInMonth(month, year);

        // Print spaces for the days before the first day of the month
        for (int i = 1; i < startDay; i++) {
            System.out.print("    "); // Print spaces for alignment
        }

        // Print the days of the month
        for (int day = 1; day <= numDays; day++) {
            System.out.printf("%3d ", day);

            // Move to the next line after Sunday (7th day)
            if ((day + startDay - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println(); // Print a newline at the end
    }

    public static String getMonthName(int month) {
        String[] monthNames = {
            "January", "February", "March", "April", "May", 
            "June", "July", "August", "September", "October", 
            "November", "December"
        };
        return monthNames[month - 1];
    }

    public static int getStartDay(int month, int year) {
        // Adjust for Zeller's Algorithm
        if (month == 1 || month == 2) {
            month += 12;
            year--;
        }
        int q = 1; // Day of the month
        int m = month; // Month
        int K = year % 100; // Year of the century
        int J = year / 100; // Zero-based century

        int h = (q + (13 * (m + 1)) / 5 + K + (K / 4) + (J / 4) + (5 * J)) % 7;

        // Zeller's output: 0 = Saturday, 1 = Sunday, ..., 6 = Friday
        int dayOfWeek = ((h + 5) % 7) + 1; // Adjust to 1 = Monday, ..., 7 = Sunday

        return dayOfWeek;
    }

    public static int getNumDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return 0; // Invalid month
        }
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
