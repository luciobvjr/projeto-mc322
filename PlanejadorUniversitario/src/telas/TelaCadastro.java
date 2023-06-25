package telas;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TelaCadastro extends JFrame {

    public TelaCadastro() {
        super("Formulário de Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);

        // Painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Texto acima do GroupLayout
        JLabel lblTitulo = new JLabel("Cadastre-se no Planejador Universitário!");
        Font font = lblTitulo.getFont();
        lblTitulo.setFont(font.deriveFont(18f));
        int padding = 4;
        lblTitulo.setBorder(new EmptyBorder(padding, padding, padding, padding));

        // Criar o GroupLayout
        JPanel grouPanel = new JPanel();
        GroupLayout layout = new GroupLayout(grouPanel);
        grouPanel.setLayout(layout);

        // Configurar o GroupLayout
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Labels e campos de texto
        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField(20);

        JLabel lblDataNascimento = new JLabel("Data de nascimento:");
        JTextField txtDataNascimento = new JTextField(20);

        JLabel lblRG = new JLabel("RG:");
        JTextField txtRG = new JTextField(20);

        JLabel lblCPF = new JLabel("CPF:");
        JTextField txtCPF = new JTextField(20);

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField(20);

        JLabel lblTelefone = new JLabel("Telefone:");
        JTextField txtTelefone = new JTextField(20);

        JLabel lblRA = new JLabel("RA:");
        JTextField txtRA = new JTextField(6);

        JLabel lblCurso = new JLabel("Curso:");
        JTextField txtCurso = new JTextField(20);

        JLabel lblAnoDeIngresso = new JLabel("Ano de ingresso:");
        JTextField txtAnoDeIngresso = new JTextField(4);

        // Botão de cadastro
        JButton btnCadastrar = new JButton("Cadastrar");

        // Configurar os grupos horizontais
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(lblNome)
                .addComponent(lblDataNascimento)
                .addComponent(lblRG)
                .addComponent(lblCPF)
                .addComponent(lblEmail)
                .addComponent(lblTelefone)
                .addComponent(lblRA)
                .addComponent(lblCurso)
                .addComponent(lblAnoDeIngresso)
                .addComponent(btnCadastrar));
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(txtNome)
                .addComponent(txtDataNascimento)
                .addComponent(txtRG)
                .addComponent(txtCPF)
                .addComponent(txtEmail)
                .addComponent(txtTelefone)
                .addComponent(txtRA)
                .addComponent(txtCurso)
                .addComponent(txtAnoDeIngresso));
                
        layout.setHorizontalGroup(hGroup);

        // Configurar os grupos verticais
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblNome)
                .addComponent(txtNome));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblDataNascimento)
                .addComponent(txtDataNascimento));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblRG)
                .addComponent(txtRG));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblCPF)
                .addComponent(txtCPF));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblEmail)
                .addComponent(txtEmail));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblTelefone)
                .addComponent(txtTelefone));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblRA)
                .addComponent(txtRA));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblCurso)
                .addComponent(txtCurso));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lblAnoDeIngresso)
                .addComponent(txtAnoDeIngresso));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnCadastrar));
        layout.setVerticalGroup(vGroup);

        // Adicionar o painel principal ao JFrame
        panel.add(lblTitulo, BorderLayout.NORTH);
        panel.add(grouPanel, BorderLayout.CENTER);
        add(panel);

        // Centralizar o JFrame na tela
        setLocationRelativeTo(null);
    }

    public static void initialize() {
        TelaCadastro form = new TelaCadastro();
        form.setVisible(true);
    }
}