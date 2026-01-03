package com.management.employee.mapper;

import com.management.employee.dto.EmployeeDTO;
import com.management.employee.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class AutoEmployeeMapperImpl implements AutoEmployeeMapper {
    public Employee dtoToEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        } else {
            return  new Employee(
                    dto.getId(),
                    dto.getFirstName(),
                    dto.getLastName(),
                    dto.getEmail(),
                    dto.getDepartmentCode()
            );
        }
    }

    public EmployeeDTO entityToDto(Employee employee) {
        if (employee == null) {
            return null;
        } else {
            return new EmployeeDTO(
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getEmail(),
                    employee.getDepartmentCode()
            );
        }
    }
}