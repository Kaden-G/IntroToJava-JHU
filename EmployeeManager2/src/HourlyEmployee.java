package src;

// HourlyEmployee class extends Employee and represents an employee paid by the hour
public class HourlyEmployee extends Employee {
    private double hourlyPayRate; // Hourly pay rate of the employee
    private double hoursWorked;   // Hours worked by the employee

    // Constructor
    public HourlyEmployee(int employeeNumber, Name name, Address address, Date hireDate, double hourlyPayRate, double hoursWorked) {
        super(employeeNumber, name, address, hireDate); // Calls the constructor of the superclass (Employee)
        validateHourlyPayRate(hourlyPayRate); // Validates the hourly pay rate to ensure it is positive
        validateHoursWorked(hoursWorked);     // Validates the hours worked to ensure it is non-negative
        this.hourlyPayRate = hourlyPayRate;
        this.hoursWorked = hoursWorked;
    }

    // Getters and Setters
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        validateHourlyPayRate(hourlyPayRate); // Validates the hourly pay rate before setting
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        validateHoursWorked(hoursWorked); // Validates the hours worked before setting
        this.hoursWorked = hoursWorked;
    }

    // Validation methods
    private void validateHourlyPayRate(double hourlyPayRate) {
        if (hourlyPayRate <= 0) {
            throw new IllegalArgumentException("Hourly pay rate must be positive."); // Throws an error if hourly pay rate is invalid
        }
    }

    private void validateHoursWorked(double hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked must be non-negative."); // Throws an error if hours worked is negative
        }
    }

    // Calculate Earnings
    protected double calculateEarnings() {
        // Calculates earnings considering overtime pay for hours worked over 40
        if (hoursWorked > 40) {
            return (40 * hourlyPayRate) + ((hoursWorked - 40) * hourlyPayRate * 1.5);
        } else {
            return hoursWorked * hourlyPayRate;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nHourly Pay Rate: $" + hourlyPayRate +
                "\nHours Worked: " + hoursWorked +
                "\nEarnings: $" + calculateEarnings();
    }
}
