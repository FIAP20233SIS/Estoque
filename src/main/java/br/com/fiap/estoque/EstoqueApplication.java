package br.com.fiap.estoque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {
	    "br.com.fiap.estoque.domain.entity", 
	    "br.com.fiap.estoque.domain.model"
	})
@EnableJpaRepositories(basePackages = "br.com.fiap.estoque.domain.repository")
public class EstoqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstoqueApplication.class, args);
	}

}
