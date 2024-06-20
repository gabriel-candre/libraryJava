package Controller;

import Entities.Ator;
import Entities.Filme;

import java.util.List;
import java.util.ArrayList;

public class AtorController {
    private List <Ator> atores = new ArrayList<>();

    public AtorController() {

    }

    public void adicionarAtor(Ator a) {
        atores.add(a);
    }

    public void removerAtor(int id) {

        boolean atorEncontrado = false;

        for (Ator a : atores) {
            if (a.getIdAtor() == id) {
                atores.remove(a);
                atorEncontrado = true;
            }
        }

        if (atorEncontrado) {
            System.out.println("Ator removido!");
        } else {
            System.out.println("Ator não encontrado!");
        }
    }

    public String getAtor(int id) {
        for (Ator a : atores){
            if (a.getIdAtor() == id) {
                return a.toString();
            }
        }
        System.out.println("Ator não encontrado!");
        return null;
    }

    public String listarAtores() {
        if (atores.isEmpty()) {
            return "Nenhum ator encontrado!";
        } else {
            for (Ator a : atores) {
                System.out.println(a.toString());
                System.out.println("-----");
            }
        }

        return null;
    }
}
