package Mod09.src;
public class NullPointerExceptionThrown {
    public static void main(String[] args) {
        String text = null;
        // This will throw a NullPointerException
        System.out.println(text.length());
    }
}
