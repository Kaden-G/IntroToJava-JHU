package src;

// Custom Date class represents a date with validation for month, day, and year
public class Date {
    // Attributes for month, day, and year
    private int month;
    private int day;
    private int year;

    // Constructor to initialize the date with validation
    public Date(int month, int day, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12.");
        }
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Day must be between 1 and 31.");
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            throw new IllegalArgumentException("Day must be between 1 and 30 for the specified month.");
        }
        if (month == 2) {
            if (day > 29) {
                throw new IllegalArgumentException("February cannot have more than 29 days.");
            }
            if (day == 29 && !isLeapYear(year)) {
                throw new IllegalArgumentException("February 29 is only valid in a leap year.");
            }
        }
        if (year < 1900 || year > 2020) {
            throw new IllegalArgumentException("Year must be between 1900 and 2020.");
        }
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // Method to check if a given year is a leap year
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Getter methods for each attribute
    public int getMonth() { return month; }
    public int getDay() { return day; }
    public int getYear() { return year; }

    // Override toString method to format the date output as MM/DD/YYYY
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }
}
