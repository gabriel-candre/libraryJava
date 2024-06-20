package Controller;

import Entities.Filme;
import Entities.Livro;
import java.util.List;
import java.util.ArrayList;

public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    public LivroController() {

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

    public String getLivro(int id) {
        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                return l.toString();
            }
        }
        System.out.println("Livro não encontrado!");
        return null;
    }

    public String listarLivros() {
        if (livros.isEmpty()) {
            return "Nenhum livro encontrado!";
        } else {
            for (Livro l : livros) {
                System.out.println(l.toString());
                System.out.println("-----");
            }
        }

        return null;
    }
}
