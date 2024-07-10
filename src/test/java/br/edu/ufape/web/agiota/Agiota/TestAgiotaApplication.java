package br.edu.ufape.web.agiota.Agiota;

import org.springframework.boot.SpringApplication;

public class TestAgiotaApplication {

	public static void main(String[] args) {
		SpringApplication.from(AgiotaApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
