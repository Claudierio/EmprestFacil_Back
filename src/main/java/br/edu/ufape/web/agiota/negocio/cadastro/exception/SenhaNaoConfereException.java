package br.edu.ufape.web.agiota.negocio.cadastro.exception;

public class SenhaNaoConfereException extends RuntimeException {
    public SenhaNaoConfereException(String mensagem) {
        super(mensagem);
    }
}
