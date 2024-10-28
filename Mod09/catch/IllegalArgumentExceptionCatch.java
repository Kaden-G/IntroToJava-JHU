public class IllegalArgumentExceptionCatch {
    public static void main(String[] args) {
        try {
            printSquareRoot(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }

    public static void printSquareRoot(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }
        System.out.println(Math.sqrt(number));
    }
}
