package telas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Teste extends JFrame {

    public Teste() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Wrap Layout Example");
        setPreferredSize(new Dimension(300, 200));

        // Create a panel with WrapLayout
        JPanel panel = new JPanel(new WrapLayout());

        // Create a lot of JLabels
        for (int i = 1; i <= 20; i++) {
            JLabel label = new JLabel("Label " + i);
            panel.add(label);
        }

        // Create a JScrollPane and set the JPanel as its viewport
        JScrollPane scrollPane = new JScrollPane(panel);

        // Set the preferred size of the JScrollPane
        scrollPane.setPreferredSize(new Dimension(280, 160));

        // Set the JScrollPane as the content pane of the frame
        setContentPane(scrollPane);

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

class WrapLayout extends FlowLayout {

    private List<Dimension> rowSizes;

    public WrapLayout() {
        rowSizes = new ArrayList<>();
    }

    @Override
    public void layoutContainer(Container parent) {
        super.layoutContainer(parent);

        int width = parent.getWidth();

        int x = 0;
        int y = 0;
        int rowHeight = 0;

        rowSizes.clear();

        for (int i = 0; i < parent.getComponentCount(); i++) {
            Component component = parent.getComponent(i);
            Dimension size = component.getPreferredSize();

            if (x == 0 || x + size.width > width) {
                x = 0;
                y += rowHeight;
                rowHeight = 0;
                rowSizes.add(size);
            } else {
                rowHeight = Math.max(rowHeight, size.height);
            }

            component.setBounds(x, y, size.width, size.height);
            x += size.width;
        }

        y += rowHeight;

        Dimension preferredSize = new Dimension(width, y);
        Dimension minimumSize = new Dimension(width, y);

        parent.setPreferredSize(preferredSize);
        parent.setMinimumSize(minimumSize);
    }
}