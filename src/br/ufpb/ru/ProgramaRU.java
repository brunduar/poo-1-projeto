package br.ufpb.ru;

import java.util.List;
import javax.swing.JOptionPane;

public class ProgramaRU {

    public static void main(String[] args) {

        SisRU sistema = new SisRURioTinto();
        sistema.recuperarDados();

        boolean sair = false;

        while (!sair) {

            try {

                int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite uma opção:\n\n"
                        + "1. Cadastrar usuário\n2. Listar todos os usuários\n" + "3. Pesquisa usuários da cidade ...\n"
                        + "4. Pesquisa usuário pela matrícula\n"
                        + "5. Pesquisa usuários com nome começando com ...\n6. Cadastrar refeição realizada\n"
                        + "7. Pesquisar número de refeições totais realizadas em um certo dia\n"
                        + "8. Pesquisar número de refeições de um certo tipo realizadas em um certo mês de um ano\n"
                        + "9. Pesquisar número de usuários que fizeram refeições em um certo mês\n"
                        + "10. Pesquisar usuários que fizeram refeições em um certo dia\n"
                        + "11. Salvar dados\n12. Sair", "Menu", JOptionPane.QUESTION_MESSAGE));

                switch (opcao) {

                    case 1:
                        String nomeUsuario = JOptionPane.showInputDialog(null, "Digite o nome do usu�rio",
                                "Cadastrando usu�rio", JOptionPane.QUESTION_MESSAGE);
                        String matriculaUsuario = JOptionPane.showInputDialog(null, "Digite a matr�cula do usu�rio",
                                "Cadastrando usu�rio", JOptionPane.QUESTION_MESSAGE);
                        String cidadeUsuario = JOptionPane.showInputDialog(null,
                                "Digite a cidade de resid�ncia do usuário", "Cadastrando usu�rio",
                                JOptionPane.QUESTION_MESSAGE);
                        Usuario usuario = new Usuario(nomeUsuario, matriculaUsuario, cidadeUsuario);
                        boolean cadastrou = sistema.cadastrarUsuario(usuario);
                        if (cadastrou) {
                            JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso");
                        } else {
                            JOptionPane.showMessageDialog(null, "J� existe usu�rio com esta matr�cula. Tente novamente.");
                        }
                        break;

                    case 2:
                        String lista = "";
                        List<Usuario> listaUsuarios = sistema.getUsuarios();
                        for (Usuario u : listaUsuarios) {
                            lista += u.toString() + "\n";
                        }
                        if (lista.equals("")) {
                            JOptionPane.showMessageDialog(null, "N�o existe nenhum usu�rio cadastrado.");
                        } else {
                            JOptionPane.showMessageDialog(null, lista, "Lista de todos os usu�rios",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 3:
                        String cidadeAPesquisar = JOptionPane.showInputDialog(null,
                                "Digite a cidade que voc� quer pesquisar", "Pesquisando usu�rios pela cidade",
                                JOptionPane.QUESTION_MESSAGE);
                        String moradoresDeTalCidade = "";
                        List<Usuario> usuariosDaCidadeTal = sistema.pesquisaUsuariosDaCidade(cidadeAPesquisar);
                        for (Usuario u : usuariosDaCidadeTal) {
                            moradoresDeTalCidade += u.toString() + "\n";
                        }
                        if (moradoresDeTalCidade == "") {
                            JOptionPane.showMessageDialog(null, "N�o foi encontrado ningu�m que reside nesta cidade.");
                        } else {
                            JOptionPane.showMessageDialog(null, moradoresDeTalCidade,
                                    "Usu�rios da cidade de '" + cidadeAPesquisar + "'", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 4:
                        try {
                            String matriculaAPesquisar = JOptionPane.showInputDialog(null,
                                    "Digite a matr�cula que voc� quer pesquisar", "Pesquisando usu�rio pela matr�cula",
                                    JOptionPane.QUESTION_MESSAGE);
                            Usuario usuarioDeTalMatricula = sistema.pesquisaUsuarioPelaMatricula(matriculaAPesquisar);
                            JOptionPane.showMessageDialog(null, usuarioDeTalMatricula.toString(), "Usu�rio",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } catch (UsuarioNaoExisteException erro) {
                            JOptionPane.showMessageDialog(null, erro.getMessage());
                        }
                        break;

                    case 5:
                        String prefixoAPesquisar = JOptionPane.showInputDialog(null,
                                "Digite o prefixo que voc� quer pesquisar", "Pesquisando usu�rios por prefixo",
                                JOptionPane.QUESTION_MESSAGE);
                        String usuariosDeNomeComecandoCom = "";
                        List<Usuario> usuariosComNomeComecandoComTalPrefixo = sistema
                                .pesquisaUsuariosComNomeComecandoCom(prefixoAPesquisar);
                        for (Usuario u : usuariosComNomeComecandoComTalPrefixo) {
                            usuariosDeNomeComecandoCom += u.getNome() + "\n";
                        }
                        if (usuariosDeNomeComecandoCom == "") {
                            JOptionPane.showMessageDialog(null, "N�o foi encontrado ningu�m que tenha este prefixo.", null,
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, usuariosDeNomeComecandoCom,
                                    "Usu�rios come�ando com '" + prefixoAPesquisar + "'", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;

                    case 6:
                        try {
                            String matriculaDoCadastroDaRefeicao = JOptionPane.showInputDialog(null,
                                    "Digite a matr�cula para cadastrar a refei��o", "Cadastrando refei��o",
                                    JOptionPane.QUESTION_MESSAGE);
                            String[] dataDaRefeicao = JOptionPane.showInputDialog(null,
                                    "Digite a data em que a refei��o foi realizada no formato dd/mm/aaaa",
                                    "Cadastrando refei��o", JOptionPane.QUESTION_MESSAGE).split("/");
                            int diaRefeicao = Integer.parseInt(dataDaRefeicao[0]);
                            int mesRefeicao = Integer.parseInt(dataDaRefeicao[1]);
                            int anoRefeicao = Integer.parseInt(dataDaRefeicao[2]);
                            String tipoRefeicao = JOptionPane.showInputDialog(null, "Digite o tipo da refei��o",
                                    "Cadastrando refei��o", JOptionPane.QUESTION_MESSAGE);
                            sistema.cadastrarRefeicaoRealizada(matriculaDoCadastroDaRefeicao, diaRefeicao, mesRefeicao,
                                    anoRefeicao, tipoRefeicao);
                            JOptionPane.showMessageDialog(null, "Refei��o cadastrada com sucesso!");
                        } catch (UsuarioNaoExisteException e) {
                            JOptionPane.showMessageDialog(null, "N�o foi encontrado nenhum usu�rio com esta matr�cula");
                        }
                        break;

                    case 7:
                        String[] dataRefeicoesDoDiaTal = JOptionPane.showInputDialog(null,
                                        "Digite a data no formato dd/mm/aaaa",
                                        "Pesquisando n�mero de refei��es realizadas em um certo dia", JOptionPane.QUESTION_MESSAGE)
                                .split("/");
                        int diaRefeicaoTal = Integer.parseInt(dataRefeicoesDoDiaTal[0]);
                        int mesRefeicaoTal = Integer.parseInt(dataRefeicoesDoDiaTal[1]);
                        int anoRefeicaoTal = Integer.parseInt(dataRefeicoesDoDiaTal[2]);
                        int numeroTotalRefeicoes = sistema.pesquisaNumeroTotalDeRefeicoesRealizadadasEmUmCertoDia(
                                diaRefeicaoTal, mesRefeicaoTal, anoRefeicaoTal);
                        JOptionPane.showMessageDialog(null,
                                "Foram realizadas " + numeroTotalRefeicoes + " refei��es neste dia");
                        break;

                    case 8:
                        String tipoRefeicaoAPesquisar = JOptionPane.showInputDialog(null, "Digite o tipo de refei��o",
                                "Pesquisando n�mero de refei��es de um certo tipo realizadas em um certo m�s",
                                JOptionPane.QUESTION_MESSAGE);
                        int mesAPesquisar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o m�s a pesquisar",
                                "Pesquisando n�mero de refei��es de um certo tipo realizadas em um certo m�s",
                                JOptionPane.QUESTION_MESSAGE));
                        int anoAPesquisar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano a pesquisar",
                                "Pesquisando n�mero de refei��es de um certo tipo realizadas em um certo m�s",
                                JOptionPane.QUESTION_MESSAGE));
                        int numeroTotalRefeicoesDeUmCertoTipo = sistema
                                .pesquisaNumeroDeRefeicoesDeUmCertoTipoRealizadasEmUmCertoMes(tipoRefeicaoAPesquisar,
                                        mesAPesquisar, anoAPesquisar);
                        JOptionPane.showMessageDialog(null,
                                "Foram realizadas" + numeroTotalRefeicoesDeUmCertoTipo + " refei��es neste dia");
                        break;

                    case 9:
                        int pesquisaMes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o m�s a pesquisar",
                                "Pesquisando n�mero de usu�rios que realizaram refei��es em um certo m�s",
                                JOptionPane.QUESTION_MESSAGE));
                        int pesquisaAno = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o tipo de refei��o",
                                "Pesquisando n�mero de usu�rios que realizaram refei��es em um certo m�s",
                                JOptionPane.QUESTION_MESSAGE));
                        int numeroTotalDeUsuarios = sistema
                                .pesquisaNumeroDeUsuariosQueFizeramRefeicoesEmUmCertoMesDeUmAno(pesquisaMes, pesquisaAno);
                        JOptionPane.showMessageDialog(null, numeroTotalDeUsuarios + " fizeram refei��es neste m�s");
                        break;

                    case 10:
                        int diaPesquisar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia a pesquisar",
                                "Pesquisando usu�rios que fizeram refei��es em um certo dia",
                                JOptionPane.QUESTION_MESSAGE));
                        int mesPesquisar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite m�s a pesquisar",
                                "Pesquisando usu�rios que fizeram refei��es em um certo dia",
                                JOptionPane.QUESTION_MESSAGE));
                        int anoPesquisar = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o ano a pesquisar",
                                "Pesquisando usu�rios que fizeram refei��es em um certo dia",
                                JOptionPane.QUESTION_MESSAGE));
                        String nomeEMatriculaDosUsuarios = "";
                        List<Usuario> usuariosQueFizeramRefeicoes = sistema
                                .pesquisaUsuariosQueFizeramRefeicoesEmUmCertoDia(diaPesquisar, mesPesquisar, anoPesquisar);
                        for(Usuario u: usuariosQueFizeramRefeicoes) {
                            nomeEMatriculaDosUsuarios += u.toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, nomeEMatriculaDosUsuarios);
                        break;

                    case 11:
                        sistema.salvarDados();
                        JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
                        break;

                    case 12:
                        int querSair = JOptionPane.showConfirmDialog(null, "Voc� realmente deseja sair do programa?",
                                "Selecione uma op��o", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (querSair == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Obrigado! At� breve!");
                            sair = true;
                        }
                        sistema.salvarDados();
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Digite uma op��o v�lida!");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Voc� deve digitar um n�mero relacionado � fun��o desejada.");
            }
        }
    }
}
