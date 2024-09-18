

import java.util.Scanner;

/**
 * Simple budget tracker
 * This can be used for a single budget to be tracked.
 */
public class Budget {

    public static void main(String[] args) {

        // Variables for tracking budget
        double budget = 0;
        double spent = 0; 
        double remaining = 0;

        // Input for budget
        Scanner input = new Scanner(System.in);
        System.out.println("\n\n");

        System.out.print("What is your budget? ");
        budget = input.nextDouble(); // Input budget value

        // Set remaining equal to budget to initialize
        remaining = budget;

        while (remaining > 0) {
            // Input for spent
            System.out.print("What did you spend? ");
            spent = input.nextDouble(); 

            // Expense calculation
            remaining -= spent;

            // Scenario where user enters 0 as an expense
            if (remaining == 0) {
                break; 
            }

            if (remaining < 0) {
                System.out.println("Overbudget!");
            } else {
                System.out.println("Remaining budget is: $" + remaining);
            }
        }

        System.out.println("Final balance: $" + remaining);
        
        input.close(); // Close the scanner
    } 
}
