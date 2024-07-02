package Controller;

import Entities.Ator;
import Entities.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

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

}
