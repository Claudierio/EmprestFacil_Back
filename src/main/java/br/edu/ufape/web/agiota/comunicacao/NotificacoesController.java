package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.web.agiota.negocio.basica.Notificacao;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/notificacoes")
public class NotificacoesController {
    @Autowired
    private Fachada fachada;

    @GetMapping
    public List<Notificacao> listarNotificacoes() {
        return fachada.listarNotificacoes();
    }

    @PostMapping
    public Notificacao criarNotificacao(@RequestBody Notificacao notificacao) {
        return fachada.salvarNotificacao(notificacao);
    }

    @GetMapping("/{id}")
    public Notificacao exibirNotificacao(@PathVariable long id) {
        return fachada.localizarNotificacaoId(id);
    }

    @DeleteMapping("/{id}")
    public String apagarNotificacao(@PathVariable long id) {
        fachada.removerNotificacaoId(id);
        return "Notificação removida com sucesso!";
    }
}
