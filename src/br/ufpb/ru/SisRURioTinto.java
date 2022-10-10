package br.ufpb.ru;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.IOException;

public class SisRURioTinto implements SisRU {

    private List<Usuario> usuarios;
    private List<RefeicaoRealizada> refeicoes;

    public SisRURioTinto() {
        this.usuarios = new ArrayList<Usuario>();
        this.refeicoes = new ArrayList<RefeicaoRealizada>();
    }

    public boolean cadastrarUsuario(Usuario u) {
        for (Usuario usuario : this.usuarios) {
            if (usuario.getMatricula().equals(u.getMatricula())) {
                return false;
            }
        }
        this.usuarios.add(u);
        return true;
    }

    public boolean removerUsuario(String matricula) throws UsuarioNaoExisteException{
        for(Usuario u: this.usuarios){
            if(u.getMatricula().equals(matricula)){
                usuarios.remove(u);
                return true;
            }
        }
        throw new UsuarioNaoExisteException("Não existe usuário com esta matrícula.");
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public List<Usuario> pesquisaUsuariosDaCidade(String cidade) {
        List<Usuario> usuariosDaCidadeTal = new ArrayList<Usuario>();
        for (Usuario u : this.usuarios) {
            if (u.getCidadeResidencia().equals(cidade)) {
                usuariosDaCidadeTal.add(u);
            }
        }
        return usuariosDaCidadeTal;
    }

    public Usuario pesquisaUsuarioPelaMatricula(String matricula) throws UsuarioNaoExisteException {
        for (Usuario u : this.usuarios) {
            if (u.getMatricula().equals(matricula)) {
                return u;
            }
        }
        throw new UsuarioNaoExisteException("Não existe usuário com esta matrícula.");
    }

    public List<Usuario> pesquisaUsuariosComNomeComecandoCom(String prefixo) {
        List<Usuario> usuariosDeNomeComecandoComTalPrefixo = new ArrayList<Usuario>();
        for (Usuario u : this.usuarios) {
            if (u.getNome().startsWith(prefixo)) {
                usuariosDeNomeComecandoComTalPrefixo.add(u);
            }
        }
        return usuariosDeNomeComecandoComTalPrefixo;
    }

    public void salvarDados() {
        GravadorDeDados gravador = new GravadorDeDados();
        try {
            gravador.gravarUsuarios(this.usuarios);
            gravador.gravarRefeicoes(this.refeicoes);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar dados. " + e.getMessage());
        }
    }

    public void recuperarDados() {
        GravadorDeDados resgataDados = new GravadorDeDados();
        try {
            this.usuarios = resgataDados.recuperarUsuarios();
            this.refeicoes = resgataDados.recuperarRefeicoes();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao recuperar dados. " + e.getMessage());
        }
    }

    public void cadastrarRefeicaoRealizada(String matricula, int dia, int mes, int ano, String tipoRefeicao)
            throws UsuarioNaoExisteException {
        for (Usuario u : this.usuarios) {
            if (u.getMatricula().equals(matricula)) {
                Data dataRefeicao = new Data(dia, mes, ano);
                RefeicaoRealizada refeicaoRealizada = new RefeicaoRealizada(dataRefeicao, matricula, tipoRefeicao);
                this.refeicoes.add(refeicaoRealizada);
            }
            return;
        }
        throw new UsuarioNaoExisteException("Este usuário não foi encontrado");
    }

    public int pesquisaNumeroTotalDeRefeicoesRealizadadasEmUmCertoDia(int dia, int mes, int ano) {
        int contadorRefeicoes = 0;
        for (RefeicaoRealizada r : this.refeicoes) {
            if (r.getDataRefeicao().getDia() == dia && r.getDataRefeicao().getMes() == mes
                    && r.getDataRefeicao().getAno() == ano) {
                contadorRefeicoes++;
            }
        }
        return contadorRefeicoes;
    }

    public int pesquisaNumeroDeRefeicoesDeUmCertoTipoRealizadasEmUmCertoMes(String tipoRefeicao, int mes, int ano) {
        int contadorRefeicoes = 0;
        for (RefeicaoRealizada r : this.refeicoes) {
            if (r.getTtipoRefeicao().equals(tipoRefeicao) && r.getDataRefeicao().getMes() == mes
                    && r.getDataRefeicao().getAno() == ano) {
                contadorRefeicoes++;
            }
        }
        return contadorRefeicoes;
    }

    public int pesquisaNumeroDeUsuariosQueFizeramRefeicoesEmUmCertoMesDeUmAno(int mes, int ano) {
        // TODO
        int contadorUsuarios = 0;
        for (RefeicaoRealizada r : this.refeicoes) {
            if (r.getDataRefeicao().getMes() == mes && r.getDataRefeicao().getAno() == ano) {
                contadorUsuarios++;
            }
        }
        return contadorUsuarios;
    }

    public List<Usuario> pesquisaUsuariosQueFizeramRefeicoesEmUmCertoDia(int dia, int mes, int ano) {
        //TODO
        List<Usuario> usuariosQueFizeramRefeicoes = new ArrayList<Usuario>();
        for (RefeicaoRealizada r : this.refeicoes) {
            if (r.getDataRefeicao().getDia() == dia && r.getDataRefeicao().getMes() == mes
                    && r.getDataRefeicao().getAno() == ano) {
                for(Usuario u: this.usuarios) {
                    usuariosQueFizeramRefeicoes.add(u);
                }
            }
        }
        return usuariosQueFizeramRefeicoes;
    }
}