package Entities;

import java.util.ArrayList;
import java.util.List;

public class Ator extends Pessoa{

    private Integer idAtor;

    public Ator(String nome, int anoNascimento, String nacionalidade, Integer idAtor) {
        super(nome, anoNascimento, nacionalidade);
        this.idAtor = idAtor;

    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Integer idAtor) {
        this.idAtor = idAtor;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                +"\nPaís: " + getNacionalidade();
    }


}
