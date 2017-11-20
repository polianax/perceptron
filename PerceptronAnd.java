package perceptron;

/**
 *
 * @author Poliana
 */
public class PerceptronAnd {
    
    public static void main(String[] args) {
        Perceptron perc = new Perceptron();
        double entradas[][] = {{1,1},{1,0},{0,1},{0,0}};
        int saidas[] = {1,0,0,0};

        perc.A(entradas, saidas,0.1, 0.05, 500);
        System.out.println(perc.Saida(new double[]{1,1}));
        System.out.println(perc.Saida(new double[]{1,0}));
        System.out.println(perc.Saida(new double[]{0,1}));
        System.out.println(perc.Saida(new double[]{0,0}));
    }
}
