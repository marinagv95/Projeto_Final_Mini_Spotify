package br.com.maisunifacisa.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuCatalogo {

    public MenuCatalogo() {
    }
    public void exibirMenuCatalogo(Scanner sc) {
        int opcao = 0;
        do {

            System.out.print("""
                    -----------------------------
                         [MENU CATÁLOGO]
                   
                    1 - Buscar Música por título
                    2 - Buscar Música por artista
                    3 - Buscar Música por gênero
                    4 - Voltar para o Menu Principal
                   
                    Digite uma opção:\s""");

            String entrada = sc.nextLine();
            try {
                opcao = Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("\nNão pode utilizar letras ou caracteres.\n  [Escolha: 1, 2, 3, ou 4]\n");
                continue;
            }
            switch (opcao){
                case 1:
                    System.out.println("Buscar por titulo!");
                    break;
                case 2:
                    System.out.println("Buscar por artista!");
                    break;
                case 3:
                    System.out.println("Buscar por genero!");
                    break;
                case 4:
                    System.out.println("\nRetornando para o menu principal...\n");
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente!\n");
            }

        } while (opcao != 4);

    }
}