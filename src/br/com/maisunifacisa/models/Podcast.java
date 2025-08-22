package br.com.maisunifacisa.models;

import br.com.maisunifacisa.enums.TipoMidia;

public class Podcast extends Midia{

    private TipoMidia tipo;

    public Podcast(String titulo, String artista, int duracao, TipoMidia tipo) {
        super(titulo, artista, duracao);
        this.tipo = TipoMidia.PODCAST;
    }

    public TipoMidia getTipo() {
        return tipo;
    }

    public void setTipo(TipoMidia tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Podcast: " + getTitulo() + " | Host: " + getArtista() +
                " | Duração: " + getDuracao() + " min";
    }

}
