package modelos;
import java.time.LocalDate;
import java.util.ArrayList;

public class Professor extends Pessoa {
    private ArrayList<Double> avaliacoesDeDesempenho = new ArrayList<Double>();//indica quantas vezes o professor foi avaliado para o calculo da nota//
    private double nota;
    private ArrayList<Disciplina> disciplinasMinistradas = new ArrayList<Disciplina>();

    public Professor(String nome, LocalDate dataNascimento, String rg, String cpf, String email, String telefone,
                     Genero genero, Endereco endereco) {
        super(nome, dataNascimento, rg, cpf, email, telefone, genero, endereco);
        this.nota = 0.0;
    }

    //Getters e Setters//
    public double getNota(){
        return this.nota;
    }

    public void setNota(double nota){
        this.nota = nota;
    }   

    public ArrayList<Disciplina> getDisciplinasMinistradas(){
        return this.disciplinasMinistradas;
    }

    public void setDisciplinasMinistradas(ArrayList<Disciplina> disciplinasMinistradas){
        this.disciplinasMinistradas = disciplinasMinistradas;
    }

    public ArrayList<Double> getAvaliacoesDeDesempenho(){
        return this.avaliacoesDeDesempenho;
    }

    //Metodos da classe Professor//
    public void recalculaNota(){//Adiciona a avaliacao de desempenho e recalcula media//
        nota = 0;
        for(int i = 0; i < this.avaliacoesDeDesempenho.size(); i++)
            nota += this.avaliacoesDeDesempenho.get(i);
        this.setNota(nota/this.avaliacoesDeDesempenho.size());    
    }

    public boolean addDisciplina(Disciplina disciplina){//adiciona uma nova disciplina a ser ministrada pelo prof//
        for(int i = 0; i < this.disciplinasMinistradas.size(); i++){
            if(this.disciplinasMinistradas.get(i).equals(disciplina)){//caso em que a disciplina já é ministrada pelo professor//
                System.out.println("O professor já ministra essa matéria!\n");
            }if(i < disciplinasMinistradas.size()-1 && !this.disciplinasMinistradas.get(i).equals(disciplina)){//trata a exceção de quando a disciplina já não é ministrada pelo professor//
                this.getDisciplinasMinistradas().add(disciplina);
                System.out.println("Disciplina adicionada, o professor agora ministrará essa disciplina!\n");
                return false;
            }
        }
        return true;
    }

    public boolean removeDisciplina(Disciplina disciplina){//professor deixa de ministrar uma disciplina//
        for(int i = 0; i < this.disciplinasMinistradas.size(); i++){
            if(this.disciplinasMinistradas.get(i).equals(disciplina)){//caso em que a disciplina já é ministrada pelo professor//
                this.disciplinasMinistradas.remove(disciplinasMinistradas.get(i));
                System.out.println("Disciplina removida, o professor não mais a ministrará!\n");
            }if(i < disciplinasMinistradas.size()-1 && !this.disciplinasMinistradas.get(i).equals(disciplina)){//trata a exceção de quando a disciplina já não é ministrada pelo professor//
                System.out.println("O professor já não ministra essa disciplina.\n");
                return false;
            }
        }
        return true;
    }

    public boolean avaliarProfessor(double nota){
        if(nota >= 0.0 && nota <= 10.0){
            this.avaliacoesDeDesempenho.add(nota);
            recalculaNota();
            System.out.println("Avaliação enviada com sucesso!\n");
        }else{
            System.out.println("Insira uma nota entre 0.0 e 10.0!\n");
            return false;
        }
        return true;
    }
}
