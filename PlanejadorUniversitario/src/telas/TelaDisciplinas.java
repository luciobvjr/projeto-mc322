package telas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import modelos.AlunoGraduacao;
import modelos.Atividade;
import modelos.Disciplina;
import modelos.Professor;

public class TelaDisciplinas extends JFrame {
    AlunoGraduacao alunoGraduacao;

    private DefaultListModel<String> listModel;
    private JList<String> list;

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

                listModel.addElement(disciplina.getCodigo());
                System.out.println(alunoGraduacao.getDisciplinasMatriculadas().size());
                repaint();
            }
        });

        // lista de disciplinas
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(1);

        JPanel listaDisciplinasPanel = new JPanel();
        listaDisciplinasPanel.setLayout(new FlowLayout());


        // Configurar Panels
        panelHeaderEsquerdo.add(lblTitulo);
        panelHeaderDireito.add(btnAddDisciplina);
        panelHeader.add(panelHeaderEsquerdo, BorderLayout.WEST);
        panelHeader.add(panelHeaderDireito, BorderLayout.EAST);

        panel.add(panelHeader, BorderLayout.NORTH);
        panel.add(new JScrollPane(list), BorderLayout.CENTER);
        add(panel);

        // Centralizar o JFrame na tela
        setLocationRelativeTo(null);
    }

    public static void initialize(AlunoGraduacao alunoGraduacao) {
        TelaDisciplinas telaDisciplinas = new TelaDisciplinas(alunoGraduacao);
        telaDisciplinas.setVisible(true);
    }
}