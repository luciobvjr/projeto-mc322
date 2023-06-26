package modelos;
import java.io.Serializable;
import java.util.ArrayList;

public class Disciplina implements Serializable {
    private final String nome;
    private final int creditos;
    private final String codigo;
    private Professor professor;
    //private Instituto instituto;
    private ArrayList<Atividade> atividades = new ArrayList<Atividade>(); //ADICIONAR METODO PARA ADICIONAR ATIVIDADES
    private int numeroFaltas;
    private double media;

    public Disciplina(String nome,int creditos,String codigo, Professor professor){
        this.nome = nome;
        this.creditos = creditos;
        this.codigo = codigo;
        this.professor = professor;
        this.numeroFaltas = 0;
        this.media = 0.0;
    }

    // classe molde para tratar a exceção
    public class ExcecoesDisciplina extends Exception {
        public.ExcecoesDisciplina {
            super("Dados inseridos incorretamente, insira novamente.")
        }
    }

    // classe que trata a exceção para caso os dados do aluno sejam inseridos incorretamente;
    public class MinhaClasse {
        ExcecoesDisciplina e = new ExcecoesDisciplina();

        if (!this.nome instanceof String) throws e;

        if (!this.creditos instanceof int) throws e;

        if (!this.codigo instanceof String) throws e;

        if (!this.numeroFaltas instanceof int) throws e;

        if (!this.media instanceof double) throws e;
    }

    //Getters e Setters//
    public String getNome(){
        return this.nome;
    }

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
    public void recalculaMedia() throws ArrayIndexOutOfBondsException{
        try {
        media = 0;
        for(int i = 0; i < this.atividades.size(); i++)
            media += this.atividades.get(i).getPeso() * this.atividades.get(i).getNota();
        this.setMedia(media/this.atividades.size());
        } catch (ArrayIndexOutOfBondsException e) {
            System.out.println("erro: " + e);
        }
    }
}
