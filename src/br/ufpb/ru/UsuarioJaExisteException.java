package br.ufpb.ru;

public class UsuarioJaExisteException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UsuarioJaExisteException(String msg) {
        super(msg);
    }

}
