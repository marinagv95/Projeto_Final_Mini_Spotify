package br.com.maisunifacisa.models;

import br.com.maisunifacisa.enums.TipoMidia;

public class Audiobook extends Midia{
    private TipoMidia tipo;

    public Audiobook(String titulo, String artista, int duracao, TipoMidia tipo) {
        super(titulo, artista, duracao);
        this.tipo = TipoMidia.AUDIOBOOK;
    }

    public TipoMidia getTipo() {
        return tipo;
    }

    public void setTipo(TipoMidia tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Audiobook: " + getTitulo() + " | Autor: " + getArtista() +
                " | Duração: " + getDuracao() + " min";
    }

}
