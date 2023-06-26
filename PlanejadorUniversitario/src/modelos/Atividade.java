package modelos;
public class Atividade {
    private String nome;
    private double peso;
    private double nota;

    public Atividade(String nome, double peso, double nota){
        this.nome = nome;
        this.peso = peso;
        this.nota = nota;
    }

    // classe molde para tratar a exceção
    public class ExcecoesAtividade extends Exception {
        public.ExcecoesAtividade {
            super("Dados inseridos incorretamente, insira novamente.")
        }
    }

    // classe que trata a exceção para caso os dados do aluno sejam inseridos incorretamente;
    public class MinhaClasse {
        ExcecoesAtividade e = new ExcecoesAtividade();

        if (!this.nome instanceof String) throws e;

        if (!this.peso instanceof double) throws e;

        if (!this.nota instanceof double) throws e;
    }

    //Getters e Setters//
    
    public String getNome(){
        return this.nome;
    }

    public double getPeso(){
        return this.peso;
    }

    public void setPeso(double peso){
        this.peso = peso;
    }

    public double getNota(){
        return this.nota;
    }

    public void setNota(double nota){
        this.nota = nota;
    }

    //Métodos da classe Atividade//
    //....//
}
