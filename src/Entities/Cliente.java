package Entities;

import Interfaces.ProcessaMídia;

import java.util.Scanner;

public class Cliente extends Pessoa implements ProcessaMídia {

    Scanner sc = new Scanner(System.in);

    Filme f = new Filme();
    Jogo j = new Jogo();
    Livro l = new Livro();
    Serie s = new Serie();

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

    @Override
    public void alugar() {
        System.out.println("1 - Processar Filme");
        System.out.println("2 - Processar Jogo");
        System.out.println("3 - Processar Livro");
        System.out.println("4 - Processar Série");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("1 - Alugar");
                System.out.println("2 - Retornar");
                System.out.print("Opção: ");
                int opcao2 = sc.nextInt();
                if (opcao2 == 1) {
                    f.alugar();
                } else {
                    f.retornar();
                }
                break;
            case 2:
                j.alugar();
                break;
            case 3:
                l.alugar();
                break;
            case 4:
                s.alugar();
                break;
            default:
                break;
        }

    }

    @Override
    public void retornar() {

    }
}
