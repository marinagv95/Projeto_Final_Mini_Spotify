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
            System.out.println("3 - Adicionar Remover ou Criar Mídias");
            System.out.println("4 - Visualizar suas Playlists");
            System.out.println("5 - Voltar para o Menu Principal");
            System.out.print("Digite uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    sistema.criarUsuario(sc);
                    break;
                case 2:
                    submenuPlaylistUsuario.exibirSubmenuPlaylist(sc, sistema);
                    break;
                case 3:
                    submenuMidiasUsuario.exibirSubmenuMidias(sc, sistema);
                    break;
                case 4:
                    sistema.listarPlaylistUsuario(sc);
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
