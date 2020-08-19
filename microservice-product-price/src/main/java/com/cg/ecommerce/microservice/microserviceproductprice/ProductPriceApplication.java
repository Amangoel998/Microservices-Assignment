package com.cg.ecommerce.microservice.microserviceproductprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductPriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductPriceApplication.class, args);
	}

}
