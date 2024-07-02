package Entities;

import Enums.Disponibilidade;
import Enums.Status;
import Interfaces.AlugarMidia;

public class Filme extends Midia implements AlugarMidia {

    private Integer idFilme;
    private Integer duracao;
    private String diretor;
    private String publicadora;

    public Filme(String titulo, Integer ano, String genero, Status status, Disponibilidade disponibilidade, Integer idFilme, Integer duracao,
                 String diretor, String publicadora) {
        super(titulo, ano, genero, status, disponibilidade);
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public String toFile() {
        return getTitulo() + ";" + getAno() + ";" + getGenero() + ";" + getStatus() + ";" + getIdFilme() + ";" + getDuracao()
                + ";" + getDiretor() + ";" + getPublicadora() + ";" + getDisponibilidade();
    }

    public static Filme fromFile(String fileString) {
        String[] fields = fileString.split(";");
        String titulo = fields[0];
        int ano = Integer.parseInt(fields[1]);
        String genero = fields[2];
        Status status = Status.valueOf(fields[3]);
        int idFilme = Integer.parseInt(fields[4]);
        int duracao = Integer.parseInt(fields[5]);
        String diretor = fields[6];
        String publicadora = fields[7];
        Disponibilidade disponibilidade = Disponibilidade.valueOf(fields[8]);
        return new Filme(titulo, ano, genero, status, disponibilidade, idFilme, duracao, diretor, publicadora);
    }

    @Override
    public String alugar() {
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
                +"\nStatus: " + getStatus()
                +"\nDisponibilidade: " + getDisponibilidade();
    }

}
