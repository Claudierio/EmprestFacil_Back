
package br.edu.ufape.web.agiota.negocio.cadastro;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.web.agiota.dados.*;
import br.edu.ufape.web.agiota.negocio.basica.*;
@Service
public class CadastroAvaliacao {
    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<br.edu.ufape.web.agiota.negocio.basica.Avaliacao> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao localizarAvaliacaoId(Long id) {
        Optional<Avaliacao> avaliacao = Optional.empty();
        return avaliacao.orElseThrow();
    }

    public void removerAvaliacaoId(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}
