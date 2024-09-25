package br.edu.ufape.web.agiota.negocio.fachada;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.web.agiota.negocio.basica.*;
import br.edu.ufape.web.agiota.negocio.cadastro.exception.LoginException;
import br.edu.ufape.web.agiota.dados.*;

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

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AgiotaRepository agiotaRepository;
    
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

    // Métodos para Pagamento
    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public Pagamento salvarPagamento(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    public Pagamento localizarPagamentoId(Long id) {
        return pagamentoRepository.findById(id).orElse(null);
    }

    public void removerPagamentoId(Long id) {
        pagamentoRepository.deleteById(id);
    }

    // Métodos para Notificacao
    public List<Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Notificacao salvarNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao localizarNotificacaoId(Long id) {
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

    public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    // Métodos para Usuario
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario localizarUsuarioId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void removerUsuarioId(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Métodos para Agiota
    public List<Agiota> listarAgiotas() {
        return agiotaRepository.findAll();
    }

    public Agiota salvarAgiota(Agiota agiota) {
        return agiotaRepository.save(agiota);
    }

    public Agiota localizarAgiotaId(Long id) {
        return agiotaRepository.findById(id).orElse(null);
    }

    public void removerAgiotaId(Long id) {
        agiotaRepository.deleteById(id);
    }
}
