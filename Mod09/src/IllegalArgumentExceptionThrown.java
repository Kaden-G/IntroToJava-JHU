public class IllegalArgumentExceptionThrown {
    public static void main(String[] args) {
        printSquareRoot(-1);
    }

    public static void printSquareRoot(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        System.out.println(Math.sqrt(number));
    }
}
