package MCO2.src;

public class MainDriver {
    public static void main(String[] args) {
        // Create a new instance of the MainDriver class
        MainGUIView view = new MainGUIView();
        ReserveSystem reserveSystem = new ReserveSystem();
        GUIController controller = new GUIController(view, reserveSystem);
        view.setVisible(true);
    }
}
