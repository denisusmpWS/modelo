package com.feign.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient //EUREKA
@EnableFeignClients //API CLIENT FEIGN
public class ProyFeignClientDemoApplication {




	//http://localhost:1000/eureka/apps/PROY-FEIGN-CLIENT-DEMO

	public static void main(String[] args) {
		SpringApplication.run(ProyFeignClientDemoApplication.class, args);
	}
}
