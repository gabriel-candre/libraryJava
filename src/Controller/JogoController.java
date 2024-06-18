package Controller;

import Entities.Jogo;
import java.util.List;
import java.util.ArrayList;

public class JogoController {

    private List<Jogo> jogos;

    public JogoController() {
        jogos = new ArrayList<>();
    }

    public void adicionarJogo(Jogo j) {
        jogos.add(j);
    }

    public void removerJogo(int id) {

        boolean jogoEncontrado = false;

        for (Jogo j : jogos) {
            if (j.getIdJogo() == id) {
                jogos.remove(j);
                jogoEncontrado = true;
            }
        }

        if (jogoEncontrado) {
            System.out.println("Jogo removido!");
        } else {
            System.out.println("Jogo não encontrado!");
        }
    }

    public Jogo getJogo(int id) {
        for (Jogo j : jogos) {
            if (j.getIdJogo() == id) {
                return j;
            }
        }
        System.out.println("Jogo não encontrado!");
        return null;
    }

    public List<Jogo> listarJogos() {
        return jogos;

    }
}
