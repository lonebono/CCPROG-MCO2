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
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 0, 10, 0); // Padding // top left bot right
        gbc.fill = GridBagConstraints.BOTH; // Fill horizontally

        card1.setBackground(Color.GRAY);
        createList.setPreferredSize(new Dimension(400, 600));
        card1.add(createList, BorderLayout.WEST);
        JLabel createLabelInfo = new JLabel("Hotel Creation Info", JLabel.CENTER);
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.05; gbc.weighty = 0.05; 
        createList.add(createLabelInfo, gbc); // adds the label
        JTextArea createTextInfo = new JTextArea();
        createTextInfo.setLineWrap(true);
        JScrollPane infoScroll = new JScrollPane(createTextInfo); // Wrap text field in scroll pane
        infoScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        infoScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3; gbc.weighty = 0.3;
        createList.add(infoScroll, gbc); // adds the info list

        card1.add(new JButton("East"), BorderLayout.EAST);

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

