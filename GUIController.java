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
        // Add logic to update the BookRoomView
        // For example, show options for booking rooms
        //bookRoomGUI.getBookingInfo().setText("Options for booking rooms..."); // example
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

    private boolean isValidRoomType(String roomType) {
        return roomType.equalsIgnoreCase("Standard") || roomType.equalsIgnoreCase("Deluxe") || roomType.equalsIgnoreCase("Executive");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is not used in the current implementation
        // It's a placeholder for future implementation or can be removed
    }
    
    //public void updateView(){
        // Create different panels with BorderLayout for CardLayout

        // Add the cards to the card panel
        //view.addCard(card1, "Create");
        //view.addCard(card2, "View");
        //view.addCard(card3, "Manage");
        //view.addCard(card4, "Book");
    //}

    //ALL OF THE ACTIONS //  tries to FOLLOW MVC
    
}

