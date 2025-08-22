package br.com.maisunifacisa.models;

import java.util.ArrayList;
import java.util.Objects;


public class Playlist {
    private String nome;
    private Usuario usuario;
    private ArrayList<Musica> musicas;
    private int duracaoTotal;

    public Playlist(String nome, Usuario usuario, int duracaoTotal) {
        this.nome = nome;
        this.usuario = usuario;
        this.duracaoTotal = duracaoTotal;
        this.musicas = new ArrayList<>();
    }

    public Playlist(String nome, Usuario usuario) {
        this.nome = nome;
        this.usuario = usuario;
        this.musicas = new ArrayList<>();
    }

    public Playlist() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

    public int getDuracaoTotal() {
        return duracaoTotal;
    }

    public void setDuracaoTotal(int duracaoTotal) {
        this.duracaoTotal = duracaoTotal;
    }

    public int duracaoTotal() {
        int total = 0;
        for (Musica musica : musicas) {
            total += musica.getDuracao();
        }
        return total;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(musicas, playlist.musicas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(musicas);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "nome='" + nome + '\'' +
                ", usuario=" + usuario +
                ", musicas=" + musicas +
                ", duração da playlist=" + duracaoTotal() +
                " min" +
                '}';
    }
}