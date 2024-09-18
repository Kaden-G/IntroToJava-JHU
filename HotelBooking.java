import java.util.Scanner;  // Import the Scanner class for user input

/**
 * The HotelBooking class represents a simple system for managing hotel room bookings
 * across a year, checking room availability, and allowing users to book rooms.
 */
public class HotelBooking {

    /**
     * The main method is the entry point of the program. It initializes the room availability
     * and checks room availability based on user input.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int[][] roomAvailability = new int[20][365];  // Declare and initialize a 2D array for 20 rooms over 365 days
        initializeRoomAvailability(roomAvailability);  // Call the method to initialize the room availability with predefined bookings
        checkRoomAvailability(roomAvailability);  // Call the method to check room availability and allow booking based on user input
    }

    /**
     * Initializes the room availability array with specific pre-booked dates.
     * Even rooms are booked for even months.
     *
     * @param roomAvailability The 2D array representing room availability across the year.
     */
    public static void initializeRoomAvailability(int[][] roomAvailability) {
        // Book even-numbered rooms for even months
        for (int room = 1; room < 20; room += 2) {  // Loop through even room numbers (1-based index, so start at 1)
            // Book for February (days 32-59), April (days 91-120), June (days 152-181), etc.
            bookRoomForMonthRange(roomAvailability, room, 32, 59);   // Call method to book room for February
            bookRoomForMonthRange(roomAvailability, room, 91, 120);  // Call method to book room for April
            bookRoomForMonthRange(roomAvailability, room, 152, 181); // Call method to book room for June
            bookRoomForMonthRange(roomAvailability, room, 213, 244); // Call method to book room for August
            bookRoomForMonthRange(roomAvailability, room, 274, 305); // Call method to book room for October
            bookRoomForMonthRange(roomAvailability, room, 335, 364); // Call method to book room for December
        }
    }

    /**
     * Books a specific room for a given range of days.
     *
     * @param roomAvailability The 2D array representing room availability.
     * @param room The room number to be booked.
     * @param startDay The start day of the booking range.
     * @param endDay The end day of the booking range.
     */
    private static void bookRoomForMonthRange(int[][] roomAvailability, int room, int startDay, int endDay) {
        for (int day = startDay; day <= endDay; day++) {  // Loop through the range of days from startDay to endDay
            roomAvailability[room][day] = 1;  // Mark room as booked by setting value to 1 for each day in the range
        }
    }

    /**
     * Checks the availability of rooms for a user-specified date range and allows booking if available.
     *
     * @param roomAvailability The 2D array representing room availability across the year.
     */
    public static void checkRoomAvailability(int[][] roomAvailability) {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object for reading user input

        // Prompt user for start and end dates
        System.out.print("Enter start day (1-365): ");  // Ask user to enter the start day
        int startDay = scanner.nextInt() - 1;  // Read the input and subtract 1 to match array indexing (0-based)

        System.out.print("Enter end day (1-365): ");  // Ask user to enter the end day
        int endDay = scanner.nextInt() - 1;  // Read the input and subtract 1 to match array indexing (0-based)

        System.out.println("Checking room availability from day " + (startDay + 1) + " to day " + (endDay + 1) + "...");  // Display the date range being checked

        boolean availableRoomFound = false;  // Flag to check if any room is available

        // Loop through each room to check availability
        for (int room = 0; room < 20; room++) {  // Loop through all 20 rooms
            boolean isAvailable = true;  // Assume the room is available

            // Loop through the specified date range
            for (int day = startDay; day <= endDay; day++) {  // Loop through each day in the date range
                if (roomAvailability[room][day] == 1) {  // Check if the room is booked on any day in the range
                    isAvailable = false;  // If booked, mark room as unavailable
                    break;  // Exit the loop early since the room is not available for the entire range
                }
            }

            // If the room is available for the entire range, print it
            if (isAvailable) {  // Check if the room is available after the loop
                System.out.println("Room " + (room + 1) + " is available.");  // Print the available room number
                availableRoomFound = true;  // Set the flag to true since we found an available room
            }
        }

        // If at least one room is available, prompt user to select a room
        if (availableRoomFound) {  // Check if any room was found to be available
            System.out.print("Enter the room number you wish to book: ");  // Ask user to select a room
            int roomChoice = scanner.nextInt() - 1;  // Read the room number and adjust for 0-based index

            // Mark the selected room as booked for the entire date range
            for (int day = startDay; day <= endDay; day++) {  // Loop through the date range
                roomAvailability[roomChoice][day] = 1;  // Mark the selected room as booked for each day in the range
            }

            // Confirmation message
            System.out.println("Room " + (roomChoice + 1) + " is successfully booked for your stay!");  // Confirm booking to the user
        } else {
            System.out.println("No rooms are available for the selected date range.");  // Inform the user if no rooms are available
        }

        scanner.close();  // Close the scanner to prevent resource leaks
    }
}