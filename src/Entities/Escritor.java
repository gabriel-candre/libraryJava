package Entities;

import java.util.ArrayList;
import java.util.List;

public class Escritor extends Pessoa{

    private Integer idEscritor;
    private List<Livro> obras = new ArrayList<>();

    public Escritor(String nome, int anoNascimento, String nacionalidade, Integer idEscritor) {
        super(nome, anoNascimento, nacionalidade);
        this.idEscritor = idEscritor;
    }

    public Escritor(String nome, int anoNascimento, String nacionalidade, Integer idEscritor, List<Livro> obras) {
        super(nome, anoNascimento, nacionalidade);
        this.idEscritor = idEscritor;
        this.obras = obras;
    }

    public Integer getIdEscritor() {
        return idEscritor;
    }

    public void setIdEscritor(Integer idEscritor) {
        this.idEscritor = idEscritor;
    }

    public List<Livro> getObras() {
        return obras;
    }

    public void setObras(List<Livro> obras) {
        this.obras = obras;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                +"\nNacionalidade: " + getNacionalidade()
                +"\nÚltimo livro: " + obras.get(obras.size() - 1) ;
    }

}
