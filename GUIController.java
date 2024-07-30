package MCO2.src;

import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIController implements ActionListener{
    private MainGUIView view;
    private Main model;

    public GUIController(MainGUIView view, Main model){
        this.view = view;
        this.model = model;

        updateView();
        // add action listeners to buttons
        view.getBtnCreate().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("Create");
                //TO FOLLOW ALL ABOUT CREATE

            }
        });

        view.getBtnView().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("View");
                //TO FOLLOW ALL ABOUT VIEW
            }
        });

        view.getBtnManage().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("Manage");
                //TO FOLLOW ALL ABOUT MANAGE
            }
        });

        view.getBtnBook().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("Book");
                //TO FOLLOW ALL ABOUT BOOK
            }
        });
    }
    
    public void updateView(){
        // Create different panels with BorderLayout for CardLayout

        // Hotel Creation Panel
        // Panels
        JPanel card1 = new JPanel(new BorderLayout());
        JPanel createList = new JPanel(new GridBagLayout());
        JPanel createInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcCreateList = new GridBagConstraints();
        gbcCreateList.insets = new Insets(0, 0, 10, 0); // Padding // top left bot right
        gbcCreateList.fill = GridBagConstraints.BOTH; // Fill horizontally and vertically
        GridBagConstraints gbcCreateInput = new GridBagConstraints();
        gbcCreateInput.insets = new Insets(0, 0, 10, 0);
        // i don't want to take the entire space i want it centered // no .fill for now 

        card1.setBackground(Color.GRAY);
        //createList
        createList.setPreferredSize(new Dimension(400, 600));
        card1.add(createList, BorderLayout.WEST);
        JLabel createLabelInfo = new JLabel("Hotel Creation Info", JLabel.CENTER);
        gbcCreateList.gridx = 0; gbcCreateList.gridy = 0; gbcCreateList.weightx = 0.05; gbcCreateList.weighty = 0.05; 
        createList.add(createLabelInfo, gbcCreateList); // adds the label
        JTextArea createTextInfo = new JTextArea();
        createTextInfo.setEditable(false);
        createTextInfo.setLineWrap(true);
        JScrollPane infoScroll = new JScrollPane(createTextInfo); // Wrap text field in scroll pane
        infoScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        infoScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        gbcCreateList.gridx = 0; gbcCreateList.gridy = 1; gbcCreateList.weightx = 0.3; gbcCreateList.weighty = 0.3;
        createList.add(infoScroll, gbcCreateList); // adds the info list
        //createInput
        createInput.setPreferredSize(new Dimension(400,600));
        card1.add(createInput, BorderLayout.EAST);
        JLabel createFeedbackLabel= new JLabel("Feedback:", JLabel.CENTER);
        gbcCreateInput.gridx = 0; gbcCreateInput.gridy = 0;
        createInput.add(createFeedbackLabel, gbcCreateInput);
        JTextField inputFeedback = new JTextField(15);
        gbcCreateInput.gridx = 1; gbcCreateInput.gridy = 0;
        createInput.add(inputFeedback, gbcCreateInput);
        JLabel inputHotelLabel = new JLabel("Hotel Name:", JLabel.CENTER);
        gbcCreateInput.gridx = 0; gbcCreateInput.gridy = 1; 
        createInput.add(inputHotelLabel, gbcCreateInput);
        JTextField inputHotelName = new JTextField(15);
        gbcCreateInput.gridx = 1; gbcCreateInput.gridy = 1;
        createInput.add(inputHotelName, gbcCreateInput);
        JLabel createRoomLabel = new JLabel("Room Type:", JLabel.CENTER);
        gbcCreateInput.gridx = 0; gbcCreateInput.gridy = 2;
        createInput.add(createRoomLabel, gbcCreateInput);
        JTextField createRoomType = new JTextField(15);
        gbcCreateInput.gridx = 1; gbcCreateInput.gridy = 2;
        createInput.add(createRoomType, gbcCreateInput);
        JButton createHotelSubmit = new JButton("Submit");
        gbcCreateInput.gridx = 0; gbcCreateInput.gridy = 3; gbcCreateInput.gridwidth = 2;
        createInput.add(createHotelSubmit, gbcCreateInput);
        

        //View Hotel Panel
        JPanel card2 = new JPanel(new BorderLayout());
        card2.setBackground(Color.GREEN);
        card2.add(new JButton("East"), BorderLayout.EAST);
        card2.add(new JButton("West"), BorderLayout.WEST);

        //Manage Hotel Panel
        JPanel card3 = new JPanel(new BorderLayout());
        card3.setBackground(Color.BLUE);
        card3.add(new JButton("East"), BorderLayout.EAST);
        card3.add(new JButton("West"), BorderLayout.WEST);


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
        bookHotels.setPreferredSize(new Dimension(200, 30));
        bookList.add(bookHotels, gbcBookList);
        JLabel bookRoomsLabel = new JLabel("Select Room: ");
        gbcBookList.gridx = 0; gbcBookList.gridy = 1;
        bookList.add(bookRoomsLabel, gbcBookList);
        JComboBox bookRooms = new JComboBox<>();
        gbcBookList.gridx = 1; gbcBookList.gridy = 1;
        bookRooms.setPreferredSize(new Dimension(200, 30));
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
        JTextField bookInInput = new JTextField(15);
        gbcBookInput.gridx = 1; gbcBookInput.gridy = 1;
        bookInput.add(bookInInput, gbcBookInput);
        JLabel bookOutLabel = new JLabel("Check-Out Day:", JLabel.CENTER);
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 2;
        bookInput.add(bookOutLabel, gbcBookInput);
        JTextField bookOutInput = new JTextField(15);
        gbcBookInput.gridx = 1; gbcBookInput.gridy = 2;
        bookInput.add(bookOutInput, gbcBookInput);
        JLabel bookRoomLabel = new JLabel("Room Type:", JLabel.CENTER);
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 3;
        bookInput.add(bookRoomLabel, gbcBookInput);
        JTextField bookRoomInput = new JTextField(15);
        gbcBookInput.gridx = 1; gbcBookInput.gridy = 3;
        bookInput.add(bookRoomInput, gbcBookInput);
        JButton bookRoomSubmit = new JButton("Submit");
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 4; gbcBookInput.gridwidth = 2;
        bookInput.add(bookRoomSubmit, gbcBookInput);

        

        // Add the cards to the card panel
        view.addCard(card1, "Create");
        view.addCard(card2, "View");
        view.addCard(card3, "Manage");
        view.addCard(card4, "Book");
    }


     
    //ALL OF THE ACTIONS // DOES NOT YET FOLLOW MVC
    //Create Hotel Button

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

