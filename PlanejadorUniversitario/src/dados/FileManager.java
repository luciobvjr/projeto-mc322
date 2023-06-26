package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import modelos.AlunoGraduacao;

public class FileManager {
    public static String projetoPath = System.getProperty("user.dir");
    public static String alunoPath = "/src/dados/aluno.obj";

    public static void salvarAluno(AlunoGraduacao aluno) {
        // Criando um objeto da classe que você deseja salvar
        AlunoGraduacao myObject = aluno;

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
            return aluno;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
