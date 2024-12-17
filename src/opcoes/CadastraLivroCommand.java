package opcoes;

import modelo.Livro;
import service.LivroService;

import java.util.Scanner;

public class CadastraLivroCommand implements Command {

    @Override
    public void executa() {
        System.out.println("=== CADASTRO DE LIVRO ===");

        try {
            Livro novoLivro = criaLivro();

            LivroService livroService = new LivroService();
            livroService.efetuaCadastroDeLivro(novoLivro);

            System.out.println("Novo livro cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Livro criaLivro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o código do livro: ");
        String codigo = scanner.nextLine();

        System.out.println("Informe o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.println("Informe o autor do livro: ");
        String autor = scanner.nextLine();

        System.out.println("Informe o preço do livro: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe o valor da multa do livro: ");
        double multa = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Informe a quantidade de exemplares do livro: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        return new Livro(codigo, titulo, autor, preco, multa, quantidade);
    }
}
