package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.web.agiota.negocio.basica.Avaliacao;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacoesController {
    @Autowired
    private Fachada fachada;

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() {
        return fachada.listarAvaliacoes();
    }

    @PostMapping
    public Avaliacao criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        return fachada.salvarAvaliacao(avaliacao);
    }

    @GetMapping("/{id}")
    public Avaliacao exibirAvaliacao(@PathVariable long id) {
        return fachada.localizarAvaliacaoId(id);
    }

    @PutMapping("/{id}")
    public Avaliacao atualizarAvaliacao(@PathVariable long id, @RequestBody Avaliacao avaliacao) {
        avaliacao.setId(id);
        return fachada.salvarAvaliacao(avaliacao);
    }

    @DeleteMapping("/{id}")
    public String apagarAvaliacao(@PathVariable long id) {
        fachada.removerAvaliacaoId(id);
        return "Avaliação removida com sucesso!";
    }
}
