package com.management.employee.client;

import com.management.employee.dto.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "http://localhost:8081", value = "DEPARTMENT-SERVICE")
// using name of service we can achieve load balancer.
// here, Spring Cloud Netflix Eureka dependency have spring cloud load balancer.
// which will balance all load over the different instances of application.
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartmentClient {

    @GetMapping("api/departments/{departmentCode}")
    public DepartmentDTO getDepartmentByDepartmentId(@PathVariable("departmentCode") String departmentCode);
}
