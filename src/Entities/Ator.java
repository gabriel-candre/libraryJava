package Entities;

import Enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Ator extends Pessoa{

    private Integer idAtor;

    public Ator(String nome, String dataNascimento, String nacionalidade, int idAtor) {
        super(nome, dataNascimento, nacionalidade);
        this.idAtor = idAtor;

    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Integer idAtor) {
        this.idAtor = idAtor;
    }

    public String toFile() {
        return getNome() + ";" + getDataNascimento() + ";" + getNacionalidade() + ";" + getIdAtor();
    }

    public static Ator fromFile(String fileString) {
        String[] fields = fileString.split(";");
        String nome = fields[0];
        String dataNascimento = fields[1];
        String nacionalidade = fields[2];
        int idAtor = Integer.parseInt(fields[3]);
        return new Ator(nome, dataNascimento, nacionalidade, idAtor);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                +"\nData de nascimento: " + getDataNascimento()
                +"\nPaís de origem: " + getNacionalidade();
    }


}
