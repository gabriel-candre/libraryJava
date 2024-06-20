package Controller;

import Entities.Filme;
import Entities.Jogo;
import java.util.List;
import java.util.ArrayList;

public class JogoController {

    private List<Jogo> jogos = new ArrayList<>();

    public JogoController() {

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

    public String getJogo(int id) {
        for (Jogo j : jogos) {
            if (j.getIdJogo() == id) {
                return j.toString();
            }
        }
        System.out.println("Jogo não encontrado!");
        return null;
    }

    public String listarJogos() {
        if (jogos.isEmpty()) {
            return "Nenhum jogo encontrado!";
        } else {
            for (Jogo j : jogos) {
                System.out.println(j.toString());
                System.out.println("-----");
            }
        }

        return null;
    }
}
