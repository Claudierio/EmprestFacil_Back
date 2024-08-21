package br.edu.ufape.web.agiota.comunicacao;

import br.edu.ufape.web.agiota.negocio.basica.Usuario;
import br.edu.ufape.web.agiota.negocio.cadastro.CadastroUsuario;
import br.edu.ufape.web.agiota.negocio.cadastro.exception.EmailAlreadyExistsException;
import br.edu.ufape.web.agiota.negocio.cadastro.exception.SenhaNaoConfereException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    private final CadastroUsuario cadastroUsuario;

    public UsuariosController(CadastroUsuario cadastroUsuario) {
        this.cadastroUsuario = cadastroUsuario;
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return cadastroUsuario.listarUsuarios();
    }

    @PostMapping
    public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario novoUsuario = cadastroUsuario.adicionarUsuario(usuario);
            return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
        } catch (EmailAlreadyExistsException | SenhaNaoConfereException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("/{id}")
    public Usuario exibirUsuario(@PathVariable long id) {
        return cadastroUsuario.buscarUsuarioPorId(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return cadastroUsuario.adicionarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public String apagarUsuario(@PathVariable long id) {
        cadastroUsuario.deletarUsuario(id);
        return "Usuário removido com sucesso!";
    }
}
