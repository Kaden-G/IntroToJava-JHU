package src;

// Address class represents a physical address with multiple components
public class Address {
    // Attributes representing different components of an address
    private final String street;
    private final String city;
    private final String state;
    private final String zipCode;

    // Constructor to initialize all fields with validation
    public Address(String street, String city, String state, String zipCode) {
        if (street == null || street.trim().isEmpty()) {
            throw new IllegalArgumentException("Street cannot be blank.");
        }
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be blank.");
        }
        if (state == null || state.length() != 2) {
            throw new IllegalArgumentException("State must be exactly 2 characters.");
        }
        if (zipCode == null || zipCode.length() != 5 || !zipCode.matches("\\d{5}")) {
            throw new IllegalArgumentException("Zip code must be exactly 5 digits.");
        }
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    // Getter methods to access each field
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }

    // Override toString method to format the address output properly
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipCode;
    }
}
