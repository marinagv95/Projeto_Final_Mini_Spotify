import br.com.maisunifacisa.menus.MenuUsuario;
import br.com.maisunifacisa.models.Sistema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();

        MenuUsuario menuUsuario = new MenuUsuario();

        int opcao = -1;

        while (opcao != 3) {
            System.out.println("-".repeat(10) + "MENU" + "-".repeat(10));
            System.out.println("1 - Usuário ");
            System.out.println("2 - Catálogo de Mídias");
            System.out.println("3 - Sair do Programa ");
            System.out.print("Digite uma Opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    menuUsuario.exibirMenuUsuario(sc, sistema);
                    break;
                case 2:
                    System.out.println("Catalogo");

                    break;
                case 3:
                    System.out.println("Saindo do programa, até logo!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }


        }


        sc.close();


    }
}