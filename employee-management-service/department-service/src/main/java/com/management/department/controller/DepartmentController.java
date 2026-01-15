package com.management.department.controller;

import com.management.department.dto.DepartmentDTO;
import com.management.department.service.DepartmentService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Tag(
        name = "Department Service - Department Controller",
        description = "Department Service - Department Controller handles all the operations related to Departments"
)
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @Operation(
            summary = "Create Department REST API",
            description = "Create Department REST API is used to save Department in DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    //Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET ONE Department By Department Code REST API",
            description = "GET Department REST API is used to GET Department from the DB by Department Code."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDTO> getDepartmentByDepartmentId(@PathVariable("departmentCode") String departmentCode){
        return  new ResponseEntity<>(departmentService.getDepartmentByDepartmentCode(departmentCode), HttpStatus.OK);
    }

}
