package com.nivelics.cursosms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CursosMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.nivelics.cursosms.CursosMsApplication.class, args);
	}

}
