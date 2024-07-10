package br.edu.ufape.web.agiota.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.web.agiota.negocio.basica.Pagamento;

@Repository

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

	Pagamento save(Pagamento pagamento);
}
