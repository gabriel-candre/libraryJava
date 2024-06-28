package Controller;

import Entities.Filme;
import Entities.Jogo;
import Enums.Status;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class JogoController {

    private List<Jogo> jogos = new ArrayList<>();
    private String arquivo = "jogos.txt";

    public JogoController() {
        carregarJogo();
    }

    public void adicionarJogo(Jogo j) {
        jogos.add(j);
        salvarJogo();
    }

    private void salvarJogo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Jogo j : jogos) {
                bw.write(j.toFile());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarJogo() {

        File file = new File(arquivo);
        if(!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Arquivo criado: " + arquivo);
            } catch(IOException e) {
                System.out.println("Erro ao criar arquivo: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while((linha = br.readLine()) != null) {
                Jogo j = Jogo.fromFile(linha);
                jogos.add(j);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar jogos: " + e.getMessage());
        }
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

    public void editarJogo(int id, Status novoStatus) {
        boolean jogoEncontrado = false;

        for (Jogo j : jogos) {
            if (j.getIdJogo() == id) {
                j.setStatus(novoStatus);
                jogoEncontrado = true;
                salvarJogo();
                System.out.println("Status atualizado!");
                break;
            }
        }
        if (!jogoEncontrado) {
            System.out.println("Jogo não encontrado");
        }
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
