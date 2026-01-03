package com.management.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

//1. RestTemplate is in mentainence mode. Soon it will depricated.
/*    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
*/
//2. Use WebClient for Synchronous and Asynchronous and Stream call.
/*    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
*/
}
