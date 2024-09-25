package br.edu.ufape.web.agiota.negocio.cadastro;

import br.edu.ufape.web.agiota.dados.UsuarioRepository;
import br.edu.ufape.web.agiota.negocio.basica.Usuario;
import br.edu.ufape.web.agiota.negocio.cadastro.exception.EmailAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroUsuario {

    private final UsuarioRepository usuarioRepository;


    @Autowired
    public CadastroUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new EmailAlreadyExistsException("O email já está em uso: " + usuario.getEmail());
        }

        // Criptografar a senha antes de salvar
   

        return usuarioRepository.save(usuario);
    }
    public Usuario atualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuario.getId());

        if (usuarioExistente.isPresent()) {
            Usuario usuarioAtualizado = usuarioExistente.get();
            usuarioAtualizado.setNome(usuario.getNome());
            usuarioAtualizado.setEmail(usuario.getEmail());

            usuarioAtualizado.setDataNascimento(usuario.getDataNascimento());
            usuarioAtualizado.setRole(usuario.getRole());
            return usuarioRepository.save(usuarioAtualizado);
        }
        throw new RuntimeException("Usuário não encontrado.");
    }



    public Optional<Usuario> buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
