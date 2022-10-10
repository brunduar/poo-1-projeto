package br.ufpb.ru;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDados {

    private String arquivoUsuarios = "usuarios.txt";
    private String arquivoRefeicoes = "refeicoes.txt";

    public void gravarUsuarios(List<Usuario> listaUsuarios) throws IOException {
        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter(arquivoUsuarios));
            for (Usuario u : listaUsuarios) {
                gravador.write(u.getNome() + "#" + u.getMatricula() + "#" + u.getCidadeResidencia() + "\n");
            }
        } finally {
            if (gravador != null) {
                gravador.close();
            }
        }
    }

    public List<Usuario> recuperarUsuarios() throws IOException {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader(arquivoUsuarios));
            String linhaLida = leitor.readLine();
            while (linhaLida != null) {
                String[] dados = linhaLida.split("#");
                Usuario u = new Usuario(dados[0], dados[1], dados[2]);
                listaUsuarios.add(u);
                linhaLida = leitor.readLine();
            }
            return listaUsuarios;
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
    }

    public void gravarRefeicoes(List<RefeicaoRealizada> listaRefeicoes) throws IOException {
        BufferedWriter gravadorRefeicoes = null;
        try {
            gravadorRefeicoes = new BufferedWriter(new FileWriter(arquivoRefeicoes));
            for (RefeicaoRealizada r : listaRefeicoes) {
                gravadorRefeicoes
                        .write(r.getDataRefeicao() + "#" + r.getMatriculaUsuario() + "#" + r.getTtipoRefeicao() + "\n");
            }
        } finally {
            if (gravadorRefeicoes != null) {
                gravadorRefeicoes.close();
            }
        }
    }

    public List<RefeicaoRealizada> recuperarRefeicoes() throws IOException {
        List<RefeicaoRealizada> listaRefeicoes = new ArrayList<RefeicaoRealizada>();
        BufferedReader leitor = null;
        try {
            leitor = new BufferedReader(new FileReader(arquivoRefeicoes));
            String linhaLida = leitor.readLine();
            while (linhaLida != null) {
                String[] dados = linhaLida.split("#");
                String[] dataRefeicao = dados[0].split("/");
                Data data = new Data(Integer.parseInt(dataRefeicao[0]), Integer.parseInt(dataRefeicao[1]), Integer.parseInt(dataRefeicao[2]));
                RefeicaoRealizada r = new RefeicaoRealizada(data, dados[1], dados[2]);
                listaRefeicoes.add(r);
                linhaLida = leitor.readLine();
            }
            return listaRefeicoes;
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
    }
}
