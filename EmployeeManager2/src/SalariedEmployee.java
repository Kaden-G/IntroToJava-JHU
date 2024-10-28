package src;

// SalariedEmployee class extends Employee and represents an employee paid a fixed annual salary
public class SalariedEmployee extends Employee {
    private double annualSalary; // Annual salary of the employee

    // Constructor
    public SalariedEmployee(int employeeNumber, Name name, Address address, Date hireDate, double annualSalary) {
        super(employeeNumber, name, address, hireDate); // Calls the constructor of the superclass (Employee)
        validateAnnualSalary(annualSalary); // Validates the annual salary to ensure it is positive
        this.annualSalary = annualSalary;
    }

    // Getter and Setter for annualSalary
    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        validateAnnualSalary(annualSalary); // Validates the annual salary before setting
        this.annualSalary = annualSalary;
    }

    // Validation method
    private void validateAnnualSalary(double annualSalary) {
        if (annualSalary <= 0) {
            throw new IllegalArgumentException("Annual salary must be positive."); // Throws an error if annual salary is invalid
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nAnnual Salary: $" + annualSalary;
    }
}