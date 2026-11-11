package com.mentor.agente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgenteApplication {
	public static void main(String[] args) {
		// Esta linha liga o servidor embutido (Tomcat) e carrega todos os componentes
		SpringApplication.run(AgenteApplication.class, args);
	}
}
