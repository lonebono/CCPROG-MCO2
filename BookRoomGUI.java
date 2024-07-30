package MCO2.src;

import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookRoomGUI extends JPanel{
    private JButton bookRoomSubmit;
    private JComboBox bookHotels, bookRooms;
    private JComboBox bookInInput, bookOutInput;
    private JTextField bookNameInput;
    public BookRoomGUI(){
        //Book Reservation Panel
        //Panels
        setLayout(new BorderLayout());
        JPanel bookList = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBookList = new GridBagConstraints();
        gbcBookList.insets = new Insets(0, 0, 10, 0);
        JPanel bookInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcBookInput = new GridBagConstraints();
        gbcBookInput.insets = new Insets(0, 0, 10, 0);

        setBackground(Color.GRAY);
        //Booking Information
        bookList.setPreferredSize(new Dimension(400, 600));
        add(bookList, BorderLayout.WEST);
        JLabel bookHotelLabel = new JLabel("Select Hotel: ");
        gbcBookList.gridx = 0; gbcBookList.gridy = 0; 
        bookList.add(bookHotelLabel, gbcBookList);
        bookHotels = new JComboBox<>();
        gbcBookList.gridx = 1; gbcBookList.gridy = 0;
        bookHotels.setPreferredSize(new Dimension(200, 20));
        bookList.add(bookHotels, gbcBookList);
        JLabel bookRoomsLabel = new JLabel("Select Room: ");
        gbcBookList.gridx = 0; gbcBookList.gridy = 1;
        bookList.add(bookRoomsLabel, gbcBookList);
        bookRooms = new JComboBox<>();
        gbcBookList.gridx = 1; gbcBookList.gridy = 1;
        bookRooms.setPreferredSize(new Dimension(200, 20));
        bookList.add(bookRooms, gbcBookList);

        //Booking Input
        bookInput.setPreferredSize(new Dimension(400,600));
        add(bookInput, BorderLayout.EAST);
        JLabel bookNameLabel = new JLabel("Name:", JLabel.CENTER);
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 0;
        bookInput.add(bookNameLabel, gbcBookInput);
        bookNameInput = new JTextField(15);
        gbcBookInput.gridx = 1; gbcBookInput.gridy = 0;
        bookInput.add(bookNameInput, gbcBookInput);
        JLabel bookInLabel = new JLabel("Check-In Day:", JLabel.CENTER);
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 1;
        bookInput.add(bookInLabel, gbcBookInput);
        bookInInput = new JComboBox<>();
        gbcBookInput.gridx = 1; gbcBookInput.gridy = 1;
        bookInInput.setPreferredSize(new Dimension(50, 20));
        bookInput.add(bookInInput, gbcBookInput);
        JLabel bookOutLabel = new JLabel("Check-Out Day:", JLabel.CENTER);
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 2;
        bookInput.add(bookOutLabel, gbcBookInput);
        bookOutInput = new JComboBox<>();
        gbcBookInput.gridx = 1; gbcBookInput.gridy = 2;
        bookOutInput.setPreferredSize(new Dimension(50, 20));
        bookInput.add(bookOutInput, gbcBookInput);
        bookRoomSubmit = new JButton("Submit");
        gbcBookInput.gridx = 0; gbcBookInput.gridy = 3; gbcBookInput.gridwidth = 2;
        bookInput.add(bookRoomSubmit, gbcBookInput);
    }
    public JComboBox getBookHotels() {
        return bookHotels;
    }

    public JComboBox getBookRooms() {
        return bookRooms;
    }

    public JTextField getBookNameInput() {
        return bookNameInput;
    }

    public JComboBox getBookInInput() {
        return bookInInput;
    }

    public JComboBox getBookOutInput() {
        return bookOutInput;
    }

    public JButton getBookRoomSubmit() {
        return bookRoomSubmit;
    }
}

