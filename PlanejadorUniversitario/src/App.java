import javax.swing.*;

import dados.FileManager;
import modelos.AlunoGraduacao;
import telas.TelaCadastro;
import telas.TelaDisciplinas;

public class App {
    public static void main(String[] args) throws Exception {
        AlunoGraduacao alunoGraduacao = FileManager.carregarAlunoGraduacao();
        SwingUtilities.invokeLater(() -> {
            if (alunoGraduacao == null) {
                TelaCadastro.initialize();
            } else {
                TelaDisciplinas.initialize(alunoGraduacao);
            }
        });
    }
}
