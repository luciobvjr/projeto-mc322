package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import modelos.AlunoGraduacao;
import modelos.Curso;
import modelos.Disciplina;
import modelos.Endereco;
import modelos.Genero;

public class FileManager {
    public static String projetoPath = System.getProperty("user.dir");
    public static String alunoPath = "/src/dados/aluno.obj";

    public static void salvarAluno(String nome, LocalDate dataNascimento, String rg, String cpf, String email,
                                   String telefone, Genero genero, Endereco endereco, int ra, Curso curso,
                                   int anoDeIngresso, ArrayList<Disciplina> arvoreDoCurso, ArrayList<Disciplina> gradeSemestral) {
        // Criando um objeto da classe que você deseja salvar
        AlunoGraduacao myObject = new AlunoGraduacao(nome, dataNascimento, rg, cpf, email, telefone, genero, endereco,
                                                     ra, curso, anoDeIngresso, arvoreDoCurso, gradeSemestral);        

        // Construindo o caminho absoluto do arquivo
        String absoluteFilePath = projetoPath + File.separator + alunoPath;
        
        File arquivo = new File(absoluteFilePath);
        try {
            arquivo.delete();
            arquivo.createNewFile();

            // Criando um FileOutputStream para escrever no arquivo
            FileOutputStream fileOutputStream = new FileOutputStream(absoluteFilePath);

            // Criando um ObjectOutputStream para serializar o objeto
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Serializando o objeto e escrevendo no arquivo
            objectOutputStream.writeObject(myObject);

            // Fechando os fluxos de saída
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Objeto salvo com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static AlunoGraduacao carregarAlunoGraduacao() {
        // Construindo o caminho absoluto do arquivo
        String absoluteFilePath = projetoPath + File.separator + alunoPath;

        try (FileInputStream fileIn = new FileInputStream(absoluteFilePath);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            AlunoGraduacao aluno = (AlunoGraduacao) objectIn.readObject();
            objectIn.close();
            System.out.println("Objeto carregado do arquivo com sucesso.");
            System.out.println(aluno.getNome());
            System.out.println(aluno.getCpf());
            System.out.println(aluno.getRg());
            System.out.println(aluno.getEmail());
            return aluno;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
