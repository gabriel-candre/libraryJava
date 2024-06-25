package Entities;

import Enums.Status;
import Interfaces.ConsumirMidia;

public class Jogo extends Midia implements ConsumirMidia{

    private Integer idJogo;
    private String publicadora;

    public Jogo(String titulo, int ano, String genero, Status status, int idJogo, String publicadora) {
        super(titulo, ano, genero, status);
        this.idJogo = idJogo;
        this.publicadora = publicadora;
    }

    public Integer getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public String getPublicadora() {
        return publicadora;
    }

    public void setPublicadora(String publicadora) {
        this.publicadora = publicadora;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String consumir() {
        this.status = Status.valueOf("Finalizado");
        return "Jogo - " + getTitulo() + " - Finalizado!";
    }

    @Override
    public String toString() {
        return "Jogo: " + getTitulo()
                +"\nAno: " + getAno()
                +"\nGênero: " + getGenero()
                +"\nPublicadora: " + getPublicadora()
                +"\nStatus: " + getStatus();

    }
}
