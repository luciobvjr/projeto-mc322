import javax.swing.*;

import dados.DataBase;
import telas.TelaCadastro;

public class App {
    public static void main(String[] args) throws Exception {
        DataBase.create();
        
        SwingUtilities.invokeLater(() -> {
            TelaCadastro.initialize();
        });
    }
}
