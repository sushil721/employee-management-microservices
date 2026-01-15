package com.management.employee;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
        info = @Info(
                title = "Employee Service API Documentation",
                description = "API documentation for Employee Service",
                version = "1.0",
                contact = @Contact(
                        name = "Sushil Kumar Singh",
                        email = "sushil@testmail.com",
                        url = "https://www.linkedin.com/in/sushilgiacr/"
                ),
                license = @License(
                        name = "Sushil 2.0",
                        url = "https://www.linkedin.com/in/sushilgiacr/"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Employee Service Documentation",
                url = "https://www.linkedin.com/in/sushilgiacr/"
        )
)

@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy
public class EmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

//1. RestTemplate is in mentainence mode. Soon it will depricated.
/*    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }*/

//2. Use WebClient for Synchronous and Asynchronous and Stream call.
    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }
}
