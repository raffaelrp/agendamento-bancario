package br.com.rafael.agendamentobancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.rafael.agendamentobancario", "br.com.rafael.agendamentobancario.models"})
@EnableJpaRepositories(basePackages = {"br.com.rafael.agendamentobancario.repository", "br.com.rafael.agendamentobancario.service" })
public class AgendamentoBancarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendamentoBancarioApplication.class, args);
	}

}
