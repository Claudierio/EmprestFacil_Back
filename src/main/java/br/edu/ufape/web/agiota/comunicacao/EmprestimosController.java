package br.edu.ufape.web.agiota.comunicacao;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.web.agiota.negocio.basica.Emprestimo;
import br.edu.ufape.web.agiota.negocio.basica.Usuario;
import br.edu.ufape.web.agiota.negocio.basica.Agiota;
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

    @GetMapping("/{id}/all")
    public List<Emprestimo> listarEmprestimosById(int Id) {
        return fachada.listarEmprestimos();
    }

    @PostMapping
    public Emprestimo criarEmprestimo(@RequestBody Map<String, Object> payload) {
        Long usuarioId = Long.valueOf(payload.get("usuario").toString());
        Long agiotaId = Long.valueOf(payload.get("agiota").toString());
        Usuario usuario = fachada.localizarUsuarioId(usuarioId);
        Agiota agiota = fachada.localizarAgiotaId(agiotaId);
        if (usuario == null || agiota == null) {
            throw new IllegalArgumentException("Usuário ou agiota inválido");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setAgiota(agiota);
        emprestimo.setValor(Double.parseDouble(payload.get("valorEmprestado").toString()));
        emprestimo.setDataVencimento(payload.get("dataVencimento").toString());
        emprestimo.setDataEmprestimo(payload.get("dataEmprestimo").toString());
        emprestimo.setParcelas(Integer.parseInt(payload.get("parcelas").toString()));
        System.out.println(emprestimo.getAgiota().getNome());
        return fachada.salvarEmprestimo(emprestimo);
    }

    @GetMapping("/{id}")
    public Emprestimo exibirEmprestimo(@PathVariable long id) {
        return fachada.localizarEmprestimoId(id);
    }

    @PutMapping("/{id}")
    public Emprestimo atualizarEmprestimo(@PathVariable long id, @RequestBody Map<String, Object> payload) {
        Emprestimo emprestimoExistente = fachada.localizarEmprestimoId(id);

        if (emprestimoExistente == null) {
            throw new IllegalArgumentException("Empréstimo não encontrado");
        }
        Long usuarioId = Long.valueOf(payload.get("usuario").toString());
        Long agiotaId = Long.valueOf(payload.get("agiota").toString());
        Usuario usuario = fachada.localizarUsuarioId(usuarioId);
        Agiota agiota = fachada.localizarAgiotaId(agiotaId);

        if (usuario == null || agiota == null) {
            throw new IllegalArgumentException("Usuário ou agiota inválido");
        }

        emprestimoExistente.setUsuario(usuario);
        emprestimoExistente.setAgiota(agiota);
        emprestimoExistente.setValor(Double.parseDouble(payload.get("valorEmprestado").toString()));
        emprestimoExistente.setDataVencimento(payload.get("dataVencimento").toString());
        emprestimoExistente.setParcelas(Integer.parseInt(payload.get("parcelas").toString()));

        return fachada.salvarEmprestimo(emprestimoExistente);
    }

    @DeleteMapping("/{id}")
    public String apagarEmprestimo(@PathVariable long id) {
        fachada.removerEmprestimoId(id);
        return "Empréstimo removido com sucesso!";
    }
}