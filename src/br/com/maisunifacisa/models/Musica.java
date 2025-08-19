package br.com.maisunifacisa.models;

import br.com.maisunifacisa.enums.TipoMidia;

public class Musica extends Midia{
    private TipoMidia tipo;

    public Musica(String titulo, String artista, int duracao, String genero, TipoMidia tipo) {
        super(titulo, artista, duracao, genero);
        this.tipo = TipoMidia.MUSICA;
    }

    public TipoMidia getTipo() {
        return tipo;
    }

    public void setTipo(TipoMidia tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "tipo=" + tipo +
                '}';
    }
}
