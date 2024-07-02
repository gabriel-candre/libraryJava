package Entities;

import Enums.Disponibilidade;
import Enums.Status;

public abstract class Midia {

    protected String titulo;
    protected Integer ano;
    protected String genero;
    protected Status status;
    protected Disponibilidade disponibilidade;

    public Midia(String titulo, Integer ano, String genero, Status status, Disponibilidade disponibilidade) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.status = status;
        this.disponibilidade = disponibilidade;
    }

    public Midia() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
