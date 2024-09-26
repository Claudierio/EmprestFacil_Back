package br.edu.ufape.web.agiota.negocio.cadastro;

import br.edu.ufape.web.agiota.dados.LoginRepository;
import br.edu.ufape.web.agiota.negocio.basica.Usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroLogin {

    @Autowired
    private LoginRepository loginRepository;

    public Optional<Usuario> autenticar(String email, String senha) {
        return loginRepository.findByEmailAndSenha(email, senha);
    }
}
