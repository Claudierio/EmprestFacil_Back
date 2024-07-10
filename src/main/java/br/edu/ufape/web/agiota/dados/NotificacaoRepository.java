package br.edu.ufape.web.agiota.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.web.agiota.negocio.basica.Notificacao;

@Repository

public interface NotificacaoRepository extends JpaRepository<Notificacao, Long> {

	Notificacao save(Notificacao notificacao);
}
