
package br.edu.ufape.web.agiota.negocio.cadastro.exception;


public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException(Double saldoAtual, Double valorPagamento) {
        super("Saldo insuficiente: Saldo atual (" + saldoAtual + ") é menor que o valor do pagamento (" + valorPagamento
                + ").");
    }
}
