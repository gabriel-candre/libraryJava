package Entities;

import Enums.Status;
import Interfaces.ConsumirMidia;

public class Livro extends Midia implements ConsumirMidia{

    private Integer idLivro;
    private Integer paginas;
    private String editora;

    public Livro(String titulo, int ano, String genero, Status status, int idLivro, int paginas,
                 String editora) {
        super(titulo, ano, genero, status);
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
                + ";" + getEditora();
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
        return new Livro(titulo, ano, genero, status, idLivro, paginas, editora);
    }

    public void setStatus (Status status) {
        this.status = status;
    }

    @Override
    public String consumir() {
        this.status = Status.valueOf("Finalizado");
        return "Livro - " + getTitulo() + " - Finalizado!";
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo()
                +"\nAno: " + getAno()
                +"\nGênero: " + getGenero()
                +"\nPáginas: " + getPaginas()
                +"\nEditora: " + getEditora()
                +"\nStatus: " + getStatus();
    }

}
