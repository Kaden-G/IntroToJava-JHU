public class HotelBookingSystem {

    public static void main(String[] args) {
        int[][] roomAvailability = new int[20][365];  // 20 rooms, 365 days
        initializeRooms(roomAvailability);
        
        checkRoomAvailability(roomAvailability);
    }

    // Initialize all rooms with specific pre-booked dates for realism
    public static void initializeRooms(int[][] roomAvailability) {
        // Mark even-numbered rooms as booked for even months
        for (int i = 1; i < 20; i += 2) {  // Even room numbers: 2, 4, 6, etc.
            // Book for February (days 32-59), April (days 91-120), June (days 152-181), etc.
            for (int j = 32; j < 60; j++) roomAvailability[i][j] = 1;  // February
            for (int j = 91; j < 121; j++) roomAvailability[i][j] = 1;  // April
            for (int j = 152; j < 182; j++) roomAvailability[i][j] = 1;  // June
            for (int j = 213; j < 244; j++) roomAvailability[i][j] = 1;  // August
            for (int j = 274; j < 305; j++) roomAvailability[i][j] = 1;  // October
            for (int j = 335; j < 365; j++) roomAvailability[i][j] = 1;  // December
        }

        // Mark half of the odd-numbered rooms as booked for 2/3 of the year
        for (int i = 0; i < 20; i += 4) {  // Odd room numbers: 1, 5, 9, etc.
            for (int j = 0; j < 243; j++) {  // Approximately 2/3 of the year (243 days)
                roomAvailability[i][j] = 1;  // Mark as booked
            }
        }
    }

    // Method to check room availability for a given date range and allow room booking
    public static void checkRoomAvailability(int[][] roomAvailability) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for start and end dates
        System.out.print("Enter start day (1-365): ");
        int startDay = scanner.nextInt() - 1;  // Subtract 1 to match array indexing

        System.out.print("Enter end day (1-365): ");
        int endDay = scanner.nextInt() - 1;  // Subtract 1 to match array indexing

        System.out.println("Checking room availability from day " + (startDay + 1) + " to day " + (endDay + 1) + "...");

        // Loop through each room
        boolean availableRoomFound = false;  // Flag to check if any room is available
        for (int i = 0; i < 20; i++) {
            boolean isAvailable = true;

            // Loop through the specified date range
            for (int j = startDay; j <= endDay; j++) {
                if (roomAvailability[i][j] == 1) {  // If room is booked on any day in the range
                    isAvailable = false;
                    break;  // No need to check further days for this room
                }
            }

            // If the room is available for the entire range, print it
            if (isAvailable) {
                System.out.println("Room " + (i + 1) + " is available.");
                availableRoomFound = true;
            }
        }

        // If at least one room is available, prompt user to select a room
        if (availableRoomFound) {
            System.out.print("Enter the room number you wish to book: ");
            int roomChoice = scanner.nextInt() - 1;  // Subtract 1 to match array indexing

            // Mark the selected room as booked for the entire date range
            for (int j = startDay; j <= endDay; j++) {
                roomAvailability[roomChoice][j] = 1;  // Set the room as booked
            }

            // Confirmation message
            System.out.println("Room " + (roomChoice + 1) + " is successfully booked for your stay!");
        } else {
            System.out.println("No rooms are available for the selected date range.");
        }

        scanner.close();  // Close the scanner to prevent resource leaks
    }
}