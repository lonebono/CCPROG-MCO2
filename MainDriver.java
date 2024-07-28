package MCO2.src;

public class MainDriver {
    public static void main(String[] args) {
        // Create a new instance of the MainDriver class
        MainGUIView view = new MainGUIView();
        Main model = new Main();
        GUIController controller = new GUIController(view, model);
        view.setVisible(true);
    }
}
