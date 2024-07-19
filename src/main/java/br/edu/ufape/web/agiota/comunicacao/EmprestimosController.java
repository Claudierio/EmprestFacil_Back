package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.web.agiota.negocio.basica.Emprestimo;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;

@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimosController {
    @Autowired
    private Fachada fachada;

    @GetMapping
    public List<Emprestimo> listarEmprestimos() {
        return fachada.listarEmprestimos();
    }

    @PostMapping
    public Emprestimo criarEmprestimo(@RequestBody Emprestimo emprestimo) {
        return fachada.salvarEmprestimo(emprestimo);
    }

    @GetMapping("/{id}")
    public Emprestimo exibirEmprestimo(@PathVariable long id) {
        return fachada.localizarEmprestimoId(id);
    }

    @PutMapping("/{id}")
    public Emprestimo atualizarEmprestimo(@PathVariable long id, @RequestBody Emprestimo emprestimo) {
        emprestimo.setId(id);
        return fachada.salvarEmprestimo(emprestimo);
    }

    @DeleteMapping("/{id}")
    public String apagarEmprestimo(@PathVariable long id) {
        fachada.removerEmprestimoId(id);
        return "Empréstimo removido com sucesso!";
    }
}
