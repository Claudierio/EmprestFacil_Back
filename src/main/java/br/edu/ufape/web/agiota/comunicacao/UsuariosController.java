package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.web.agiota.negocio.basica.Usuario;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {
    @Autowired
    private Fachada fachada;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return fachada.listarUsuarios();
    }

    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return fachada.salvarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public Usuario exibirUsuario(@PathVariable long id) {
        return fachada.localizarUsuarioId(id);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return fachada.salvarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public String apagarUsuario(@PathVariable long id) {
        fachada.removerUsuarioId(id);
        return "Usuário removido com sucesso!";
    }
}
