package Controller;

import Entities.Escritor;
import java.util.List;
import java.util.ArrayList;

public class EscritorController {

    private List<Escritor> escritores;

    public EscritorController() {
        escritores = new ArrayList<>();
    }

    public void adicionarEscritor(Escritor e) {
        escritores.add(e);
    }

    public void removerEscritor(int id) {

        boolean escritorEncontrado = false;

        for (Escritor e : escritores) {
            if (e.getIdEscritor() == id) {
                escritores.remove(e);
                escritorEncontrado = true;
            }
        }

        if (escritorEncontrado) {
            System.out.println("Escritor Removido!");
        } else {
            System.out.println("Escritor não encontrado!");
        }
    }

    public Escritor getEscritor(int id) {
        for (Escritor e : escritores) {
            if (e.getIdEscritor() == id) {
                return e;
            }
        }
        System.out.println("Escritor não encontrado!");
        return null;
    }

    public List<Escritor> listarEscritores() {
        return escritores;
    }
}
