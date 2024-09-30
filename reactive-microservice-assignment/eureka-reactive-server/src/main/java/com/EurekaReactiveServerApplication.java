package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaReactiveServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaReactiveServerApplication.class, args);
		System.err.println("Enable Eureka Server on Port 8761");
	}

}
