package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dados.DataBase;
import modelos.AlunoGraduacao;
import modelos.Disciplina;

public class TelaDisciplinas extends JFrame {
    AlunoGraduacao alunoGraduacao;

    private JPanel listaDisciplinasPanel;
    private JScrollPane listaDisciplinasScroll;

    public TelaDisciplinas(AlunoGraduacao alunoGraduacao) {
        super("Minhas Disciplinas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);

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
        listaDisciplinasPanel = new JPanel();
        listaDisciplinasPanel.setLayout(new WrapLayout());

        JButton btnAddDisciplina = new JButton("Adicionar");
        btnAddDisciplina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaDisciplinasPanel
                        .add(new DisciplinaCelula(DataBase.getInstitutos().get(0).getDisciplinasOferecidas().get(0)));
                revalidate();
                repaint();
            }
        });

        listaDisciplinasScroll = new JScrollPane(listaDisciplinasPanel);
        listaDisciplinasScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        listaDisciplinasScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Botões do segmented control
        JToggleButton btnMatriculadas = new JToggleButton("Matriculadas");
        JToggleButton btnDisponiveis = new JToggleButton("Disponíveis");
        JToggleButton btnConcluidas = new JToggleButton("Concluídas");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(btnMatriculadas);
        buttonGroup.add(btnDisponiveis);
        buttonGroup.add(btnConcluidas);

        JPanel controlPanel = new JPanel();
        controlPanel.add(btnMatriculadas);
        controlPanel.add(btnDisponiveis);
        controlPanel.add(btnConcluidas);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaDisciplinasPanel.removeAll();

                JToggleButton selectedButton = (JToggleButton) e.getSource();
                if (selectedButton.equals(btnMatriculadas)) {
                    for (Disciplina disciplina : alunoGraduacao.getDisciplinasMatriculadas()) {
                        listaDisciplinasPanel.add(new DisciplinaCelula(disciplina));
                    }
                } else if (selectedButton.equals(btnDisponiveis)) {
                    for (Disciplina disciplina : alunoGraduacao.getArvoreDoCurso()) {
                        listaDisciplinasPanel.add(new DisciplinaCelula(disciplina));
                    }
                } else if (selectedButton.equals(btnConcluidas)) {
                    for (Disciplina disciplina : alunoGraduacao.getDisciplinasConcluidas()) {
                        listaDisciplinasPanel.add(new DisciplinaCelula(disciplina));
                    }
                }
                revalidate();
                repaint();
            }
        };

        btnMatriculadas.addActionListener(actionListener);
        btnDisponiveis.addActionListener(actionListener);
        btnConcluidas.addActionListener(actionListener);

        // Configurar Panels
        panelHeaderEsquerdo.add(lblTitulo);
        panelHeaderDireito.add(btnAddDisciplina);
        panelHeader.add(panelHeaderEsquerdo, BorderLayout.WEST);
        panelHeader.add(controlPanel, BorderLayout.CENTER);
        panelHeader.add(panelHeaderDireito, BorderLayout.EAST);

        panel.add(panelHeader, BorderLayout.NORTH);
        panel.add(listaDisciplinasScroll, BorderLayout.CENTER);
        add(panel);

        // Centralizar o JFrame na tela
        setLocationRelativeTo(null);
    }

    // Célula da disciplina
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
            Border paddingBorder = new EmptyBorder(padding, padding, padding, padding);
            Border roundedBorder = new RoundBorder(15, Color.BLACK);
            Border border = BorderFactory.createCompoundBorder(paddingBorder, roundedBorder);
            setBorder(border);

            lblCodigo.setText(disciplina.getCodigo());
            lblProfessor.setText("Prof: " + disciplina.getProfessor().getNome());
            lblCreditos.setText(disciplina.getCreditos() + " créditos");
            lblFaltas.setText("Faltas: " + disciplina.getNumeroFaltas());
        }

        public class RoundBorder implements Border {
            private int radius;
            private Color color;

            public RoundBorder(int radius, Color color) {
                this.radius = radius;
                this.color = color;
            }

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                g.setColor(color);
                g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(radius, radius, radius, radius);
            }

            @Override
            public boolean isBorderOpaque() {
                return true;
            }
        }
    }

    public static void initialize(AlunoGraduacao alunoGraduacao) {
        TelaDisciplinas telaDisciplinas = new TelaDisciplinas(alunoGraduacao);
        telaDisciplinas.setVisible(true);
    }
}