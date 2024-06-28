package Entities;

import Enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Ator extends Pessoa{

    private Integer idAtor;

    public Ator(String nome, int anoNascimento, String nacionalidade, int idAtor) {
        super(nome, anoNascimento, nacionalidade);
        this.idAtor = idAtor;

    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Integer idAtor) {
        this.idAtor = idAtor;
    }

    public String toFile() {
        return getNome() + ";" + getAnoNascimento() + ";" + getNacionalidade() + ";" + getIdAtor();
    }

    public static Ator fromFile(String fileString) {
        String[] fields = fileString.split(";");
        String nome = fields[0];
        int anoNascimento = Integer.parseInt(fields[1]);
        String nacionalidade = fields[2];
        int idAtor = Integer.parseInt(fields[3]);
        return new Ator(nome, anoNascimento, nacionalidade, idAtor);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                +"\nAno de nascimento: " + getAnoNascimento()
                +"\nPaís de origem: " + getNacionalidade();
    }


}
