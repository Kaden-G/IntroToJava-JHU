public class ClassCastExceptionCatch {
    public static void main(String[] args) {
        Object object = new String("Hello");
        try {
            Integer number = (Integer) object;
        } catch (ClassCastException e) {
            System.out.println("Caught ClassCastException: " + e.getMessage());
        }
    }
}
