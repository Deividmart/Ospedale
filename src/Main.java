import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import view.LoginView;

public class Main {

    public static void main(String[] args) {
        System.setProperty("flatlaf.useNativeLibrary", "false");
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        java.awt.EventQueue.invokeLater(() -> new LoginView().setVisible(true));
    }
}
