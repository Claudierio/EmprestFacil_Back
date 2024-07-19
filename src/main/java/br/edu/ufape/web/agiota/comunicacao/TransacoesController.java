package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.web.agiota.negocio.basica.Transacao;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/transacoes")
public class TransacoesController {
    @Autowired
    private Fachada fachada;

    @GetMapping
    public List<Transacao> listarTransacoes() {
        return fachada.listarTransacoes();
    }

    @PostMapping
    public Transacao criarTransacao(@RequestBody Transacao transacao) {
        return fachada.salvarTransacao(transacao);
    }

    @GetMapping("/{id}")
    public Transacao exibirTransacao(@PathVariable long id) {
        return fachada.localizarTransacaoId(id);
    }

    @PutMapping("/{id}")
    public Transacao atualizarTransacao(@PathVariable long id, @RequestBody Transacao transacao) {
        transacao.setId(id);
        return fachada.salvarTransacao(transacao);
    }

    @DeleteMapping("/{id}")
    public String apagarTransacao(@PathVariable long id) {
        fachada.removerTransacaoId(id);
        return "Transação removida com sucesso!";
    }
}
