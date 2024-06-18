package Entities;

import Enums.Status;

public abstract class Midia {

    protected String titulo;
    protected Integer ano;
    protected String genero;
    protected Status status;

    public Midia(String titulo, int ano, String genero, Status status) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
        this.status = status;
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

    public void setAno(int ano) {
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


}
