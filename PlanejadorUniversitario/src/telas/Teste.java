package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teste extends JFrame {

    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField textField;
    private JButton addButton;

    public Teste() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Update Vertical List Example");

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        textField = new JTextField(20);
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = textField.getText();
                listModel.addElement(item);
                textField.setText("");
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        panel.add(textField, BorderLayout.WEST);
        panel.add(addButton, BorderLayout.EAST);

        getContentPane().add(panel);

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
