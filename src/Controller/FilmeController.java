package Controller;

import Entities.Filme;
import Enums.Status;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmeController {
    Scanner sc = new Scanner(System.in);

    private List<Filme> filmes = new ArrayList<>();
    private String arquivo = "filmes.txt";

    public FilmeController() {
        carregarFilme();
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
        salvarFilme();
    }

    private void salvarFilme() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Filme f : filmes) {
                bw.write(f.toFile());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarFilme() {

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
                Filme f = Filme.fromFile(linha);
                filmes.add(f);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar filmes: " + e.getMessage());
        }
    }

    public void removerFilme(int id) {

        boolean filmeEncontrado = false;

        for (Filme f : filmes) {
            if (f.getIdFilme() == id) {
                filmes.remove(f);
                filmeEncontrado = true;
                salvarFilme();
                break;
            }
        }
        if (filmeEncontrado) {
            System.out.println("Filme removido!");
        } else {
            System.out.println("Filme não encontrado!");
        }
    }

    public String getFilme(int id) {

        for (Filme f : filmes) {
            if (f.getIdFilme() == id) {
                return f.toString();
            }
        }
        System.out.println("Filme não encontrado!");
        return null;
    }

    public void editarFilme(int id, Status novoStatus) {
        boolean filmeEncontrado = false;

        for (Filme f : filmes) {
            if (f.getIdFilme() == id) {
                f.setStatus(novoStatus);
                filmeEncontrado = true;
                salvarFilme();
                System.out.println("Status atualizado!");
                break;
            }
        }
        if (!filmeEncontrado) {
            System.out.println("Filme não encontrado");
        }
    }

    public String listarFilmes() {
        if (filmes.isEmpty()) {
            return "Nenhum filme encontrado!";
        } else {
            for (Filme f : filmes) {
                System.out.println(f.toString());
                System.out.println("-----");
            }
        }

        return null;
    }

}