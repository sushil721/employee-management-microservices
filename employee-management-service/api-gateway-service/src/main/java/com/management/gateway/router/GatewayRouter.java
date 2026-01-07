package com.management.gateway.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRouter {


    @Bean
    public RouteLocator gatewayRoutes(
            RouteLocatorBuilder builder) {
        return builder.routes()
                .route("EMPLOYEE-SERVICE", r -> r.path("/api/employees/**")
                        //.filters(f -> f.stripPrefix(1))
                        .uri("lb://EMPLOYEE-SERVICE"))
                .route("DEPARTMENT-SERVICE", r -> r.path("/api/departments/**")
                        //.filters(f -> f.stripPrefix(1))
                        .uri("lb://DEPARTMENT-SERVICE"))
                .build();
    }
}
