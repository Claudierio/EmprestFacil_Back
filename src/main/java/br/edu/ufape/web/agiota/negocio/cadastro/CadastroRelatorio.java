package br.edu.ufape.web.agiota.negocio.cadastro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ufape.web.agiota.dados.*;
import br.edu.ufape.web.agiota.negocio.basica.*;

@Service
public class CadastroRelatorio {
    @Autowired
    private RelatorioRepository relatorioRepository;

    public List<br.edu.ufape.web.agiota.negocio.basica.Relatorio> listarRelatorios() {
        return relatorioRepository.findAll();
    }

    public br.edu.ufape.web.agiota.negocio.basica.Relatorio salvarRelatorio(Relatorio relatorio) {
        return relatorioRepository.save(relatorio);
    }

    public br.edu.ufape.web.agiota.negocio.basica.Relatorio localizarRelatorioId(Long id) {
        return relatorioRepository.findById(id).orElseThrow();
    }
}
