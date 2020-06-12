package com.sixtybees.bsb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sixtybees.bsb")
public class BsbApp extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		System.setProperty("org.jboss.logging.provider", "slf4j");
		new BsbApp().configure(new SpringApplicationBuilder(BsbApp.class)).run(args);
	}
	
}
