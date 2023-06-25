package modelos;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Aluno extends Pessoa implements Serializable {
    private final int ra;
    private double cp;
    private double cr;
    private Curso curso;
    private int anoDeIngresso;
    private int creditosPermitidos;
    private int creditosSemestrais;
    private ArrayList<Disciplina> arvoreDoCurso;
    private ArrayList<Disciplina> gradeSemestral;

    public Aluno(String nome, LocalDate dataNascimento, String rg, String cpf, String email, String telefone,
                 Genero genero, Endereco endereco, int ra, Curso curso, int anoDeIngresso,
                 ArrayList<Disciplina> arvoreDoCurso, ArrayList<Disciplina> gradeSemestral){
        super(nome, dataNascimento, rg, cpf, email, telefone, genero, endereco);
        this.ra = ra;
        this.cp = 0.0; //cp inicial é zero, pois um novo aluno ainda não teve progressão no curso//
        this.cr = 1.0; //cr inicial é 1 e diminui conforme o aluno avança no curso//
        this.curso = curso;
        this.anoDeIngresso = anoDeIngresso;
        this.arvoreDoCurso = arvoreDoCurso;
        this.gradeSemestral = gradeSemestral;//ADICIONAR O METODO DE CRIACAO DE GRADE PARA VETERANOS//
        this.creditosPermitidos = this.curso.getCreditosPermitidos();
        this.creditosSemestrais = calculaCreditosSemestrais(gradeSemestral);
    }

    //GETTERS E SETTERS//
    public int getRA(){
        return this.ra;
    }

    public double getCP(){
        return this.cp;
    }

    public void setCP(double cp){
        this.cp = cp;
    }

    public double getCR(){
        return this.cr;
    }

    public void setCR(double cr){
        this.cr = cr;
    }

    public Curso getCurso(){
        return this.curso;
    }

    //Apenas em caso de troca de curso//
    public void setCurso(Curso curso){
        this.curso = curso;
    }

    public int getAnoDeIngresso(){
        return this.anoDeIngresso;
    }

    //Em caso de troca de curso o ano de ingresso deve ser trocado//
    public void setAnoDeIngresso(int anoDeIngresso){
        this.anoDeIngresso = anoDeIngresso;
    }

    public ArrayList<Disciplina> getArvoreDoCurso(){
        return this.arvoreDoCurso;
    }

    //Em caso de troca de curso a arvore do curso deve ser atualizada//
    public void setArvoreDoCurso(ArrayList<Disciplina> arvoreDoCurso){
        this.arvoreDoCurso = arvoreDoCurso;
    }

    public ArrayList<Disciplina> getGradeSemestral(){
        return this.gradeSemestral;
    }

    public void setGradeSemestral(ArrayList<Disciplina> gradeSemestral){
        this.gradeSemestral = gradeSemestral;
    }

    public int getCreditosPermitidos(){
        return creditosPermitidos;
    }

    
    public void setCreditosPermitidos(int creditosPermitidos){//Creditos permitidos aumentam de acordo com o CR//
        this.creditosPermitidos = creditosPermitidos;
    }

    public int getCreditosSemestrais(){
        return this.creditosSemestrais;
    }

    public void setCreditosSemestrais(int creditosSemestrais){
        this.creditosSemestrais = creditosSemestrais;
    }

    //Metodos da classe Aluno//
    public int calculaCreditosSemestrais(ArrayList<Disciplina> gradeSemestral){
        int creditos = 0;
        for(int i = 0; i < gradeSemestral.size(); i++)
            creditos += gradeSemestral.get(i).getCreditos();
        return creditos;
    }

    //Metodo para adcionar disciplina se fizer parte do curso
        public void adicionarDisciplina(Disciplina disciplina) {
        if (arvoreDoCurso.contains(disciplina)) {
            gradeSemestral.add(disciplina);
            creditosSemestrais += disciplina.getCreditos();
        } 
        else {
            System.out.println("A disciplina não faz parte do curso do aluno.");
        }
    }

    //Metodo para remover disciplina se ja foi adcionada
    public void removerDisciplina(Disciplina disciplina) {
        if (gradeSemestral.contains(disciplina)) {
            gradeSemestral.remove(disciplina);
            creditosSemestrais -= disciplina.getCreditos();
        } 
        else {
            System.out.println("A disciplina não está na grade semestral do aluno.");
        }
    }
}
