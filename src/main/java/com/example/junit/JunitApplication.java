package com.example.junit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class JunitApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitApplication.class, args);
	}

}
