package Entities;

import Enums.Disponibilidade;
import Enums.Status;
import Interfaces.AlugarMidia;

public class Serie extends Midia implements AlugarMidia {

    private Integer idSerie;
    private Integer temporada;
    private Integer episodios;

    public Serie(String titulo, int ano, String genero, Status status, Disponibilidade disponibilidade, int idSerie, int temporada,
                 int episodios) {
        super(titulo, ano, genero, status, disponibilidade);
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

    public String toFile() {
        return getTitulo() + ";" + getAno() + ";" + getGenero() + ";" + getStatus() + ";" + getIdSerie() + ";" + getTemporada()
                + ";" + getEpisodios() + ";" + getDisponibilidade();
    }

    public static Serie fromFile(String fileString) {
        String[] fields = fileString.split(";");
        String titulo = fields[0];
        int ano = Integer.parseInt(fields[1]);
        String genero = fields[2];
        Status status = Status.valueOf(fields[3]);
        int idSerie = Integer.parseInt(fields[4]);
        int temporada = Integer.parseInt(fields[5]);
        int episodios = Integer.parseInt(fields[6]);
        Disponibilidade disponibilidade = Disponibilidade.valueOf(fields[7]);
        return new Serie(titulo, ano, genero, status, disponibilidade, idSerie, temporada, episodios);
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    @Override
    public String alugar() {
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
                +"\nStatus: " + getStatus()
                +"\nDisponibilidade: " + getDisponibilidade();
    }

}
