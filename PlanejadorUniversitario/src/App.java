import javax.swing.*;

import dados.DataBase;
import modelos.Validacao;
import telas.TelaCadastro;

public class App {
    public static void main(String[] args) throws Exception {
        DataBase.create();
        
        System.out.println(Validacao.validaRG(DataBase.getProfessor().get(0).getRg()));
    }
}
