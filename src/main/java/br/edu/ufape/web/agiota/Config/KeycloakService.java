package br.edu.ufape.web.agiota.Config;

import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Service
public class KeycloakService {

    private static final String SERVER_URL = "http://localhost:8080";  // URL do Keycloak
    private static final String REALM = "A.G.I.O.T.A";  // O realm específico
    private static final String CLIENT_ID = "admin-cli";  // O client ID, geralmente "admin-cli"
    private static final String ADMIN_USERNAME = "admin";  // O nome do usuário admin
    private static final String ADMIN_PASSWORD = "admin";  // A senha do usuário admin

    // Inicializa o cliente do Keycloak
    private Keycloak getKeycloakClient() {
        return KeycloakBuilder.builder()
                .serverUrl(SERVER_URL)
                .realm("master")  // Aqui estamos no "master" realm para criar usuários no realm "A.G.I.O.T.A"
                .clientId(CLIENT_ID)
                .username(ADMIN_USERNAME)
                .password(ADMIN_PASSWORD)
                .grantType("password")
                .build();
    }

    public void criarUsuarioKeycloak(String nome, String email, String senha, String role) {
        Keycloak keycloak = getKeycloakClient();

        // Representação de Credencial
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setTemporary(false);
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(senha);

        // Criação de um novo usuário
        UserRepresentation user = new UserRepresentation();
        user.setUsername(nome);
        user.setEmail(email);
        user.setCredentials(Arrays.asList(credential));
        user.setEnabled(true);

        // Adicionar o usuário no Keycloak
        Response response = keycloak.realm(REALM).users().create(user);

        if (response.getStatus() != 201) {
            // Adicione o conteúdo da resposta para depuração
            System.out.println("Erro ao criar usuário no Keycloak: " + response.getStatus() + " " + response.getEntity());
            return;
        }

        // Verifique se o usuário foi criado com sucesso
        List<UserRepresentation> users = keycloak.realm(REALM).users().search(nome);
        if (users == null || users.isEmpty()) {
            System.out.println("Usuário não encontrado após a criação.");
            return;
        }

        // Recuperar o ID do usuário recém-criado
        String userId = users.get(0).getId();

        // Atribuir o papel (Role) ao usuário recém-criado
        keycloak.realm(REALM).users().get(userId).roles().realmLevel()
                .add(Arrays.asList(keycloak.realm(REALM).roles().get(role).toRepresentation()));
        
        System.out.println("Usuário criado com sucesso e papel atribuído.");
    }
}
