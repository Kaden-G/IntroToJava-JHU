import java.util.Scanner;

/**
 * NumberGame
 *
 * This class implements a number guessing game where the user attempts to guess
 * a randomly generated secret number within a specified range and a limited number
 * of attempts. The user can choose to play multiple rounds of the game.
 */
public class NumberGame {
    /**
     * The main method serves as the entry point of the program.
     * It manages the game flow, including user interactions and game logic.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
    
        // Print welcome message
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the secret number within your chosen range and attempts.\n");
    
        while (playAgain) { // start while loop for replay
            int maxNumber = getPositiveInteger(scanner, "Enter the maximum number (N) for the secret number (must be > 1): ");
            int maxGuesses = getPositiveInteger(scanner, "Enter the maximum number of guesses allowed: ");
            int secretNumber = generateSecretNumber(maxNumber);
            int guessCount = 0;
            boolean hasGuessedCorrectly = false;
    
            // Game loop for guessing
            while (guessCount < maxGuesses && !hasGuessedCorrectly) { // start while loop for guesses
                int userGuess = getPositiveInteger(scanner, "Enter your guess: ");
                guessCount++;
    
                if (userGuess == secretNumber) { // start if
                    System.out.println("Correct! You've guessed the secret number in " + guessCount + " attempt(s).\n");
                    hasGuessedCorrectly = true;
                } else if (userGuess < secretNumber) { // start else if
                    System.out.println("Too low.");
                } else { // start else
                    System.out.println("Too high.");
                } // end if-else
    
                if (guessCount < maxGuesses) { // start if
                    System.out.println("You have " + (maxGuesses - guessCount) + " guess(es) left.");
                } // end if
            } // end while loop for guesses
    
            if (!hasGuessedCorrectly) { // start if
                System.out.println("You've exceeded the maximum number of guesses. The secret number was " + secretNumber + ".\n");
            } // end if
    
            // Prompt to play again
            playAgain = promptPlayAgain(scanner);
        } // end while loop for replay
    
        // Print farewell message
        System.out.println("Thank you for playing! Goodbye.");
    
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
            if (scanner.hasNextInt()) { // start if
                number = scanner.nextInt();
                if (number <= 0) { // start if
                    System.out.println("Invalid input. Please enter a positive integer greater than zero.\n");
                } // end if
            } else { // start else
                System.out.println("Invalid input. Please enter a valid integer.\n");
                scanner.next(); // Clear invalid input
            } // end else
        } // end while loop
    
        return number;
    } // end getPositiveInteger()
    
    /**
     * Generates a random secret number between 1 and the specified maximum number (inclusive).
     *
     * @param maxNumber The upper bound for the secret number.
     * @return A randomly generated secret number.
     */
    private static int generateSecretNumber(int maxNumber) {
        return (int) (maxNumber * Math.random()) + 1;
    } // end generateSecretNumber()
    
    /**
     * Prompts the user to decide whether to play the game again.
     * Repeats the prompt until the user enters a valid response ('Y' or 'N').
     *
     * @param scanner Scanner object for user input.
     * @return True if the user chooses to play again, false otherwise.
     */
    private static boolean promptPlayAgain(Scanner scanner) {
        char response = 'N';
    
        // Loop until the user enters 'Y' or 'N'
        while (true) { // start infinite loop
            System.out.print("Do you want to play again? (Y/N): ");
            String input = scanner.next();
            if (input.length() == 1) { // start if
                response = Character.toUpperCase(input.charAt(0));
                if (response == 'Y') { // start if
                    System.out.println();
                    return true;
                } else if (response == 'N') { // start else if
                    return false;
                } // end if-else if
            } // end if
            System.out.println("Invalid input. Please enter 'Y' for yes or 'N' for no.\n");
        } // end infinite loop
    } // end promptPlayAgain()
    
   
