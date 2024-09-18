import java.util.Scanner;  // Importing the Scanner class from the java.util package

/**
 * The BMICalculator class prompts the user for their weight and height,
 * calculates their Body Mass Index (BMI), and provides a health assessment
 * based on the BMI value.
 */
public class BMICalculator {  // Class declaration for BMICalculator

    /**
     * The main method executes the program logic, including user input,
     * BMI calculation, and output of health assessment. It uses the Scanner 
     * class to read input from the user.
     */
    public static void main(String[] args) {  // Main method: entry point
        Scanner input = new Scanner(System.in);  // Creating Scanner object

        // Prompt the user to enter weight in pounds
        System.out.println("Enter your weight in pounds:");  // Prompt for weight
        double weightPounds = input.nextDouble();  // Store the weight

        // Prompt the user to enter height in inches
        System.out.println("Enter your height in inches:");  // Prompt for height
        double heightInches = input.nextDouble();  // Store the height

        // Convert weight to kilograms (1 pound = 0.45359237 kilograms)
        double weightKg = weightPounds * 0.45359237;  // Convert to kg

        // Convert height to meters (1 inch = 0.0254 meters)
        double heightMeters = heightInches * 0.0254;  // Convert to meters

        // Calculate BMI
        double bmi = weightKg / (heightMeters * heightMeters);  // Calculate BMI

        // Output the BMI
        System.out.printf("Your BMI is: %.2f%n", bmi);  // Output BMI

        // Provide health assessment with advice based on BMI
        if (bmi < 18.5) {  // BMI is less than 18.5 (underweight)
            System.out.println("You are underweight. Try increasing your " + 
                "caloric intake to maintain strength and focus.");  // Advice
        } else if (bmi >= 18.5 && bmi < 24.9) {  // BMI between 18.5 and 24.9
            System.out.println("You are at a normal weight. Continue " + 
                "maintaining your current lifestyle!");  // Advice
        } else if (bmi >= 25 && bmi < 29.9) {  // BMI between 25 and 29.9
            System.out.println("You are overweight. Consider incorporating " +
                "regular exercise and a balanced diet to improve your health.");
        } else {  // BMI is 30 or greater (obese)
            System.out.println("You are obese. It is advisable to consult " + 
                "with a healthcare provider for personalized advice on " + 
                "achieving a healthier weight.");  // Advice
        }
    }  // End of the main method
}  // End of the BMICalculator class