
package br.edu.ufape.web.agiota.negocio.cadastro.exception;

public class EmprestimoNaoEncontradoException extends RuntimeException {
    public EmprestimoNaoEncontradoException(Long id) {
        super("Empréstimo não encontrado: " + id);
    }
}
