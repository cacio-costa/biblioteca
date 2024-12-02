public class Livro {

    private String codigo;
    private String titulo;
    private String autor;

    private double preco;
    private double valorMulta;

    private int quantidadeExemplares;

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

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        this.quantidadeExemplares = quantidadeExemplares;
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

    public void registraEmprestimo() {
        if (isDisponivel()) {
            quantidadeExemplares--;
        }
    }

    public boolean isDisponivel() {
        return quantidadeExemplares > 0;
    }

    public void registraDevolucao() {
        quantidadeExemplares++;
    }

    public double calculaMulta(int diasDeAtraso) {
        return diasDeAtraso * valorMulta;
    }
}
