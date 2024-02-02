package com.ntt.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = IcoValidationApp.class)
public class IcoValidationApp {

	public static void main(String[] args) {
		SpringApplication.run(IcoValidationApp.class, args);
	}
	
}
