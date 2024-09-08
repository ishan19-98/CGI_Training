package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		System.err.println("api gateway running on port number 8080");
	}
	
	@Bean
	public RouteLocator myCustomerLocator(RouteLocatorBuilder builder) {
		System.out.println("API GATEWAY");
		
		return builder.routes().route(r->r.path("/orders/**").and().method("GET","PUT","DELETE","POST").uri("http://localhost:9393")).
				route(r->r.path("/users/**").and().method("GET","POST","PUT","DELETE").uri("http://localhost:9191")).
				route(r->r.path("/products/**").and().method("GET").uri("http://localhost:9292")).
				build();
	}

}
