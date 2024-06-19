package Application;

import java.util.Scanner;

import Controller.*;


public class Program {

    public static String quebra() {
        return "-----";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        Menu menu = new Menu();

        menu.menuPrincipal();
        menu.gerenciamento(sc.nextInt());
        quebra();
        sc.close();
    }
}

