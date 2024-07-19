package br.edu.ufape.web.agiota.negocio.cadastro;

import br.edu.ufape.web.agiota.negocio.basica.Usuario;
import java.util.List;

public class CadastroUsuario {
    private List<Usuario> usuarios;

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public void atualizarUsuario(Usuario usuario) {
        Usuario u = buscarUsuarioPorId(usuario.getId());
        if (u != null) {
            u.setNome(usuario.getNome());
            u.setEmail(usuario.getEmail());
            u.setSenha(usuario.getSenha());
        }
    }

    public void removerUsuario(Long id) {
        usuarios.removeIf(u -> u.getId().equals(id));
    }
}
