import java.util.Scanner;

/**
 * SoftballPitch class that takes an input of any integer from 1 through 10
 * from the user, and then generates the success of that pitch
 * based on the integer provided.
 */
public class SoftballPitchRefactored {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Get valid pitch input from the user
        int pitchInput = getUserInput(input);

        // Determine the outcome based on the pitch input
        determineEffortOutcome(pitchInput);

        // Close the Scanner to free up resources
        input.close();
    }

    /**
     * Handles user input, validates it, and returns a valid integer between 1 and 10.
     *
     * @param input Scanner object for reading user input
     * @return A validated integer representing the effort level
     */
    public static int getUserInput(Scanner input) {
        int pitchInput = 0;

        while (true) {
            System.out.print("From 1 to 10 (inclusive), how much effort do you put in your pitch? ");

            // If input is an integer, process it; otherwise, handle invalid input
            if (input.hasNextInt()) {
                pitchInput = input.nextInt();

                // Check if the input is within the valid range
                if (pitchInput >= 1 && pitchInput <= 10) {
                    break; // Valid input, exit the loop
                } else {
                    System.out.println("That's not between 1 and 10.");
                }
            } else {
                System.out.println("That's not an integer.");
                input.next(); // Clear the invalid input
            }
        }

        return pitchInput;
    }

    /**
     * Determines and prints the outcome of the pitch based on the user's effort input.
     *
     * @param pitchInput The validated effort level input by the user
     */
    public static void determineEffortOutcome(int pitchInput) {
        // This if statement checks the input value and returns a scenario
        // consistent with the choice made.
        if (pitchInput == 10) {
            System.out.println("You put so much into the pitch that you threw " +
                    "out your back and the ball went straight to the ground.");
        } else if (pitchInput < 10 && pitchInput >= 8) {
            System.out.println("You threw a fast curveball right in the corner " +
                    "and the batter whiffed. Strike!");
        } else if (pitchInput < 8 && pitchInput >= 5) {
            System.out.println("You threw one right down the middle and the " +
                    "batter hit it towards you, but you were able to scoop it up " +
                    "and get them out at first!");
        } else if (pitchInput < 5 && pitchInput >= 2) {
            System.out.println("Foul ball.");
        } else {
            System.out.println("You tripped and fell. A bit embarrassing...");
        }

        // Adding some blank lines for readability
        System.out.println("\n\n\n");
    }
}
