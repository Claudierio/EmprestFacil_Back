package br.edu.ufape.web.agiota.negocio.cadastro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.web.agiota.dados.*;
import br.edu.ufape.web.agiota.negocio.basica.*;
@Service
public class CadastroPagamento {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<br.edu.ufape.web.agiota.negocio.basica.Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento salvarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public br.edu.ufape.web.agiota.negocio.basica.Pagamento localizarPagamentoId(Long id) {
        return pagamentoRepository.findById(id).orElseThrow();
    }

    public void removerPagamentoId(Long id) {
        pagamentoRepository.deleteById(id);
    }
}
