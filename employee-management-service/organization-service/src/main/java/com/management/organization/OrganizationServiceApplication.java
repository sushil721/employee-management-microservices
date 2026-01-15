package com.management.organization;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Organization Service API Documentation",
                description = "API documentation for Organization Service",
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
                description = "Organization Service Documentation",
                url = "https://www.linkedin.com/in/sushilgiacr/"
        )
)

@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
