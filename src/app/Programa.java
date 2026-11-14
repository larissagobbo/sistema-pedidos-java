package app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.ConexaoBanco;
import model.Cliente;

public class Programa {

    public static void main(String[] args) {
        try (Connection conn = ConexaoBanco.getConexao();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, nome, email FROM cliente ORDER BY id")) {

            while (rs.next()) {
                Cliente c = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                System.out.println(c);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}