package br.com.maisunifacisa.menus;


import br.com.maisunifacisa.models.Sistema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuUsuario {
    private final SubmenuMidiasUsuario submenuMidiasUsuario;
    private final SubmenuPlaylistUsuario submenuPlaylistUsuario;
    private final Sistema sistema;

    public MenuUsuario() {
        this.submenuMidiasUsuario = new SubmenuMidiasUsuario();
        this.submenuPlaylistUsuario = new SubmenuPlaylistUsuario();
        this.sistema = new Sistema();
    }

    public void exibirMenuUsuario(Scanner sc) {

        int opcao = 0;

        do {

            System.out.print("""
                    -----------------------------
                         [MENU USUÁRIO]
                    
                    1 - Criar Usuário
                    2 - Gerenciar sua Playlist
                    4 - Visualizar suas Playlists
                    5 - Voltar para o Menu Principal
                    
                    Digite uma opção:\s""");

            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nNão pode utilizar letras ou caracteres.\n  [Escolha: 1, 2, 3, 4 ou 5]\n");
                sc.nextLine();
                continue;
            }
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
                    System.out.println("\nRetornando para o menu principal...\n");
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente!\n");
            }

        } while (opcao != 5);
    }


}
