package com.vincle.ejercicio_dos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(apiInfo());
	}

	private Info apiInfo() {
		return new Info()
				.title("Item API")
				.description("API de prueba para realizar CRUD de un Item")
				.version("v1.0")
				.contact(apiContact());
	}	

	private Contact apiContact() {
		return new Contact()
				.name("Josué Crespo")
				.email("josue.crespo.21@gmail.com")
				.url("");
	}
}
