package br.edu.ufape.web.agiota.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.web.agiota.negocio.basica.Relatorio;

@Repository

public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {

	Relatorio save(Relatorio relatorio);
}
