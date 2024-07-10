package br.edu.ufape.web.agiota.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.web.agiota.dados.*;

import br.edu.ufape.web.agiota.negocio.basica.*;

@Service
public class CadastroNotificacao {
    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public List<br.edu.ufape.web.agiota.negocio.basica.Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Notificacao salvarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public br.edu.ufape.web.agiota.negocio.basica.Notificacao localizarNotificacaoId(Long id) {
        return notificacaoRepository.findById(id).orElseThrow();
    }

    public void removerNotificacaoId(Long id) {
        notificacaoRepository.deleteById(id);
    }
}
