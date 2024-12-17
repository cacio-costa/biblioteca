package teste;

import banco.ConnectionFactory;
import dao.LivroDao;
import modelo.Livro;

import java.sql.Connection;
import java.sql.ResultSet;

public class TestaGerenteDeLivrosInsert {

    public static void main(String[] args) {
        Connection connection = null;
        ResultSet rs = null;
        try {
            ConnectionFactory criadoraDeConexao = new ConnectionFactory();
            connection = criadoraDeConexao.getConexao();
            connection.setAutoCommit(false);

            Livro oCodigoDaVinci = new Livro("OCV001", "O código da Vinci", "Dan Brown", 25.75, 1.5, 10);

            LivroDao gerenteDeLivros = new LivroDao(connection);
            gerenteDeLivros.insere(oCodigoDaVinci);
            System.out.println("Livro inserido com sucesso!");

            Livro oApanhadorNoCampoDeCenteio = new Livro("OAC001", "O apanhador no campo de centeio", "J. D. Salinger", 19.9, 4.5, 4);
            gerenteDeLivros.insere(oApanhadorNoCampoDeCenteio);
            System.out.println("Livro inserido com sucesso!");
        } catch (Exception e) {

        }


    }
}
