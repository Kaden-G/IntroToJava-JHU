import java.util.Scanner;  // Importing the Scanner class to handle user input

/**
 * The Original2 class prompts the user for six integers, calculates the sum of rows and columns,
 * and displays the results in a formatted table.
 */
public class Original2 {  // Class declaration for Original2

    /**
     * The main method executes the program logic, including user input, calculation, and output formatting.
     */
    public static void main(String[] args) {  // Main method: entry point of the program
        Scanner input = new Scanner(System.in);  // Creating an object of the Scanner class to read user input

        // Prompt the user to enter six integers
        System.out.println("Enter six integers:");
        int value1 = input.nextInt();  // Read first integer
        int value2 = input.nextInt();  // Read second integer
        int value3 = input.nextInt();  // Read third integer
        int value4 = input.nextInt();  // Read fourth integer
        int value5 = input.nextInt();  // Read fifth integer
        int value6 = input.nextInt();  // Read sixth integer

        // Calculate row totals
        int totalRow1 = value1 + value2;  // Sum of the first row
        int totalRow2 = value3 + value4;  // Sum of the second row
        int totalRow3 = value5 + value6;  // Sum of the third row

        // Calculate column totals
        int totalCol1 = value1 + value3 + value5;  // Sum of the first column
        int totalCol2 = value2 + value4 + value6;  // Sum of the second column
        int totalOverall = totalRow1 + totalRow2 + totalRow3;  // Sum of the total column

        // Output the table with a "Total" column using escape sequences
        System.out.println("\n\n");  // Add extra space before the table

        // Output the header
        System.out.println("\tValue    Value    Total");

        // Output the rows with their respective totals
        System.out.println("\t" + value1 + "        " + value2 + "        " + totalRow1);  // First row output
        System.out.println("\t" + value3 + "        " + value4 + "        " + totalRow2);  // Second row output
        System.out.println("\t" + value5 + "        " + value6 + "        " + totalRow3);  // Third row output

        // Add dashes
        System.out.println("\t----     ----     ----");

        // Output the final "Total" row 
        System.out.println("Total\t" + totalCol1 + "        " + totalCol2 + "        " + totalOverall);

        System.out.println("\n\n");  // Extra table spacing
    }  // End of the main method
}  // End of class Original2