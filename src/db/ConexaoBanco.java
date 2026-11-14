package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBanco {

    private static Properties carregarPropriedades() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível ler o arquivo db.properties: " + e.getMessage());
        }
    }

    public static Connection getConexao() {
        Properties props = carregarPropriedades();
        try {
            return DriverManager.getConnection(
                    props.getProperty("url"),
                    props.getProperty("usuario"),
                    props.getProperty("senha"));
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage());
        }
    }
}