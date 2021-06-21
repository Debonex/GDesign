package com.example.debonex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Debonex
 * @date 2021年6月21日
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GdesignConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdesignConsumerApplication.class, args);
	}

}
