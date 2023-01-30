package com.springbootapp.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springbootapp")
public class SpringBootCallingExternalApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCallingExternalApiApplication.class, args);
	}

}
