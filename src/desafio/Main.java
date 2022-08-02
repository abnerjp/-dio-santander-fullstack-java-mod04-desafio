package desafio;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Fulano");
        Cliente cliente2 = new Cliente("Ciclano");

        Banco bancoDoPais = new Banco("Banco do País");
        Conta contaCorrenteCli1 = bancoDoPais.criarContaCorrente(cliente1);
        Conta contaPoupancaCli2 = bancoDoPais.criarContaPoupanca(cliente2);

        contaCorrenteCli1.depositar(100);
        contaCorrenteCli1.transferir(30, contaPoupancaCli2);
        contaCorrenteCli1.depositar(1);

        contaCorrenteCli1.imprimirExtrato();
        contaCorrenteCli1.imprimirMovimentacoes();

        contaPoupancaCli2.imprimirExtrato();
        contaPoupancaCli2.imprimirMovimentacoes();

        bancoDoPais.listarClientes();
        bancoDoPais.listarTodasContasComClientes();
        bancoDoPais.listarContasCorrenteComClientes();
        bancoDoPais.listarContasPoupancaComClientes();

    }
}
