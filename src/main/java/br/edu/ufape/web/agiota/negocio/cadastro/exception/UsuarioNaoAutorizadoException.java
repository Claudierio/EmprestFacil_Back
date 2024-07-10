package br.edu.ufape.web.agiota.negocio.cadastro.exception;
public class UsuarioNaoAutorizadoException extends RuntimeException {
    public UsuarioNaoAutorizadoException(String mensagem) {
        super("Usuário não autorizado: " + mensagem);
    }
}
