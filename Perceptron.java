package perceptron;
import java.util.Random;

/**
 *
 * @author Poliana
 */
public class Perceptron {

    double limite;
    double[] pesos;
    public void A(double[][] entradas, int[] saidas, double limite, double learnrate, int ciclos)
    {

        this.limite = limite;
        Random r = new Random(); // definido para gerar valores aleatórios
        int n = entradas[0].length; // n é o número de entradas
        int p = saidas.length; // p é o numero de saídas
        pesos = new double[n]; //o vetor peso tera tamanho N que é o numero de entradas
        
        //aqui gero os pesos aleatórios para começar
        for(int i=0;i<n;i++)
        {
            pesos[i] = r.nextDouble(); //armazeno os valores aleátorios no vetor peso
        }
        
        //
        for(int i=0;i<ciclos;i++) //para parar quando atingir o numero maximo de ciclos
        {
            int totalErro = 0; //inicia erro igual a 0
            for(int j =0;j<p;j++) //
            {
                int saida = Saida(entradas[j]); // aqui o vetor saida recebe o retorno da saida
                int erro = saidas[j] - saida; // aqui comparo com o valor esperado
                
                totalErro +=erro; //calculo o novo erro
               
                for(int k = 0;k<n;k++)
                {
                    double delta = learnrate * entradas[j][k] * erro; //cacula delta para 
                    pesos[k] += delta;
                }    
            }
            if(totalErro == 0) //quando total for zero, para de recalcular os pesos
                break;
        }
    }
    public int Saida (double[] entrada)
    {
        double soma = 0.0; //soma inicia com zero
        for(int i=0;i<entrada.length;i++) //para ao atingir o numero de entradas
        {  
            soma += pesos[i]*entrada[i]; // no final deste loop tera realizado somatoria das entradas multiplicadas pelos seus respectivos pesos
        }
        if(soma>limite) //se a somatoria for maior que o limite, entao retorna 1 se não retorna zero, pois é uma função degrau
            return 1;
        else
            return 0;
    }
}
