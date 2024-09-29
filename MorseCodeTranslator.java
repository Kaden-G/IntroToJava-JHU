import java.util.Scanner;

public class MorseCodeTranslator {

    // Array of English alphabet and numbers
    private static final String[] ENGLISH_ALPHABET = { 
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", 
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" 
    };

    // Corresponding array of Morse code for each letter and number
    private static final String[] MORSE_CODE = { 
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", 
        "..-", "...-", ".--", "-..-", "-.--", "--..", 
        ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----" 
    };

    /**
     * Method to check if a given Morse code character is valid.
     * @param morse The Morse code string to check.
     * @return True if the Morse code is valid, false otherwise.
     */
    public static boolean isValidMorseCode(String morse) {
        for (String validCode : MORSE_CODE) {
            if (morse.equals(validCode)) {
                return true;  // The input matches a valid Morse code symbol.
            }
        }
        return false;  // The input is invalid Morse code.
    }

    /**
     * Translates a Morse code string to English.
     * @param morse The Morse code input string (letters separated by spaces, words separated by '|').
     * @return The English translation, or an error message if invalid Morse code is found.
     */
    public static String morseToEnglish(String morse) {
        StringBuilder english = new StringBuilder();
        String[] words = morse.split(" \\| ");  // Split Morse input into words

        // Loop through each word
        for (String word : words) {
            String[] letters = word.split(" ");  // Split word into Morse code letters

            // Translate each letter
            for (String letter : letters) {
                if (!isValidMorseCode(letter)) {
                    return "Error: Invalid Morse code detected: " + letter;  // If invalid Morse code is found, return error
                }
                // Match Morse code to the corresponding English letter
                for (int i = 0; i < MORSE_CODE.length; i++) {
                    if (letter.equals(MORSE_CODE[i])) {
                        english.append(ENGLISH_ALPHABET[i]);  // Append translated English letter
                        break;
                    }
                }
            }
            english.append(" ");  // Add space between translated words
        }

        return english.toString().trim();  // Return translated English string
    }

    /**
     * Translates an English string to Morse code.
     * @param english The English input string.
     * @return The Morse code translation.
     */
    public static String englishToMorse(String english) {
        StringBuilder morse = new StringBuilder();
        english = english.toUpperCase();  // Convert input to uppercase to match the array

        // Loop through each character in the English string
        for (char letter : english.toCharArray()) {
            if (letter == ' ') {
                morse.append("| ");  // Use '|' to separate words in Morse code
            } else {
                // Match English letter to its corresponding Morse code
                for (int i = 0; i < ENGLISH_ALPHABET.length; i++) {
                    if (String.valueOf(letter).equals(ENGLISH_ALPHABET[i])) {
                        morse.append(MORSE_CODE[i]).append(" ");  // Append Morse code and a space
                        break;
                    }
                }
            }
        }

        return morse.toString().trim();  // Return translated Morse code string
    }

    /**
     * Main method to run the Morse code translator program.
     * Handles user input and keeps the program running until the user chooses to quit.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = "";

        System.out.println("Welcome to the Morse Code Translator!");

        // Keep the program running until the user inputs 'Q' to quit
        while (!choice.equalsIgnoreCase("Q")) {
            // Display options for translation
            System.out.println("\nEnter '1' to translate Morse to English");
            System.out.println("Enter '2' to translate English to Morse");
            System.out.println("Enter 'Q' to quit");

            choice = scanner.nextLine();  // Get user input for the choice

            // Morse to English translation
            if (choice.equalsIgnoreCase("1")) {
                System.out.println("Enter Morse code (separate letters with spaces, words with '|'):");
                String morseInput = scanner.nextLine();  // Get Morse code input from the user
                String translation = morseToEnglish(morseInput);  // Perform the translation
                if (translation.startsWith("Error")) {
                    System.out.println(translation);  // Print error if invalid Morse code is detected
                } else {
                    System.out.println("English Translation: " + translation);  // Print the English translation
                }

            // English to Morse translation
            } else if (choice.equalsIgnoreCase("2")) {
                System.out.println("Enter English text:");
                String englishInput = scanner.nextLine();  // Get English text input from the user
                System.out.println("Morse Code Translation: " + englishToMorse(englishInput));  // Perform and print Morse code translation

            // Quit the program
            } else if (choice.equalsIgnoreCase("Q")) {
                System.out.println("Exiting the program. Goodbye!");

            // Handle invalid input choice
            } else {
                System.out.println("Invalid choice. Please enter '1', '2', or 'Q'.");
            }
        }

        scanner.close();  // Close the scanner resource
    }
}
