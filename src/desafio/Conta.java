package desafio;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta {


    protected Integer agencia;
    protected Integer numeroConta;
    protected double saldo;
    protected Cliente cliente;
    protected List<String> movimentacoes = new ArrayList<>();

    public Conta(int agencia, int numeroConta, Cliente cliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.registrarInfo(String.format("conta criada, saldo: %.2f", this.getSaldo()));
    }

    @Override
    public boolean sacar(double valor) {
        boolean possivelSacar = this.saquePossivel(valor);
        if (possivelSacar) {
            this.saldo -= valor;
            this.registrarSaque(valor);
        }
        return possivelSacar;
    }

    @Override
    public boolean depositar(double valor) {
        boolean depositoPossivel = this.depositoPossivel(valor);
        if (depositoPossivel) {
            this.saldo += valor;
            this.registrarDeposito(valor);
        }
        return depositoPossivel;
    }

    @Override
    public boolean transferir(double valor, Conta contaDestino) {
        if (contaDestino == null) return false;

        boolean saqueRealizado = this.sacar(valor);
        boolean depositoRealizado = false;
        if (saqueRealizado) {
            depositoRealizado = contaDestino.depositar(valor);
            if (!depositoRealizado) {
                this.depositar(valor);
            }
        }
        return saqueRealizado && depositoRealizado;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numeroConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

    public void imprimirMovimentacoes() {
        System.out.println(String.format("==== Movimentações - Agência: %d, Conta: %d ====",
                this.getAgencia(), this.getNumeroConta()));
        movimentacoes.forEach(reg -> System.out.println("  " + reg));
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    private boolean saquePossivel(double valor) {
        return valor > 0 && this.saldo >= valor;
    }

    private boolean depositoPossivel(double valor) {
        return valor > 0;
    }


    private void registrarInfo(String msg) {
        this.movimentacoes.add("(i) "+ LocalDateTime.now() + " - " + msg);
    }

    private void registrarSaque(double valor) {
        this.movimentacoes.add(String.format("(-) %s - valor retirado: %.2f, saldo atual: %.2f",
                LocalDateTime.now(), valor, this.getSaldo()));
    }

    private void registrarDeposito(double valor) {
        this.movimentacoes.add(String.format("(+) %s - valor depositado: %.2f, saldo atual: %.2f",
                LocalDateTime.now(), valor, this.getSaldo()));
    }

    @Override
    public String toString() {
        return "Conta Bancária - Cliente: " + this.cliente.getNome();
    }

}
