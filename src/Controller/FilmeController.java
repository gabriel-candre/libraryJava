package Controller;

import Entities.Filme;
import Enums.Status;
import java.util.ArrayList;
import java.util.List;

public class FilmeController {
    private List<Filme> filmes;

    public FilmeController() {
        filmes = new ArrayList<>();
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

    public Filme getFilme(int id) {

        for (Filme f : filmes) {
            if (f.getIdFilme() == id) {
                return f;
            }
        }
        System.out.println("Filme não encontrado!");
        return null;
    }

    public List<Filme> listarFilmes() {
        return filmes;
    }

    public void consumirFilme(int id) {
        Filme filme = getFilme(id);
        if (filme != null) {
            System.out.println(filme.consumir());
        }
    }
}