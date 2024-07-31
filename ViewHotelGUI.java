package MCO2.src;

import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewHotelGUI extends JPanel{
    private JLabel lowLevelOption, hotelViewDate, roomViewInfo, reservationViewInfo;
    private JTextArea viewTextInfo;
    private JComboBox viewHotels;
    private JButton highLevel, lowLevel;
    private JComboBox lowOptions, viewDate, viewRoom, viewReserve;
    
    public ViewHotelGUI(){
        //View Hotel Panel
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);

        //View Hotel Panel RIGHT
        JPanel hotelViewInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcHotelViewInput = new GridBagConstraints();
        gbcHotelViewInput.insets = new Insets(0, 0, 10, 0);
        hotelViewInput.setPreferredSize(new Dimension(400, 600));
        add(hotelViewInput, BorderLayout.EAST);
        
        //View Hotel Panel LEFT
        JPanel hotelViewList = new JPanel(new GridBagLayout());
        GridBagConstraints gbcHotelViewList = new GridBagConstraints();
        gbcHotelViewList.insets = new Insets(0, 0, 10, 0);
        hotelViewList.setPreferredSize(new Dimension(400, 600));
        add(hotelViewList, BorderLayout.WEST);

        //Implementing Text Area
        viewTextInfo = new JTextArea();
        viewTextInfo.setEditable(false);
        viewTextInfo.setLineWrap(true);
        JScrollPane viewScroll = new JScrollPane(viewTextInfo); // Wrap text field in scroll pane
        viewScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        viewScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        gbcHotelViewInput.gridx = 0; gbcHotelViewInput.gridy = 1; gbcHotelViewInput.weightx = 1; gbcHotelViewInput.weighty = 1;
        gbcHotelViewInput.fill = GridBagConstraints.BOTH;
        hotelViewInput.add(viewScroll, gbcHotelViewInput);
        
        //Selecting Hotel to View
        JLabel viewHotelLabel = new JLabel("Select Hotel: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 0; 
        hotelViewList.add(viewHotelLabel, gbcHotelViewList);
        viewHotels = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 0; 
        viewHotels.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewHotels, gbcHotelViewList);

        //High-Level Button
        highLevel = new JButton("High-Level");
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 1;
        gbcHotelViewList.fill = GridBagConstraints.HORIZONTAL;
        hotelViewList.add(highLevel, gbcHotelViewList);

        //Low-Level Button
        lowLevel = new JButton("Low-Level");
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 2;
        gbcHotelViewList.fill = GridBagConstraints.HORIZONTAL;
        hotelViewList.add(lowLevel, gbcHotelViewList);

        //Selecting low level type of information
        lowLevelOption = new JLabel("Low-Level Options: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 3;
        lowLevelOption.setVisible(false);
        hotelViewList.add(lowLevelOption, gbcHotelViewList);
        lowOptions = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 3; 
        lowOptions.setPreferredSize(new Dimension(200, 30));
        lowOptions.setVisible(false);
        hotelViewList.add(lowOptions, gbcHotelViewList);        

        //Low-Level Info View Rooms for Date
        //hotelViewInput.setPreferredSize(new Dimension(400, 600));
        //card2.add(hotelViewInput, BorderLayout.EAST);
        hotelViewDate = new JLabel("Select a Date: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 4;
        hotelViewDate.setVisible(false);
        hotelViewList.add(hotelViewDate, gbcHotelViewList);
        viewDate = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 4;
        viewDate.setPreferredSize(new Dimension(200, 30));
        viewDate.setVisible(false);
        hotelViewList.add(viewDate, gbcHotelViewList);

        //Low-Level Info View Rooms Info
        roomViewInfo = new JLabel("Select a Room: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 5; //change y to 4 when combobox finish for appear disappear
        roomViewInfo.setVisible(false);
        hotelViewList.add(roomViewInfo, gbcHotelViewList);
        viewRoom = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 5; //change y to 4 when combobox finish for appear disappear
        viewRoom.setVisible(false);
        viewRoom.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewRoom, gbcHotelViewList);

        //Low-Level Info View Reservation Info
        reservationViewInfo = new JLabel("Select a Reservation: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 6; //change y to 4 when combobox finish for appear disappear
        reservationViewInfo.setVisible(false);
        hotelViewList.add(reservationViewInfo, gbcHotelViewList);
        viewReserve = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 6; //change y to 4 when combobox finish for appear disappear
        viewReserve.setVisible(false);
        viewReserve.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewReserve, gbcHotelViewList);
    }

    public JTextArea getviewTextInfo() {
        return viewTextInfo;
    }

    public JComboBox getViewHotels() {
        return viewHotels;
    }

    public JButton getHighLevel() {
        return highLevel;
    }
    
    public JLabel getLowLevelOption() {
        return lowLevelOption;
    }

    public JButton getLowLevel() {
        return lowLevel;
    }

    public JComboBox getLowOptions() {
        return lowOptions;
    }

    public JLabel getHotelViewDate() {
        return hotelViewDate;
    }

    public JComboBox getViewDate() {
        return viewDate;
    }

    public JLabel getRoomViewInfo() {
        return roomViewInfo;
    }

    public JComboBox getViewRoom() {
        return viewRoom;
    }

    public JLabel getReservationViewInfo() {
        return reservationViewInfo;
    }

    public JComboBox getViewReserve() {
        return viewReserve;
    }

}
