public class ClassCastExceptionThrown {
    public static void main(String[] args) {
        Object object = new String("Hello");
        // This will throw a ClassCastException
        Integer number = (Integer) object;
    }
}
