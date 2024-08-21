package br.edu.ufape.web.agiota.Agiota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "br.edu.ufape.web.agiota")
@EntityScan(basePackages = "br.edu.ufape.web.agiota.negocio.basica")
@EnableJpaRepositories(basePackages = "br.edu.ufape.web.agiota.dados")
public class AgiotaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AgiotaApplication.class, args);
    }

}
