package com.Configurations;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
@PropertySource("classpath:prop.properties")
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
	
//	 @Bean
//	 public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds) {
//        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//        em.setDataSource(ds);
//        em.setPackagesToScan("com");
//        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        Properties jpaProperties = new Properties();
//        jpaProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
//        jpaProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
//        jpaProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
//        jpaProperties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
//        em.setJpaProperties(jpaProperties);
//
//        return em;
//    }
//
//
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//    
//    
//    @Bean
//    public EntityManager entityManager(EntityManagerFactory entityManagerFactory) {
//        return entityManagerFactory.createEntityManager();
//    }
}
