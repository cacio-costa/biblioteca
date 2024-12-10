import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Bibliotecario {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        int opcao = pedeOpcao();

        while (opcao != 6) {
            if (opcao == 1) {
                exibeAcervo(biblioteca);
            } else if (opcao == 2) {
                realizaEmprestimo(biblioteca);
            } else if (opcao == 3) {
                devolveLivro(biblioteca);
            } else if (opcao == 4) {
                calculaMulta(biblioteca);
            } else if (opcao == 5) {
                cadastraLivro(biblioteca);
            } else {
                System.out.println("Opção inválida");
            }

            opcao = pedeOpcao();
        }
    }

    private static void cadastraLivro(Biblioteca biblioteca) {
        System.out.println("=== CADASTRO DE LIVRO ===");

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

        Livro novoLivro = new Livro(codigo, titulo, autor, preco, multa, quantidade);
        biblioteca.cadastra(novoLivro);
        System.out.println("Novo livro cadastrado com sucesso!");
    }

    private static void calculaMulta(Biblioteca biblioteca) {
        System.out.println("Digite o código do livro emprestado: ");
        Scanner scanner = new Scanner(System.in);

        String codigoParaMulta = scanner.nextLine();
        Livro livroParaMulta = biblioteca.recuperaLivroPorCodigo(codigoParaMulta);

        if (livroParaMulta == null) {
            System.out.println("Livro não encontrado: " + codigoParaMulta);
            return;
        }

        System.out.println("Digite a quantidade de dias de atraso: ");
        int diasAtraso = scanner.nextInt();

        double multa = diasAtraso * livroParaMulta.getValorMulta();
        System.out.printf("Multa a ser paga: R$ %.2f\n", multa);
    }

    private static void devolveLivro(Biblioteca biblioteca) {
        System.out.println("Digite o código do livro a ser devolvido: ");
        Scanner scanner = new Scanner(System.in);

        String codigoDoLivroDevolvido = scanner.nextLine();

        Livro livroParaDevolucao = biblioteca.recuperaLivroPorCodigo(codigoDoLivroDevolvido);
        if (livroParaDevolucao == null) {
            System.out.println("Livro não encontrado: " + codigoDoLivroDevolvido);
            return;
        }

        livroParaDevolucao.registraDevolucao();
        System.out.println("Livro " + livroParaDevolucao.getTitulo() + " devolvido!");
    }

    private static void realizaEmprestimo(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o código do livro que deseja: ");

        String codigoDoLivroDesejado = scanner.nextLine();

        Livro livroDesejado = biblioteca.recuperaLivroPorCodigo(codigoDoLivroDesejado);
        if (livroDesejado == null) {
            System.out.println("Livro não encontrado: " + codigoDoLivroDesejado);
            return;
        }

        if (!livroDesejado.isDisponivel()) {
            System.out.println("Livro indisponível!");
            return;
        }

        livroDesejado.registraEmprestimo();
        System.out.println("Empréstimo do livro " + livroDesejado.getTitulo() + " realizado!");
    }

    private static void exibeAcervo(Biblioteca biblioteca) {
        System.out.println("=== ACERVO ===");

        List<Livro> acervoAtual = biblioteca.getLivros();
        for (int indice = 0; indice < acervoAtual.size(); indice++) {
            System.out.println(acervoAtual.get(indice));
        }

        System.out.println(" -> Livros disponíveis: " + biblioteca.getTotalDeLivrosDisponiveis());

        System.out.println("=== ====== ===");
        System.out.println();
    }



    private static int pedeOpcao() {
        exibeMenu();
        System.out.println("Escolha uma opção:");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void exibeMenu() {
        System.out.println("""
                1 - Consultar acervo
                2 - Emprestar livro
                3 - Devolver livro
                4 - Calcular multa
                5 - Cadastrar livro
                6 - Sair
                """);
    }
    
}