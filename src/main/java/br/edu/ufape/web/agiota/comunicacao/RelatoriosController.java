package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.web.agiota.negocio.basica.Relatorio;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/relatorios")
public class RelatoriosController {
    @Autowired
    private Fachada fachada;

    @GetMapping
    public List<Relatorio> listarRelatorios() {
        return fachada.listarRelatorios();
    }

    @PostMapping
    public Relatorio criarRelatorio(@RequestBody Relatorio relatorio) {
        return fachada.salvarRelatorio(relatorio);
    }

    @GetMapping("/{id}")
    public Relatorio exibirRelatorio(@PathVariable long id) {
        return fachada.localizarRelatorioId(id);
    }
}
