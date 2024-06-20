package Controller;

import Entities.Escritor;
import Entities.Filme;

import java.util.List;
import java.util.ArrayList;

public class EscritorController {

    private List<Escritor> escritores = new ArrayList<>();

    public EscritorController() {

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

    public String getEscritor(int id) {
        for (Escritor e : escritores) {
            if (e.getIdEscritor() == id) {
                return e.toString();
            }
        }
        System.out.println("Escritor não encontrado!");
        return null;
    }

    public String listarEscritores() {
        if (escritores.isEmpty()) {
            return "Nenhum escritor encontrado!";
        } else {
            for (Escritor e : escritores) {
                System.out.println(e.toString());
                System.out.println("-----");
            }
        }

        return null;
    }
}
