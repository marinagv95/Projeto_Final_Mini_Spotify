package br.com.maisunifacisa.menus;

import br.com.maisunifacisa.models.Playlist;
import br.com.maisunifacisa.models.Sistema;
import br.com.maisunifacisa.models.Usuario;

import java.util.Scanner;

public class SubmenuPlaylistUsuario {


    public void exibirSubmenuPlaylist(Scanner sc, Sistema sistema) {
        int opcao = -1;

        while (opcao != 4) {
            System.out.println("1 - Criar Playlist");
            System.out.println("2 - Deletar Playlist");
            System.out.println("3 - Alterar nome da  Playlist");
            System.out.println("4 - Voltar para o Menu de Usuário");
            System.out.print("Digite uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite um nome para a Playlist: ");
                    String nomePlaylist = sc.nextLine();
                    System.out.print("Digite o e-mail do usuário para atribuir a playlist: ");
                    String emailUsuario = sc.nextLine();

                    if(sistema.verificarUsuarioExiste(emailUsuario)){
                        Usuario usuarioEncontrado = sistema.buscarUsuarioPorEmail(emailUsuario);
                        Playlist playlist = new Playlist(nomePlaylist, usuarioEncontrado);
                        sistema.criarPlaylist(playlist);
                        System.out.println("Playlist criada com sucesso!");
                    } else{
                        System.out.println("Digite um e-mail válido!");
                    }

                    break;

                case 2:
                    System.out.println("Deletando Playlist");

                    break;
                case 3:
                    System.out.println("Alterando Playlist");

                    break;
                case 4:
                    System.out.println("Voltando para o menu de usuário...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        }
    }
}
