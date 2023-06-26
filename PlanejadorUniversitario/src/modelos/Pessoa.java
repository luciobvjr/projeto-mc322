package modelos;
import java.io.Serializable;
import java.time.LocalDate;

public abstract class Pessoa implements Serializable {
    private String nome;
    private LocalDate dataNascimento;
    private final String rg;
    private final String cpf;
    private String email;
    private String telefone;
    private Genero genero;
    private Endereco endereco;
<<<<<<< HEAD:PlanejadorUniversitario/src/Pessoa.java
    
    public Pessoa(String nome, LocalDate dataNascimento, String rg, String cpf, String email,
    String telefone, Genero genero, Endereco endereco) {
=======

    public Pessoa(String nome, LocalDate dataNascimento, String rg, String cpf, String email, String telefone, Genero genero, Endereco endereco) {
>>>>>>> 782945c06bbc62117abb2a47522fb24912d40e72:PlanejadorUniversitario/src/modelos/Pessoa.java
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.genero = genero;
        this.endereco = endereco;
    }

    // classe molde para tratar a exceção
    public class ExcecoesPessoa extends Exception {
        public.ExcecoesPessoa {
            super("Dados inseridos incorretamente, insira novamente.")
        }
    }

    // classe que trata a exceção para caso os dados do aluno sejam inseridos incorretamente;
    public class MinhaClasse {
        ExcecoesPessoa e = new ExcecoesPessoa();

        if (!this.nome instanceof String) throws e;

        if (!this.dataNascimento instanceof LocalDate) throws e;

        if (!this.rg instanceof String) throws e;

        if (!this.cpf instanceof String) throws e;

        if (!this.email instanceof String) throws e;

        if (!this.telefone instanceof String) throws e;

        if (!this.genero instanceof Genero) throws e;

        if (!this.endereco instanceof Endereco) throws e;
    }

    // Getters //
    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Genero getGenero() {
        return genero;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    // Setters //
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}