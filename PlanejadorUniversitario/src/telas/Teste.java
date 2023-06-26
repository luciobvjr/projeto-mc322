package telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teste extends JFrame {

    private JPanel contentPane;
    private JButton addButton;
    private JPanel itemListPanel;

    public Teste() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Flow Layout List Example");
        setPreferredSize(new Dimension(300, 200));

        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        addButton = new JButton("Adicionar Item");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });
        contentPane.add(addButton, BorderLayout.NORTH);

        itemListPanel = new JPanel();
        itemListPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        contentPane.add(itemListPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
    }

    private void addItem() {
        JLabel newItem = new JLabel("Novo Item");
        newItem.setBorder(BorderFactory.createLineBorder(Color.black));
        itemListPanel.add(newItem);

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Teste example = new Teste();
            example.setVisible(true);
        });
    }
}