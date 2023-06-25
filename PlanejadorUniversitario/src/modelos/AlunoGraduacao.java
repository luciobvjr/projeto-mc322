package modelos;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class AlunoGraduacao extends Aluno implements Serializable {
    private ArrayList<Disciplina> disciplinasMatriculadas;
    private ArrayList<Disciplina> disciplinasConcluidas;

    public AlunoGraduacao(String nome, LocalDate dataNascimento, String rg, String cpf, String email, String telefone,
            Genero genero, Endereco endereco, int ra, Curso curso, int anoDeIngresso,
            ArrayList<Disciplina> arvoreDoCurso, ArrayList<Disciplina> gradeSemestral) {
        super(nome, dataNascimento, rg, cpf, email, telefone, genero, endereco, ra, curso, anoDeIngresso, arvoreDoCurso,
                gradeSemestral);
        this.disciplinasMatriculadas = new ArrayList<>();
        this.disciplinasConcluidas = new ArrayList<>();
    }

    public ArrayList<Disciplina> getDisciplinasMatriculadas() {
        return disciplinasMatriculadas;
    }

    public ArrayList<Disciplina> getDisciplinasConcluidas() {
        return disciplinasConcluidas;
    }

    //Metodos herdados de Aluno
    public void adicionarDisciplina(Disciplina disciplina) {
        super.adicionarDisciplina(disciplina);
        disciplinasMatriculadas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina) {
        super.removerDisciplina(disciplina);
        disciplinasMatriculadas.remove(disciplina);
        disciplinasConcluidas.remove(disciplina);
    }

    //Metodos de AlunoGraduacao
    public void concluirDisciplina(Disciplina disciplina) {
        if (disciplinasMatriculadas.contains(disciplina)) {
            disciplinasMatriculadas.remove(disciplina);
            disciplinasConcluidas.add(disciplina);
        } else {
            System.out.println("A disciplina não está matriculada.");
        }
    }
}
