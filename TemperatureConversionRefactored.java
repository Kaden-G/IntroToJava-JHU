import java.util.Scanner; // Import the Scanner class to handle user input

public class TemperatureConversionRefactored { 
    public static void main(String[] args) {
        // Constants representing user choices for conversion options
        final int CONVERT_TO_CELSIUS = 1; 
        final int CONVERT_TO_FAHRENHEIT = 2; 
        final int END_PROGRAM = 3; 
        
        int userChoice = 0; // Variable to store user's choice
        Scanner input = new Scanner(System.in); // Create a Scanner object for reading user input

        // Main loop to process the user's choice until they choose to end the program
        while (userChoice != END_PROGRAM) {
            // Call the getUserInput method to get the user's selection
            userChoice = getUserInput(input);
            
            // Switch statement to handle user choices based on the entered option
            switch (userChoice) {
                case CONVERT_TO_CELSIUS:
                    // If the user wants to convert Fahrenheit to Celsius:
                    // Call getTemperatureInput to get the Fahrenheit temperature from the user
                    float fahrenheit = getTemperatureInput(input, "Fahrenheit");
                    
                    // Convert the Fahrenheit temperature to Celsius using convertToCelsius method
                    float celsius = convertToCelsius(fahrenheit);
                    
                    // Output the result to the user
                    System.out.println(fahrenheit + " degrees Fahrenheit is " + celsius + " degrees Celsius");
                    break;

                case CONVERT_TO_FAHRENHEIT:
                    // If the user wants to convert Celsius to Fahrenheit:
                    // Call getTemperatureInput to get the Celsius temperature from the user
                    celsius = getTemperatureInput(input, "Celsius");
                    
                    // Convert the Celsius temperature to Fahrenheit using convertToFahrenheit method
                    fahrenheit = convertToFahrenheit(celsius);
                    
                    // Output the result to the user
                    System.out.println(celsius + " degrees Celsius is " + fahrenheit + " degrees Fahrenheit");
                    break;

                case END_PROGRAM:
                    // If the user chooses to end the program:
                    System.out.println("Bye Bye"); // Print a farewell message
                    break;

                default:
                    // If the user enters an invalid choice, call handleInvalidInput to notify them
                    handleInvalidInput();
            }
        }
        input.close(); // Close the Scanner object to free resources
    }

    // Method to handle user input for selection of conversion or program termination
    public static int getUserInput(Scanner input) {
        System.out.print("Enter 1 to convert F->C, 2 to convert C->F, 3 to quit: ");
        // Return the integer input by the user (their choice)
        return input.nextInt();
    }

    // Method to handle invalid user inputs
    public static void handleInvalidInput() {
        // Print an error message when the user enters an invalid choice
        System.out.println("Invalid Data: You must enter 1, 2, or 3.");
    }

    // Method to prompt the user for a temperature input (either Fahrenheit or Celsius)
    public static float getTemperatureInput(Scanner input, String scale) {
        // Ask the user to enter a temperature, specifying either Fahrenheit or Celsius based on the 'scale' parameter
        System.out.print("Enter a " + scale + " temperature: ");
        // Return the float value input by the user (their temperature input)
        return input.nextFloat();
    }

    // Method to convert a Fahrenheit temperature to Celsius
    public static float convertToCelsius(float fahrenheit) {
        // Formula to convert Fahrenheit to Celsius
        return 5F / 9F * (fahrenheit - 32F);
    }

    // Method to convert a Celsius temperature to Fahrenheit
    public static float convertToFahrenheit(float celsius) {
        // Formula to convert Celsius to Fahrenheit
        return 9F / 5F * celsius + 32F;
    }
}
