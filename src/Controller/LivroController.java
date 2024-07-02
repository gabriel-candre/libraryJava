package Controller;

import Entities.Filme;
import Entities.Livro;
import Enums.Disponibilidade;
import Enums.Status;
import Interfaces.ProcessaMidia;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class LivroController implements ProcessaMidia {

    private List<Livro> livros = new ArrayList<>();
    private String arquivo = "livros.txt";

    public LivroController() {
        carregarLivro();
    }

    public void adicionarLivro(Livro l) {
        livros.add(l);
        salvarLivro();
    }

    private void salvarLivro() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Livro l : livros) {
                bw.write(l.toFile());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarLivro() {

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
                Livro l = Livro.fromFile(linha);
                livros.add(l);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar livros: " + e.getMessage());
        }
    }

    public void removerLivro(int id) {

        boolean livroEncontrado = false;

        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                livros.remove(l);
                livroEncontrado = true;
            }
        }

        if (livroEncontrado) {
            System.out.println("Livro removido!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public String getLivro(int id) {
        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                return l.toString();
            }
        }
        System.out.println("Livro não encontrado!");
        return null;
    }

    public void editarLivro(int id, Status novoStatus) {
        boolean livroEncontrado = false;

        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                l.setStatus(novoStatus);
                livroEncontrado = true;
                salvarLivro();
                System.out.println("Status atualizado!");
                break;
            }
        }
        if (!livroEncontrado) {
            System.out.println("Livro não encontrado");
        }
    }

    public String listarLivros() {
        if (livros.isEmpty()) {
            return "Nenhum livro encontrado!";
        } else {
            for (Livro l : livros) {
                System.out.println(l.toString());
                System.out.println("-----");
            }
        }

        return null;
    }

    @Override
    public void alugar(int id) {
        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                l.setDisponibilidade(Disponibilidade.valueOf("ALUGADO"));
            }
        }

    }

    @Override
    public void retornar(int id) {
        for (Livro l : livros) {
            if (l.getIdLivro() == id) {
                l.setDisponibilidade(Disponibilidade.valueOf("DISPONIVEL"));
            }
        }
    }
}
