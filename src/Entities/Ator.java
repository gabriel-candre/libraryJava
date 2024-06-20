package Entities;

import java.util.ArrayList;
import java.util.List;

public class Ator extends Pessoa{

    private Integer idAtor;
    private List<Filme> filmes = new ArrayList<>();

    public Ator(String nome, int anoNascimento, String nacionalidade, Integer idAtor) {
        super(nome, anoNascimento, nacionalidade);
        this.idAtor = idAtor;

    }

    public Ator(String nome, int anoNascimento, String nacionalidade, Integer idAtor, List<Filme> filmes) {
        super(nome, anoNascimento, nacionalidade);
        this.idAtor = idAtor;
        this.filmes = filmes;
    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Integer idAtor) {
        this.idAtor = idAtor;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome()
                +"\nNacionalidade: " + getNacionalidade()
                +"\nÚltimo filme: " + filmes.get(filmes.size() - 1);
    }


}
