package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.web.agiota.negocio.basica.Pagamento;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentosController {
    @Autowired
    private Fachada fachada;

    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return fachada.listarPagamentos();
    }

    @PostMapping
    public Pagamento criarPagamento(@RequestBody Pagamento pagamento) {
        return fachada.salvarPagamento(pagamento);
    }

    @GetMapping("/{id}")
    public Pagamento exibirPagamento(@PathVariable long id) {
        return fachada.localizarPagamentoId(id);
    }

    @PutMapping("/{id}")
    public Pagamento atualizarPagamento(@PathVariable long id, @RequestBody Pagamento pagamento) {
        pagamento.setId(id);
        return fachada.salvarPagamento(pagamento);
    }

    @DeleteMapping("/{id}")
    public String apagarPagamento(@PathVariable long id) {
        fachada.removerPagamentoId(id);
        return "Pagamento removido com sucesso!";
    }
}
