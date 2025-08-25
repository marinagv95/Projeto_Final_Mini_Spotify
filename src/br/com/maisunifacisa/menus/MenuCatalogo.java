package br.com.maisunifacisa.menus;

import br.com.maisunifacisa.models.Sistema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCatalogo {

    public void exibirMenuCatalogo(Scanner sc, Sistema sistema) {
        int opcao = -1;

        while (opcao != 3) {
            try {
                System.out.println("-".repeat(10) + "CATÁLOGO" + "-".repeat(10));
                System.out.println("1 - Listar todas as mídias");
                System.out.println("2 - Buscar por título, artista ou gênero");
                System.out.println("3 - Voltar ao menu principal");
                System.out.print("Digite uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println(sistema.listarTodasAsMidias());
                        break;
                    case 2:
                        sistema.buscarMidia(sc);

                        break;
                    case 3:
                        System.out.println("Voltando para o menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Digite uma opção válida!");
                sc.nextLine();
            }
        }
    }
}