public class Livro {

    private String codigo;
    private String titulo;
    private String autor;

    private double preco;
    private double valorMulta;

    // Modificador de ACESSO
    private int quantidadeExemplares;

    public Livro(String codigo, String titulo, String autor, double preco, double valorMulta, int quantidadeExemplares) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.valorMulta = valorMulta;
        this.quantidadeExemplares = quantidadeExemplares;
    }


    public boolean isDisponivel() {
        return this.quantidadeExemplares > 0;
    }

    public void setQuantidadeExemplares(int novaQuantidade) {
        if (novaQuantidade >= 0) {
            this.quantidadeExemplares = novaQuantidade;
        }
    }

    public int getQuantidadeExemplares() {
        return this.quantidadeExemplares;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public void registraEmprestimo() {
        this.quantidadeExemplares--;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                ", valorMulta=" + valorMulta +
                ", quantidadeExemplares=" + quantidadeExemplares +
                '}';
    }

    public boolean isMesmoCodigo(String outroCodigo) {
        return this.codigo.equals(outroCodigo);
    }

    public void registraDevolucao() {
        this.quantidadeExemplares++;
    }
}
