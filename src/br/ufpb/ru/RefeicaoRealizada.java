package br.ufpb.ru;

public class RefeicaoRealizada {

    private Data dataRefeicao;
    private String matriculaUsuario;
    private String tipoRefeicao;

    public RefeicaoRealizada(Data dataRefeicao, String matriculaUsuario, String tipoRefeicao) {
        this.dataRefeicao = dataRefeicao;
        this.matriculaUsuario = matriculaUsuario;
        this.tipoRefeicao = tipoRefeicao;
    }

    public Data getDataRefeicao() {
        return this.dataRefeicao;
    }

    public void setDataRefeicao(Data dataRefeicao) {
        this.dataRefeicao = dataRefeicao;
    }

    public String getMatriculaUsuario() {
        return this.matriculaUsuario;
    }

    public void setMatriculaUsuario(String matriculaUsuario) {
        this.matriculaUsuario = matriculaUsuario;
    }

    public String getTtipoRefeicao() {
        return this.tipoRefeicao;
    }

    public void setTipoRefeicao(String tipoRefeicao) {
        this.tipoRefeicao = tipoRefeicao;
    }

    public String toString() {
        return this.dataRefeicao.toString() + "#" + this.matriculaUsuario + "#" + this.tipoRefeicao;
    }
}
