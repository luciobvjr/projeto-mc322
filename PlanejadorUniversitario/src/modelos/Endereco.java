package modelos;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(String rua, Integer numero, String bairro, String cidade, String estado, String pais) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    // classe molde para tratar a exceção
    public class ExcecoesEnderco extends Exception {
        public.ExcecoesEndereco {
            super("Dados inseridos incorretamente, insira novamente.")
        }
    }

    // classe que trata a exceção para caso os dados do aluno sejam inseridos incorretamente;
    public class MinhaClasse {
        ExcecoesEndereco e = new ExcecoesEndereco();

        if (!this.rua instanceof String) throws e;

        if (!this.numero instanceof Integer) throws e;

        if (!this.bairro instanceof String) throws e;

        if (!this.cidade instanceof String) throws e;

        if (!this.estado instanceof String) throws e;

        if (!this.pais instanceof String) throws e;
    }

    // Getters //
    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
    
    public String getPais() {
        return pais;
    }

    // Setters //
    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // Métodos públicos //
    @Override
    public String toString() {
        String descricao = "";

        descricao += this.rua + ", ";
        descricao += Integer.toString(this.numero) + ", ";
        descricao += this.bairro + ", ";
        descricao += this.cidade + " - ";
        descricao += this.estado + " - ";
        descricao += this.pais;

        return descricao;
    }
}