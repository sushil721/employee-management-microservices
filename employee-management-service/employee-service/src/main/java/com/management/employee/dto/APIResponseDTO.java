package com.management.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class APIResponseDTO {
    public EmployeeDTO employee;
    public DepartmentDTO department;
}
