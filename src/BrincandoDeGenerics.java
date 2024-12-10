import java.util.ArrayList;

public class BrincandoDeGenerics {

    public static void main(String[] args) {
        ArrayList<Double> notas = new ArrayList<Double>();
        notas.add(7.5);
        notas.add(8.0);
        notas.add(10.0);
        notas.add(3.89);

        double soma = 0;
        for (int i = 0; i < notas.size(); i++) {
            double notaAtual = notas.get(i);
            soma += notaAtual;
        }
    }
}
