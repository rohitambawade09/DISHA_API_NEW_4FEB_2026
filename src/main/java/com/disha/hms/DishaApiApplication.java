package com.disha.hms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	 info = @Info(
	      title = "My DISHA API Application",
	      version = "1.0",
	      description = "Swagger documentation for DISHA APIs"
	 )
)

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class DishaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DishaApiApplication.class, args);
	}

}
