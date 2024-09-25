package br.edu.ufape.web.agiota.comunicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import br.edu.ufape.web.agiota.negocio.basica.Emprestimo;
import br.edu.ufape.web.agiota.negocio.fachada.Fachada;

import org.keycloak.KeycloakPrincipal;


@RestController
@RequestMapping("/api/emprestimos")
public class EmprestimosController {

    @Autowired
    private Fachada fachada;

    // Lista todos os empréstimos (apenas usuários com a role 'user')
    @GetMapping
    @PreAuthorize("hasRole('user')")
    public List<Emprestimo> listarEmprestimos() {
        return fachada.listarEmprestimos();
    }

    // Solicitação de empréstimo (apenas usuários com a role 'usuario')
    @PostMapping("/pedir-emprestimo")
    @PreAuthorize("hasRole('usuario') and #userInfo.containsKey('pedi_emprestimo')") 
    public ResponseEntity<String> pedirEmprestimo(@AuthenticationPrincipal KeycloakPrincipal<?> userInfo) {
        return ResponseEntity.ok("Empréstimo solicitado com sucesso!");
    }

    // Aprovação de empréstimo (apenas agiotas)
    @PostMapping("/aprovar-emprestimo")
    @PreAuthorize("hasRole('agiota') and #userInfo.containsKey('emprestar')")
    public ResponseEntity<String> aprovarEmprestimo(@AuthenticationPrincipal KeycloakPrincipal<?> userInfo) {
        return ResponseEntity.ok("Empréstimo aprovado pelo agiota!");
    }

    // Deletar usuário (apenas gerentes)
    @DeleteMapping("/deletar-usuario")
    @PreAuthorize("hasRole('gerente') and #userInfo.containsKey('apagar_user')")
    public ResponseEntity<String> deletarUsuario(@RequestParam String username, @AuthenticationPrincipal KeycloakPrincipal<?> userInfo) {
        return ResponseEntity.ok("Usuário " + username + " deletado com sucesso!");
    }
}
