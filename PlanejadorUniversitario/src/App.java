import javax.swing.*;
import telas.TelaCadastro;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            TelaCadastro.initialize();
        });
    }
}
