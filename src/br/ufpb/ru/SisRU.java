package br.ufpb.ru;

import java.util.List;

public interface SisRU {

    public boolean cadastrarUsuario(Usuario u);

    public List<Usuario> getUsuarios();

    public List<Usuario> pesquisaUsuariosDaCidade(String cidade);

    public Usuario pesquisaUsuarioPelaMatricula(String matricula) throws UsuarioNaoExisteException;

    public List<Usuario> pesquisaUsuariosComNomeComecandoCom(String prefixo);

    public void salvarDados();

    public void recuperarDados();

    public void cadastrarRefeicaoRealizada(String matricula, int dia, int mes, int ano, String tipoRefeicao)
            throws UsuarioNaoExisteException;

    public int pesquisaNumeroTotalDeRefeicoesRealizadadasEmUmCertoDia(int dia, int mes, int ano);

    public int pesquisaNumeroDeRefeicoesDeUmCertoTipoRealizadasEmUmCertoMes(String tipoRefeicao, int mes, int ano);

    public int pesquisaNumeroDeUsuariosQueFizeramRefeicoesEmUmCertoMesDeUmAno(int mes, int ano);

    public List<Usuario> pesquisaUsuariosQueFizeramRefeicoesEmUmCertoDia(int dia, int mes, int ano);

}
