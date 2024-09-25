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

    @PostMapping
    public Emprestimo criarEmprestimo(@RequestBody Map<String, Object> payload) {
        // Obtendo IDs de usuario e agiota do payload
        Long usuarioId = Long.valueOf(payload.get("usuario").toString());
        Long agiotaId = Long.valueOf(payload.get("agiota").toString());

        // Buscando Usuario e Agiota pelo ID
        Usuario usuario = fachada.localizarUsuarioId(usuarioId);
        Agiota agiota = fachada.localizarAgiotaId(agiotaId);
        // Validação dos IDs de usuario e agiota
        if (usuario == null || agiota == null) {
            throw new IllegalArgumentException("Usuário ou agiota inválido");
        }

        // Criando novo empréstimo
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setAgiota(agiota);
        emprestimo.setValor(Double.parseDouble(payload.get("valorEmprestado").toString()));
        emprestimo.setTaxaJuros(Double.parseDouble(payload.get("taxaJuros").toString()));
        emprestimo.setDataVencimento(payload.get("dataVencimento").toString());
        emprestimo.setParcelas(Integer.parseInt(payload.get("parcelas").toString()));
        System.out.println(emprestimo.getAgiota().getNome());
        // Salvando empréstimo
        return fachada.salvarEmprestimo(emprestimo);
    }

    @GetMapping("/{id}")
    public Emprestimo exibirEmprestimo(@PathVariable long id) {
        return fachada.localizarEmprestimoId(id);
    }

    @PutMapping("/{id}")
    public Emprestimo atualizarEmprestimo(@PathVariable long id, @RequestBody Map<String, Object> payload) {
        // Buscando o empréstimo existente
        Emprestimo emprestimoExistente = fachada.localizarEmprestimoId(id);

        if (emprestimoExistente == null) {
            throw new IllegalArgumentException("Empréstimo não encontrado");
        }

        // Obtendo IDs de usuario e agiota do payload
        Long usuarioId = Long.valueOf(payload.get("usuario").toString());
        Long agiotaId = Long.valueOf(payload.get("agiota").toString());

        // Buscando Usuario e Agiota pelo ID
        Usuario usuario = fachada.localizarUsuarioId(usuarioId);
        Agiota agiota = fachada.localizarAgiotaId(agiotaId);

        // Validação dos IDs de usuario e agiota
        if (usuario == null || agiota == null) {
            throw new IllegalArgumentException("Usuário ou agiota inválido");
        }

        // Atualizando os dados do empréstimo
        emprestimoExistente.setUsuario(usuario);
        emprestimoExistente.setAgiota(agiota);
        emprestimoExistente.setValor(Double.parseDouble(payload.get("valorEmprestado").toString()));
        emprestimoExistente.setTaxaJuros(Double.parseDouble(payload.get("taxaJuros").toString()));
        emprestimoExistente.setDataVencimento(payload.get("dataVencimento").toString());
        emprestimoExistente.setParcelas(Integer.parseInt(payload.get("parcelas").toString()));

        // Salvando as alterações
        return fachada.salvarEmprestimo(emprestimoExistente);
    }

    @DeleteMapping("/{id}")
    public String apagarEmprestimo(@PathVariable long id) {
        fachada.removerEmprestimoId(id);
        return "Empréstimo removido com sucesso!";
    }
}
