package br.edu.ufape.web.agiota.comunicacao;

import br.edu.ufape.web.agiota.negocio.basica.Usuario;
import br.edu.ufape.web.agiota.negocio.cadastro.CadastroUsuario;
import br.edu.ufape.web.agiota.negocio.cadastro.exception.LoginException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private final CadastroUsuario cadastroUsuario;
    private final PasswordEncoder passwordEncoder;

    public LoginController(CadastroUsuario cadastroUsuario, PasswordEncoder passwordEncoder) {
        this.cadastroUsuario = cadastroUsuario;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<Usuario> login(@RequestBody LoginRequest loginRequest) {
        try {
            Optional<Usuario> usuarioOpt = cadastroUsuario.buscarUsuarioPorEmail(loginRequest.getEmail());
            
            if (usuarioOpt.isPresent()) {
                Usuario usuario = usuarioOpt.get();
                
                // Verifica se a senha fornecida corresponde ao hash armazenado
                if (passwordEncoder.matches(loginRequest.getSenha(), usuario.getSenha())) {
                    return ResponseEntity.ok(usuario);
                } else {
                    throw new LoginException("Credenciais inválidas");
                }
            } else {
                throw new LoginException("Credenciais inválidas");
            }
        } catch (LoginException e) {
            return ResponseEntity.status(401).body(null);
        }
    }

    public static class LoginRequest {
        private String email;
        private String senha;

        // Getters and Setters
        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }
}
