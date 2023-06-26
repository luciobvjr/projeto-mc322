package telas;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import modelos.Disciplina;

public class CelulaDisciplinaMatriculada extends JPanel {
    private JLabel lblCodigo;
    private JLabel lblProfessor;
    private JLabel lblCreditos;
    private JLabel lblFaltas;

    public CelulaDisciplinaMatriculada(Disciplina disciplina) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        lblCodigo = new JLabel();
        Font boldFont = new Font(lblCodigo.getFont().getName(), Font.BOLD, 18);
        lblCodigo.setFont(boldFont);
        lblProfessor = new JLabel();
        lblCreditos = new JLabel();
        lblFaltas = new JLabel();

        add(lblCodigo);
        add(lblProfessor);
        add(lblCreditos);
        add(lblFaltas);

        setOpaque(true);

        int padding = 10;
        Border paddingBorder = new EmptyBorder(padding, padding, padding, padding);
        Border roundedBorder = new RoundBorder(15, Color.BLACK);
        Border border = BorderFactory.createCompoundBorder(paddingBorder, roundedBorder);
        setBorder(border);

        lblCodigo.setText(disciplina.getCodigo());
        lblProfessor.setText("Prof: " + disciplina.getProfessor().getNome());
        lblCreditos.setText(disciplina.getCreditos() + " créditos");
        lblFaltas.setText("Faltas: " + disciplina.getNumeroFaltas());
    }
}