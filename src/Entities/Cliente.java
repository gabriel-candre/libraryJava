package Entities;

import Interfaces.ProcessaMidia;
import Controller.*;

import java.util.Scanner;

public class Cliente extends Pessoa {

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



    public String toFile() {
        return getNome() + ";" + getDataNascimento() + ";" + getNacionalidade() + ";" + getIdCliente() + ";" + getEndereco() + ";"
                + getTelefone() + ";" + getEmail();
    }

    public static Cliente fromFile(String fileString) {
        String[] fields = fileString.split(";");
        String nome = fields[0];
        String dataNascimento = fields[1];
        String nacionalidade = fields[2];
        int idCliente = Integer.parseInt(fields[3]);
        String endereco = fields[4];
        String telefone = fields[5];
        String email = fields[6];
        return new Cliente(nome, dataNascimento, nacionalidade, idCliente, endereco, telefone, email);
    }

}

/*
* public void menuClientes() {
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Remover Cliente");
        System.out.println("3 - Buscar Cliente por id");
        System.out.println("4 - Listar todos os clientes");
        System.out.println("5 - Aluguel ou retorno de mídia");
        System.out.print("Opção: ");
    }
* */
