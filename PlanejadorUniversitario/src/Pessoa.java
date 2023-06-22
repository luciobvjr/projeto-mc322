import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private final String rg;
    private final String cpf;
    private String email;
    private String telefone;
    private Genero genero;
//    private Endereco endereco;
    
    public Pessoa(String nome, LocalDate dataNascimento, String rg, String cpf, String email, String telefone, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.genero = genero;
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
}