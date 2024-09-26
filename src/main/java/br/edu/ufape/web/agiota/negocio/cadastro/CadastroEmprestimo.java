package br.edu.ufape.web.agiota.negocio.cadastro;

import br.edu.ufape.web.agiota.negocio.basica.Emprestimo;
import br.edu.ufape.web.agiota.negocio.basica.Usuario;
import br.edu.ufape.web.agiota.negocio.basica.Agiota;
import java.util.List;

public class CadastroEmprestimo {
    private List<Emprestimo> emprestimos;

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public Emprestimo buscarEmprestimoPorId(Long id) {
        return emprestimos.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Emprestimo> buscarEmprestimosPorUsuario(Usuario usuario) {
        return emprestimos.stream().filter(e -> e.getUsuario().getId().equals(usuario.getId())).toList();
    }

    public List<Emprestimo> buscarEmprestimosPorAgiota(Agiota agiota) {
        return emprestimos.stream().filter(e -> e.getAgiota().getId().equals(agiota.getId())).toList();
    }

    public void atualizarEmprestimo(Emprestimo emprestimo) {
        Emprestimo e = buscarEmprestimoPorId(emprestimo.getId());
        if (e != null) {
            e.setValor(emprestimo.getValor());
            e.setDataVencimento(emprestimo.getDataVencimento());
            e.setParcelas(emprestimo.getParcelas());
        }
    }

    public void removerEmprestimo(Long id) {
        emprestimos.removeIf(e -> e.getId().equals(id));
    }
}
