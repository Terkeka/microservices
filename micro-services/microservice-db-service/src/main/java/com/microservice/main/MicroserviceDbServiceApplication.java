package com.microservice.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.microservice.repository")
@SpringBootApplication
@ComponentScan(basePackages = "com.microservice")
@EntityScan("com.microservice.model")
public class MicroserviceDbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDbServiceApplication.class, args);
	}

}
