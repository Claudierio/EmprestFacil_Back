package br.edu.ufape.web.agiota.negocio.cadastro;

import br.edu.ufape.web.agiota.negocio.basica.Agiota;
import java.util.List;

public class CadastroAgiota {
    private List<Agiota> agiotas;

    public void adicionarAgiota(Agiota agiota) {
        agiotas.add(agiota);
    }

    public Agiota buscarAgiotaPorId(Long id) {
        return agiotas.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    public void atualizarAgiota(Agiota agiota) {
        Agiota a = buscarAgiotaPorId(agiota.getId());
        if (a != null) {
            a.setNome(agiota.getNome());
            a.setTaxaJuros(agiota.getTaxaJuros());
        }
    }

    public void removerAgiota(Long id) {
        agiotas.removeIf(a -> a.getId().equals(id));
    }
}
