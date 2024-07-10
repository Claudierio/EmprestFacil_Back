package br.edu.ufape.web.agiota.negocio.cadastro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.web.agiota.dados.*;
import br.edu.ufape.web.agiota.negocio.basica.*;

@Service
public class CadastroTransacao {
    @Autowired
    private TransacaoRepository transacaoRepository;

    public List<br.edu.ufape.web.agiota.negocio.basica.Transacao> listarTransacoes() {
        return transacaoRepository.findAll();
    }

    public Transacao salvarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public br.edu.ufape.web.agiota.negocio.basica.Transacao localizarTransacaoId(Long id) {
        return transacaoRepository.findById(id).orElseThrow();
    }

    public void removerTransacaoId(Long id) {
        transacaoRepository.deleteById(id);
    }
}
