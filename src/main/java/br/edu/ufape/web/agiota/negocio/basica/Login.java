package br.edu.ufape.web.agiota.negocio.basica;

import br.edu.ufape.web.agiota.negocio.cadastro.CadastroUsuario;
import br.edu.ufape.web.agiota.negocio.cadastro.exception.LoginException;
import org.springframework.stereotype.Service;

@Service
public class Login {

    private final CadastroUsuario cadastroUsuario;


    public Login(CadastroUsuario cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;
    }

    public Usuario autenticar(String email, String senha) throws LoginException {
        return cadastroUsuario.buscarUsuarioPorEmail(email)
                .filter(usuario -> usuario.getSenha().equals(senha))
                .orElseThrow(() -> new LoginException("Credenciais inválidas"));
    }
}
