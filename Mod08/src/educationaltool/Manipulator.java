package educationaltool;

import educationaltool.entities.Animal;
import educationaltool.entities.Vehicle;
import educationaltool.interfaces.Drawable;
import educationaltool.interfaces.Rotatable;
import educationaltool.interfaces.Resizable;
import educationaltool.interfaces.Sounds;

public class Manipulator {
    public static void main(String[] args) {
        // Creating two Animal objects
        Animal animal1 = new Animal("Lion");
        Animal animal2 = new Animal("Elephant");

        // Creating two Vehicle objects
        Vehicle vehicle1 = new Vehicle("Car", 5);
        Vehicle vehicle2 = new Vehicle("Bike", 2);

        // Creating an array of Objects to store both Animals and Vehicles
        Object[] objects = {animal1, animal2, vehicle1, vehicle2};

        // Looping through the array and invoking methods polymorphically
        for (Object obj : objects) {
            if (obj instanceof Drawable) {
                ((Drawable) obj).drawObject();
            }
            if (obj instanceof Rotatable) {
                ((Rotatable) obj).rotateObject();
            }
            if (obj instanceof Resizable) {
                ((Resizable) obj).resizeObject();
            }
            if (obj instanceof Sounds) {
                ((Sounds) obj).playSound();
            }
            System.out.println(); // For better readability
        }
    }
}
