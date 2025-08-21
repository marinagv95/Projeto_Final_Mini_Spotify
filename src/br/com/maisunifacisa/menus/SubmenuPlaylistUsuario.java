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
                    sistema.criarPlaylist(sc);
                    break;

                case 2:
                    sistema.removerPlaylistUsuario(sc);

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
