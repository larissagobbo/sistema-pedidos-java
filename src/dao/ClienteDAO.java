package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConexaoBanco;
import model.Cliente;

public class ClienteDAO {

    // CREATE: insere um cliente e devolve o id gerado pelo banco
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, email) VALUES (?, ?)";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    // READ: lista todos os clientes
    public List<Cliente> listarTodos() {
        String sql = "SELECT id, nome, email FROM cliente ORDER BY id";
        List<Cliente> lista = new ArrayList<>();
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("email")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar clientes: " + e.getMessage());
        }
        return lista;
    }

    // READ: busca um cliente pelo id (devolve null se não existir)
    public Cliente buscarPorId(int id) {
        String sql = "SELECT id, nome, email FROM cliente WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente: " + e.getMessage());
        }
        return null;
    }

    // UPDATE: atualiza nome e e-mail
    public void atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setInt(3, cliente.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    // DELETE: remove um cliente pelo id
    public void deletar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar cliente: " + e.getMessage());
        }
    }
}