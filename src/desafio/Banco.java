package desafio;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static int AGENCIA_SEQUENCIAL = 1;
    private static int NUMERO_CONTA_SEQUENCIAL = 1;

    private String nome;
    private int agencia;
    private List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
        this.agencia = AGENCIA_SEQUENCIAL++;
    }

    public Conta criarContaCorrente(Cliente cliente) {
        return novaConta(new ContaCorrente(
            this.agencia,
            NUMERO_CONTA_SEQUENCIAL++,
            cliente)
        );
    }

    public Conta criarContaPoupanca(Cliente cliente) {
        return novaConta(new ContaPoupanca(
                this.agencia,
                NUMERO_CONTA_SEQUENCIAL++,
                cliente)
        );
    }

    private Conta novaConta(Conta novaConta) {
        this.contas.add(novaConta);
        return novaConta;
    }

    public void listarClientes() {
        System.out.println("=== Lista de clientes ===");
        contas.forEach(conta -> System.out.println(conta.cliente.getNome()));
    }

    public void listarTodasContasComClientes() {
        System.out.println("=== Lista de clientes com tipos de contas ===");
        contas.forEach(System.out::println);
    }

    public void listarContasCorrenteComClientes() {
        System.out.println("=== Lista conta corrente com clientes ===");
        contas.stream()
                .filter(conta -> conta instanceof ContaCorrente)
                .forEach(System.out::println);

    }

    public void listarContasPoupancaComClientes() {
        System.out.println("=== Lista conta poupança com clientes ===");
        contas.stream()
                .filter(conta -> conta instanceof ContaPoupanca)
                .forEach(System.out::println);

    }
}
