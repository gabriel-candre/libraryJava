package Controller;

import Entities.Escritor;
import Entities.Filme;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class EscritorController {

    private List<Escritor> escritores = new ArrayList<>();
    private String arquivo = "escritores.txt";

    public EscritorController() {
        carregarEscritor();
    }

    public void adicionarEscritor(Escritor e) {
        escritores.add(e);
        salvarEscritor();
    }

    private void salvarEscritor() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Escritor e : escritores) {
                bw.write(e.toFile());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarEscritor() {

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
                Escritor e = Escritor.fromFile(linha);
                escritores.add(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar escritor: " + e.getMessage());
        }
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
