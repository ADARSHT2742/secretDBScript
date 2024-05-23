package com.pennant.Configurations;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// ajshdfjkhasjdf
// now made some changes
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.pennant")
public class JdbcConfig {
	@Bean
	public DataSource plpgsql_data_source() {
		BasicDataSource obj = new BasicDataSource();
		obj.setDriverClassName("org.postgresql.Driver");
		obj.setUrl(null);
		obj.setUsername(null);
		obj.setPassword(null);
		return obj;
	}
	
	@Bean
	public JdbcTemplate plpgsql_jdbc_template(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
