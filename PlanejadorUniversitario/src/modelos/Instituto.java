package modelos;

import java.util.ArrayList;

public class Instituto {
    private final String nome;
    private final String sigla;
    private Endereco endereco;
    private ArrayList<Disciplina> disciplinasOferecidas = new ArrayList<Disciplina>();

    public Instituto(String nome, String sigla, Endereco endereco){
        this.nome = nome;
        this.sigla = sigla;
        this.endereco = endereco;
    }

    // classe molde para tratar a exceção
    public class ExcecoesInstituto extends Exception {
        public.ExcecoesInstituto {
            super("Dados inseridos incorretamente, insira novamente.")
        }
    }

    // classe que trata a exceção para caso os dados do aluno sejam inseridos incorretamente;
    public class MinhaClasse {
        ExcecoesInstituto e = new ExcecoesInstituto();

        if (!this.nome instanceof String) throws e;

        if (!this.sigla instanceof String) throws e;

        if (!this.enderco instanceof Endereco) throws e;
    }

    //Getters//
    public String getNome(){
        return this.nome;
    }

    public String getSigla(){
        return this.sigla;
    }

    public Endereco getEndereco(){
        return this.endereco;
    }

    public ArrayList<Disciplina> getDisciplinasOferecidas(){
        return this.disciplinasOferecidas;
    }

    //Setters//
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    
    public void setDisciplinasOferecidas(ArrayList<Disciplina> disciplinasOferecidas){
        this.disciplinasOferecidas = disciplinasOferecidas;
    }
}
