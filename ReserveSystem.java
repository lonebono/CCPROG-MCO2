package MCO2.src;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages operations related to hotels and reservations in a hotel reservation system.
 */
public class ReserveSystem {
    private ArrayList<Hotel> hotelList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    /**
     * Adds a new hotel to the system.
     */
    public void addHotel(String inputHotelName) {
        String hotelName = inputHotelName;
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                return;
            }
        }
        hotelList.add(new Hotel(hotelName));
        System.out.println("Hotel " + hotelName + " has been added.");
    }

    /**
     * Displays information about hotels in the system.
     * Allows viewing details like available rooms, bookings, and reservations.
     */
    public void viewHotel() {
        if (hotelList.isEmpty()) {
            System.out.println("No hotels available.");
            return;
        }

        System.out.println("List of Hotels:");
        for (int i = 0; i < hotelList.size(); i++) {
            System.out.println((i + 1) + ". " + hotelList.get(i).getHotelName());
        }

        System.out.print("Select a hotel to view: ");
        int hotelChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (hotelChoice < 1 || hotelChoice > hotelList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Hotel selectedHotel = hotelList.get(hotelChoice - 1);
        System.out.println("\nHotel: " + selectedHotel.getHotelName());
        System.out.println("Number of rooms: " + selectedHotel.getRoomList().size());
        System.out.println("Estimated earnings for the month: " + selectedHotel.calculateTotalEarnings());

        System.out.println("\nAvailable low-level information:");
        System.out.println("[1] Total number of available and booked rooms for a selected day");
        System.out.println("[2] Room Info");
        System.out.println("[3] Reservation Info");
        System.out.print("Select an option: ");
        int infoChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (infoChoice) {
            case 1:
                System.out.print("Enter a date (1-30): ");
                int date = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.println("Total number of available rooms on day " + date + ": " + selectedHotel.getAvailableRooms(date));
                System.out.println("Total number of booked rooms on day " + date + ": " + selectedHotel.getBookedRooms(date));
                break;
            case 2:
                System.out.println("Enter room number: ");
                // Shows the roomList
                ArrayList<Room> roomList = selectedHotel.getRoomList();
                for (int i = 0; i < roomList.size(); i++){
                    if(roomList.get(i).getPricePerNight() == selectedHotel.getBasePrice()){
                        System.out.println("Room " + (i+1) + ": Standard");
                    }
                    if(roomList.get(i).getPricePerNight() == (selectedHotel.getBasePrice() * 1.20)){
                        System.out.println("Room " + (i+1) + ": Deluxe");
                    }
                    if(roomList.get(i).getPricePerNight() == (selectedHotel.getBasePrice() * 1.35)){
                        System.out.println("Room " + (i+1) + ": Executive");
                    }
                }
                int roomNumber = sc.nextInt();
                sc.nextLine(); // Consume newline
                Room room = selectedHotel.getRoom(roomNumber);
                if (room != null) {
                    System.out.println("Room Number: " + room.getRoomNumber());
                    System.out.println("Price per night: " + room.getPricePerNight());
                    System.out.println("Availability for the entire month: " + room.getAvail());
                } else {
                    System.out.println("Room not found.");
                }
                break;
            case 3:
                System.out.print("Enter the guest name for the reservation: ");
                String guestName = sc.nextLine();
                Reservation reservation = selectedHotel.getReservationByGuestName(guestName);
                if (reservation != null) {
                    System.out.println("Guest Name: " + reservation.getGuestName());
                    System.out.println("Room Number: " + reservation.getRoomInfo().getRoomNumber());
                    System.out.println("Check-in Day: " + reservation.getInDay());
                    System.out.println("Check-out Day: " + reservation.getOutDay());
                    System.out.println("Total Price: " + reservation.getBookPrice());
                    System.out.println("Price Breakdown: " + reservation.getRoomInfo().getPricePerNight() + " per night");
                } else {
                    System.out.println("Reservation not found.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    /**
     * Manages operations for a specific hotel in the system.
     * Allows adding rooms, updating prices, canceling reservations, and more.
     */
    public void manageHotel() {
        if (hotelList.isEmpty()) {
            System.out.println("No hotels available.");
            return;
        }

        System.out.println("List of Hotels:");
        for (int i = 0; i < hotelList.size(); i++) {
            System.out.println((i + 1) + ". " + hotelList.get(i).getHotelName());
        }

        System.out.print("Select number of hotel to manage: ");
        int hotelChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (hotelChoice < 1 || hotelChoice > hotelList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Hotel selectedHotel = hotelList.get(hotelChoice - 1);
        while (true) {
            System.out.println("\nManaging Hotel: " + selectedHotel.getHotelName());
            System.out.println("[1] Add Room");
            System.out.println("[2] Remove Room");
            System.out.println("[3] Update Base Price");
            System.out.println("[4] Cancel Reservation");
            System.out.println("[5] Change Hotel Name");
            System.out.println("[6] Remove Hotel");
            System.out.println("[7] Change Day Price Rate");
            System.out.println("[8] Back");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    //selectedHotel.createRoom();
                    break;
                case 2:
                    //selectedHotel.removeRoom();
                    break;
                case 3:
                    System.out.print("Enter the new price: ");
                    double price = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    selectedHotel.setPrice(price);
                    break;
                case 4:
                    System.out.print("Enter the guest name for the reservation to cancel: ");
                    String guestName = sc.nextLine();
                    Reservation reservation = selectedHotel.getReservationByGuestName(guestName);
                    if (reservation != null) {
                        selectedHotel.cancelReserve(reservation);
                        System.out.println("Reservation has been canceled.");
                    } else {
                        System.out.println("Reservation not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter new hotel name: ");
                    String newHotelName = sc.nextLine();
                    boolean nameExists = false;
                    for (Hotel hotel : hotelList) {
                        if (hotel.getHotelName().equalsIgnoreCase(newHotelName)) {
                            System.out.println("A hotel with this name already exists.");
                            nameExists = true;
                            break;
                        }
                    }
                    if (!nameExists) {
                        selectedHotel.setHotelName(newHotelName);
                        System.out.println("Hotel name changed to: " + newHotelName);
                    }
                    break;
                case 6:
                    if (!selectedHotel.getReservationList().isEmpty()) {
                        System.out.println("Hotel has existing reservations. Are you sure you want to remove it? YES[1] NO[Any Other Number]");
                        int confirm = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        if (confirm != 1) {
                            System.out.println("Hotel removal canceled.");
                            break;
                        }
                    }
                    hotelList.remove(selectedHotel);
                    System.out.println("Hotel has been removed.");
                    return; // gets out of the method loop
                case 7:
                    System.out.println("Setting price rate for specific days:");
                    selectedHotel.printAvailableDaysForPriceChange();
                    System.out.println("Enter the day (1-30) you want to modify: "); // is a day -> day basis so not including 31
                    int day = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    if (day < 1 || day > 30) {
                        System.out.println("Invalid day.");
                        break;
                    }
                    System.out.println("Enter the new price rate (0.5 to 1.5): ");
                    double rate = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    if (rate < 0.5 || rate > 1.5) {
                        System.out.println("Invalid price rate.");
                        break;
                    }
                    boolean canChange = true;
                    for (Room room : selectedHotel.getRoomList()) {
                        if (!room.isAvailable(day, day + 1)) {
                            canChange = false;
                            break;
                        }
                    } 
                    if (canChange) {
                        for (Room room : selectedHotel.getRoomList()) {
                            room.setPriceRate(day, rate);
                        }
                        System.out.println("Price rate updated successfully.");
                    } else {
                        System.out.println("Cannot change price rate for this day as some rooms are reserved.");
                    }
                    break;
                case 8:
                    return; // Go back to the main menu
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * Books a reservation in a selected hotel for specified check-in and check-out dates.
     */
    public void bookReserve() {
        Scanner sc = new Scanner(System.in); 
        if (hotelList.isEmpty()) {
            System.out.println("No hotels available.");
            return;
        }

        System.out.println("List of Hotels:");
        for (int i = 0; i < hotelList.size(); i++) {
            System.out.println((i + 1) + ". " + hotelList.get(i).getHotelName());
        }

        System.out.print("Select a hotel to book a reservation: ");
        int hotelChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (hotelChoice < 1 || hotelChoice > hotelList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Hotel selectedHotel = hotelList.get(hotelChoice - 1);
        System.out.print("Enter check-in date (1-30): ");
        int inDay = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter check-out date (2-31): ");
        int outDay = sc.nextInt();
        sc.nextLine(); // Consume newline

        //sc.close();

        if (selectedHotel.canBookReservation(inDay, outDay)) {
            selectedHotel.bookReserve(inDay, outDay, null, outDay, null);
        } else {
            System.out.println("No available rooms for the selected dates.");
        }
    }
}
