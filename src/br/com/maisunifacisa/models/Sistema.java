package br.com.maisunifacisa.models;


import br.com.maisunifacisa.enums.GeneroMusical;
import br.com.maisunifacisa.enums.TipoMidia;
import br.com.maisunifacisa.excecao.EmailInvalidoException;
import br.com.maisunifacisa.excecao.OpcaoInvalidaException;
import br.com.maisunifacisa.excecao.PlaylistVaziaException;
import br.com.maisunifacisa.excecao.UsuarioInvalidoException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Sistema {
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Playlist> playlists = new ArrayList<>();
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


    public void criarUsuario(Scanner sc) throws EmailInvalidoException {
        System.out.print("Digite o nome do usuário: ");
        String nome = sc.nextLine();
        System.out.print("Digite um e-mail válido: ");
        String email = sc.nextLine();
        try {
            validarEmail(email);
            System.out.println("Email válido!");
            Usuario usuario = new Usuario(nome, email);
            adicionarUsuario(usuario);
            System.out.println("Usuário adicionado com sucesso");

        } catch (EmailInvalidoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void validarEmail(String email) throws EmailInvalidoException {
        if (!email.contains("@")) {
            throw new EmailInvalidoException("Email em formato inválido'.");
        }
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


    public void listarPlaylistUsuario(Scanner sc) throws PlaylistVaziaException, UsuarioInvalidoException {
        System.out.print("Digite o e-mail do usuário: ");
        String emailUsuario = sc.nextLine();
        verificarPlaylistCadastrada(emailUsuario);

    }

    public void verificarPlaylistCadastrada(String emailUsuario)
            throws UsuarioInvalidoException, PlaylistVaziaException {

        if (!verificarUsuarioExiste(emailUsuario)) {
            throw new UsuarioInvalidoException("Digite um e-mail válido!");
        }

        if (getPlaylists().isEmpty()) {
            throw new PlaylistVaziaException("Você não tem nenhuma playlist cadastrada!");
        }

        System.out.println(listarPlaylistUsuario(emailUsuario));
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


    public void criarPlaylist(Scanner sc) throws UsuarioInvalidoException {
        System.out.print("Digite um nome para a Playlist: ");
        String nomePlaylist = sc.nextLine();
        System.out.print("Digite o e-mail do usuário para atribuir a playlist: ");
        String emailUsuario = sc.nextLine();
        criarPlaylist(nomePlaylist, emailUsuario);

    }

    public void criarPlaylist(String nomePlaylist, String emailUsuario)
            throws UsuarioInvalidoException {

        if (verificarUsuarioExiste(emailUsuario)) {
            Usuario usuarioEncontrado = buscarUsuarioPorEmail(emailUsuario);
            Playlist playlist = new Playlist(nomePlaylist, usuarioEncontrado);
            adicionarPlaylist(playlist);
            System.out.println("Playlist criada com sucesso!");
        } else {
            throw new UsuarioInvalidoException("Usuário não encontrado!");
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

    public void criarMidia(Scanner sc) {
        String titulo;
        String artista;
        int duracao;
        GeneroMusical generoMusical = null;
        int opcaoMidia;

        System.out.print("Digite o nome do Título: ");
        titulo = sc.nextLine();

        System.out.print("Digite o nome do Artista: ");
        artista = sc.nextLine();

        duracao = lerDuracao(sc);

        opcaoMidia = escolherTipoMidia(sc);

        if (opcaoMidia == 1) {
            generoMusical = escolherGenero(sc);
        }

        try {
            criarMidia(opcaoMidia, titulo, artista, duracao, generoMusical);
            System.out.println("Mídia criada com sucesso!");
        } catch (Exception e) {
            System.out.println("Algo deu errado.");
        }
    }

    private int lerDuracao(Scanner sc) {
        int duracao = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print("Digite a duração da Mídia: ");
                duracao = sc.nextInt();
                sc.nextLine();
                if (duracao <= 0) throw new InputMismatchException();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Digite uma duração válida!");
                sc.nextLine();
            }
        }
        return duracao;
    }

    private int escolherTipoMidia(Scanner sc) {
        int opcao = 0;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println("Qual o tipo da mídia?");
                System.out.println("1 - Música");
                System.out.println("2 - Podcast");
                System.out.println("3 - Audiobook");
                System.out.print("Digite uma Opção: ");
                opcao = sc.nextInt();
                sc.nextLine();
                if (opcao < 1 || opcao > 3)
                    throw new OpcaoInvalidaException("Opção de tipo de mídia inválida!");
                valido = true;
            } catch (OpcaoInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Digite uma opção válida!");
                sc.nextLine();
            }
        }
        return opcao;
    }

    private GeneroMusical escolherGenero(Scanner sc) {
        int opcaoGenero = 0;
        GeneroMusical genero = GeneroMusical.OUTRO;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.println("Selecione o gênero musical:");
                System.out.println("1 - Rock");
                System.out.println("2 - Pop");
                System.out.println("3 - MPB");
                System.out.println("4 - Jazz");
                System.out.println("5 - Clássica");
                System.out.println("6 - Outro");
                System.out.print("Digite uma Opção: ");
                opcaoGenero = sc.nextInt();
                sc.nextLine();
                genero = escolherGeneroMusical(opcaoGenero);
                valido = true;
            } catch (InputMismatchException e) {
                System.out.print("Digite uma opção válida!");
                sc.nextLine();
            }
        }
        return genero;
    }

    public void criarMidia(int opcaoMidia, String titulo, String artista, int duracao, GeneroMusical generoMusical) {
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
    }

    public GeneroMusical escolherGeneroMusical(int opcaoGenero) {
        switch (opcaoGenero) {
            case 1: return GeneroMusical.ROCK;
            case 2: return GeneroMusical.POP;
            case 3: return GeneroMusical.MPB;
            case 4: return GeneroMusical.JAZZ;
            case 5: return GeneroMusical.CLASSICA;
            case 6: return GeneroMusical.OUTRO;
            default:
                System.out.println("Opção inválida. Definido como OUTRO.");
                return GeneroMusical.OUTRO;
        }
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





    public Midia buscarMidiaPorTitulo(String titulo){
    for (Midia midia: midias){
        if(midia.getTitulo().equals(titulo))
            return midia;
    }
    return null;
    }



    public Playlist buscarPlaylistPorNome(String nomePlaylist) {
        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                return playlist;
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









