import opcoes.*;
import service.LivroService;
import modelo.Livro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Map<Integer, Command> opcoes = new HashMap<>();
        opcoes.put(1, new ExibeAcervoCommand());
        opcoes.put(2, new RealizaEmprestimoCommand());
        opcoes.put(3, new DevolveLivroCommand());
        opcoes.put(4, new CalculaMultaCommand());
        opcoes.put(5, new CadastraLivroCommand());

        int opcao = pedeOpcao();
        while (opcao != 6) {
            Command comando = opcoes.getOrDefault(opcao, new OpcaoInvalidaCommand());
            comando.executa();

            opcao = pedeOpcao();
        }
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