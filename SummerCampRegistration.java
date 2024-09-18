import java.util.Scanner;  // Import Scanner for user input

/**
 * The SummerCampRegistration class handles the registration process
 * for a summer camp that offers different sessions based on age and activity preference.
 */
public class SummerCampRegistration {

    /**
     * The main method is the entry point of the program. It handles user input,
     * validates age, and assigns the child to the appropriate session.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object for reading user input

        // Prompt for child's first name
        System.out.print("Enter your child's first name: ");
        String firstName = scanner.nextLine();  // Read the first name

        // Prompt for child's last name
        System.out.print("Enter your child's last name: ");
        String lastName = scanner.nextLine();  // Read the last name

        // Prompt for child's age
        System.out.print("Enter your child's age (eligible children are 5-18): ");
        int age = scanner.nextInt();  // Read the age
        scanner.nextLine();  // Consume the newline left by nextInt()

        // Validate the age and check if the child is eligible for the camp
        if (age < 5 || age > 18) {
            // If the age is outside the eligible range, display an error message
            System.out.println("Error: Your child is not eligible for our camp sessions. Only ages 5-18 are accepted.");
        } else {
            // Initialize the activity variable
            String activity = "";

            // Loop to ensure valid activity input is provided
            while (true) {
                // Prompt for preferred activity
                System.out.print("Enter preferred activity. Indicate by typing 'surf' or 'skate': ");
                activity = scanner.nextLine().trim().toLowerCase();  // Read and process the activity input

                // Check if the input is valid
                if (activity.equals("surf") || activity.equals("skate")) {
                    break;  // Valid input, exit the loop
                } else {
                    // Display an error message if the input is invalid
                    System.out.println("Error: The activity you entered is invalid. Please enter 'surf' or 'skate'.");
                }
            }

            // Determine the appropriate session based on age and activity
            String session = determineSession(age, activity);

            // Display the confirmation message with the child's full name and session
            System.out.println(firstName + " " + lastName + " is successfully registered for our " + session + " session.");
        }

        scanner.close();  // Close the scanner to prevent resource leaks
    }

    /**
     * Determines the specific camp session based on the child's age and preferred activity.
     *
     * This method returns a string indicating the camp session for which the child is registered.
     */
    private static String determineSession(int age, String activity) {
        String month;  // Variable to store the month based on the age group

        // Assign the correct month based on the age group
        if (age >= 5 && age <= 10) {
            month = "June";
        } else if (age >= 11 && age <= 13) {
            month = "July";
        } else {
            month = "August";
        }

        // Return the full session description based on the activity preference
        if (activity.equals("surf")) {
            return month + " Surfing (first two weeks)";
        } else {
            return month + " Skateboarding (last two weeks)";
        }
    }
}