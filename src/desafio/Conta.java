import desafio.IConta;

public abstract class Conta implements IConta {

    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected Integer agencia;
    protected Integer numero;
    protected double saldo;

    public Conta() {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

}
