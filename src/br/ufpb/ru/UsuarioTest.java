package br.ufpb.ru;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @org.junit.jupiter.api.Test
    void getMatricula() {
        Usuario u = new Usuario("Bruno", "123", "RT");
        assertEquals("123", u.getMatricula());
    }

    @org.junit.jupiter.api.Test
    void getNome(){
        Usuario u = new Usuario("Raiff", "456", "RT");
        assertEquals("Raiff", u.getNome());
    }

    @org.junit.jupiter.api.Test
    void getCidadeResidencia(){
        Usuario u = new Usuario("Cinthia", "789", "Rio Tinto");
        assertEquals("Rio Tinto", u.getCidadeResidencia());
    }




}