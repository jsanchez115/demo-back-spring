package com.ejercicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebApplication {

	private static Logger LOG = LoggerFactory.getLogger(DemoWebApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
		LOG.info("Terminó");
	}

}
