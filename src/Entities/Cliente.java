package Entities;

public class Cliente extends Pessoa{

    private Integer idCliente;
    private String endereco;
    private String telefone;
    private String email;


    public Cliente(String nome, String dataNascimento, String nacionalidade, Integer idCliente, String endereco, String telefone, String email) {
        super(nome, dataNascimento, nacionalidade);
        this.idCliente = idCliente;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
        return "ID: " + getIdCliente()
                +"\nNome: " + getNome()
                +"\nE-mail: " + getEmail()
                +"\nTelefone: " + getTelefone()
                +"\nEndereço: " + getEndereco();
    }
}
