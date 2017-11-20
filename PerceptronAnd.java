package perceptron;

/**
 *
 * @author Poliana
 */
public class PerceptronAnd {
    
    public static void main(String[] args) {
        Perceptron p = new Perceptron();
        double entradas[][] = {{1,1},{0,1},{1,0},{0,0}};
        int saidas[] = {0,0,0,1};

        p.A(entradas, saidas,0.2, 0.1, 200);
        System.out.println(p.Saida(new double[]{0,0}));
        System.out.println(p.Saida(new double[]{1,0}));
        System.out.println(p.Saida(new double[]{0,1}));
        System.out.println(p.Saida(new double[]{1,1}));
    }
}
