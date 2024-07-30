package MCO2.src;

import javax.sound.sampled.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewHotelGUI extends JPanel{
    
    public ViewHotelGUI(){
        //View Hotel Panel
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);

        //View Hotel Panel LEFT
        JPanel hotelViewList = new JPanel(new GridBagLayout());
        GridBagConstraints gbcHotelViewList = new GridBagConstraints();
        gbcHotelViewList.insets = new Insets(0, 0, 10, 0);
        hotelViewList.setPreferredSize(new Dimension(400, 600));
        add(hotelViewList, BorderLayout.WEST);

        //View Hotel Panel RIGHT
        JPanel hotelViewInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcHotelViewInput = new GridBagConstraints();
        gbcHotelViewInput.insets = new Insets(0, 0, 10, 0);
        hotelViewInput.setPreferredSize(new Dimension(400, 600));
        add(hotelViewInput, BorderLayout.EAST);

        //Selecting Hotel to View
        JLabel viewHotelLabel = new JLabel("Select Hotel: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 0; 
        hotelViewList.add(viewHotelLabel, gbcHotelViewList);
        JComboBox viewHotels = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 0; 
        viewHotels.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewHotels, gbcHotelViewList);

        //High-Level Button
        JButton highLevel = new JButton("High-Level");
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 1;
        gbcHotelViewList.fill = GridBagConstraints.HORIZONTAL;
        hotelViewList.add(highLevel, gbcHotelViewList);

        //Low-Level Button
        JButton lowLevel = new JButton("Low-Level");
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 2;
        gbcHotelViewList.fill = GridBagConstraints.HORIZONTAL;
        hotelViewList.add(lowLevel, gbcHotelViewList);

        //Selecting low level type of information
        JLabel lowLevelOption = new JLabel("Low-Level Options: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 3; 
        hotelViewList.add(lowLevelOption, gbcHotelViewList);
        JComboBox lowOptions = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 3; 
        lowOptions.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(lowOptions, gbcHotelViewList);        

        //Low-Level Info View Rooms for Date
        //hotelViewInput.setPreferredSize(new Dimension(400, 600));
        //card2.add(hotelViewInput, BorderLayout.EAST);
        JLabel hotelViewDate = new JLabel("Select a Date: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 4;
        hotelViewList.add(hotelViewDate, gbcHotelViewList);
        JComboBox viewDate = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 4;
        viewDate.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewDate, gbcHotelViewList);

        //Low-Level Info View Rooms Info
        JLabel roomViewInfo = new JLabel("Select a Room: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 5; //change y to 4 when combobox finish for appear disappear
        hotelViewList.add(roomViewInfo, gbcHotelViewList);
        JComboBox viewRoom = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 5; //change y to 4 when combobox finish for appear disappear
        viewRoom.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewRoom, gbcHotelViewList);

        //Low-Level Info View Reservation Info
        JLabel reservationViewInfo = new JLabel("Select a Reservation: ");
        gbcHotelViewList.gridx = 0; gbcHotelViewList.gridy = 6; //change y to 4 when combobox finish for appear disappear
        hotelViewList.add(reservationViewInfo, gbcHotelViewList);
        JComboBox viewReserve = new JComboBox<>();
        gbcHotelViewList.gridx = 1; gbcHotelViewList.gridy = 6; //change y to 4 when combobox finish for appear disappear
        viewReserve.setPreferredSize(new Dimension(200, 30));
        hotelViewList.add(viewReserve, gbcHotelViewList);
    }

}
