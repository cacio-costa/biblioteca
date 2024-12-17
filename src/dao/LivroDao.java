package dao;

import modelo.Livro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivroDao {

    private Connection conexao;

    public LivroDao(Connection con) {
        this.conexao = con;
    }


    public void insere(Livro livro) {
        String sqlInsert = """
                           insert into livro 
                               (codigo, titulo, autor, preco, multa, exemplares) 
                           values
                               (?, ?, ?, ?, ?, ?)""";

        try (PreparedStatement comandoPreparado = this.conexao.prepareStatement(sqlInsert)) {
            comandoPreparado.setString(1, livro.getCodigo());
            comandoPreparado.setString(2, livro.getTitulo());
            comandoPreparado.setString(3, livro.getAutor());
            comandoPreparado.setDouble(4, livro.getPreco());
            comandoPreparado.setDouble(5, livro.getValorMulta());
            comandoPreparado.setInt(6, livro.getQuantidadeExemplares());

            comandoPreparado.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Livro> listaTodos() {
        String sqlSelect = "select * from livro";

        try (PreparedStatement comandoPreparado = this.conexao.prepareStatement(sqlSelect);
             ResultSet resultSet = comandoPreparado.executeQuery()) {
            List<Livro> livros = new ArrayList<>();
            while(resultSet.next()) {
                livros.add(criaLivro(resultSet));
            }

            return livros;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int calculaTotalDeLivrosDisponiveis() {
        String sqlSelect = "select sum(exemplares) as total from livro";

        try (PreparedStatement comandoPreparado = this.conexao.prepareStatement(sqlSelect);
            ResultSet resultSet = comandoPreparado.executeQuery()) {
            resultSet.next();

            return resultSet.getInt("total");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Livro pesquisaPorCodigo(String codigo) {
        String sql = "select * from livro where codigo = ?";

        try (PreparedStatement comandoSelect = this.conexao.prepareStatement(sql)) {
            comandoSelect.setString(1, codigo);

            try (ResultSet resultSet = comandoSelect.executeQuery()) {
                Livro livro = null;
                if (resultSet.next()) {
                    livro = criaLivro(resultSet);
                }

                return livro;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Livro criaLivro(ResultSet rs) throws SQLException {
        return new Livro(
            rs.getString("codigo"),
            rs.getString("titulo"),
            rs.getString("autor"),
            rs.getDouble("preco"),
            rs.getDouble("multa"),
            rs.getInt("exemplares")
        );
    }

    public void atualiza(Livro livro) {
        String sql = """
                     update livro
                        set titulo = ?, 
                            autor = ?, 
                            preco = ?, 
                            multa = ?, 
                            exemplares = ?
                      where codigo = ?""";

        try (PreparedStatement comandoPreparado = this.conexao.prepareStatement(sql)) {
            comandoPreparado.setString(1, livro.getTitulo());
            comandoPreparado.setString(2, livro.getAutor());
            comandoPreparado.setDouble(3, livro.getPreco());
            comandoPreparado.setDouble(4, livro.getValorMulta());
            comandoPreparado.setInt(5, livro.getQuantidadeExemplares());
            comandoPreparado.setString(6, livro.getCodigo());

            comandoPreparado.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}