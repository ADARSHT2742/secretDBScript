package com.Initialisers;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.Configurations.AppConfig;
import com.Configurations.JdbcConfig;
import com.Configurations.ORMConfig;

public class WebApplicationInitialiser implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class, JdbcConfig.class,ORMConfig.class);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
				new DispatcherServlet(context));
		dispatcher.addMapping("/");
		dispatcher.setLoadOnStartup(1);
	}
}