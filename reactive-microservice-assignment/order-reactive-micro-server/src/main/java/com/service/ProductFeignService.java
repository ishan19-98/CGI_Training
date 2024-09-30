//package com.service;
//
//import java.util.Optional;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//
//@FeignClient(name = "PRODUCT-SERVICE")
//public interface ProductFeignService {
//	
//	@GetMapping(value = "products/{pid}")
//	public String findProductById(@PathVariable("pid") int id);
//
//}
