package Controller;

import Entities.Filme;
import Entities.Serie;
import Enums.Status;

import java.util.List;
import java.util.ArrayList;

public class SerieController {

    private List<Serie> series = new ArrayList<>();

    public SerieController() {

    }

    public void adicionarSerie(Serie s) {
        series.add(s);
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
}
