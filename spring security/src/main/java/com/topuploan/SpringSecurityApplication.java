package com.topuploan;


import com.sun.istack.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {
	private static Logger log = Logger.getLogger(SpringSecurityApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
		log.info("Application started successfully!");
	
	}
}
