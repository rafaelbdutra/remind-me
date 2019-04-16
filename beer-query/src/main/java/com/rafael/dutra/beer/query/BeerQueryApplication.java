package com.rafael.dutra.beer.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@SpringBootApplication
@EnableEurekaClient
public class BeerQueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeerQueryApplication.class, args);
	}
}
