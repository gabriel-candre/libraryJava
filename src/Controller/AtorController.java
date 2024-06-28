package Controller;

import Entities.Ator;
import Entities.Filme;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class AtorController {
    private List <Ator> atores = new ArrayList<>();
    private String arquivo = "atores.txt";

    public AtorController() {
        carregarAtor();
    }

    public void adicionarAtor(Ator a) {
        atores.add(a);
        salvarAtor();
    }

    private void salvarAtor() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Ator a : atores) {
                bw.write(a.toFile());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarAtor() {

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
                Ator a = Ator.fromFile(linha);
                atores.add(a);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar atores: " + e.getMessage());
        }
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
