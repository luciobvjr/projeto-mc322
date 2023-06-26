package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelos.AlunoGraduacao;
import modelos.Atividade;
import modelos.Disciplina;
import modelos.Professor;

public class TelaDisciplinas extends JFrame {
    AlunoGraduacao alunoGraduacao;

    private JPanel itemListPanel;

    public TelaDisciplinas(AlunoGraduacao alunoGraduacao) {
        super("Minhas Disciplinas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel panelHeader = new JPanel();
        panelHeader = new JPanel();
        panelHeader.setLayout(new BorderLayout());

        // Titulo da tela
        JPanel panelHeaderEsquerdo = new JPanel();
        panelHeaderEsquerdo.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel lblTitulo = new JLabel("Minhas Disciplinas");
        Font font = lblTitulo.getFont();
        lblTitulo.setFont(font.deriveFont(18f));
        int padding = 4;
        lblTitulo.setBorder(new EmptyBorder(padding, padding, padding, padding));

        JPanel panelAddDisciplina = new JPanel();
        panelAddDisciplina.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Botao add disciplina
        JPanel panelHeaderDireito = new JPanel();
        panelHeaderDireito.setLayout(new FlowLayout(FlowLayout.LEFT));

        // lista de disciplinas
        itemListPanel = new JPanel();
        itemListPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton btnAddDisciplina = new JButton("Adicionar");
        btnAddDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // USADO PARA TESTE, REMOVER DEPOIS//
                Professor professor = new Professor("Marcos Medeiros Raimundo", null, null, null, null, null, null,
                        null, null);
                Disciplina disciplina = new Disciplina(4, "MC322", professor, new ArrayList<Atividade>());
                alunoGraduacao.getArvoreDoCurso().add(disciplina);
                alunoGraduacao.adicionarDisciplina(disciplina);

                itemListPanel.add(new DisciplinaCelula(disciplina));
                revalidate();
                repaint();
            }
        });

        
        

        // Configurar Panels
        panelHeaderEsquerdo.add(lblTitulo);
        panelHeaderDireito.add(btnAddDisciplina);
        panelHeader.add(panelHeaderEsquerdo, BorderLayout.WEST);
        panelHeader.add(panelHeaderDireito, BorderLayout.EAST);

        panel.add(panelHeader, BorderLayout.NORTH);
        panel.add(itemListPanel, BorderLayout.CENTER);
        add(panel);

        // Centralizar o JFrame na tela
        setLocationRelativeTo(null);
    }

    private static class DisciplinaCelula extends JPanel {
        private JLabel lblCodigo;
        private JLabel lblProfessor;
        private JLabel lblCreditos;
        private JLabel lblFaltas;

        public DisciplinaCelula(Disciplina disciplina) {
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
            setBorder(new EmptyBorder(padding, padding, padding, padding));

            lblCodigo.setText(disciplina.getCodigo());
            lblProfessor.setText("Prof: " + disciplina.getProfessor().getNome());
            lblCreditos.setText(disciplina.getCreditos() + " créditos");
            lblFaltas.setText("Faltas: " + disciplina.getNumeroFaltas());
        }
    }

    public static void initialize(AlunoGraduacao alunoGraduacao) {
        TelaDisciplinas telaDisciplinas = new TelaDisciplinas(alunoGraduacao);
        telaDisciplinas.setVisible(true);
    }
}