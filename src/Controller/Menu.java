package Controller;

import Entities.*;
import Controller.*;
import Enums.Status;

import java.util.Scanner;

public class Menu {

    FilmeController filmeController = new FilmeController();
    JogoController jogoController = new JogoController();
    LivroController livroController = new LivroController();
    SerieController serieController = new SerieController();
    AtorController AtorController = new AtorController();
    EscritorController escritorController = new EscritorController();

    Scanner sc = new Scanner(System.in);

    public Menu() {

    }

    public void menuPrincipal() {
        System.out.println("1 - Gerenciar Filmes");
        System.out.println("2 - Gerenciar Jogos");
        System.out.println("3 - Gerenciar Livros");
        System.out.println("4 - Gerenciar Séries");
        System.out.println("5 - Gerenciar Atores");
        System.out.println("6 - Gerenciar Escritores");
        System.out.println("0 - Cancelar");
        System.out.print("Opção: ");
    }

    public void menuFilmes() {
        System.out.println("1 - Adicionar filme");
        System.out.println("2 - Remover filme");
        System.out.println("3 - Buscar filme por id");
        System.out.println("4 - Listar todos os filmes");
        System.out.print("Opção: ");
    }

    public void menuJogos() {
        System.out.println("1 - Adicionar jogo");
        System.out.println("2 - Remover jogo");
        System.out.println("3 - Buscar jogo por id");
        System.out.println("4 - Listar todos os jogos");
        System.out.print("Opção: ");
    }

    public void menuLivros() {
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Remover livro");
        System.out.println("3 - Buscar livro por id");
        System.out.println("4 - Listar todos os livros");
        System.out.print("Opção: ");
    }

    public void menuSeries() {
        System.out.println("1 - Adicionar série");
        System.out.println("2 - Remover série");
        System.out.println("3 - Buscar série por id");
        System.out.println("4 - Listar todos os série");
        System.out.print("Opção: ");
    }

    public void menuAtores() {
        System.out.println("1 - Adicionar ator");
        System.out.println("2 - Remover ator");
        System.out.println("3 - Buscar ator por id");
        System.out.println("4 - Listar todos os atores");
        System.out.print("Opção: ");
    }

    public void menuEscritores() {
        System.out.println("1 - Adicionar escritor");
        System.out.println("2 - Remover escritor");
        System.out.println("3 - Buscar escritor por id");
        System.out.println("4 - Listar todos os escritores");
        System.out.print("Opção: ");
    }

    public void gerenciamento(int opcao) {
        switch (opcao) {
            case 1:
                menuFilmes();
                int opcaoFilme = sc.nextInt();
                switch (opcaoFilme) {
                    case 1:
                        System.out.print("ID filme: ");
                        int idFilme = sc.nextInt();
                        System.out.print("Título: ");
                        String tituloFilme = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Ano: ");
                        int anoFilme = sc.nextInt();
                        System.out.print("Gênero: ");
                        String generoFilme = sc.nextLine();
                        System.out.print("Diretor: ");
                        String diretorFilme = sc.nextLine();
                        System.out.print("Duração (min): ");
                        int duracao = sc.nextInt();
                        System.out.print("Publicadora: ");
                        String publicadora = sc.nextLine();
                        Filme f = new Filme(tituloFilme, anoFilme, generoFilme, Status.valueOf("Não Iniciado"), idFilme, duracao, diretorFilme,
                                publicadora);
                        filmeController.adicionarFilme(f);
                        break;
                }
                break;
        }
        sc.close();
    }
}
