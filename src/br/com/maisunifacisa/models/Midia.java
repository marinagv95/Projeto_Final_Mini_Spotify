package br.com.maisunifacisa.models;




public abstract class Midia {
    private String titulo;
    private String artista;
    private int duracao;




    public Midia(String titulo, String artista, int duracao) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;


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


    public void setGenero(String genero) {

    }


    @Override
    public String toString() {
        return "Midia{" +
                "titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", duracao=" + duracao +
                '}';
    }
}
