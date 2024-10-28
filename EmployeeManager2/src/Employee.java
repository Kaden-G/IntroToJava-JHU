package src;

// Employee class represents an employee with various attributes including name, address, and hire date
public class Employee {
    // Attributes representing the employee number, name, address, and hire date
    private int employeeNumber;
    private Name name;
    private Address address;
    private Date hireDate;

    // Constructor to initialize the employee fields with validation
    public Employee(int employeeNumber, Name name, Address address, Date hireDate) {
        validateEmployeeNumber(employeeNumber); // Validates the employee number to ensure it is positive
        validateNotNull(name, "Name cannot be null."); // Ensures that name is not null
        validateNotNull(address, "Address cannot be null."); // Ensures that address is not null
        validateNotNull(hireDate, "Hire date cannot be null."); // Ensures that hire date is not null
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.address = address;
        this.hireDate = hireDate;
    }

    // Getter methods for each attribute
    public int getEmployeeNumber() { return employeeNumber; }
    public Name getName() { return name; }
    public Address getAddress() { return address; }
    public Date getHireDate() { return hireDate; }

    // Setter methods to allow updating the employee's attributes
    public void setEmployeeNumber(int employeeNumber) {
        validateEmployeeNumber(employeeNumber); // Validates the employee number before setting
        this.employeeNumber = employeeNumber;
    }

    public void setName(Name name) {
        validateNotNull(name, "Name cannot be null."); // Ensures that name is not null before setting
        this.name = name;
    }

    public void setAddress(Address address) {
        validateNotNull(address, "Address cannot be null."); // Ensures that address is not null before setting
        this.address = address;
    }

    public void setHireDate(Date hireDate) {
        validateNotNull(hireDate, "Hire date cannot be null."); // Ensures that hire date is not null before setting
        this.hireDate = hireDate;
    }

    // Validation methods to avoid redundancy
    private void validateEmployeeNumber(int employeeNumber) {
        if (employeeNumber <= 0) {
            throw new IllegalArgumentException("Employee number must be a positive integer."); // Throws an error if employee number is invalid
        }
    }

    private void validateNotNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message); // Throws an error if the provided object is null
        }
    }

    // Override toString method to format the employee details output properly
    @Override
    public String toString() {
        return "Employee Number: " + employeeNumber + "\n" +
               "Name: " + name + "\n" +
               "Address: " + address + "\n" +   // This calls the Address's toString() method
               "Hire Date: " + hireDate;          // This calls the Date's toString() method
    }
}

