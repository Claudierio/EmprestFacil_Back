package br.edu.ufape.web.agiota.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.web.agiota.negocio.basica.Emprestimo;
import br.edu.ufape.web.agiota.dados.EmprestimoRepository;
import br.edu.ufape.web.agiota.negocio.cadastro.exception.EmprestimoNaoEncontradoException;

@Service
public class CadastroEmprestimo {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public List<Emprestimo> listarEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo localizarEmprestimoId(Long id) {
        return emprestimoRepository.findById(id).orElseThrow(() -> new EmprestimoNaoEncontradoException(id));
    }

    public void removerEmprestimoId(Long id) {
        emprestimoRepository.deleteById(id);
    }
}
