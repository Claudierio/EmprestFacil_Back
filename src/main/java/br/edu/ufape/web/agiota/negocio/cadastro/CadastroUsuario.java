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
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public CadastroUsuario(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario adicionarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new EmailAlreadyExistsException("O email já está em uso: " + usuario.getEmail());
        }

        // Criptografar a senha antes de salvar
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        return usuarioRepository.save(usuario);
    }
    public Usuario atualizarUsuario(Usuario usuario) {
        // Verifique se o usuário existe no banco de dados
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(usuario.getId());
        if (!usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + usuario.getId());
        }

        // Se o email foi alterado, verifique se o novo email já está em uso
        if (!usuarioExistente.get().getEmail().equals(usuario.getEmail())) {
            Optional<Usuario> emailExistente = usuarioRepository.findByEmail(usuario.getEmail());
            if (emailExistente.isPresent()) {
                throw new EmailAlreadyExistsException("O email já está em uso: " + usuario.getEmail());
            }
        }

        // Criptografar a nova senha, se fornecida
        if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        } else {
            // Se a senha não foi alterada, mantenha a senha antiga
            usuario.setSenha(usuarioExistente.get().getSenha());
        }

        return usuarioRepository.save(usuario);
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
