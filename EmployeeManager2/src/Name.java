package src;

public class Name {
    private String firstName;
    private String lastName;

    // Constructor
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter methods
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // Override toString method to display the full name
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
