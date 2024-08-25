package br.edu.ufape.web.agiota.Agiota;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testPasswordEncoding() {
        String rawPassword = "minhaSenha";
        String encodedPassword = passwordEncoder.encode(rawPassword);
        System.out.println("Senha Codificada: " + encodedPassword);
        System.out.println("Senha Corresponde: " + passwordEncoder.matches(rawPassword, encodedPassword));
    }
}
