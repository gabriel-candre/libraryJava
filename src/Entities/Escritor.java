package Entities;

import Enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Escritor extends Pessoa{

    private Integer idEscritor;

    public Escritor(String nome, int anoNascimento, String nacionalidade, int idEscritor) {
        super(nome, anoNascimento, nacionalidade);
        this.idEscritor = idEscritor;
    }

    public Integer getIdEscritor() {
        return idEscritor;
    }

    public void setIdEscritor(Integer idEscritor) {
        this.idEscritor = idEscritor;
    }

    public String toFile() {
        return getNome() + ";" + getAnoNascimento() + ";" + getNacionalidade() + ";" +  getIdEscritor();
    }

    public static Escritor fromFile(String fileString) {
        String[] fields = fileString.split(";");
        String nome = fields[0];
        int anoNascimento = Integer.parseInt(fields[1]);
        String nacionalidade = fields[2];
        int idEscritor = Integer.parseInt(fields[3]);
        return new Escritor(nome, anoNascimento, nacionalidade, idEscritor);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                +"\nAno de nascimento: " + getAnoNascimento()
                +"\nPaís de origem: " + getNacionalidade();
    }

}
