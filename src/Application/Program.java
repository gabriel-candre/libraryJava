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
        int opcao = sc.nextInt();
        System.out.println("-----");
        menu.gerenciamento(opcao);
        System.out.println("-----");
        sc.close();
    }
}

