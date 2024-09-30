package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.dao")
@EnableDiscoveryClient
public class ProductReactiveMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductReactiveMicroServiceApplication.class, args);
	}

}
