package teste;

import banco.ConnectionFactory;
import dao.LivroDao;
import modelo.Livro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeLivros {

    public static void main(String[] args) {
        try (Connection connection = new ConnectionFactory().getConexao()) {
            connection.setAutoCommit(false);

            LivroDao livroDao = new LivroDao(connection);
            List<Livro> livros = livroDao.listaTodos();

            for (Livro livro : livros) {
                System.out.println(livro.getCodigo());
                System.out.println(livro.getTitulo());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
