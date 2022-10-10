package br.ufpb.ru;

public class Usuario {

    private String nome;
    private String matricula;
    private String cidadeResidencia;

    public Usuario(String nome, String matricula, String cidadeResidencia) {
        this.nome = nome;
        this.matricula = matricula;
        this.cidadeResidencia = cidadeResidencia;
    }

    public String toString() {
        return this.nome + " de matricula " + this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCidadeResidencia() {
        return this.cidadeResidencia;
    }

    public void setCidadeResidencia(String cidadeResidencia) {
        this.cidadeResidencia = cidadeResidencia;
    }

}
