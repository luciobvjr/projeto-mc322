package telas;
import javax.swing.*;

public class Teste extends JFrame {

    public Teste() {
        super("Enum ComboBox Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definição do enum
        enum Color {
            RED, GREEN, BLUE
        }

        // Criação do JComboBox com os valores do enum
        JComboBox<Color> comboBox = new JComboBox<>(Color.values());

        // Adição do JComboBox ao painel
        JPanel panel = new JPanel();
        panel.add(comboBox);
        add(panel);

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Teste example = new Teste();
            example.setVisible(true);
        });
    }
}
