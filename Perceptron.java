
package perceptron;
import java.util.Random;

/**
 *
 * @author Poliana
 */
public class Perceptron {

    double[] pesos;
    double threshold;
    public void A(double[][] entradas, int[] saidas, double threshold, double lrate, int ciclos)
    {

        this.threshold = threshold;
        int n = entradas[0].length;
        int p = saidas.length;
        pesos = new double[n];
        Random r = new Random();
        
        //aqui inicio os pesos
        for(int i=0;i<n;i++)
        {
            pesos[i] = r.nextDouble();
        }

        for(int i=0;i<ciclos;i++)
        {
            int totalErro = 0;
            for(int j =0;j<p;j++)
            {
                int saida = Saida(entradas[j]);
                int erro = saidas[j] - saida;
                
                totalErro +=erro;
               
                for(int k = 0;k<n;k++)
                {
                    double delta = lrate * entradas[j][k] * erro;
                    pesos[k] += delta;
                }
                
                
            }
            if(totalErro == 0)
                break;
        }

    }

    public int Saida (double[] entrada)
    {
        double soma = 0.0;
        for(int i=0;i<entrada.length;i++)
        {
            soma += pesos[i]*entrada[i];
        }

        if(soma>threshold)
            return 1;
        else
            return 0;
    }

        
}
