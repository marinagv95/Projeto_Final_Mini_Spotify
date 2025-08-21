package br.com.maisunifacisa.models;


import java.util.ArrayList;
import java.util.Scanner;


public class Sistema {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Playlist> playlists = new ArrayList<>();
    ArrayList<Musica> musicas = new ArrayList<>();

    public Sistema( ArrayList<Usuario> usuarios, ArrayList<Playlist> playlists, ArrayList<Musica> musicas) {
        this.usuarios = usuarios;
        this.playlists = playlists;
        this.musicas = musicas;
    }

    public Sistema() {
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica> musicas) {
        this.musicas = musicas;
    }

    public void criarUsuario(Scanner sc){
        System.out.print("Digite o nome do usuário: ");
        String nome = sc.nextLine();
        System.out.print("Digite um e-mail válido: ");
        String email = sc.nextLine();
        Usuario usuario = new Usuario(nome, email);
        adicionarUsuario(usuario);
        System.out.println("Usuário adicionado com sucesso");

    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);

    }


    public String listarTodosUsuarios() {
        String retorno = "";
        for (int i = 0; i < usuarios.size(); i++) {
            retorno += (i + 1) + " - " + usuarios.get(i).toString() + "\n";
        }
        return retorno;
    }

    public Usuario buscarUsuarioPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    }

    public Boolean verificarUsuarioExiste(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }


    public void listarPlaylistUsuario(Scanner sc){
        System.out.print("Digite o e-mail do usuário: ");
        String emailUsuario = sc.nextLine();

        if (getPlaylists().isEmpty()) {
            System.out.println("Você não tem nenhuma playlist cadastrada!");
        } else if (verificarUsuarioExiste(emailUsuario)) {
            System.out.println(listarPlaylistDoUsuario(emailUsuario));
        } else {
            System.out.println("Digite um e-mail válido!");
        }
    }


    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public String listarTodasPlaylists() {
        String retorno = "";
        for (int i = 0; i < playlists.size(); i++) {
            retorno += (i + 1) + " - " + playlists.get(i).toString() + "\n";
        }
        return retorno;
    }


    public String listarPlaylistDoUsuario(String email) {
        String retorno = "";
        for (Playlist playlist : playlists) {
            if (playlist.getUsuario().getEmail().equals(email)) {
                retorno += playlist + "\n";
            }
        }
        return retorno;
    }


}
