package Project1.src;
import java.util.Random;
// Tortoise class representing the tortoise racer
class Tortoise extends Racer {
    // Random number generator to determine the type of move
    private Random rand = new Random();

    // Override the move method to implement the tortoise's movement behavior
    @Override
    public void move() {
        int n = rand.nextInt(10) + 1; // Generates number between 1 and 10
        if (n <= 5) {
            setPosition(getPosition() + 3); // Fast plod: 50% chance to move 3 squares to the right
        } else if (n <= 8) {
            setPosition(getPosition() + 1); // Slow plod: 30% chance to move 1 square to the right
        } else {
            setPosition(getPosition() - 6); // Slip: 20% chance to move 6 squares to the left
        }
    }
}
