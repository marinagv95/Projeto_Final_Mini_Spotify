package br.com.maisunifacisa.models;


import br.com.maisunifacisa.enums.TipoMidia;

public class Midia {
    private String titulo;
    private String artista;
    private int duracao;
    private String genero;



    public Midia(String titulo, String artista, int duracao, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    @Override
    public String toString() {
        return "Midia{" +
                "titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", duracao=" + duracao +
                ", genero='" + genero + '\'' +
                '}';
    }
}
