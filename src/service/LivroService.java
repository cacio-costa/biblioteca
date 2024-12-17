package service;

import banco.ConnectionFactory;
import dao.LivroDao;
import modelo.Livro;

import java.sql.Connection;
import java.util.List;

public class LivroService {

    private LivroDao livroDao;

    public LivroService() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection conexao = connectionFactory.getConexao();

        this.livroDao = new LivroDao(conexao);
    }

    public List<Livro> getLivros() {
        return this.livroDao.listaTodos();
    }

    public int getTotalDeLivrosDisponiveis() {
        return this.livroDao.calculaTotalDeLivrosDisponiveis();
    }

    public Livro recuperaLivroPorCodigo(String codigo) {
        return this.livroDao.pesquisaPorCodigo(codigo);
    }

    public Livro efetuaEmprestimoDoLivro(String codigo) throws Exception {
        Livro livro = recuperaLivroPorCodigo(codigo);
        if (livro == null) {
            throw new Exception("Livro não encontrado: " + codigo);
        }

        if (!livro.isDisponivel()) {
            throw new Exception("Livro indisponível!");
        }

        livro.registraEmprestimo();
        this.livroDao.atualiza(livro);

        return livro;
    }

    public Livro efetuaDevolucaoDoLivro(String codigo) throws Exception {
        Livro livro = recuperaLivroPorCodigo(codigo);
        if (livro == null) {
            throw new Exception("Livro não encontrado: " + codigo);
        }

        livro.registraDevolucao();
        this.livroDao.atualiza(livro);

        return livro;
    }

    public double calculaMultaPorAtraso(String codigoDoLivro, int diasAtraso) throws Exception {
        Livro livro = recuperaLivroPorCodigo(codigoDoLivro);

        if (livro == null) {
            throw new Exception("Livro não encontrado: " + codigoDoLivro);
        }

        return diasAtraso * livro.getValorMulta();
    }

    public void efetuaCadastroDeLivro(Livro livro) throws Exception {
        Livro possivelLivro = recuperaLivroPorCodigo(livro.getCodigo());
        if (possivelLivro != null) {
            throw new Exception("Livro já cadastrado: " + livro.getCodigo());
        }

        this.livroDao.insere(livro);
    }
}
