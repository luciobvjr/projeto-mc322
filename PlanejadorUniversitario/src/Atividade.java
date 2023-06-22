public class Atividade {
    private String nome;
    private double peso;
    private double nota;

    public Atividade(String nome, double peso, double nota){
        this.nome = nome;
        this.peso = peso;
        this.nota = nota;
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
