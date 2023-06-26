package telas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Teste extends JFrame {

    public Teste() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Selector Example");

        // Create an ArrayList with the options
        ArrayList<String> options = new ArrayList<>();
        options.add("Option 1");
        options.add("Option 2");
        options.add("Option 3");
        options.add("Option 4");

        // Create a JComboBox and populate it with the options
        JComboBox<String> comboBox = new JComboBox<>(options.toArray(new String[0]));
        
        // Set the preferred size of the JComboBox
        comboBox.setPreferredSize(new Dimension(200, 30));

        // Add the JComboBox to the JFrame
        add(comboBox, BorderLayout.CENTER);

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
