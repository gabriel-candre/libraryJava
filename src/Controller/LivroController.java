package Controller;

import Entities.Livro;
import java.util.List;
import java.util.ArrayList;

public class LivroController {

    private List<Livro> livros;

    public LivroController() {
        livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro l) {
        livros.add(l);
    }

    public void removerLivro(int id) {

        boolean livroEncontrado = false;

        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                livros.remove(l);
                livroEncontrado = true;
            }
        }

        if (livroEncontrado) {
            System.out.println("Livro removido!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public Livro getLivro(int id) {
        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                return l;
            }
        }
        System.out.println("Livro não encontrado!");
        return null;
    }

    public List<Livro> listarLivros() {
        return livros;
    }
}
