package opcoes;

import modelo.Livro;
import service.LivroService;

import java.util.List;

public class ExibeAcervoCommand implements Command {

    @Override
    public void executa() {
        LivroService livroService = new LivroService();
        System.out.println("=== ACERVO ===");

        List<Livro> acervoAtual = livroService.getLivros();

        for (int indice = 0; indice < acervoAtual.size(); indice++) {
            System.out.println(acervoAtual.get(indice));
        }

        System.out.println(" -> Livros disponíveis: " + livroService.getTotalDeLivrosDisponiveis());

        System.out.println("=== ====== ===");
        System.out.println();
    }
}
