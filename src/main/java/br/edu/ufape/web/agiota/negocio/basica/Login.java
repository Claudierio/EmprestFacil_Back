package br.edu.ufape.web.agiota.negocio.basica;

import br.edu.ufape.web.agiota.negocio.cadastro.CadastroUsuario;
import br.edu.ufape.web.agiota.negocio.cadastro.exception.LoginException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Login {
    private final CadastroUsuario cadastroUsuario;
    private final PasswordEncoder passwordEncoder;

    public Login(CadastroUsuario cadastroUsuario, PasswordEncoder passwordEncoder) {
        this.cadastroUsuario = cadastroUsuario;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario autenticar(String email, String senha) throws LoginException {
        System.out.println("Método autenticar chamado com email: " + email);
        return cadastroUsuario.buscarUsuarioPorEmail(email)
                .map(usuario -> {
                    boolean matches = passwordEncoder.matches(senha, usuario.getSenha());
                    System.out.println("Senha fornecida: " + senha);
                    System.out.println("Senha armazenada: " + usuario.getSenha());
                    System.out.println("Resultado da comparação: " + matches);
                    if (!matches) {
                        throw new LoginException("Credenciais inválidas");
                    }
                    return usuario;
                })
                .orElseThrow(() -> new LoginException("Credenciais inválidas"));
    }

}
