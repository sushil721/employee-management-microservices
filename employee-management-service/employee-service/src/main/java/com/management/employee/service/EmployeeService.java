package com.management.employee.service;

import com.management.employee.dto.APIResponseDTO;
import com.management.employee.dto.EmployeeDTO;

public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    APIResponseDTO getEmployeeById(Long id);
}
