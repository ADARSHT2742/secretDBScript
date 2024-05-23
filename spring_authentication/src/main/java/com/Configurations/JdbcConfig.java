package com.Configurations;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com")
public class JdbcConfig {
	@Bean
	public DataSource plpgsql_data_source() throws IOException {
		// can be modified with resource handler class
		Properties p = new Properties();
		FileReader f = new FileReader("D:\\workspace\\Pro\\spring_authentication\\prop.properties");
		p.load(f);
		System.out.println("Connection established once");

		BasicDataSource plpgsql_ds = new BasicDataSource();
		plpgsql_ds.setDriverClassName(p.getProperty("driver_name"));
		plpgsql_ds.setUrl(p.getProperty("jdbc_conn_string"));
		plpgsql_ds.setUsername(p.getProperty("user"));
		plpgsql_ds.setPassword(p.getProperty("password"));
		return plpgsql_ds;
	}

	@Bean
	public JdbcTemplate postgresql_database(DataSource ds) {
		return new JdbcTemplate(ds);
	}
}
