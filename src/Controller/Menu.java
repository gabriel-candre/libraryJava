package Controller;

import Entities.*;
import Controller.*;
import Enums.Status;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {

    FilmeController filmeController = new FilmeController();
    JogoController jogoController = new JogoController();
    LivroController livroController = new LivroController();
    SerieController serieController = new SerieController();
    AtorController atorController = new AtorController();
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
        System.out.println("0 - Finalizar");
        System.out.print("Opção: ");
    }

    public void menuFilmes() {
        System.out.println("1 - Adicionar filme");
        System.out.println("2 - Remover filme");
        System.out.println("3 - Buscar filme por id");
        System.out.println("4 - Listar todos os filmes");
        System.out.println("5 - Editar um filme");
        System.out.println("0 - Finalizar");
        System.out.print("Opção: ");
    }

    public void menuJogos() {
        System.out.println("1 - Adicionar jogo");
        System.out.println("2 - Remover jogo");
        System.out.println("3 - Buscar jogo por id");
        System.out.println("4 - Listar todos os jogos");
        System.out.println("0 - Finalizar");
        System.out.print("Opção: ");
    }

    public void menuLivros() {
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Remover livro");
        System.out.println("3 - Buscar livro por id");
        System.out.println("4 - Listar todos os livros");
        System.out.println("0 - Finalizar");
        System.out.print("Opção: ");
    }

    public void menuSeries() {
        System.out.println("1 - Adicionar série");
        System.out.println("2 - Remover série");
        System.out.println("3 - Buscar série por id");
        System.out.println("4 - Listar todos os série");
        System.out.println("0 - Finalizar");
        System.out.print("Opção: ");
    }

    public void menuAtores() {
        System.out.println("1 - Adicionar ator");
        System.out.println("2 - Remover ator");
        System.out.println("3 - Buscar ator por id");
        System.out.println("4 - Listar todos os atores");
        System.out.println("0 - Finalizar");
        System.out.print("Opção: ");
    }

    public void menuEscritores() {
        System.out.println("1 - Adicionar escritor");
        System.out.println("2 - Remover escritor");
        System.out.println("3 - Buscar escritor por id");
        System.out.println("4 - Listar todos os escritores");
        System.out.println("0 - Finalizar");
        System.out.print("Opção: ");
    }

    public void gerenciamento(int opcao) {
        while(opcao != 0) {
            switch (opcao) {
                case 1:
                    menuFilmes();
                    int opcaoFilmes = sc.nextInt();
                    System.out.println("-----");
                    while (opcaoFilmes != 0) {
                        switch (opcaoFilmes) {
                            case 1:
                                System.out.print("ID filme: ");
                                int idFilme = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Título: ");
                                String tituloFilme = sc.nextLine();

                                System.out.print("Ano: ");
                                int anoFilme = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Gênero: ");
                                String generoFilme = sc.nextLine();

                                System.out.print("Diretor: ");
                                String diretorFilme = sc.nextLine();

                                System.out.print("Duração (min): ");
                                int duracao = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Publicadora: ");
                                String publicadora = sc.nextLine();

                                System.out.println("-----");

                                Filme f = new Filme(tituloFilme, anoFilme, generoFilme, Status.valueOf("ADICIONADO"), idFilme, duracao, diretorFilme,
                                        publicadora);
                                filmeController.adicionarFilme(f);
                                break;
                            case 2:
                                System.out.print("Id do filme a remover: ");
                                int idFilmeRemove = sc.nextInt();
                                filmeController.removerFilme(idFilmeRemove);
                                System.out.println("-----");
                                break;
                            case 3:
                                System.out.print("Id do filme: ");
                                int idBuscaFilme = sc.nextInt();
                                System.out.println(filmeController.getFilme(idBuscaFilme));
                                System.out.println("-----");
                                break;
                            case 4:
                                filmeController.listarFilmes();
                                break;
                            case 5:
                                System.out.print("ID a do filme a ser atualizado: ");
                                int idAtualiza = sc.nextInt();
                                filmeController.menuAtualizaStatus();
                                filmeController.atualizarStatus(idAtualiza);
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente!");
                                menuFilmes();
                                opcaoFilmes = sc.nextInt();
                                System.out.println("-----");
                                break;
                        }
                        menuFilmes();
                        opcaoFilmes = sc.nextInt();
                        System.out.println("-----");
                    }
                    break;
                case 2:
                    menuJogos();
                    int opcaoJogos = sc.nextInt();
                    System.out.println("-----");
                    while (opcaoJogos != 0) {
                        switch (opcaoJogos) {
                            case 1:
                                System.out.print("ID jogo: ");
                                int idJogo = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Título: ");
                                String tituloJogo = sc.nextLine();

                                System.out.print("Ano: ");
                                int anoJogo = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Gênero: ");
                                String generoJogo = sc.nextLine();

                                System.out.print("Publicadora: ");
                                String publicadoraJogo = sc.nextLine();
                                System.out.println("-----");

                                Jogo j = new Jogo(tituloJogo, anoJogo, generoJogo, Status.valueOf("ADICIONADO"), idJogo, publicadoraJogo);
                                jogoController.adicionarJogo(j);
                                break;
                            case 2:
                                System.out.print("ID do jogo a remover: ");
                                int idRemover = sc.nextInt();
                                jogoController.removerJogo(idRemover);
                                System.out.println("-----");
                                break;
                            case 3:
                                System.out.print("ID do jogo: ");
                                int idBusca = sc.nextInt();
                                System.out.println(jogoController.getJogo(idBusca));
                                System.out.println("-----");
                                break;
                            case 4:
                                jogoController.listarJogos();
                                break;
                            default:
                                System.out.println("Opção Inválida! Tente novamente!");
                                menuJogos();
                                opcaoJogos = sc.nextInt();
                                System.out.println("-----");
                                break;
                        }
                        menuJogos();
                        opcaoJogos = sc.nextInt();
                        System.out.println("-----");
                    }
                    break;
                case 3:
                    menuLivros();
                    int opcaoLivros = sc.nextInt();
                    System.out.println("-----");
                    while (opcaoLivros != 0) {
                        switch (opcaoLivros) {
                            case 1:
                                System.out.print("ID Livro: ");
                                int idLivro = sc.nextInt();
                                sc.nextInt();

                                System.out.print("Título: ");
                                String tituloLivro = sc.nextLine();

                                System.out.print("Ano: ");
                                int anoLivro = sc.nextInt();
                                sc.nextInt();

                                System.out.print("Gênero: ");
                                String generoLivro = sc.nextLine();

                                System.out.print("Páginas: ");
                                int paginas = sc.nextInt();
                                sc.nextInt();

                                System.out.print("Editora: ");
                                String editora = sc.nextLine();
                                System.out.println("-----");

                                Livro l = new Livro(tituloLivro, anoLivro, generoLivro, Status.valueOf("ADICIONADO"), idLivro, paginas, editora);
                                livroController.adicionarLivro(l);
                                break;
                            case 2:
                                System.out.print("ID do livro a remover: ");
                                int idRemover = sc.nextInt();
                                livroController.removerLivro(idRemover);
                                System.out.println("-----");
                                break;
                            case 3:
                                System.out.print("ID do livro");
                                int idBusca = sc.nextInt();
                                System.out.println(livroController.getLivro(idBusca));
                                System.out.println("-----");
                                break;
                            case 4:
                                livroController.listarLivros();
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente!");
                                menuLivros();
                                opcaoLivros = sc.nextInt();
                                System.out.println("-----");
                            break;
                        }
                        menuLivros();
                        opcaoLivros = sc.nextInt();
                        System.out.println("-----");
                    }
                    break;
                case 4:
                    menuSeries();
                    int opcaoSeries = sc.nextInt();
                    System.out.println("-----");
                    while (opcaoSeries != 0) {
                        switch (opcaoSeries) {
                            case 1:
                                System.out.print("ID série: ");
                                int idSerie = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Título: ");
                                String tituloSerie = sc.nextLine();

                                System.out.print("Ano: ");
                                int anoSerie = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Gênero: ");
                                String generoSerie = sc.nextLine();

                                System.out.print("Temporada: ");
                                int temporada = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Episódios: ");
                                int episodios = sc.nextInt();
                                System.out.println("-----");

                                Serie s = new Serie(tituloSerie, anoSerie, generoSerie, Status.valueOf("ADICIONADO"), idSerie, temporada, episodios);
                                serieController.adicionarSerie(s);
                                break;
                            case 2:
                                System.out.print("Id da série a remover: ");
                                int idRemover = sc.nextInt();
                                serieController.removerSerie(idRemover);
                                System.out.println("-----");
                                break;
                            case 3:
                                System.out.print("ID da série: ");
                                int idBusca = sc.nextInt();
                                System.out.println(serieController.getSerie(idBusca));
                                System.out.println("-----");
                                break;
                            case 4:
                                serieController.listarSeries();
                                break;
                            default:
                                System.out.println("Opção inválida! Tente Novamente!");
                                menuSeries();
                                opcaoSeries = sc.nextInt();
                                System.out.println("-----");
                                break;
                        }
                        menuSeries();
                        opcaoSeries = sc.nextInt();
                        System.out.println("-----");
                    }
                    break;
                case 5:
                    menuAtores();
                    int opcaoAtores = sc.nextInt();
                    System.out.println("-----");
                    while(opcaoAtores != 0) {
                        switch (opcaoAtores) {
                            case 1:
                                System.out.print("ID ator: ");
                                int idAtor = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Nome: ");
                                String nomeAtor = sc.nextLine();

                                System.out.print("Ano nascimento: ");
                                int anoAtor = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Nacionalidade: ");
                                String nacionalidadeAtor = sc.nextLine();
                                System.out.println("-----");

                                Ator a = new Ator(nomeAtor, anoAtor, nacionalidadeAtor, idAtor);
                                atorController.adicionarAtor(a);
                                break;
                            case 2:
                                System.out.print("ID do ator a remover: ");
                                int idRemove = sc.nextInt();
                                atorController.removerAtor(idRemove);
                                System.out.println("-----");
                                break;
                            case 3:
                                System.out.print("ID ator: ");
                                int idBusca = sc.nextInt();
                                System.out.println(atorController.getAtor(idBusca));
                                System.out.println("-----");
                                break;
                            case 4:
                                atorController.listarAtores();
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente");
                                menuAtores();
                                opcaoAtores = sc.nextInt();
                                System.out.println("-----");
                                break;
                        }
                        menuAtores();
                        opcaoAtores = sc.nextInt();
                        System.out.println("-----");
                    }
                    break;
                case 6:
                    menuEscritores();
                    int opcaoEscritores = sc.nextInt();
                    System.out.println("-----");
                    while (opcaoEscritores != 0) {
                        switch (opcaoEscritores) {
                            case 1:
                                System.out.print("ID escritor: ");
                                int idEscritor = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Nome: ");
                                String nomeEscritor = sc.nextLine();

                                System.out.print("Ano nascimento: ");
                                int anoEscritor = sc.nextInt();
                                sc.nextLine();

                                System.out.print("Nacionalidade: ");
                                String nacionalidadeEscritor = sc.nextLine();
                                System.out.println("-----");

                                Escritor e = new Escritor(nomeEscritor, anoEscritor, nacionalidadeEscritor, idEscritor);
                                escritorController.adicionarEscritor(e);
                                break;
                            case 2:
                                System.out.print("ID do escritor a remover: ");
                                int idRemove = sc.nextInt();
                                escritorController.removerEscritor(idRemove);
                                System.out.println("-----");
                                break;
                            case 3:
                                System.out.print("ID escritor: ");
                                int idBusca = sc.nextInt();
                                System.out.println(escritorController.getEscritor(idBusca));
                                System.out.println("-----");
                                break;
                            case 4:
                                escritorController.listarEscritores();
                                break;
                            default:
                                System.out.println("Opção inválida! Tente novamente!");
                                menuEscritores();
                                opcaoEscritores = sc.nextInt();
                                System.out.println("-----");
                                break;
                        }
                        menuEscritores();
                        opcaoEscritores = sc.nextInt();
                        System.out.println("-----");
                    }
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente!");
                    menuPrincipal();
                    opcao = sc.nextInt();
                    System.out.println("-----");
                    break;

            }
         menuPrincipal();
         opcao = sc.nextInt();
            System.out.println("-----");
        }
        sc.close();
    }
}
