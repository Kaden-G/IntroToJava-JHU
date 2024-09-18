import java.util.Scanner;

/**
 * AsteriskPatterns
 *
 * This class provides functionality to display a pattern of asterisks
 * based on user input. The user can choose between an ascending or
 * descending pyramid of asterisks up to a specified maximum number.
 */
public class AsteriskPatterns {
    /**
     * The main method serves as the entry point of the program.
     * It handles user input and displays the chosen asterisk pattern.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxAsterisks = 0;
        int patternChoice = 0;

        // Print welcome message
        System.out.println("Welcome to the Asterisk Pattern Program");
        System.out.println("This program will display a pattern of asterisks\n");

        // Prompt user for the maximum number of asterisks
        maxAsterisks = getPositiveInteger(scanner, "Enter the maximum number of asterisks: ");

        // Prompt user for pattern choice
        patternChoice = getPatternChoice(scanner);

        // Display the pattern based on user's choice
        System.out.println("\nGenerated Pattern:\n");
        if (patternChoice == 1) {
            displayPyramidAscending(maxAsterisks);
        } else {
            displayPyramidDescending(maxAsterisks);
        }

        // Close the scanner
        scanner.close(); // end scanner
    } // end main()

    /**
     * Prompts the user to enter a positive integer.
     * Repeats the prompt until a valid positive integer is entered.
     *
     * @param scanner Scanner object for user input.
     * @param prompt  The message displayed to prompt the user.
     * @return A positive integer entered by the user.
     */
    private static int getPositiveInteger(Scanner scanner, String prompt) {
        int number = 0;

        // Loop until a valid positive integer is entered
        while (number <= 0) { // start while loop
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number <= 0) {
                    System.out.println("Invalid input. Please enter a positive number.\n");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.\n");
                scanner.next(); // Clear invalid input
            }
        } // end while loop

        return number;
    } // end getPositiveInteger()

    /**
     * Prompts the user to choose a pattern to display.
     * Repeats the prompt until a valid choice (1 or 2) is entered.
     *
     * @param scanner Scanner object for user input.
     * @return The user's pattern choice (1 for ascending, 2 for descending).
     */
    private static int getPatternChoice(Scanner scanner) {
        int choice = 0;

        // Loop until the user enters either 1 or 2
        while (choice != 1 && choice != 2) { // start while loop
            System.out.println("Choose a pattern to display:");
            System.out.println("1) Pyramid of asterisks ascending");
            System.out.println("2) Pyramid of asterisks descending");
            System.out.print("Enter your choice (1 or 2): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice != 1 && choice != 2) {
                    System.out.println("Invalid choice. Please enter 1 or 2.\n");
                }
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.\n");
                scanner.next(); // Clear invalid input
            }
        } // end while loop

        return choice;
    } // end getPatternChoice()

    /**
     * Displays an ascending pyramid of asterisks.
     *
     * @param maxAsterisks The maximum number of asterisks in the last line.
     */
    private static void displayPyramidAscending(int maxAsterisks) {
        // Loop to handle the number of rows
        for (int i = 1; i <= maxAsterisks; i++) { // start for loop
            // Loop to handle the number of asterisks in each row
            for (int j = 1; j <= i; j++) { // start nested for loop
                System.out.print("*");
            } // end nested for loop
            System.out.println();
        } // end for loop
    } // end displayPyramidAscending()

    /**
     * Displays a descending pyramid of asterisks.
     *
     * @param maxAsterisks The maximum number of asterisks in the first line.
     */
    private static void displayPyramidDescending(int maxAsterisks) {
        // Loop to handle the number of rows
        for (int i = maxAsterisks; i >= 1; i--) { // start for loop
            // Loop to handle the number of asterisks in each row
            for (int j = 1; j <= i; j++) { // start nested for loop
                System.out.print("*");
            } // end nested for loop
            System.out.println();
        } // end for loop
    } // end displayPyramidDescending()
} // end AsteriskPatterns
