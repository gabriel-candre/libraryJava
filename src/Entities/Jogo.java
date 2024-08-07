package Entities;

import Enums.Disponibilidade;
import Enums.Status;
import Interfaces.ProcessaMidia;

public class Jogo extends Midia{

    private Integer idJogo;
    private String publicadora;

    public Jogo() {
        super();
    }

    public Jogo(String titulo, int ano, String genero, Status status, Disponibilidade disponibilidade, int idJogo, String publicadora) {
        super(titulo, ano, genero, status, disponibilidade);
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

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String toFile() {
        return getTitulo() + ";" + getAno() + ";" + getGenero() + ";" + getStatus() + ";" + getIdJogo() + ";" + getPublicadora() + ";" + getDisponibilidade();
    }

    public static Jogo fromFile(String fileString) {
        String [] fields = fileString.split(";");
        String titulo = fields[0];
        int ano = Integer.parseInt(fields[1]);
        String genero = fields[2];
        Status status = Status.valueOf(fields[3]);
        int idJogo = Integer.parseInt(fields[4]);
        String publicadora = fields[5];
        Disponibilidade disponibilidade = Disponibilidade.valueOf(fields[6]);
        return new Jogo(titulo, ano, genero, status, disponibilidade, idJogo, publicadora);
    }


    @Override
    public String toString() {
        return "Jogo: " + getTitulo()
                +"\nAno: " + getAno()
                +"\nGênero: " + getGenero()
                +"\nPublicadora: " + getPublicadora()
                +"\nStatus: " + getStatus()
                +"\nDisponibilidade: " + getDisponibilidade();

    }
}
