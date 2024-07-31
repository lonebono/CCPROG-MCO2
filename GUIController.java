package MCO2.src;

import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController implements ActionListener{
    private MainGUIView view;
    private ReserveSystem reserveSystem;
    private CreateHotelGUI createHotelGUI;
    private ViewHotelGUI viewHotelGUI;
    private ManageHotelGUI manageHotelGUI;
    private BookRoomGUI bookRoomGUI;

    public GUIController(MainGUIView view, ReserveSystem reserveSystem){
        this.view = view;
        this.reserveSystem = reserveSystem;
        
        createHotelGUI = new CreateHotelGUI();
        viewHotelGUI = new ViewHotelGUI();
        manageHotelGUI = new ManageHotelGUI();
        bookRoomGUI = new BookRoomGUI();

        view.addCard( createHotelGUI, "Create");
        view.addCard(viewHotelGUI, "View");
        view.addCard(manageHotelGUI, "Manage");
        view.addCard(bookRoomGUI, "Book");

        // add action listeners to buttons
        view.getBtnCreate().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("Create");
                updateCreateHotelView();
            }
        });

        view.getBtnView().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("View");
                updateViewHotelView();
            }
        });

        view.getBtnManage().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("Manage");
                updateManageHotelView();
            }
        });

        view.getBtnBook().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("Book");
                updateBookRoomView();
            }
        });

        // Set up action listeners for other buttons
        createHotelGUI.getCreateHotelSubmit().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleCreateHotelSubmit();
            }
        });

        bookRoomGUI.getBookRoomSubmit().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleBookRoomSubmit();
            }
        });

        //View Hotel Action Listeners
        viewHotelGUI.getHighLevel().addActionListener(new ActionListener() { //High Level Button
            public void actionPerformed(ActionEvent e) {
                //handleGetHighLevel();

                //Unshow low options
                viewHotelGUI.getLowLevelOption().setVisible(false);
                viewHotelGUI.getLowOptions().setVisible(false);

                viewHotelGUI.getHotelViewDate().setVisible(false);
                viewHotelGUI.getViewDate().setVisible(false);

                viewHotelGUI.getRoomViewInfo().setVisible(false);
                viewHotelGUI.getViewRoom().setVisible(false);

                viewHotelGUI.getReservationViewInfo().setVisible(false);
                viewHotelGUI.getViewReserve().setVisible(false);
            }
        });

        viewHotelGUI.getLowLevel().addActionListener(new ActionListener() { //Low Level Button
            public void actionPerformed(ActionEvent e) {
                //handleGetLowLevel();

                //Show Low Options
                viewHotelGUI.getLowLevelOption().setVisible(true);
                viewHotelGUI.getLowOptions().setVisible(true);
                //Show Date Option
                viewHotelGUI.getHotelViewDate().setVisible(true);
                viewHotelGUI.getViewDate().setVisible(true);
                //Show Room Option
                viewHotelGUI.getRoomViewInfo().setVisible(true);
                viewHotelGUI.getViewRoom().setVisible(true);
                //Show Reserve Option
                viewHotelGUI.getReservationViewInfo().setVisible(true);
                viewHotelGUI.getViewReserve().setVisible(true);

            }
        });

    }

    private void updateCreateHotelView() {
        // Add logic to update the ViewHotelView
        // For example, create a hotel
        // Clear input fields
        createHotelGUI.getInputHotelName().setText(""); 
        createHotelGUI.getCreateRoomType().setText(""); 

        // Update the hotel list
        String hotelListText = "";
        for (Hotel hotel : reserveSystem.getHotelList()) {
            hotelListText += hotel.getHotelName() + "\n";
        }
        createHotelGUI.getCreateTextInfo().setText(hotelListText);
    }

    private void updateViewHotelView() {
        // Add logic to update the ViewHotelView
        // For example, display a list of hotels
        //viewHotelGUI.getHotelList().setText("Displaying list of hotels..."); example line
    }

    private void updateManageHotelView() {
        // Add logic to update the ManageHotelView
        // For example, show options for managing existing hotels
        //manageHotelView.getManageList().setText("Options for managing hotels..."); // example line
    }

    private void updateBookRoomView() {
        // Update the bookHotels JComboBox
        updateBookHotelsComboBox();

        // Update the bookRooms JComboBox
        updateBookRoomsComboBox();

        // Update the bookInInput JComboBox
        updateBookInInputComboBox();

        // Update the bookOutInput JComboBox
        updateBookOutInputComboBox();
    }

    private void handleCreateHotelSubmit() {
        // Extract data from CreateHotelView
        String hotelName = createHotelGUI.getInputHotelName().getText().trim();
        String roomType = createHotelGUI.getCreateRoomType().getText().trim();
        if (hotelName.isEmpty()) {
            createHotelGUI.getInputFeedback().setText("Hotel name cannot be empty.");
            return;
        }
        // Check if hotel already exists
        if (reserveSystem.getHotelList().stream().anyMatch(hotel -> hotel.getHotelName().equalsIgnoreCase(hotelName))) {
            createHotelGUI.getInputFeedback().setText("Hotel already exists.");
            return;
        }
        // Check if room type is valid
        if (!isValidRoomType(roomType)) {
            createHotelGUI.getInputFeedback().setText("Invalid room type.");
            return;
        }
        // Add hotel to the model
        reserveSystem.addHotel(hotelName);

        // Find the newly added hotel and add room to it
        for (Hotel hotel : reserveSystem.getHotelList()) {
            if (hotel.getHotelName().equalsIgnoreCase(hotelName)) {
                hotel.createRoom(roomType);
                break;
            }
        }   
        createHotelGUI.getInputFeedback().setText("Hotel successfully added");
        updateCreateHotelView();
    }

    //View Hotel Actions
    private void handleGetHighLevel() {
        // Extract data from CreateHotelView
        viewHotelGUI.getviewTextInfo().setText("Clicked");
        
        //Implement this
        /*System.out.print("Select a hotel to view: ");
        int hotelChoice = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (hotelChoice < 1 || hotelChoice > hotelList.size()) {
            System.out.println("Invalid choice.");
            return;
        }

        Hotel selectedHotel = hotelList.get(hotelChoice - 1);
        System.out.println("\nHotel: " + selectedHotel.getHotelName());
        System.out.println("Number of rooms: " + selectedHotel.getRoomList().size());
        System.out.println("Estimated earnings for the month: " + selectedHotel.calculateTotalEarnings());*/
    }

    private void handleGetLowLevel() {
        // Extract data from CreateHotelView
        viewHotelGUI.getviewTextInfo().setText("Clicked 2");
    }
    
    private boolean isValidRoomType(String roomType) {
        return roomType.equalsIgnoreCase("Standard") || roomType.equalsIgnoreCase("Deluxe") || roomType.equalsIgnoreCase("Executive");
    }

    private void handleBookRoomSubmit() {
        // Get the selected values from the JComboBoxes
        String hotelName = (String) bookRoomGUI.getBookHotels().getSelectedItem();
        String roomType = (String) bookRoomGUI.getBookRooms().getSelectedItem();
        int inDay = (int) bookRoomGUI.getBookInInput().getSelectedItem();
        int outDay = (int) bookRoomGUI.getBookOutInput().getSelectedItem();
        
        // Get the text from the JTextFields
        String name = bookRoomGUI.getBookNameInput().getText();
        String discountCode = bookRoomGUI.getBookDiscountInput().getText();
        
        // Validate the input and add the reservation to the hotel's arraylist of reservation objects
        Hotel selectedHotel = null;
        for (Hotel hotel : reserveSystem.getHotelList()) {
            if (hotel.getHotelName().equals(hotelName)) {
                selectedHotel = hotel;
                break;
            }
        }
        if (selectedHotel!= null) {
            Room room = selectedHotel.getRoom(roomType);
            if (room!= null) {
                Reservation reservation = new Reservation(name, inDay, outDay, room, discountCode);
                if (selectedHotel.addReservation(reservation)) {
                    bookRoomGUI.getBookFeedbackInput().setText("Reservation Success");
                } else {
                    bookRoomGUI.getBookFeedbackInput().setText("Reservation Failed");
                }
            } else {
                bookRoomGUI.getBookFeedbackInput().setText("Room not available");
            }
        } else {
            bookRoomGUI.getBookFeedbackInput().setText("Hotel not found");
        }
    }

    private void updateBookHotelsComboBox() {
        bookRoomGUI.getBookHotels().removeAllItems();
        for (Hotel hotel : reserveSystem.getHotelList()) {
            bookRoomGUI.getBookHotels().addItem(hotel.getHotelName());
        }
    }

    private void updateBookRoomsComboBox() {
        bookRoomGUI.getBookRooms().removeAllItems();
        // You need to get the selected hotel from bookHotels JComboBox
        String selectedHotel = (String) bookRoomGUI.getBookHotels().getSelectedItem();
        Hotel hotel = reserveSystem.getHotel(selectedHotel);
        if (hotel!= null) {
            for (Room room : hotel.getRoomList()) {
                bookRoomGUI.getBookRooms().addItem(room.getRoomType());
            }
        }
    }

    private void updateBookInInputComboBox() {
        bookRoomGUI.getBookInInput().removeAllItems();
        // You need to add days of the month to this JComboBox
        for (int i = 1; i <= 31; i++) {
            bookRoomGUI.getBookInInput().addItem(i);
        }
    }

    private void updateBookOutInputComboBox() {
        bookRoomGUI.getBookOutInput().removeAllItems();
        // You need to add days of the month to this JComboBox
        for (int i = 1; i <= 31; i++) {
            bookRoomGUI.getBookOutInput().addItem(i);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is not used in the current implementation
        // It's a placeholder for future implementation or can be removed
    }
    
    //ALL OF THE ACTIONS MUST FOLLOW MVC
    
}

