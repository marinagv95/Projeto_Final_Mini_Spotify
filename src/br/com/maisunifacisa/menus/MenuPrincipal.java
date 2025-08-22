package br.com.maisunifacisa.menus;
import java.util.Scanner;

public class MenuPrincipal {
    private final MenuUsuario menuUsuario;
    private final MenuCatalogo menuCatalogo;

    public MenuPrincipal() {
        this.menuUsuario = new MenuUsuario();
        this.menuCatalogo = new MenuCatalogo();
    }

    public void exibirMenuPrincipal(Scanner sc) {
        int opcao = 0;
        do {
            System.out.print("""
                    -----------------------------
                         [MENU PRINCIPAL]
                   
                    1 - Usuário
                    2 - Catálogo de Mídias
                    3 - Sair do Programa
                   
                    Digite uma opção:\s""");

            String entrada = sc.nextLine();
            try {
                opcao = Integer.parseInt(entrada.trim());
            } catch (NumberFormatException e) {
                System.out.println("\nNão pode utilizar letras ou caracteres.\n  [Escolha: 1, 2 ou 3]\n");
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