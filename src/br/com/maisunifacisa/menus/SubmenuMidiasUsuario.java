package br.com.maisunifacisa.menus;

import br.com.maisunifacisa.models.Sistema;

import java.util.Scanner;

public class SubmenuMidiasUsuario {
    public void exibirSubmenuMidias(Scanner sc, Sistema sistema) {
        int opcao = -1;

        while (opcao != 4) {
            System.out.println("1 - Criar Mídia");
            System.out.println("2 - Remover Música");
            System.out.println("3 - Adicionar Música a Playlist");
            System.out.println("4 - Voltar para o Menu de Usuários");
            System.out.print("Digite uma Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    sistema.criarMidia(sc);

                    break;
                case 2:
                    sistema.removerMusica(sc);
                    break;
                case 3:
                    sistema.adicionarMusicaAPlaylist(sc);
                    break;
                case 4:
                    System.out.println("Voltando para o menu de usuários...");
                    break;
                default:
                    System.out.println("Opção inválida");


            }


        }
    }

}
