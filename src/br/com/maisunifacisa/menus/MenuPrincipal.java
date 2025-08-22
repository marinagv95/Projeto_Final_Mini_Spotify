package br.com.maisunifacisa.menus;

import br.com.maisunifacisa.models.Sistema;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    private final Scanner sc;
    private final MenuUsuario menuUsuario;
    private final MenuCatalogo menuCatalogo;

    public MenuPrincipal(Scanner sc) {
        this.sc = sc;
        this.menuUsuario = new MenuUsuario();
        this.menuCatalogo = new MenuCatalogo();
    }

    public void exibirMenuPrincipal() {
        int opcao = 0;
        do {
            System.out.print("""
                    -----------------------------
                         [MENU PRINCIPAL]
                   
                    1 - Usuário
                    2 - Catálogo de Mídias
                    3 - Sair do Programa
                   
                    Digite uma opção:\s""");
            try {
                opcao = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nNão pode utilizar letras ou caracteres.\n  [Escolha: 1, 2 ou 3]\n");
                sc.nextLine();
                continue;
            }


            switch (opcao) {
                case 1:
                    System.out.println("Usuário");
                    menuUsuario.exibirMenuUsuario(sc);
                    break;
                case 2:
                    System.out.println("Catalogo");
                    menuCatalogo.exibirMenuCatalogo(sc);
                    break;
                case 3:
                    System.out.println("\nSaiu do programa!");
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente!\n");
            }
        } while (opcao != 3);



    }
}