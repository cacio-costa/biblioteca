package opcoes;

import modelo.Livro;
import service.LivroService;

import java.util.Scanner;

public class RealizaEmprestimoCommand implements Command {

    @Override
    public void executa() {
        LivroService livroService = new LivroService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o código do livro que deseja: ");

        String codigoDoLivroDesejado = scanner.nextLine();
        try {
            Livro livroEmprestado = livroService.efetuaEmprestimoDoLivro(codigoDoLivroDesejado);
            System.out.println("Empréstimo do livro " + livroEmprestado.getTitulo() + " realizado!");
            System.out.println("Exemplares disponíveis atualmente: " + livroEmprestado.getQuantidadeExemplares());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
