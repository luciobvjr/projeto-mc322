import javax.swing.*;

import dados.DataBase;
import modelos.Validacao;
import dados.FileManager;
import modelos.AlunoGraduacao;
import telas.TelaCadastro;
import telas.TelaDisciplinas;

public class App {
    public static void main(String[] args) throws Exception {
        DataBase.create();
        
        System.out.println(Validacao.validaRG(DataBase.getProfessor().get(0).getRg()));
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
