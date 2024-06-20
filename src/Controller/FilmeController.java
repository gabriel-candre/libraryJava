package Controller;

import Entities.Filme;
import Enums.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmeController {
    Scanner sc = new Scanner(System.in);

    private List<Filme> filmes = new ArrayList<>();

    public FilmeController() {

    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void removerFilme(int id) {

        boolean filmeEncontrado = false;

        for (Filme f : filmes) {
            if (f.getIdFilme() == id) {
                filmes.remove(f);
                filmeEncontrado = true;
            }
        }
        if (filmeEncontrado) {
            System.out.println("Filme removido!");
        } else {
            System.out.println("Filme não encontrado!");
        }
    }

    public String getFilme(int id) {

        for (Filme f : filmes) {
            if (f.getIdFilme() == id) {
                return f.toString();
            }
        }
        System.out.println("Filme não encontrado!");
        return null;
    }

    public String listarFilmes() {
        if (filmes.isEmpty()) {
            return "Nenhum filme encontrado!";
        } else {
            for (Filme f : filmes) {
                System.out.println(f.toString());
                System.out.println("-----");
            }
        }

        return null;
    }

    public void menuAtualizaStatus() {
        System.out.println("Novo status: ");
        System.out.println("1 - Não Iniciado");
        System.out.println("2 - Em Andamento");
        System.out.println("3 - Finalizado");
        System.out.println("0 - Cancelar");
        System.out.print("Opção: ");
    }

    public void atualizarStatus(int id) {

        for (Filme f : filmes) {
            if (f.getIdFilme() == id) {
                menuAtualizaStatus();
                int opcao = sc.nextInt();
                sc.nextLine();

                while(opcao != 0) {
                    switch (opcao) {
                        case 1:
                            f.setStatus(Status.valueOf("NAO_INICIADO"));
                            System.out.println("Status atualizado!");
                            System.out.println("-----");
                            break;
                        case 2:
                            f.setStatus(Status.valueOf("EM_ANDAMENTO"));
                            System.out.println("Status atualizado!");
                            System.out.println("-----");
                            break;
                        case 3:
                            f.setStatus(Status.valueOf("FINALIZADO"));
                            System.out.println("Status atualizado!");
                            System.out.println("-----");
                            break;
                        default:
                            System.out.println("Opção inválida! Tente novamente!");
                            menuAtualizaStatus();
                            opcao = sc.nextInt();
                            sc.nextLine();
                            System.out.println("-----");
                            break;
                    }
                    menuAtualizaStatus();
                    opcao = sc.nextInt();
                    sc.nextLine();
                    System.out.println("-----");
                }

            }
        }
    }

}