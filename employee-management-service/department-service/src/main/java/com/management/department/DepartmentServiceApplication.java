package com.management.department;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Department Service API Documentation",
                description = "API documentation for Department Service",
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
                description = "Department Service Documentation",
                url = "https://www.linkedin.com/in/sushilgiacr/"
        )
)

@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
