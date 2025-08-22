import br.com.maisunifacisa.menus.MenuPrincipal;
import br.com.maisunifacisa.models.Sistema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal(sc);

        menu.exibirMenuPrincipal();

        sc.close();


    }
}