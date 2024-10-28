package src;

// Name class represents an employee's full name consisting of a first and last name
public class Name {
    // Attributes for the first and last name
    private String firstName;
    private String lastName;

    // Constructor to initialize the name fields with validation
    public Name(String firstName, String lastName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be blank.");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be blank.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter methods for each attribute
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    // Setter methods to allow updating the first and last name
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be blank.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be blank.");
        }
        this.lastName = lastName;
    }

    // Override toString method to format the name output properly
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
