package Entities;

import Enums.Status;
import Interfaces.ConsumirMidia;

public class Filme extends Midia implements ConsumirMidia{

    private Integer idFilme;
    private Integer duracao;
    private String diretor;
    private String publicadora;

    public Filme(String titulo, int ano, String genero, Status status, int idFilme, int duracao, String diretor,
                 String publicadora) {
        super(titulo, ano, genero, status);
        this.idFilme = idFilme;
        this.duracao = duracao;
        this.diretor = diretor;
        this.publicadora = publicadora;
    }

    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public String getPublicadora() {
        return publicadora;
    }

    public void setPublicadora(String publicadora) {
        this.publicadora = publicadora;
    }

    @Override
    public String consumir() {
        this.status = Status.valueOf("Finalizado");
        return "Filme - " + getTitulo() + " - Assistido!";
    }

    @Override
    public String toString() {
        return "Filme: " + getTitulo()
                +"\nAno: " + getAno()
                +"\nGênero: " + getGenero()
                +"\nDiretor(a): " + getDiretor()
                +"\nDuração (min): " + getDuracao()
                +"\nStatus: " + getStatus();
    }

}
