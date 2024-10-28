package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// EmployeeManager class handles user interaction and manages employee data
public class EmployeeManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>(); // Using ArrayList for dynamic resizing

        System.out.println("Welcome to the Employee Management System!");
        boolean continueEntering = true;

        // Loop to collect multiple employees
        while (continueEntering) {
            try {
                // Collecting employee number
                int employeeNumber;
                while (true) {
                    try {
                        System.out.print("Enter employee number (4-digit positive integer): ");
                        employeeNumber = Integer.parseInt(scanner.nextLine());
                        if (employeeNumber < 1000 || employeeNumber > 9999) {
                            throw new IllegalArgumentException("Employee number must be a 4-digit positive integer.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                // Collecting name information
                String firstName;
                String lastName;
                while (true) {
                    try {
                        System.out.print("Enter first name: ");
                        firstName = scanner.nextLine().trim();
                        if (firstName.isEmpty() || !firstName.matches("[a-zA-Z]+")) {
                            throw new IllegalArgumentException("First name cannot be blank and must contain only letters.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter last name: ");
                        lastName = scanner.nextLine().trim();
                        if (lastName.isEmpty() || !lastName.matches("[a-zA-Z]+")) {
                            throw new IllegalArgumentException("Last name cannot be blank and must contain only letters.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                Name name = new Name(firstName, lastName);

                // Collecting address information
                String streetNumber;
                String streetName;
                while (true) {
                    try {
                        System.out.print("Enter street number (positive integer): ");
                        streetNumber = scanner.nextLine().trim();
                        if (!streetNumber.matches("\\d+") || Integer.parseInt(streetNumber) <= 0) {
                            throw new IllegalArgumentException("Street number must be a positive integer.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter street name: ");
                        streetName = scanner.nextLine().trim();
                        if (streetName.isEmpty() || !streetName.matches("[a-zA-Z ]+")) {
                            throw new IllegalArgumentException("Street name must contain only letters and spaces.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                String street = streetNumber + " " + streetName;

                String city;
                while (true) {
                    try {
                        System.out.print("Enter city: ");
                        city = scanner.nextLine().trim();
                        if (city.isEmpty() || !city.matches("[a-zA-Z ]+")) {
                            throw new IllegalArgumentException("City must contain only letters and spaces.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                String state;
                while (true) {
                    try {
                        System.out.print("Enter state (2 characters): ");
                        state = scanner.nextLine().trim();
                        if (state.length() != 2 || !state.matches("[a-zA-Z]+")) {
                            throw new IllegalArgumentException("State must be exactly 2 letters.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                String zipCode;
                while (true) {
                    try {
                        System.out.print("Enter zip code (5 digits): ");
                        zipCode = scanner.nextLine().trim();
                        if (!zipCode.matches("\\d{5}")) {
                            throw new IllegalArgumentException("Zip code must be exactly 5 digits.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                Address address = new Address(street, city, state, zipCode);

                // Collecting hire date information
                int month;
                int day;
                int year;

                while (true) {
                    try {
                        System.out.print("Enter hire month (1-12): ");
                        month = Integer.parseInt(scanner.nextLine());
                        if (month < 1 || month > 12) {
                            throw new IllegalArgumentException("Month must be between 1 and 12.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter hire day (1-31): ");
                        day = Integer.parseInt(scanner.nextLine());
                        if (day < 1 || day > 31) {
                            throw new IllegalArgumentException("Day must be between 1 and 31.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.print("Enter hire year (1900-2020): ");
                        year = Integer.parseInt(scanner.nextLine());
                        if (year < 1900 || year > 2020) {
                            throw new IllegalArgumentException("Year must be between 1900 and 2020.");
                        }
                        break; // Break the loop if valid
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                Date hireDate = new Date(month, day, year);

                // Creating and adding employee to the list
                Employee employee = new Employee(employeeNumber, name, address, hireDate);
                employees.add(employee);
                System.out.println("Employee added successfully!");

            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }

            // Asking user if they want to continue adding employees
            System.out.print("Would you like to add another employee? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                continueEntering = false;
            }
        }

        // Displaying all employees
        System.out.println("\nList of Employees:");
        System.out.println("-----------------------");
        for (Employee emp : employees) {
            System.out.println(emp);
            System.out.println("-----------------------");  // Separator line for readability
        }

        // Close the Scanner object to avoid resource leaks
        scanner.close();
        System.out.println("Program exited. Goodbye!");  // Exit message when the program ends
    }
}
