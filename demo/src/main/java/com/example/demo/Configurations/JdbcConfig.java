package com.example.demo.Configurations;

import java.io.IOException;
import java.util.Properties;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
@PropertySource("classpath:application.properties")
public class JdbcConfig {
	@Autowired
	private Environment env;

	@Bean
	public DataSource plpgsql_data_source() throws IOException {

		BasicDataSource plpgsql_ds = new BasicDataSource();
		plpgsql_ds.setDriverClassName(env.getProperty("driver_name"));
		plpgsql_ds.setUrl(env.getProperty("jdbc_conn_string"));
		plpgsql_ds.setUsername(env.getProperty("user"));
		plpgsql_ds.setPassword(env.getProperty("password"));
		System.out.println("I am loaded : jdbc config");
		System.out.println(env.getProperty("password"));
		return plpgsql_ds;
	}

	@Bean
	public JdbcTemplate postgresql_database(DataSource ds) {
		return new JdbcTemplate(ds);
	}

}
