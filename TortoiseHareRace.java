import java.util.Random;

public class TortoiseHareRace {

    // Constants for race settings
    private static final int RACE_END = 50;
    private static final int START_POSITION = 1;
    private static final int SLEEP_DURATION_MS = 500;

    public static void main(String[] args) {
        // Initialize positions for the tortoise and the hare
        int tortoisePosition = START_POSITION;
        int harePosition = START_POSITION;

        // Initialize random number generator
        Random random = new Random();

        // Start race message
        System.out.println("AND THEY'RE OFF!!");

        // Main race loop
        while (tortoisePosition < RACE_END && harePosition < RACE_END) {
            // Update positions based on random move selections
            tortoisePosition = updateTortoisePosition(tortoisePosition, random);
            harePosition = updateHarePosition(harePosition, random);

            // Display the race track with current positions
            displayRace(tortoisePosition, harePosition);

            // Check if there is a winner or if the race ends in a tie
            if (tortoisePosition >= RACE_END && harePosition >= RACE_END) {
                System.out.println("IT’S A TIE!!");
                break;
            } else if (tortoisePosition >= RACE_END) {
                System.out.println("TORTOISE WINS!!");
                break;
            } else if (harePosition >= RACE_END) {
                System.out.println("HARE WINS!!");
                break;
            }

            // Pause to simulate race progression
            pauseRace();
        }
    }

    /**
     * Updates the position of the tortoise based on a random move.
     *
     * @param position The current position of the tortoise.
     * @param random The random number generator to determine the move.
     * @return The new position of the tortoise.
     */
    private static int updateTortoisePosition(int position, Random random) {
        int move = random.nextInt(10) + 1;

        if (move <= 5) {
            position += 3; // Fast plod
        } else if (move <= 8) {
            position += 1; // Slow plod
        } else {
            position -= 6; // Slip
        }

        // Ensure position does not go below the starting position
        return Math.max(position, START_POSITION);
    }

    /**
     * Updates the position of the hare based on a random move.
     *
     * @param position The current position of the hare.
     * @param random The random number generator to determine the move.
     * @return The new position of the hare.
     */
    private static int updateHarePosition(int position, Random random) {
        int move = random.nextInt(10) + 1;

        if (move <= 2) {
            position += 9; // Big hop
        } else if (move <= 5) {
            position += 1; // Small hop
        } else if (move == 6) {
            position -= 12; // Big slip
        } else if (move <= 8) {
            position -= 2; // Small slip
        }
        // Fall asleep (no change in position for 9-10)

        // Ensure position does not go below the starting position
        return Math.max(position, START_POSITION);
    }

    /**
     * Displays the current positions of the tortoise and hare on the race track.
     *
     * @param tortoisePosition The current position of the tortoise.
     * @param harePosition The current position of the hare.
     */
    private static void displayRace(int tortoisePosition, int harePosition) {
        StringBuilder raceTrack = new StringBuilder();

        for (int i = 1; i <= RACE_END; i++) {
            if (i == tortoisePosition && i == harePosition) {
                raceTrack.append("OUCH!!");
                i += 5; // Skip extra positions occupied by "OUCH!!"
            } else if (i == tortoisePosition) {
                raceTrack.append("T");
            } else if (i == harePosition) {
                raceTrack.append("H");
            } else {
                raceTrack.append(" ");
            }
        }

        // Print the race track to the console
        System.out.println(raceTrack.toString());
    }

    /**
     * Pauses the race for a short duration to simulate race progression.
     */
    private static void pauseRace() {
        try {
            Thread.sleep(SLEEP_DURATION_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}