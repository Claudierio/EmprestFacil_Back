package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.edu.ufape.web.agiota.negocio.basica.Agiota;
import br.edu.ufape.web.agiota.negocio.basica.Emprestimo;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;
import br.edu.ufape.web.agiota.Config.*;

@RestController
@RequestMapping("/api/agiotas")
public class AgiotasController {

    @Autowired
    private Fachada fachada;

    @Autowired
    private KeycloakService keycloakService;

    @GetMapping
    public List<Agiota> listarAgiotas() {
        return fachada.listarAgiotas();
    }

    @PostMapping
    public Agiota criarAgiota(@RequestBody Agiota agiota) {
        // Criar o usuário no Keycloak antes de salvar no sistema
        keycloakService.criarUsuarioKeycloak(agiota.getNome(), agiota.getEmail(), agiota.getSenha(), "agiota");

        // Agora salva o Agiota no banco de dados
        return fachada.salvarAgiota(agiota);
    }

    @GetMapping("/{id}")
    public Agiota exibirAgiota(@PathVariable long id) {
        return fachada.localizarAgiotaId(id);
    }

    @PutMapping("/{id}")
    public Agiota atualizarAgiota(@PathVariable long id, @RequestBody Agiota agiota) {
        agiota.setId(id);
        return fachada.salvarAgiota(agiota);
    }

    @DeleteMapping("/{id}")
    public String apagarAgiota(@PathVariable long id) {
        fachada.removerAgiotaId(id);
        return "Agiota removido com sucesso!";
    }
