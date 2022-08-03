package com.example.test.projetoT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class ProjetoTApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoTApplication.class, args);
	}

}
