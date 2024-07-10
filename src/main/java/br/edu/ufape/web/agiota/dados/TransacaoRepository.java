package br.edu.ufape.web.agiota.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.web.agiota.negocio.basica.Transacao;

@Repository

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	Transacao save(Transacao transacao);
}
