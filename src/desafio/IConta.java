package desafio;


public interface IConta {

     boolean sacar(double valor);
     boolean depositar(double valor);
     boolean transferir(double valor, Conta contaDestino);
     void imprimirExtrato();

}
