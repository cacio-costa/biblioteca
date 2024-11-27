import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        String bibliotecario = "Nome do Bibliotecário";
        int livrosDisponiveis = 150;
        int livrosEmprestados = 0;
        double multaPorDia = 2.50;

        exibeAcervo(livrosDisponiveis, livrosEmprestados);
        int opcao = pedeOpcao();

        while (opcao != 5) {
            if (opcao == 1) {
                exibeAcervo(livrosDisponiveis, livrosEmprestados);
            } else if (opcao == 2) {
                int quantidadeEmprestada = realizaEmprestimo(livrosDisponiveis);

                livrosDisponiveis -= quantidadeEmprestada;
                livrosEmprestados += quantidadeEmprestada;
            } else if (opcao == 3) {
                int quantidadeDevolvida = devolveLivro(livrosEmprestados);

                livrosDisponiveis += quantidadeDevolvida;
                livrosEmprestados -= quantidadeDevolvida;
            } else if (opcao == 4) {
                calculaMulta(multaPorDia);
            } else {
                System.out.println("Opção inválida");
            }

            opcao = pedeOpcao();
        }
    }

    private static void calculaMulta(double multaPorDia) {
        System.out.println("Digite a quantidade de dias de atraso: ");
        Scanner scanner = new Scanner(System.in);
        int diasAtraso = scanner.nextInt();

        double multa = diasAtraso * multaPorDia;
        System.out.printf("Multa a ser paga: R$ %.2f\n", multa);
    }

    private static int devolveLivro(int livrosEmprestados) {
        if (livrosEmprestados == 0) {
            System.out.println("Não há livros para devolução");
            return 0;
        }

        System.out.println("Digite a quantidade de livros a serem devolvidos: ");
        Scanner scanner = new Scanner(System.in);
        int quantidadeDevolvida = scanner.nextInt();

        if (quantidadeDevolvida > livrosEmprestados) {
            System.out.println("Quantidade inválida!");
            return 0;
        }

        return quantidadeDevolvida;
    }

    private static int realizaEmprestimo(int livrosDisponiveis) {
        System.out.printf("Há %d livros disponíveis para empréstimo\n", livrosDisponiveis);

        System.out.println("Digite a quantidade de livros desejada: ");
        Scanner scanner = new Scanner(System.in);

        int quantidadeLivros = scanner.nextInt();
        if (quantidadeLivros > livrosDisponiveis) {
            System.out.println("Quantidade de livros indisponível");
            return 0;
        }

        return quantidadeLivros;
    }

    private static void exibeAcervo(int livrosDisponiveis, int livrosEmprestados) {
        System.out.println("=== ACERVO ===");
        System.out.println(" -> Livros disponíveis: " + livrosDisponiveis);
        System.out.println(" -> Livros emprestados: " + livrosEmprestados);
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
                5 - Sair
                """);
    }

    private static void exibeInformacoes(String bibliotecario, int livrosDisponiveis, int livrosEmprestados, double multaPorDia) {
        System.out.println("=== BIBLIOTECA SORTECH ===");

        System.out.println(" -> Bibliotecário: " + bibliotecario);
        System.out.println(" -> Livros disponíveis: " + livrosDisponiveis);
        System.out.println(" -> Livros emprestados: " + livrosEmprestados);
        System.out.println(" -> Multa por dia de atraso: R$ " + multaPorDia);
        System.out.println("=== ================== ===");
        System.out.println();
    }
}