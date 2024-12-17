package banco;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Design Pattern (Padrão de Projeto)
 */
public class ConnectionFactory {

    public Connection getConexao() {
        String usuario = "root";
        String senha = "root";
        String url = "jdbc:mysql://localhost:3306/biblioteca_db";

        try {
            return DriverManager.getConnection(url, usuario,senha);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }

}
