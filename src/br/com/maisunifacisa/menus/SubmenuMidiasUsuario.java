package br.com.maisunifacisa.menus;

import br.com.maisunifacisa.models.Sistema;

import java.util.Scanner;

public class SubmenuMidiasUsuario {
    public void exibirSubmenuMidias(Scanner sc, Sistema sistema) {
        int opcao = -1;

        while (opcao != 3) {
            System.out.println("1 - Adicionar Mídia");
            System.out.println("2 - Remover Mídia");
            System.out.println("3 - Voltar para o Menu de Usuários");
            System.out.print("Digite uma Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    sistema.criarMidia(sc);
                    System.out.println(sistema.listarTodasAsMidias());

                    break;
                case 2:
                    System.out.println("Removendo mídias");
                    break;
                case 3:
                    System.out.println("Voltando para o menu de usuários...");
                    break;
                default:
                    System.out.println("Opção inválida");


            }


        }
    }

}
