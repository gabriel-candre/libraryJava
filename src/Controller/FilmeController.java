package Controller;

import Entities.Filme;
import Enums.Status;
import java.util.ArrayList;
import java.util.List;

public class FilmeController {
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
}