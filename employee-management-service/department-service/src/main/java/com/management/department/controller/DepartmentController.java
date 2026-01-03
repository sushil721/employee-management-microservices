package com.management.department.controller;

import com.management.department.dto.DepartmentDTO;
import com.management.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    //Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentDTO), HttpStatus.CREATED);
    }

    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDTO> getDepartmentByDepartmentId(@PathVariable("departmentCode") String departmentCode){
        return  new ResponseEntity<>(departmentService.getDepartmentByDepartmentCode(departmentCode), HttpStatus.OK);
    }
}
