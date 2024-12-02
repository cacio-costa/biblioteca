import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao = pedeOpcao(scanner);
        while (opcao != 6) {
            if (opcao == 1) {
                System.out.println("=== EXIBIR ACERVO ===");
                biblioteca.exibeAcervo();

                System.out.println("=== ====== ===");
                System.out.println();
            } else if (opcao == 2) {
                System.out.println("=== REALIZAR EMPRÉSTIMO ===");

                System.out.println("Digite o código do livro: ");
                String codigoDoLivro = scanner.nextLine();

                if (biblioteca.existeLivro(codigoDoLivro)) {
                    Livro livro = biblioteca.recuperaLivro(codigoDoLivro);

                    if (livro.isDisponivel()) {
                        livro.registraEmprestimo();
                        System.out.printf("Livro %s emprestado com sucesso! Exemplares disponíveis: %d.\n", livro.getTitulo(), livro.getQuantidadeExemplares());
                    } else {
                        System.out.println("Livro indisponível!");
                    }
                } else {
                    System.out.println("Livro não encontrado!");
                }

                System.out.println("=== ====== ===");
                System.out.println();
            } else if (opcao == 3) {
                System.out.println("=== DEVOLVER LIVRO ===");
                System.out.println("Digite o código do livro: ");

                String codigoDoLivro = scanner.nextLine();

                if (biblioteca.existeLivro(codigoDoLivro)) {
                    Livro livro = biblioteca.recuperaLivro(codigoDoLivro);
                    livro.registraDevolucao();

                    System.out.printf("Livro %s devolvido com sucesso! Exemplares disponíveis: %d.\n", livro.getTitulo(), livro.getQuantidadeExemplares());
                } else {
                    System.out.println("Livro não encontrado!");
                }

                System.out.println("=== ====== ===");
                System.out.println();
            } else if (opcao == 4) {
                System.out.println("=== CALCULAR MULTA ===");

                System.out.println("Digite o código do livro: ");
                String codigoDoLivro = scanner.nextLine();

                if (biblioteca.existeLivro(codigoDoLivro)) {
                    System.out.println("Digite a quantidade de dias de atraso: ");
                    int diasDeAtraso = scanner.nextInt();

                    Livro livro = biblioteca.recuperaLivro(codigoDoLivro);
                    double multa = livro.calculaMulta(diasDeAtraso);

                    System.out.println("Multa a ser paga: R$ " + multa);
                } else {
                    System.out.println("Livro não encontrado!");
                }

                System.out.println("=== ====== ===");
                System.out.println();
            } else if (opcao == 5) {
                System.out.println("=== CADASTRAR LIVRO ===");

                Livro novoLivro = new Livro();
                System.out.println("Digite o código do livro: ");
                novoLivro.setCodigo(scanner.nextLine());

                System.out.println("Digite o título do livro: ");
                novoLivro.setTitulo(scanner.nextLine());

                System.out.println("Digite o autor do livro: ");
                novoLivro.setAutor(scanner.nextLine());

                System.out.println("Digite o preço do livro: ");
                novoLivro.setPreco(scanner.nextDouble());
                scanner.nextLine();

                System.out.println("Digite o valor da multa: ");
                novoLivro.setValorMulta(scanner.nextDouble());
                scanner.nextLine();

                System.out.println("Digite a quantidade de exemplares: ");
                novoLivro.setQuantidadeExemplares(scanner.nextInt());
                scanner.nextLine();

                biblioteca.cadastraLivro(novoLivro);

                System.out.println("Livro cadastrado com sucesso!");
            } else {
                System.out.println("Opção inválida");
            }

            opcao = pedeOpcao(scanner);
        }
    }

    private static int pedeOpcao(Scanner scanner) {
        exibeMenu();
        System.out.println("Escolha uma opção:");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        return opcao;
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
