package com.prodapt.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = { "com.prodapt.app.*" })
public class AppConfig extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
        SpringApplication.run(AppConfig.class, args);
    } 
	@Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        // Customize the application or call application.sources(...) to add
        // sources
        return application.sources(AppConfig.class);
    }
	
	@Bean
    public ServletRegistrationBean dispatcherRegistration(
            DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                dispatcherServlet);
        registration.addUrlMappings("/*");
        return registration;
    }
	
	
}
