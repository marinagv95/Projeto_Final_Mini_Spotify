package br.com.maisunifacisa.models;

import br.com.maisunifacisa.enums.GeneroMusical;
import br.com.maisunifacisa.enums.TipoMidia;

public class Musica extends Midia{
    private TipoMidia tipo;
    private GeneroMusical generoMusical;

    public Musica(String titulo, String artista, int duracao,  TipoMidia tipo, GeneroMusical generoMusical) {
        super(titulo, artista, duracao);
        this.tipo = TipoMidia.MUSICA;
        this.generoMusical = generoMusical;
    }

    public TipoMidia getTipo() {
        return tipo;
    }

    public void setTipo(TipoMidia tipo) {
        this.tipo = tipo;
    }

    public GeneroMusical getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(GeneroMusical generoMusical) {
        this.generoMusical = generoMusical;
    }

    @Override
    public String toString() {
        return "Música: " + getTitulo() + " | Artista: " + getArtista() +
                " | Duração: " + getDuracao() + " min | Gênero: " + getGeneroMusical();
    }

}
