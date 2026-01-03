package com.management.employee.contoller;

import com.management.employee.dto.APIResponseDTO;
import com.management.employee.dto.EmployeeDTO;
import com.management.employee.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
@Tag(
        name = "CURD Rest APIs for Employee operations",
        description = "CURD Rest APIs- Create Employee, Update Employee, GetAllEmployee, GetEmployeeById, DeleteEmployee"
)
public class EmployeeController {

    private EmployeeService employeeService;

    @Operation(
            summary = "Create Employee REST API",
            description = "Create Employee REST API is used to save Employee in DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployeeDTO = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployeeDTO, HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET ONE Employee By ID REST API",
            description = "GET Employee REST API is used to GET Employee from the DB by ID."
    )
    @ApiResponse(
            responseCode = "302",
            description = "HTTP Status 302 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id), HttpStatus.FOUND);
    }
}
