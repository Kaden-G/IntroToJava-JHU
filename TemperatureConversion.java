
// class TemperatureConversion
//    Performs Temperature conversion from Fahrenheit to Celsius and vice versa
//
import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        final int CONVERT_TO_CELSIUS = 1;
        final int CONVERT_TO_FAHRENHEIT = 2;
        final int END_PROGRAM = 3;
        int userChoice = 0; // User selection: 1, 2, 3
        float tempF = 0; // Fahrenheit temperature
        float tempC = 0; // Celsius temperature
        Scanner input = new Scanner(System.in); // Create a Scanner to obtain user input

        while (userChoice != END_PROGRAM) {
            System.out.print("Enter 1 to convert F->C, 2 to convert C->F, 3 to quit: ");
            userChoice = input.nextInt(); // Read user input
            if (userChoice == CONVERT_TO_CELSIUS)
            {
                System.out.print("Enter a Fahrenheit temperature: ");
                tempF = input.nextFloat();
                convertToCelsius(tempF);
            }
            else if (userChoice == CONVERT_TO_FAHRENHEIT)
            {
                System.out.print("Enter a Celsius temperature: ");
                tempC = input.nextFloat();
                convertToFahrenheit(tempC);
            }
            else if (userChoice == END_PROGRAM)
            {
                System.out.println("Bye bye");
            }
        } // end while
        input.close();
    } // end main

    public static void convertToCelsius(float tempF)
    {
        float tempC = 5F / 9F * (tempF - 32F);
        System.out.println(tempF + " degrees Fahrenheit is " + tempC + " degrees Celsius");
    } // end convertToCelsius()
    
    public static void convertToFahrenheit(float tempC)
    {
        float tempF = 9F / 5F * tempC + 32F;
        System.out.println(tempC + " degrees Celsius is " + tempF + " degrees Fahrenheit");
    } // end convertToFahrenheit()
} // end class TemperatureConversion