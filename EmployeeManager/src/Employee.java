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
        if (employeeNumber <= 0) {
            throw new IllegalArgumentException("Employee number must be a positive integer.");
        }
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        if (hireDate == null) {
            throw new IllegalArgumentException("Hire date cannot be null.");
        }
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
        if (employeeNumber <= 0) {
            throw new IllegalArgumentException("Employee number must be a positive integer.");
        }
        this.employeeNumber = employeeNumber;
    }

    public void setName(Name name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        this.name = name;
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        this.address = address;
    }

    public void setHireDate(Date hireDate) {
        if (hireDate == null) {
            throw new IllegalArgumentException("Hire date cannot be null.");
        }
        this.hireDate = hireDate;
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
