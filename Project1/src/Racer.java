package Project1.src;

import java.util.Random;

// Base class representing a Racer
class Racer {
    // Position of the racer on the track
    private int position;

    // Constructor initializing the racer's position to 1 (starting position)
    public Racer() {
        this.position = 1;
    }

    // Getter for the racer's position
    public int getPosition() {
        return position;
    }

    // Setter for the racer's position, ensuring it does not go below 1
    public void setPosition(int position) {
        if (position < 1) {
            this.position = 1; // Ensure position does not go below 1
        } else {
            this.position = position;
        }
    }

    // Default move method, can be overridden by subclasses to provide specific movement behavior
    public void move() {
        // No default movement behavior, subclasses should override this method
    }
} 
    

