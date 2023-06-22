import java.util.ArrayList;

public class Curso {
    private final int codigo;
    private ArrayList<Disciplina> arvoreIntegralizacao;
    //private Instituto instituto;
    private int creditosPermitidos;
    private int creditosObrigatorios;
    private int creditosEletivos;
    private String turno;
    private int semestres;

    public Curso(int codigo, ArrayList<Disciplina> arvoreIntegralizacao, int creditosPermitidos, int creditosObrigatorios, int creditosEletivos, String turno, int semestres){
        this.codigo = codigo;
        this.arvoreIntegralizacao = arvoreIntegralizacao;
        this.creditosPermitidos = creditosPermitidos;
        this.creditosObrigatorios = creditosObrigatorios;
        this.creditosEletivos = creditosEletivos;
        this.turno = turno;
        this.semestres = semestres;
    }

    //Getters e Setters//
    
    public int getCodigo(){
        return this.codigo;
    }

    public ArrayList<Disciplina> getArvoreIntegralizacao(){
        return this.arvoreIntegralizacao;
    }

    public void setArvoreIntegralizacao(ArrayList<Disciplina> arvoreIntegralizacao){
        this.arvoreIntegralizacao = arvoreIntegralizacao;
    }

    public int getCreditosPermitidos(){
        return this.creditosPermitidos;
    }

    public void setCreditosPermitidos(int creditosPermitidos){
        this.creditosPermitidos = creditosPermitidos;
    }

    public int getCreditosObrigatorios(){
        return this.creditosObrigatorios;
    }

    public void setCreditosObrigatorios(int creditosObrigatorios){
        this.creditosObrigatorios = creditosObrigatorios;
    }

    public int getCreditosEletivos(){
        return this.creditosEletivos;
    }

    public void setCreditosEletivos(int creditosEletivos){
        this.creditosEletivos = creditosEletivos;
    }

    public String getTurno(){
        return this.turno;
    }

    public void setTurno(String turno){
        this.turno = turno;//ADICIONAR EXCEPTION PARA TRATAR APENAS AS STRINGS "DIURNO" E "NOTURNO"//
    }

    public int getSemestres(){
        return this.semestres;
    }

    public void setSemestres(int semestres){
        this.semestres = semestres;
    }

    //Metodos da classe Curso//
    //....//
}
