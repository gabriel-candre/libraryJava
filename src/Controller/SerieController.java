package Controller;

import Entities.Serie;
import java.util.List;
import java.util.ArrayList;

public class SerieController {

    private List<Serie> series;

    public SerieController() {
        series = new ArrayList<>();
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

    public Serie getSerie(int id) {
        for (Serie s : series) {
            if (s.getIdSerie() == id) {
                return s;
            }
        }
        System.out.println("Série não encontrada!");
        return null;
    }

    public List<Serie> listarSeries() {
        return series;
    }
}
