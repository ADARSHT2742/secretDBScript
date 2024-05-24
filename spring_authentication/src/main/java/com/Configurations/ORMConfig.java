package com.Configurations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
@PropertySource("classpath:prop.properties")
public class ORMConfig {

	@Bean
	public EntityManager entityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgresPersistUnit");
		return entityManagerFactory.createEntityManager();
	}

}
