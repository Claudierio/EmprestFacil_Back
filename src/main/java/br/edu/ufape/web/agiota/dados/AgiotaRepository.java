package br.edu.ufape.web.agiota.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.web.agiota.negocio.basica.Agiota;

@Repository
public interface AgiotaRepository extends JpaRepository<Agiota, Long> {
}
