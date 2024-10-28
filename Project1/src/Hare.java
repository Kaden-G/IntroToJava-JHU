package Project1.src;
import java.util.Random;
// Hare class representing the hare racer
class Hare extends Racer {
    // Random number generator to determine the type of move
    private Random rand = new Random();

    // Override the move method to implement the hare's movement behavior
    @Override
    public void move() {
        int n = rand.nextInt(10) + 1; // Generates number between 1 and 10
        if (n <= 2) {
            setPosition(getPosition() + 9); // Big hop: 20% chance to move 9 squares to the right
        } else if (n <= 5) {
            setPosition(getPosition() + 1); // Small hop: 30% chance to move 1 square to the right
        } else if (n == 6) {
            setPosition(getPosition() - 12); // Big slip: 10% chance to move 12 squares to the left
        } else if (n <= 8) {
            setPosition(getPosition() - 2); // Small slip: 20% chance to move 2 squares to the left
        } else {
            System.out.println("Zzzzzz"); // Fall asleep: 20% chance, no movement
        }
    }
}