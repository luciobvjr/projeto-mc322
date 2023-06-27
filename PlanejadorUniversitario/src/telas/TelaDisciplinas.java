package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

import dados.FileManager;
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

        // lista de disciplinas
        listaDisciplinasPanel = new JPanel();
        listaDisciplinasPanel.setLayout(new WrapLayout());

        listaDisciplinasScroll = new JScrollPane(listaDisciplinasPanel);
        listaDisciplinasScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        listaDisciplinasScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        for (Disciplina disciplina : alunoGraduacao.getDisciplinasMatriculadas()) {
            ActionListener addFalta = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int numeroFaltas = disciplina.getNumeroFaltas() + 1;
                    disciplina.setNumeroFaltas(numeroFaltas);
                    FileManager.salvarAluno(alunoGraduacao);
                }
            };

            ActionListener removerFalta = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int numeroFaltas = disciplina.getNumeroFaltas() - 1;
                    disciplina.setNumeroFaltas(numeroFaltas);
                    FileManager.salvarAluno(alunoGraduacao);
                }
            };

            ActionListener concluirDisciplina = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    alunoGraduacao.concluirDisciplina(disciplina);
                }
            };

            ActionListener cancelarMatricula = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    alunoGraduacao.getDisciplinasMatriculadas().remove(disciplina);
                    alunoGraduacao.getArvoreDoCurso().add(disciplina);
                }
            };

            listaDisciplinasPanel.add(new CelulaDisciplinaMatriculada(disciplina, addFalta, removerFalta, concluirDisciplina, cancelarMatricula));
        }

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
                        ActionListener addFalta = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int numeroFaltas = disciplina.getNumeroFaltas() + 1;
                                disciplina.setNumeroFaltas(numeroFaltas);
                                FileManager.salvarAluno(alunoGraduacao);
                            }
                        };

                        ActionListener removerFalta = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int numeroFaltas = disciplina.getNumeroFaltas() - 1;
                                disciplina.setNumeroFaltas(numeroFaltas);
                                FileManager.salvarAluno(alunoGraduacao);
                            }
                        };

                        ActionListener concluirDisciplina = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                alunoGraduacao.concluirDisciplina(disciplina);
                            }
                        };

                        ActionListener cancelarMatricula = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                alunoGraduacao.getDisciplinasMatriculadas().remove(disciplina);
                                alunoGraduacao.getArvoreDoCurso().add(disciplina);
                            }
                        };

                        listaDisciplinasPanel.add(new CelulaDisciplinaMatriculada(disciplina, addFalta, removerFalta, concluirDisciplina, cancelarMatricula));
                    }
                } else if (selectedButton.equals(btnDisponiveis)) {
                    for (Disciplina disciplina : alunoGraduacao.getArvoreDoCurso()) {
                        ActionListener matricularDisciplina = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                alunoGraduacao.adicionarDisciplina(disciplina);
                                alunoGraduacao.getArvoreDoCurso().remove(disciplina);
                                FileManager.salvarAluno(alunoGraduacao);
                            }
                        };
                        listaDisciplinasPanel.add(new CelulaDisciplinaDisponivel(disciplina, matricularDisciplina));
                    }
                } else if (selectedButton.equals(btnConcluidas)) {
                    for (Disciplina disciplina : alunoGraduacao.getDisciplinasConcluidas()) {
                        // listaDisciplinasPanel.add(new CelulaDisciplinaMatriculada(disciplina));
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
        panelHeader.add(panelHeaderEsquerdo, BorderLayout.WEST);
        panelHeader.add(controlPanel, BorderLayout.CENTER);

        panel.add(panelHeader, BorderLayout.NORTH);
        panel.add(listaDisciplinasScroll, BorderLayout.CENTER);
        add(panel);

        // Centralizar o JFrame na tela
        setLocationRelativeTo(null);
    }

    public static void initialize(AlunoGraduacao alunoGraduacao) {
        TelaDisciplinas telaDisciplinas = new TelaDisciplinas(alunoGraduacao);
        telaDisciplinas.setVisible(true);
    }
}