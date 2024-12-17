package opcoes;

import service.LivroService;

import java.util.Scanner;

public class CalculaMultaCommand implements Command {

    @Override
    public void executa() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o código do livro emprestado: ");
        String codigoDoLivro = scanner.nextLine();

        System.out.println("Digite a quantidade de dias de atraso: ");
        int diasAtraso = scanner.nextInt();
        scanner.nextLine();

        try {
            LivroService livroService = new LivroService();
            double multa = livroService.calculaMultaPorAtraso(codigoDoLivro, diasAtraso);

            System.out.printf("Multa a ser paga: R$ %.2f\n", multa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
