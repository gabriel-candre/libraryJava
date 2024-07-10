package Controller;

import Entities.Ator;
import Entities.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteController {

    Scanner sc = new Scanner(System.in);

    FilmeController f = new FilmeController();
    JogoController j = new JogoController();
    LivroController l = new LivroController();
    SerieController s = new SerieController();

    private List<Cliente> clientes = new ArrayList<>();
    private String arquivo = "clientes.txt";

    public ClienteController () {
        carregarCliente();
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c);
        salvarCliente();
    }

    private void salvarCliente() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Cliente c : clientes) {
                bw.write(c.toFile());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    private void carregarCliente() {

        File file = new File(arquivo);
        if(!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Arquivo criado: " + arquivo);
            } catch(IOException e) {
                System.out.println("Erro ao criar arquivo: " + e.getMessage());
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while((linha = br.readLine()) != null) {
                Cliente c = Cliente.fromFile(linha);
                clientes.add(c);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } catch (IOException e) {
            System.out.println("Erro ao carregar clientes: " + e.getMessage());
        }
    }

    public void removerCliente(int id) {

        boolean clienteEncontrado = false;

        for (Cliente c : clientes) {
            if (c.getIdCliente() == id) {
                clientes.remove(c);
                clienteEncontrado = true;
            }
        }

        if (clienteEncontrado) {
            System.out.println("Cliente removido!");
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    public String getCliente(int id) {
        for (Cliente c : clientes){
            if (c.getIdCliente() == id) {
                return c.toString();
            }
        }
        System.out.println("Cliente não encontrado!");
        return null;
    }

    public String listarClientes() {
        if (clientes.isEmpty()) {
            return "Nenhum cliente encontrado!";
        } else {
            for (Cliente c : clientes) {
                System.out.println(c.toString());
                System.out.println("-----");
            }
        }
        return null;
    }

    public void alugar() {
        System.out.print("ID do cliente: ");
        int idClienteProcessa = sc.nextInt();
        boolean clienteEncontrado = false;
        for (Cliente c : clientes) {
            if (c.getIdCliente() == idClienteProcessa) {
                clienteEncontrado = true;
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
                        System.out.print("Opção: ");
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
                        System.out.print("Opção: ");
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
                        System.out.print("Opção: ");
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
                        System.out.print("Opção: ");
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
        }
        if (!clienteEncontrado) {
            System.out.println("Cliente não encontrado!");
        }
    }

}
