package MCO2.src;

import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController implements ActionListener{
    private MainGUIView view;
    private Main model;
    private CreateHotelGUI createHotelGUI;
    private ViewHotelGUI viewHotelGUI;
    private ManageHotelGUI manageHotelGUI;
    private BookRoomGUI bookRoomGUI;

    public GUIController(MainGUIView view, Main model){
        this.view = view;
        this.model = model;
        
        createHotelGUI = new CreateHotelGUI();
        viewHotelGUI = new ViewHotelGUI();
        manageHotelGUI = new ManageHotelGUI();
        bookRoomGUI = new BookRoomGUI();

        view.add(createHotelGUI, "Create");
        view.add(viewHotelGUI, "View");
        view.add(manageHotelGUI, "Manage");
        view.add(bookRoomGUI, "Book");

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
        // Add logic to update the CreateHotelView, if needed
        // For example, you can reset fields or update information
        //createHotelGUI.getCreateTextInfo().setText("Fill out the form to create a new hotel."); example line
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
        //String hotelName = createHotelGUI.getInputHotelName().getText();
        //String roomType = createHotelGUI.getCreateRoomType().getText();
        //String feedback = createHotelGUI.getInputFeedback().getText();

        // Validate inputs
        //if (hotelName.isEmpty() || roomType.isEmpty()) {
        //    createHotelView.getCreateTextInfo().append("Please fill in all fields.\n");
        //    return;
        //}

        // Create a new hotel using the model
        //model.createHotel(hotelName, roomType);

        // Provide feedback to the user
        //createHotelGUI.getCreateTextInfo().append("Hotel created: " + hotelName + " with room type: " + roomType + "\n");

        // Optionally, reset fields
        //createHotelView.getInputHotelName().setText("");
        //createHotelView.getCreateRoomType().setText("");
        //createHotelView.getInputFeedback().setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is not used in the current implementation
        // It's a placeholder for future implementation or can be removed
    }
    
    public void updateView(){
        // Create different panels with BorderLayout for CardLayout

        //Book Reservation Panel
        //Panels
        JPanel card4 = new JPanel(new BorderLayout());
        JPanel bookList = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBookList = new GridBagConstraints();
        gbcBookList.insets = new Insets(0, 0, 10, 0);
        JPanel bookInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBookInput = new GridBagConstraints();
        gbcBookInput.insets = new Insets(0, 0, 10, 0);

        card4.setBackground(Color.GRAY);
        //Booking Information
        bookList.setPreferredSize(new Dimension(400, 600));
        card4.add(bookList, BorderLayout.WEST);
        JLabel bookHotelLabel = new JLabel("Select Hotel: ");
        gbcBookList.gridx = 0; gbcBookList.gridy = 0; 
        bookList.add(bookHotelLabel, gbcBookList);
        JComboBox bookHotels = new JComboBox<>();
        gbcBookList.gridx = 1; gbcBookList.gridy = 0;
        bookHotels.setPreferredSize(new Dimension(200, 20));
        bookList.add(bookHotels, gbcBookList);
        JLabel bookRoomsLabel = new JLabel("Select Room: ");
        gbcBookList.gridx = 0; gbcBookList.gridy = 1;
        bookList.add(bookRoomsLabel, gbcBookList);
        JComboBox bookRooms = new JComboBox<>();
        gbcBookList.gridx = 1; gbcBookList.gridy = 1;
        bookRooms.setPreferredSize(new Dimension(200, 20));
        bookList.add(bookRooms, gbcBookList);

        //Booking Input
        bookInput.setPreferredSize(new Dimension(400,600));
        card4.add(bookInput, BorderLayout.EAST);
        JLabel bookNameLabel = new JLabel("Name:", JLabel.CENTER);
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 0;
        bookInput.add(bookNameLabel, gbcBookInput);
        JTextField bookNameInput = new JTextField(15);
        gbcBookInput.gridx = 1; gbcBookInput.gridy = 0;
        bookInput.add(bookNameInput, gbcBookInput);
        JLabel bookInLabel = new JLabel("Check-In Day:", JLabel.CENTER);
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 1;
        bookInput.add(bookInLabel, gbcBookInput);
        JComboBox bookInInput = new JComboBox<>();
        gbcBookInput.gridx = 1; gbcBookInput.gridy = 1;
        bookInInput.setPreferredSize(new Dimension(50, 20));
        bookInput.add(bookInInput, gbcBookInput);
        JLabel bookOutLabel = new JLabel("Check-Out Day:", JLabel.CENTER);
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 2;
        bookInput.add(bookOutLabel, gbcBookInput);
        JComboBox bookOutInput = new JComboBox<>();
        gbcBookInput.gridx = 1; gbcBookInput.gridy = 2;
        bookOutInput.setPreferredSize(new Dimension(50, 20));
        bookInput.add(bookOutInput, gbcBookInput);
        JButton bookRoomSubmit = new JButton("Submit");
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 3; gbcBookInput.gridwidth = 2;
        bookInput.add(bookRoomSubmit, gbcBookInput);

        

        // Add the cards to the card panel
        //view.addCard(card1, "Create");
        //view.addCard(card2, "View");
        //view.addCard(card3, "Manage");
        //view.addCard(card4, "Book");
    }


    private JPanel createHotelPanel() {
        // Hotel creation panel implementation (similar to your current implementation)
        // Return the created panel
        JPanel card1 = new JPanel(new BorderLayout());
        // Your current panel creation code here
        return card1;
    }

    //ALL OF THE ACTIONS //  tries to FOLLOW MVC
    

    //@Override //comment out for now
    //public void actionPerformed(ActionEvent e) {
    //    // TODO Auto-generated method stub
    //    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    //}
}

