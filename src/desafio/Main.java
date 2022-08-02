package desafio;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Abner");
        Cliente cliente2 = new Cliente("Davi");

        Banco bancoBrasil = new Banco("Banco do Brasil");
        Conta contaCorrenteCli1 = bancoBrasil.criarContaCorrente(cliente1);
        Conta contaPoupancaCli2 = bancoBrasil.criarContaPoupanca(cliente2);

        contaCorrenteCli1.depositar(100);
        contaCorrenteCli1.transferir(30, contaPoupancaCli2);
        contaCorrenteCli1.depositar(1);

        contaCorrenteCli1.imprimirExtrato();
        contaCorrenteCli1.imprimirMovimentacoes();

        contaPoupancaCli2.imprimirExtrato();
        contaPoupancaCli2.imprimirMovimentacoes();

        bancoBrasil.listarClientes();
        bancoBrasil.listarTodasContasComClientes();
        bancoBrasil.listarContasCorrenteComClientes();
        bancoBrasil.listarContasPoupancaComClientes();

    }
}
