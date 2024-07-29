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
                view.showCard("1");
                //TO FOLLOW ALL ABOUT CREATE

            }
        });

        view.getBtnView().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("2");
                //TO FOLLOW ALL ABOUT VIEW
            }
        });

        view.getBtnManage().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("3");
                //TO FOLLOW ALL ABOUT MANAGE
            }
        });

        view.getBtnBook().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.showCard("4");
                //TO FOLLOW ALL ABOUT BOOK
            }
        });
    }
    
    public void updateView(){
        // Create different panels with BorderLayout for CardLayout
        // Hotel Creation Panel
        JPanel card1 = new JPanel(new BorderLayout());
        JPanel createList = new JPanel(new GridBagLayout());
        JPanel createInput = new JPanel(new GridBagLayout());
        GridBagConstraints gbcList = new GridBagConstraints();
        gbcList.insets = new Insets(0, 0, 10, 0); // Padding // top left bot right
        gbcList.fill = GridBagConstraints.BOTH; // Fill horizontally
        GridBagConstraints gbcInput = new GridBagConstraints();
        gbcInput.insets = new Insets(0, 0, 10, 0);
        // i don't want to take the entire space i want it centered // no .fill for now 

        card1.setBackground(Color.GRAY);
        //createList
        createList.setPreferredSize(new Dimension(400, 600));
        card1.add(createList, BorderLayout.WEST);
        JLabel createLabelInfo = new JLabel("Hotel Creation Info", JLabel.CENTER);
        gbcList.gridx = 0; gbcList.gridy = 0; gbcList.weightx = 0.05; gbcList.weighty = 0.05; 
        createList.add(createLabelInfo, gbcList); // adds the label
        JTextArea createTextInfo = new JTextArea();
        createTextInfo.setEditable(false);
        createTextInfo.setLineWrap(true);
        JScrollPane infoScroll = new JScrollPane(createTextInfo); // Wrap text field in scroll pane
        infoScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        infoScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        gbcList.gridx = 0; gbcList.gridy = 1; gbcList.weightx = 0.3; gbcList.weighty = 0.3;
        createList.add(infoScroll, gbcList); // adds the info list
        //createInput
        createInput.setPreferredSize(new Dimension(400,600));
        card1.add(createInput, BorderLayout.EAST);
        JLabel createFeedbackLabel= new JLabel("Feedback:", JLabel.CENTER);
        gbcInput.gridx = 0; gbcInput.gridy = 0;
        createInput.add(createFeedbackLabel, gbcInput);
        JTextField inputFeedback = new JTextField(15);
        gbcInput.gridx = 1; gbcInput.gridy = 0;
        createInput.add(inputFeedback, gbcInput);
        JLabel createInputLabel= new JLabel("Input Information Below:", JLabel.CENTER);
        gbcInput.gridx = 0; gbcInput.gridy = 1; gbcInput.gridwidth = 2;
        createInput.add(createInputLabel, gbcInput);
        gbcInput.gridwidth = 1; //resets gridwidth
        JLabel inputHotelLabel = new JLabel("Hotel Name:", JLabel.CENTER);
        gbcInput.gridx = 0; gbcInput.gridy = 2; 
        createInput.add(inputHotelLabel, gbcInput);
        JTextField inputHotelName = new JTextField(15);
        gbcInput.gridx = 1; gbcInput.gridy = 2;
        createInput.add(inputHotelName, gbcInput);
        JLabel createRoomLabel = new JLabel("Room Type:", JLabel.CENTER);
        gbcInput.gridx = 0; gbcInput.gridy = 3;
        createInput.add(createRoomLabel, gbcInput);
        JTextField createRoomType = new JTextField(15);
        gbcInput.gridx = 1; gbcInput.gridy = 3;
        createInput.add(createRoomType, gbcInput);
        JButton createHotelSubmit = new JButton("Submit");
        gbcInput.gridx = 0; gbcInput.gridy = 4; gbcInput.gridwidth = 2;
        createInput.add(createHotelSubmit, gbcInput);
        

        //View Hotel Panel
        JPanel card2 = new JPanel(new BorderLayout());
        card2.setBackground(Color.GREEN);
        card2.add(new JButton("East"), BorderLayout.EAST);
        card2.add(new JButton("West"), BorderLayout.WEST);

        JPanel card3 = new JPanel(new BorderLayout());
        card3.setBackground(Color.BLUE);
        card3.add(new JButton("East"), BorderLayout.EAST);
        card3.add(new JButton("West"), BorderLayout.WEST);

        JPanel card4 = new JPanel(new BorderLayout());
        card4.setBackground(Color.YELLOW);
        card4.add(new JButton("East"), BorderLayout.EAST);
        card4.add(new JButton("West"), BorderLayout.WEST);

        // Add the cards to the card panel
        view.addCard(card1, "1");
        view.addCard(card2, "2");
        view.addCard(card3, "3");
        view.addCard(card4, "4");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

