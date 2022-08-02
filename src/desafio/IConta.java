package desafio;

import desafio.excecoes.SaldoInsuficienteException;
import desafio.excecoes.ValorInvalidoException;

public interface IConta {

     boolean sacar(double valor) throws ValorInvalidoException, SaldoInsuficienteException;
     boolean depositar(double valor) throws ValorInvalidoException;
     boolean transferir(double valor, Conta contaDestino) throws SaldoInsuficienteException, ValorInvalidoException;
     void imprimirExtrato();

}
