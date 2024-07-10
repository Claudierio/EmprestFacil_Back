package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.web.agiota.negocio.basica.Transacao;
import br.edu.ufape.web.agiota.negocio.basica.Emprestimo;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;
import br.edu.ufape.web.agiota.negocio.basica.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    public Fachada fachada;

    // Endpoints para Gestão de Empréstimos
    @GetMapping("/emprestimos")
    public List<Emprestimo> listarEmprestimos() {
        return fachada.listarEmprestimos();
    }

    @PostMapping("/emprestimos")
    public Emprestimo criarEmprestimo(@RequestBody Emprestimo emprestimo) {
        return fachada.salvarEmprestimo(emprestimo);
    }

    @GetMapping("/emprestimos/{id}")
    public Emprestimo exibirEmprestimo(@PathVariable long id) {
        return fachada.localizarEmprestimoId(id);
    }

    @PutMapping("/emprestimos/{id}")
    public Emprestimo atualizarEmprestimo(@PathVariable long id, @RequestBody Emprestimo emprestimo) {
        emprestimo.setId(id);
        return fachada.salvarEmprestimo(emprestimo);
    }

    @DeleteMapping("/emprestimos/{id}")
    public String apagarEmprestimo(@PathVariable long id) {
        fachada.removerEmprestimoId(id);
        return "Empréstimo removido com sucesso!";
    }

    // Endpoints para Transações

    @GetMapping("/transacoes")
    public List<Transacao> listarTransacoes() {
        return fachada.listarTransacoes();
    }

    @PostMapping("/transacoes")
    public Transacao criarTransacao(@RequestBody Transacao transacao) {
        return fachada.salvarTransacao(transacao);
    }

    @GetMapping("/transacoes/{id}")
    public Transacao exibirTransacao(@PathVariable long id) {
        return fachada.localizarTransacaoId(id);
    }

    @PutMapping("/transacoes/{id}")
    public Transacao atualizarTransacao(@PathVariable long id, @RequestBody Transacao transacao) {
        transacao.setId(id);
        return fachada.salvarTransacao(transacao);
    }

    @DeleteMapping("/transacoes/{id}")
    public String apagarTransacao(@PathVariable long id) {
        fachada.removerTransacaoId(id);
        return "ok";
    }

    // Endpoints para Pagamentos

    @GetMapping("/pagamentos")
    public List<br.edu.ufape.web.agiota.negocio.basica.Pagamento> listarPagamentos() {
        return fachada.listarPagamentos();
    }

    @PostMapping("/pagamentos")
    public Pagamento criarPagamento(@RequestBody Pagamento pagamento) {
        return fachada.salvarPagamento(pagamento);
    }

    @GetMapping("/pagamentos/{id}")
    public br.edu.ufape.web.agiota.negocio.basica.Pagamento exibirPagamento(@PathVariable long id) {
        return fachada.localizarPagamentoId(id);
    }

    @PutMapping("/pagamentos/{id}")
    public Pagamento atualizarPagamento(@PathVariable long id, @RequestBody Pagamento pagamento) {
        pagamento.setId(id);
        return fachada.salvarPagamento(pagamento);
    }

    @DeleteMapping("/pagamentos/{id}")
    public String apagarPagamento(@PathVariable long id) {
        fachada.removerPagamentoId(id);
        return "ok";
    }

    // Endpoints para Notificações

    @GetMapping("/notificacoes")
    public List<br.edu.ufape.web.agiota.negocio.basica.Notificacao> listarNotificacoes() {
        return fachada.listarNotificacoes();
    }

    @PostMapping("/notificacoes")
    public Notificacao criarNotificacao(@RequestBody Notificacao notificacao) {
        return fachada.salvarNotificacao(notificacao);
    }

    @GetMapping("/notificacoes/{id}")
    public br.edu.ufape.web.agiota.negocio.basica.Notificacao exibirNotificacao(@PathVariable long id) {
        return fachada.localizarNotificacaoId(id);
    }

    @DeleteMapping("/notificacoes/{id}")
    public String apagarNotificacao(@PathVariable long id) {
        fachada.removerNotificacaoId(id);
        return "ok";
    }

    // Endpoints para Relatórios

    @GetMapping("/relatorios")
    public List<br.edu.ufape.web.agiota.negocio.basica.Relatorio> listarRelatorios() {
        return fachada.listarRelatorios();
    }

    @PostMapping("/relatorios")
    public br.edu.ufape.web.agiota.negocio.basica.Relatorio criarRelatorio(@RequestBody Relatorio relatorio) {
        return fachada.salvarRelatorio(relatorio);
    }

    @GetMapping("/relatorios/{id}")
    public br.edu.ufape.web.agiota.negocio.basica.Relatorio exibirRelatorio(@PathVariable long id) {
        return fachada.localizarRelatorioId(id);
    }

    // Endpoints para Avaliações

    @GetMapping("/avaliacoes")
    public List<br.edu.ufape.web.agiota.negocio.basica.Avaliacao> listarAvaliacoes() {
        return fachada.listarAvaliacoes();
    }

    @PostMapping("/avaliacoes")
    public Avaliacao criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        return fachada.salvarNotificacao(avaliacao);
    }

    @GetMapping("/avaliacoes/{id}")
    public br.edu.ufape.web.agiota.negocio.basica.Avaliacao exibirAvaliacao(@PathVariable long id) {
        return fachada.localizarAvaliacaoId(id);
    }

    @PutMapping("/avaliacoes/{id}")
    public Avaliacao atualizarAvaliacao(@PathVariable long id, @RequestBody Avaliacao avaliacao) {
        avaliacao.setId(id);
        return fachada.salvarNotificacao(avaliacao);
    }

    @DeleteMapping("/avaliacoes/{id}")
    public String apagarAvaliacao(@PathVariable long id) {
        fachada.removerAvaliacaoId(id);
        return "Avaliação removida com sucesso!";
    }
}
