import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Biblioteca {

    private List<Livro> livros = new ArrayList<>();

    public Biblioteca() {
        Livro pedraFilosofal = new Livro("HP001", "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 45.90, 2.00, 3);
        Livro ladraoDeRaios = new Livro("PJ001", "Percy Jackson e o Ladrão de Raios", "Rick Riordan", 39.90, 2.00, 2);
        Livro oHobbit = new Livro("HB001", "O Hobbit", "J.R.R. Tolkien", 55.90, 2.00, 2);

        this.livros.add(pedraFilosofal);
        this.livros.add(ladraoDeRaios);
        this.livros.add(oHobbit);
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

    public int getTotalDeLivrosDisponiveis() {
        int total = 0;
        for (Livro livro : this.livros) {
            total += livro.getQuantidadeExemplares();
        }

        return total;
    }

    public Livro recuperaLivroPorCodigo(String codigo) {
        for (Livro livro : this.livros) {
            if (livro.isMesmoCodigo(codigo)) {
                return livro;
            }
        }

        return null;
    }

    public boolean cadastra(Livro livro) {
        this.livros.add(livro);
        return true;
    }

}
