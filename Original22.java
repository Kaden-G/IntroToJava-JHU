import java.util.Scanner;

public class Original2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter six integers
        System.out.println("Enter six integers:");
        int v1 = input.nextInt();
        int v2 = input.nextInt();
        int v3 = input.nextInt();
        int v4 = input.nextInt();
        int v5 = input.nextInt();
        int v6 = input.nextInt();

        // Calculate row totals
        int total1 = v1 + v2;
        int total2 = v3 + v4;
        int total3 = v5 + v6;

        // Calculate column totals
        int col1Total = v1 + v3 + v5;
        int col2Total = v2 + v4 + v6;
        int col3Total = total1 + total2 + total3;

        // Output the table with a "Total" column
        System.out.println("\n\n");

        // Output the header
        System.out.printf("\t%-10s%-10s%-10s%n", "Value", "Value", "Total");

        // Output the rows with their respective totals
        System.out.printf("\t%-10d%-10d%-10d%n", v1, v2, total1);
        System.out.printf("\t%-10d%-10d%-10d%n", v3, v4, total2);
        System.out.printf("\t%-10d%-10d%-10d%n", v5, v6, total3);

        // Add the row with dashes
        System.out.printf("\t%-10s%-10s%-10s%n", "----", "----", "----");

        // Output the final "Total" row with no headers above
        System.out.printf("Total\t%-10d%-10d%-10d%n", col1Total, col2Total, col3Total);

        System.out.println("\n\n");
    }
}