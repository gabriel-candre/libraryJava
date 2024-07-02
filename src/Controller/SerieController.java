package Controller;

import Entities.Filme;
import Entities.Serie;
import Enums.Disponibilidade;
import Enums.Status;
import Interfaces.ProcessaMidia;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class SerieController implements ProcessaMidia {

    private List<Serie> series = new ArrayList<>();
    private String arquivo = "series.txt";

    public SerieController() {
        carregarSerie();
    }

    public void adicionarSerie(Serie s) {
        series.add(s);
        salvarSerie();
    }

    private void salvarSerie() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Serie s : series) {
                bw.write(s.toFile());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarSerie() {

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
                Serie s = Serie.fromFile(linha);
                series.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar series: " + e.getMessage());
        }
    }

    public void removerSerie(int id) {

        boolean serieEncontrada = false;

        for (Serie s : series) {
            if (s.getIdSerie() == id) {
                series.remove(s);
                serieEncontrada = true;
            }
        }

        if (serieEncontrada) {
            System.out.println("Série removida!");
        } else {
            System.out.println("Série não encontrada!");
        }
    }

    public String getSerie(int id) {
        for (Serie s : series) {
            if (s.getIdSerie() == id) {
                return s.toString();
            }
        }
        System.out.println("Série não encontrada!");
        return null;
    }

    public void editarSerie(int id, Status novoStatus) {
        boolean serieEncontrada = false;

        for (Serie s : series) {
            if (s.getIdSerie() == id) {
                s.setStatus(novoStatus);
                serieEncontrada = true;
                salvarSerie();
                System.out.println("Status atualizado!");
                break;
            }
        }
        if (!serieEncontrada) {
            System.out.println("Série não encontrada");
        }
    }

    public String listarSeries() {
        if (series.isEmpty()) {
            return "Nenhuma série encontrada!";
        } else {
            for (Serie s : series) {
                System.out.println(s.toString());
                System.out.println("-----");
            }
        }

        return null;
    }

    @Override
    public void alugar(int id) {
        for (Serie s : series) {
            if (s.getIdSerie() == id) {
                s.setDisponibilidade(Disponibilidade.valueOf("ALUGADO"));
            }
        }

    }

    @Override
    public void retornar(int id) {
        for (Serie s : series) {
            if (s.getIdSerie() == id) {
                s.setDisponibilidade(Disponibilidade.valueOf("DISPONIVEL"));
            }
        }
    }
}
