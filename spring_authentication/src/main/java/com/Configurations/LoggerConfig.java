package com.Configurations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerConfig {

	@Bean
	public Logger logger() {
		configureLog4j2();
		return LogManager.getLogger(LoggerConfig.class);
	}

	private void configureLog4j2() {
		ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

		// Set the status of the configuration
		builder.setStatusLevel(org.apache.logging.log4j.Level.ALL);

		// for console
		AppenderComponentBuilder consoleAppenderBuilder = builder.newAppender("Console", "CONSOLE")
				.addAttribute("target", org.apache.logging.log4j.core.appender.ConsoleAppender.Target.SYSTEM_OUT);
		consoleAppenderBuilder.add(builder.newLayout("PatternLayout").addAttribute("pattern",
				"\u001B[35m%d{yyyy-MM-dd HH:mm:ss}\u001B[0m \u001B[1;31m%-5p\u001B[0m \u001B[36m%c{1}:%L\u001B[0m - \u001B[32m%m%n\u001B[0m"));
		builder.add(consoleAppenderBuilder);

		// Create a file appender
		AppenderComponentBuilder fileAppenderBuilder = builder.newAppender("File", "File").addAttribute("fileName",
				"logs/application1.log");
		fileAppenderBuilder.add(builder.newLayout("PatternLayout").addAttribute("pattern",
				"%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"));

		// Add appenders to the configuration
		builder.add(consoleAppenderBuilder);
		builder.add(fileAppenderBuilder);

		// Create a logger
		builder.add(builder.newRootLogger(org.apache.logging.log4j.Level.ALL).add(builder.newAppenderRef("Console"))
				.add(builder.newAppenderRef("File")));

		// Build the configuration
		org.apache.logging.log4j.core.config.Configuration config = builder.build();

		// Apply the configuration
		Configurator.initialize(config);
	}
}
