package com.cloudproject.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cloudproject.rest","com.cloudproject.model"})
@EnableJpaRepositories(basePackages = {"com.cloudproject.model"})
@EntityScan(basePackages = {"com.cloudproject.model"})
public class CloudprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudprojectApplication.class, args);
	}

}
