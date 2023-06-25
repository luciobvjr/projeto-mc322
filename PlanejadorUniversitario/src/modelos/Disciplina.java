package modelos;
import java.io.Serializable;
import java.util.ArrayList;

public class Disciplina implements Serializable {
    private final int creditos;
    private final String codigo;
    private Professor professor;
    //private Instituto instituto;
    private ArrayList<Atividade> atividades;
    private int numeroFaltas;
    private double media;

    public Disciplina(int creditos,String codigo, Professor professor, ArrayList<Atividade> atividades){
        this.creditos = creditos;
        this.codigo = codigo;
        this.professor = professor;
        this.atividades = atividades;
        this.numeroFaltas = 0;
        this.media = 0.0;
    }

    //Getters e Setters//
    public int getCreditos(){
        return this.creditos;
    }

    public String getCodigo(){
        return this.codigo;
    }

    public Professor getProfessor(){
        return this.professor;
    }

    public void setProfessor(Professor professor){//METODO SERA SUBSTITUIDO POR ADICIONA OU REMOVE PROFESSOR CASO DISCIPLINA TENHA UMA LISTA DE PROFESSORES//
        this.professor = professor;
    }

    public ArrayList<Atividade> getAtividades(){
        return this.atividades;
    }

    public void setAtividades(ArrayList<Atividade> atividades){
        this.atividades = atividades;
    }

    public int getNumeroFaltas(){
        return this.numeroFaltas;
    }

    public void setNumeroFaltas(int numeroFaltas){
        this.numeroFaltas = numeroFaltas;//SE PERTINENTE, PASSAR O NUM DE FALTAS A SEREM ADICIONADAS E MUDAR PARA +=//
    }

    public double getMedia(){
        return this.media;
    }

    public void setMedia(double media){
        this.media = media;
    }

    //Metodos da classe Disciplina//
    public void recalculaMedia(){
        media = 0;
        for(int i = 0; i < this.atividades.size(); i++)
            media += this.atividades.get(i).getPeso() * this.atividades.get(i).getNota();
        this.setMedia(media/this.atividades.size());
    }
}
