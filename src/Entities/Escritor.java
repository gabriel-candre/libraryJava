package Entities;

import java.util.ArrayList;
import java.util.List;

public class Escritor extends Pessoa{

    private Integer idEscritor;

    public Escritor(String nome, int anoNascimento, String nacionalidade, Integer idEscritor) {
        super(nome, anoNascimento, nacionalidade);
        this.idEscritor = idEscritor;
    }

    public Integer getIdEscritor() {
        return idEscritor;
    }

    public void setIdEscritor(Integer idEscritor) {
        this.idEscritor = idEscritor;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                +"\nPaís: " + getNacionalidade();
    }

}
