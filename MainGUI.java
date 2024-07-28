package MCO2.src;


import javax.swing.*;
import java.awt.*;

//This is where the main GUI starts
//Update as soon as all functionalities are done
//Expected to have many GUI classes to adhere to MVC
//GOODLUCK
public class MainGUI extends JFrame {
    private JButton btnCreate;
    private JButton btnView;
    private JButton btnManage;
    private JButton btnBook;
    private JButton btnSubmit; // submits the information requested

    public MainGUI() {
        super("Hotel Reservation System"); // sets title of the window 
        setLayout(new BorderLayout());

        setSize(500, 500);
        //init(); //this is where all of the components of this frame will be

        // by default, the window will not be displayed
        setVisible(true);
        setResizable(false);

        // so that the program will actually stop running
        // when you press the close button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
