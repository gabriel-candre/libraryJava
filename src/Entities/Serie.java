package Entities;

import Enums.Status;
import Interfaces.ConsumirMidia;

public class Serie extends Midia implements ConsumirMidia{

    private Integer idSerie;
    private Integer temporada;
    private Integer episodios;

    public Serie(String titulo, int ano, String genero, Status status, int idSerie, int temporada,
                 int episodios) {
        super(titulo, ano, genero, status);
        this.idSerie = idSerie;
        this.temporada = temporada;
        this.episodios = episodios;
    }

    public Integer getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(int idSerie) {
        this.idSerie = idSerie;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public Integer getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    @Override
    public String consumir() {
        this.status = Status.valueOf("Finalizada");
        return "Séria - " + getTitulo() + " - Finalizada!";
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo()
                +"\nAno: " + getAno()
                +"\nGênero: " +getGenero()
                +"\nTemporada: " + getTemporada()
                +"\nEpisódios: " + getEpisodios()
                +"\nStatus: " + getStatus();
    }

}
