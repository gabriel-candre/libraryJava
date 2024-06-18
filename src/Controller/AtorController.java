package Controller;

import Entities.Ator;
import java.util.List;
import java.util.ArrayList;

public class AtorController {
    private List <Ator> atores;

    public AtorController() {
        atores = new ArrayList<>();
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

    public Ator getAtor(int id) {
        for (Ator a : atores){
            if (a.getIdAtor() == id) {
                return a;
            }
        }
        System.out.println("Ator não encontrado!");
        return null;
    }

    public List<Ator> listarAtores() {
        return atores;
    }
}
