package Project1.src;
// Race class to control the race between the tortoise and the hare

public class Race {
    // Constant representing the finish line position
    private static final int FINISH_LINE = 50;
    // Instances of Tortoise and Hare
    private Tortoise tortoise;
    private Hare hare;

    // Constructor to initialize the race by creating the racers
    public Race() {
        tortoise = new Tortoise();
        hare = new Hare();
    }

    // Method to start the race and control the flow of the race
    public void startRace() {
        System.out.println("AND THEY'RE OFF!!");
        // Loop until one of the racers reaches or passes the finish line
        while (tortoise.getPosition() < FINISH_LINE && hare.getPosition() < FINISH_LINE) {
            tortoise.move(); // Move the tortoise
            hare.move(); // Move the hare
            printPositions(); // Print the current positions of both racers
        }
        // Determine the winner once the race is over
        determineWinner();
    }

    // Method to print the current positions of the tortoise and hare on the track
    private void printPositions() {
        int tortoisePos = tortoise.getPosition() - 1;
        int harePos = hare.getPosition() - 1;

        // Create a character array representing the race track
        char[] track = new char[FINISH_LINE];
        for (int i = 0; i < track.length; i++) {
            track[i] = ' '; // Initialize all positions as blank
        }
         // Check if both racers are on the same position
         if (tortoisePos == harePos) {
            System.out.println("OUCH!! Tortoise bites Hare!");
        } else {
            // Place 'T' for the tortoise's position if within track bounds
            if (tortoisePos < FINISH_LINE) track[tortoisePos] = 'T';
            // Place 'H' for the hare's position if within track bounds
            if (harePos < FINISH_LINE) track[harePos] = 'H';

            // Print the track to show the current positions of both racers
            System.out.println(new String(track));
        }
    }

    // Method to determine and print the winner of the race
    private void determineWinner() {
        if (tortoise.getPosition() >= FINISH_LINE && hare.getPosition() >= FINISH_LINE) {
            System.out.println("IT'S A TIE!!"); // If both reach the finish line at the same time
        } else if (tortoise.getPosition() >= FINISH_LINE) {
            System.out.println("TORTOISE WINS!!"); // If the tortoise reaches the finish line first
        } else {
            System.out.println("HARE WINS!!"); // If the hare reaches the finish line first
        }
    }

    // Main method to initiate the race
    public static void main(String[] args) {
        Race race = new Race(); // Create a Race instance
        race.startRace(); // Start the race
    }
}