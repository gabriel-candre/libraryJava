package Entities;

import Enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Escritor extends Pessoa{

    private Integer idEscritor;

    public Escritor(String nome, String dataNascimento, String nacionalidade, int idEscritor) {
        super(nome, dataNascimento, nacionalidade);
        this.idEscritor = idEscritor;
    }

    public Integer getIdEscritor() {
        return idEscritor;
    }

    public void setIdEscritor(Integer idEscritor) {
        this.idEscritor = idEscritor;
    }

    public String toFile() {
        return getNome() + ";" + getDataNascimento() + ";" + getNacionalidade() + ";" +  getIdEscritor();
    }

    public static Escritor fromFile(String fileString) {
        String[] fields = fileString.split(";");
        String nome = fields[0];
        String dataNascimento = fields[1];
        String nacionalidade = fields[2];
        int idEscritor = Integer.parseInt(fields[3]);
        return new Escritor(nome, dataNascimento, nacionalidade, idEscritor);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                +"\nAno de nascimento: " + getDataNascimento()
                +"\nPaís de origem: " + getNacionalidade();
    }

}
