package br.edu.ufape.web.agiota.negocio.fachada;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.web.agiota.negocio.basica.Avaliacao;
import br.edu.ufape.web.agiota.negocio.basica.Emprestimo;
import br.edu.ufape.web.agiota.negocio.basica.Relatorio;
import br.edu.ufape.web.agiota.negocio.basica.Transacao;
import br.edu.ufape.web.agiota.dados.AvaliacaoRepository;
import br.edu.ufape.web.agiota.dados.EmprestimoRepository;
import br.edu.ufape.web.agiota.dados.TransacaoRepository;
import br.edu.ufape.web.agiota.negocio.basica.*;
import br.edu.ufape.web.agiota.dados.PagamentoRepository;
import br.edu.ufape.web.agiota.dados.RelatorioRepository;
import br.edu.ufape.web.agiota.dados.NotificacaoRepository;

@Service
public class Fachada {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private RelatorioRepository relatorioRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    // Métodos para Emprestimo
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo localizarEmprestimoId(Long id) {
        return emprestimoRepository.findById(id).orElse(null);
    }

    public void removerEmprestimoId(Long id) {
        emprestimoRepository.deleteById(id);
    }

    // Métodos para Transacao
    public List<Transacao> listarTransacoes() {
        return transacaoRepository.findAll();
    }

    public Transacao salvarTransacao(Transacao transacao) {
        return transacaoRepository.save(transacao);
    }

    public Transacao localizarTransacaoId(Long id) {
        return transacaoRepository.findById(id).orElse(null);
    }

    public void removerTransacaoId(Long id) {
        transacaoRepository.deleteById(id);
    }

    // Métodos para Pagamentof
    public List<br.edu.ufape.web.agiota.negocio.basica.Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento salvarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public br.edu.ufape.web.agiota.negocio.basica.Pagamento localizarPagamentoId(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public void removerPagamentoId(Long id) {
        pagamentoRepository.deleteById(id);
    }

    // Métodos para Notificacao
    public List<br.edu.ufape.web.agiota.negocio.basica.Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Notificacao salvarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public br.edu.ufape.web.agiota.negocio.basica.Notificacao localizarNotificacaoId(Long id) {
        return notificacaoRepository.findById(id).orElse(null);
    }

    public void removerNotificacaoId(Long id) {
        notificacaoRepository.deleteById(id);
    }

    // Métodos para Relatorio
    public List<Relatorio> listarRelatorios() {
        return relatorioRepository.findAll();
    }

    public Relatorio salvarRelatorio(Relatorio relatorio) {
        return relatorioRepository.save(relatorio);
    }

    public Relatorio localizarRelatorioId(Long id) {
        return relatorioRepository.findById(id).orElse(null);
    }

    // Métodos para Avaliacao
    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao localizarAvaliacaoId(Long id) {
        return avaliacaoRepository.findById(id).orElse(null);
    }

    public void removerAvaliacaoId(Long id) {
        avaliacaoRepository.deleteById(id);
    }

    public Avaliacao salvarNotificacao(
           Avaliacao avaliacao) {
        return null;
    }
}