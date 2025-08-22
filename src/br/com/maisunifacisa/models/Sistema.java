package br.com.maisunifacisa.models;


import br.com.maisunifacisa.enums.GeneroMusical;
import br.com.maisunifacisa.enums.TipoMidia;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Sistema {

    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Playlist> playlists = new ArrayList<>();
    ArrayList<Musica> musicas = new ArrayList<>();
    ArrayList<Midia> midias = new ArrayList<>();

    public Sistema(ArrayList<Usuario> usuarios, ArrayList<Playlist> playlists, ArrayList<Musica> musicas) {
        this.usuarios = usuarios;
        this.playlists = playlists;

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


    public void criarUsuario(Scanner sc) {
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


    public void listarPlaylistUsuario(Scanner sc) {
        System.out.print("Digite o e-mail do usuário: ");
        String emailUsuario = sc.nextLine();
        verificarPlaylistCadastrada(emailUsuario);

    }

    // implementar exception
    public void verificarPlaylistCadastrada(String emailUsuario) {
        if (getPlaylists().isEmpty()) {
            System.out.println("Você não tem nenhuma playlist cadastrada!");
        } else if (verificarUsuarioExiste(emailUsuario)) {
            System.out.println(listarPlaylistUsuario(emailUsuario));
        } else {
            System.out.println("Digite um e-mail válido!");
        }
    }

    public String listarPlaylistUsuario(String email) {
        String retorno = "";
        for (Playlist playlist : playlists) {
            if (playlist.getUsuario().getEmail().equals(email)) {
                retorno += playlist + "\n";
            }
        }
        return retorno;
    }


    public void criarPlaylist(Scanner sc) {
        System.out.print("Digite um nome para a Playlist: ");
        String nomePlaylist = sc.nextLine();
        System.out.print("Digite o e-mail do usuário para atribuir a playlist: ");
        String emailUsuario = sc.nextLine();
        criarPlaylist(nomePlaylist, emailUsuario);

    }

    //implementar exception
    public void criarPlaylist(String nomePlaylist, String emailUsuario) {
        if (verificarUsuarioExiste(emailUsuario)) {
            Usuario usuarioEncontrado = buscarUsuarioPorEmail(emailUsuario);
            Playlist playlist = new Playlist(nomePlaylist, usuarioEncontrado);
            adicionarPlaylist(playlist);
            System.out.println("Playlist criada com sucesso!");
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


    // Colocar exceptions
    public void removerPlaylist(Scanner sc) {
        System.out.print("Digite o nome da playlist para remover: ");
        String nomePlaylist = sc.nextLine();
        removerPlaylist(nomePlaylist);

    }

    public boolean removerPlaylist(String nomePlaylist) {
        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getNome().equalsIgnoreCase(nomePlaylist)) {
                playlists.remove(i);
                System.out.println("Playlist removida com sucesso!");
                return true;
            }
        }
        return false;
    }



    public void atualizarNomePlaylist(Scanner sc) {
        System.out.print("Digite o email do usuário para acessar as playlists: ");
        String emailUsuario = sc.nextLine();
        System.out.print("Digite o nome da playlist para alterar: ");
        String nomePlaylist = sc.nextLine();
        System.out.print("Digite o novo nome: ");
        String novoNomePlaylist = sc.nextLine();


        atualizarNomePlaylist(emailUsuario, nomePlaylist, novoNomePlaylist);

    }

    //Colocar Exceptions
    public void atualizarNomePlaylist(String emailUsuario, String nomePlaylist, String novoNomePlaylist) {
        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nomePlaylist) && playlist.getUsuario().getEmail().equals(emailUsuario)) {
                playlist.setNome(novoNomePlaylist);
                System.out.println("Nome atualizado com sucesso!");

            } else {
                System.out.println("Playlist não encontrada para esse Usuário!");
            }
        }
    }


    //Colocar Exception
    public void criarMidia(Scanner sc) {
        System.out.print("Digite o nome do Título: ");
        String titulo = sc.nextLine();

        System.out.print("Digite o nome do Artista: ");
        String artista = sc.nextLine();

        System.out.print("Digite a duração da Mídia: ");
        int duracao = sc.nextInt();
        sc.nextLine();

        System.out.println("Selecione o gênero musical:");
        System.out.println("1 - Rock");
        System.out.println("2 - Pop");
        System.out.println("3 - MPB");
        System.out.println("4 - Jazz");
        System.out.println("5 - Clássica");
        System.out.println("6 - Outro");
        System.out.print("Digite uma Opção: ");
        int opcaoGenero = sc.nextInt();
        sc.nextLine();
        GeneroMusical generoMusical = escolherGeneroMusical(opcaoGenero);

        System.out.println("Qual o tipo da mídia?");
        System.out.println("1 - Música");
        System.out.println("2 - Podcast");
        System.out.println("3 - Audiobook");
        System.out.print("Digite uma Opção: ");
        int opcaoMidia = sc.nextInt();
        sc.nextLine();

        criarMidia(opcaoMidia, titulo, artista, duracao, generoMusical);

    }

    public void criarMidia(int opcaoMidia, String titulo, String artista, int duracao, GeneroMusical generoMusical) {
        try {
            if (opcaoMidia == 1) {
                Midia midia = new Musica(titulo, artista, duracao, TipoMidia.MUSICA, generoMusical);
                criarMidia(midia);
            } else if (opcaoMidia == 2) {
                Midia midia = new Podcast(titulo, artista, duracao, TipoMidia.PODCAST);
                criarMidia(midia);
            } else if (opcaoMidia == 3) {
                Midia midia = new Audiobook(titulo, artista, duracao, TipoMidia.AUDIOBOOK);
                criarMidia(midia);
            }

        } catch (InputMismatchException e) {
            System.out.println("Digite uma opção válida!");
        }
    }


    public GeneroMusical escolherGeneroMusical(int opcaoGenero) {

        GeneroMusical generoMusical = GeneroMusical.OUTRO;
        switch (opcaoGenero) {
            case 1:
                generoMusical = GeneroMusical.ROCK;
                break;
            case 2:
                generoMusical = GeneroMusical.POP;
                break;
            case 3:
                generoMusical = GeneroMusical.MPB;
                break;
            case 4:
                generoMusical = GeneroMusical.JAZZ;
                break;
            case 5:
                generoMusical = GeneroMusical.CLASSICA;
                break;
            case 6:
                generoMusical = GeneroMusical.OUTRO;
                break;
            default:
                System.out.println("Opção inválida. Definido como OUTRO.");
        }
        return generoMusical;
    }


    public void criarMidia(Midia midia) {
        midias.add(midia);
    }

    public String listarTodasAsMidias() {
        StringBuilder retorno = new StringBuilder();
        for (int i = 0; i < midias.size(); i++) {
            retorno.append(i + 1).append(" - ").append(midias.get(i).toString()).append("\n");
        }
        return retorno.toString();
    }

    public Playlist buscarPlaylistPorNome(String nomePlaylist) {
        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                return playlist;
            }
        }
        return null;
    }


    public Musica buscarMusicaPorTitulo(String tituloMusica) {
        for (Playlist playlist : playlists) {
            for (Musica musica : playlist.getMusicas()) {
                if (musica.getTitulo().equalsIgnoreCase(tituloMusica)) {
                    return musica;
                }
            }
        }
        return null;
    }

    public void adicionarMusicaAPlaylist(Scanner sc) {
        System.out.print("Digite o título da música para adicionar: ");
        String tituloMusica = sc.nextLine();

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = sc.nextLine();

        Playlist playlist = buscarPlaylistPorNome(nomePlaylist);

        if (playlist == null) {
            System.out.println("Playlist não encontrada!");
        } else {
            Musica musica = null;
            for (Midia midia : midias) {
                if (midia instanceof Musica && midia.getTitulo().equalsIgnoreCase(tituloMusica)) {
                    musica = (Musica) midia;
                    break;
                }
            }

            if (musica == null) {
                System.out.println("Música não encontrada!");
            } else {
                playlist.getMusicas().add(musica);
                System.out.println("Música adicionada com sucesso na playlist!");
            }
        }
    }


    public void removerMusica(Scanner sc) {
        System.out.print("Digite o nome da música para remover: ");
        String nomeMusica = sc.nextLine();

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = sc.nextLine();

        Playlist playlist = buscarPlaylistPorNome(nomePlaylist);

        if (playlist == null) {
            System.out.println("Playlist não encontrada!");
        } else {
            removerMusica(nomeMusica, playlist);
        }
    }


    public boolean removerMusica(String nomeMusica, Playlist playlist) {
        if (playlist == null) {
            System.out.println("Playlist não encontrada!");
            return false;
        }

        ArrayList<Musica> musicas = playlist.getMusicas();

        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i).getTitulo().equalsIgnoreCase(nomeMusica.trim())) {
                musicas.remove(i);
                System.out.println("Música removida da playlist com sucesso!");
                return true;
            }
        }

        System.out.println("Música não encontrada na playlist!");
        return false;
    }




}





