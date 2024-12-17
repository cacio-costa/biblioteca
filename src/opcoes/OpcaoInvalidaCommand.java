package opcoes;

public class OpcaoInvalidaCommand implements Command {

    @Override
    public void executa() {
        System.out.println("Opção inválida! Tente novamente.");
    }
}
