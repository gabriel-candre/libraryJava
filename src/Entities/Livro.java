package Entities;

import Enums.Disponibilidade;
import Enums.Status;
import Interfaces.ProcessaMídia;

public class Livro extends Midia implements ProcessaMídia {

    private Integer idLivro;
    private Integer paginas;
    private String editora;

    public Livro() {
        super();
    }

    public Livro(String titulo, int ano, String genero, Status status, Disponibilidade disponibilidade, int idLivro, int paginas,
                 String editora) {
        super(titulo, ano, genero, status, disponibilidade);
        this.idLivro = idLivro;
        this.paginas = paginas;
        this.editora = editora;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String toFile() {
        return getTitulo() + ";" + getAno() + ";" + getGenero() + ";" + getStatus() + ";" + getIdLivro() + ";" + getPaginas()
                + ";" + getEditora() + ";" + getDisponibilidade();
    }

    public static Livro fromFile(String fileString) {
        String [] fields = fileString.split(";");
        String titulo = fields[0];
        int ano = Integer.parseInt(fields[1]);
        String genero = fields[2];
        Status status = Status.valueOf(fields[3]);
        int idLivro = Integer.parseInt(fields[4]);
        int paginas = Integer.parseInt(fields[5]);
        String editora = fields[6];
        Disponibilidade disponibilidade = Disponibilidade.valueOf(fields[7]);
        return new Livro(titulo, ano, genero, status, disponibilidade, idLivro, paginas, editora);
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    @Override
    public void alugar() {
        this.disponibilidade = Disponibilidade.valueOf("Alugado");

    }

    @Override
    public void retornar() {
        this.disponibilidade = Disponibilidade.valueOf("DISPONIVEL");
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo()
                +"\nAno: " + getAno()
                +"\nGênero: " + getGenero()
                +"\nPáginas: " + getPaginas()
                +"\nEditora: " + getEditora()
                +"\nStatus: " + getStatus()
                +"\nDisponibilidade: " + getDisponibilidade();
    }

}
