package br.com.maisunifacisa.menus;


import br.com.maisunifacisa.models.Sistema;
import br.com.maisunifacisa.models.Usuario;

import java.util.Scanner;

public class MenuUsuario {
    SubmenuMidiasUsuario submenuMidiasUsuario = new SubmenuMidiasUsuario();
    SubmenuPlaylistUsuario submenuPlaylistUsuario = new SubmenuPlaylistUsuario();


    public void exibirMenuUsuario(Scanner sc, Sistema sistema) {

        int opcao = -1;

        while (opcao != 5) {
            System.out.println("-".repeat(10) + "MENU DE USUÁRIOS" + "-".repeat(10));
            System.out.println("1 - Criar Usuário");
            System.out.println("2 - Gerenciar sua Playlist");
            System.out.println("3 - Adicionar ou Remover Mídias");
            System.out.println("4 - Visualizar suas Playlists");
            System.out.println("5 - Voltar para o Menu Principal");
            System.out.print("Digite uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    sistema.novoUsuario(sc);


                    break;
                case 2:
                    submenuPlaylistUsuario.exibirSubmenuPlaylist(sc, sistema);
                    break;
                case 3:
                    submenuMidiasUsuario.exibirSubmenuMidias(sc);
                    break;
                case 4:
                    System.out.print("Digite o e-mail do usuário: ");
                    String emailUsuario = sc.nextLine();

                    if (sistema.getPlaylists().isEmpty()) {
                        System.out.println("Você não tem nenhuma playlist cadastrada!");
                    } else if (sistema.verificarUsuarioExiste(emailUsuario)) {
                        System.out.println(sistema.listarPlaylistDoUsuario(emailUsuario));
                    } else {
                        System.out.println("Digite um e-mail válido!");
                    }
                    break;
                case 5:
                    System.out.println("Voltando para o menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }


        }


    }


}
