package app;

import dao.ClienteDAO;
import model.Cliente;

public class Programa {

    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        // CREATE
        Cliente novo = new Cliente(null, "Larissa Teste", "larissa.teste@email.com");
        dao.inserir(novo);
        System.out.println("Inserido: " + novo);

        // READ (todos)
        System.out.println("\n--- Todos os clientes ---");
        for (Cliente c : dao.listarTodos()) {
            System.out.println(c);
        }

        // READ (por id)
        System.out.println("\n--- Buscar por id ---");
        System.out.println(dao.buscarPorId(novo.getId()));

        // UPDATE
        novo.setNome("Larissa Atualizada");
        dao.atualizar(novo);
        System.out.println("\nApós atualizar: " + dao.buscarPorId(novo.getId()));

        // DELETE
        dao.deletar(novo.getId());
        System.out.println("\nApós deletar: " + dao.buscarPorId(novo.getId()));
    }
}