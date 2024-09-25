package br.edu.ufape.web.agiota.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()  // Em versões mais recentes, authorizeRequests foi substituído por authorizeHttpRequests
                .requestMatchers("/pedir-emprestimo").hasRole("usuario")
                .requestMatchers("/aprovar-emprestimo").hasRole("agiota")
                .requestMatchers("/deletar-usuario").hasRole("gerente")
                .anyRequest().authenticated()
            .and()
            .oauth2ResourceServer()
                .jwt();  // Para validar tokens JWT gerados pelo Keycloak
        return http.build();
    }
}
