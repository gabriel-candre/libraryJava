package Entities;

public class Funcionario extends Pessoa{

    private Integer idFuncionario;
    private String telefone;
    private String email;

    public Funcionario(String nome, String dataNascimento, String nacionalidade, Integer idFuncionario, String telefone, String email) {
        super(nome, dataNascimento, nacionalidade);
        this.idFuncionario = idFuncionario;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + getIdFuncionario()
                +"\nNome: " + getNome()
                +"\nE-mail: " + getEmail()
                +"\nTelefone: " + getTelefone();
    }
}
