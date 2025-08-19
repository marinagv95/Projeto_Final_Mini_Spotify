package br.com.maisunifacisa.models;

import java.util.ArrayList;


public class Playlist {
    private String nome;
    private Usuario usuario;
    private ArrayList<Musica> musicas = new ArrayList<>();

    public Playlist(String nome, Usuario usuario, ArrayList<Musica> musicas) {
        this.nome = nome;
        this.usuario = usuario;
        this.musicas = musicas;
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

    @Override
    public String toString() {
        return "Playlist{" +
                "nome='" + nome + '\'' +
                ", usuario=" + usuario +
                ", musicas=" + musicas +
                '}';
    }
}