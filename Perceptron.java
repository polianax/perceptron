package perceptron;
import java.util.Random;
/**
 *
 * @author Poliana
 */
public class Perceptron {

    double limite;
    double[] pesos;
    public void A(double[][] entradas, int[] saidas, double limite, double aprendizado, int ciclos)
    {

        this.limite = limite;
        Random r = new Random(); // definido para gerar valores aleatórios
        int e = entradas[0].length; // n é o número de entradas
        int s = saidas.length; // s é o numero de saídas
        pesos = new double[e]; //o vetor peso tera tamanho E que é o numero de entradas
        
        //aqui gero os pesos aleatórios para começar
        for(int i=0;i<e;i++)
        {
            pesos[i] = r.nextDouble(); //armazeno os valores aleátorios no vetor peso
        }
        
        //
        for(int i=0;i<ciclos;i++) //para parar quando atingir o numero maximo de ciclos
        {
            int totalErro = 0; //inicia erro igual a 0
            for(int j =0;j<s;j++) //
            {
                int saida = Saida(entradas[j]); // aqui o vetor saida recebe o retorno da função de ativação
                int erro = saidas[j] - saida; // aqui calculo o erro: valor esperado - valor calculado
                
                totalErro +=erro; //totalErro recebe o erro calculado acima
            
                for(int k = 0;k<e;k++)
                {
                    double delta = pesos[k] + aprendizado * entradas[j][k] * erro; //cacula delta para usar em pesos
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
