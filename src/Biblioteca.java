import java.util.Arrays;
import java.util.Scanner;

public class Biblioteca {

    private Livro[] livros = new Livro[5];

    public Biblioteca() {
        Livro harryPotter = new Livro();
        harryPotter.setCodigo("HP001");
        harryPotter.setTitulo("Harry Potter e a Pedra Filosofal");
        harryPotter.setAutor("J.K. Rowling");
        harryPotter.setPreco(45.90);
        harryPotter.setValorMulta(2.50);
        harryPotter.setQuantidadeExemplares(3);

        Livro percyJackson = new Livro();
        percyJackson.setCodigo("PJ001");
        percyJackson.setTitulo("Percy Jackson e o Ladrão de Raios");
        percyJackson.setAutor("Rick Riordan");
        percyJackson.setPreco(39.90);
        percyJackson.setValorMulta(2.00);
        percyJackson.setQuantidadeExemplares(2);

        Livro oHobbit = new Livro();
        oHobbit.setCodigo("HB001");
        oHobbit.setTitulo("O Hobbit");
        oHobbit.setAutor("J.R.R. Tolkien");
        oHobbit.setPreco(55.90);
        oHobbit.setValorMulta(3.00);
        oHobbit.setQuantidadeExemplares(5);

        livros[0] = harryPotter;
        livros[1] = percyJackson;
        livros[2] = oHobbit;
    }

    public void exibeAcervo() {
        int totalDeExemplares = 0;

        for (Livro livro : livros) {
            if (livro == null) {
                break;
            }

            System.out.println(livro);
            totalDeExemplares += livro.getQuantidadeExemplares();
        }

        System.out.println("Quantidade total do acervo: " + totalDeExemplares);
    }

    public boolean existeLivro(String codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo().equals(codigo)) {
                return true;
            }
        }

        return false;
    }

    public Livro recuperaLivro(String codigo) {
        for (Livro livro : livros) {
            if (livro.getCodigo().equals(codigo)) {
                return livro;
            }
        }

        return null;
    }

    public void cadastraLivro(Livro novoLivro) {
        int indiceDisponivel = -1;

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                indiceDisponivel = i;
                break;
            }
        }

        if (indiceDisponivel != -1) {
            livros[indiceDisponivel] = novoLivro;
        } else {
            indiceDisponivel = livros.length;

            livros = Arrays.copyOf(this.livros, livros.length * 2);
            livros[indiceDisponivel] = novoLivro;
        }
    }
}