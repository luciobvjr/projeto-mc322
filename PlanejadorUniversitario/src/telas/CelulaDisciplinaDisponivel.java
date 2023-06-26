package telas;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import modelos.Disciplina;

public class CelulaDisciplinaDisponivel extends JPanel {
    private JLabel lblCodigo;
    private JLabel lblNome;
    private JLabel lblProfessor;
    private JLabel lblCreditos;
    private JButton btnMatricular;

    public CelulaDisciplinaDisponivel(Disciplina disciplina, ActionListener actionMatricular) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        lblCodigo = new JLabel();
        Font boldFont = new Font(lblCodigo.getFont().getName(), Font.BOLD, 18);
        lblCodigo.setFont(boldFont);
        lblNome = new JLabel();
        lblProfessor = new JLabel();
        lblCreditos = new JLabel();
        btnMatricular = new JButton("Matricular");

        add(lblCodigo);
        add(lblNome);
        add(lblProfessor);
        add(lblCreditos);
        add(btnMatricular);

        setOpaque(true);

        int padding = 10;
        Border paddingBorder = new EmptyBorder(padding, padding, padding, padding);
        Border roundedBorder = new RoundBorder(15, Color.BLACK);
        Border border = BorderFactory.createCompoundBorder(paddingBorder, roundedBorder);
        setBorder(border);

        lblCodigo.setText(disciplina.getCodigo());
        lblNome.setText(disciplina.getNome());
        lblProfessor.setText("Prof: " + disciplina.getProfessor().getNome());
        lblCreditos.setText(disciplina.getCreditos() + " créditos");
        btnMatricular.addActionListener(actionMatricular);
    }
}
