package Entities;

import Interfaces.ProcessaMidia;
import Controller.*;

import java.util.Scanner;

public class Cliente extends Pessoa {

    Scanner sc = new Scanner(System.in);

    FilmeController f = new FilmeController();
    JogoController j = new JogoController();
    LivroController l = new LivroController();
    SerieController s = new SerieController();

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

    public void alugar() {
        System.out.println("1 - Processar Filme");
        System.out.println("2 - Processar Jogo");
        System.out.println("3 - Processar Livro");
        System.out.println("4 - Processar Série");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                System.out.print("ID do filme a processar: ");
                int idProcessa = sc.nextInt();
                System.out.println("1 - Alugar");
                System.out.println("2 - Retornar");
                int opcaoProcessa = sc.nextInt();
                if (opcaoProcessa == 1) {
                    f.alugar(idProcessa);
                } else {
                    f.retornar(idProcessa);
                }
                break;
            case 2:
                System.out.print("ID do jogo a processar: ");
                idProcessa = sc.nextInt();
                System.out.println("1 - Alugar");
                System.out.println("2 - Retornar");
                opcaoProcessa = sc.nextInt();
                if (opcaoProcessa == 1) {
                    j.alugar(idProcessa);
                } else {
                    j.retornar(idProcessa);
                }
                break;
            case 3:
                System.out.print("ID do livro a processar: ");
                idProcessa = sc.nextInt();
                System.out.println("1 - Alugar");
                System.out.println("2 - Retornar");
                opcaoProcessa = sc.nextInt();
                if (opcaoProcessa == 1) {
                    l.alugar(idProcessa);
                } else {
                    l.retornar(idProcessa);
                }
                break;
            case 4:
                System.out.print("ID da série a processar: ");
                idProcessa = sc.nextInt();
                System.out.println("1 - Alugar");
                System.out.println("2 - Retornar");
                opcaoProcessa = sc.nextInt();
                if (opcaoProcessa == 1) {
                    s.alugar(idProcessa);
                } else {
                    s.retornar(idProcessa);
                }
                break;
            default:
                break;
        }

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
