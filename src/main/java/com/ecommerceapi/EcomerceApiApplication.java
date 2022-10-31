package com.ecommerceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"com.ecommerceapi"})
public class EcomerceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomerceApiApplication.class, args);
	}
}
