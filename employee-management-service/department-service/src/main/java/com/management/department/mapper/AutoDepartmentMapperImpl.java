package com.management.department.mapper;

import com.management.department.dto.DepartmentDTO;
import com.management.department.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class AutoDepartmentMapperImpl implements AutoDepartmentMapper {
    public Department dtoToEntity(DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            return null;
        } else {
            return new Department(
                    departmentDTO.getId(),
                    departmentDTO.getDepartmentName(),
                    departmentDTO.getDepartmentDescription(),
                    departmentDTO.getDepartmentCode()
            );
        }
    }

    public DepartmentDTO entityToDto(Department department) {
        if (department == null) {
            return null;
        } else {
            return  new DepartmentDTO(
                    department.getId(),
                    department.getDepartmentName(),
                    department.getDepartmentDescription(),
                    department.getDepartmentCode()
            );
        }
    }
}
