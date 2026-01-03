package com.management.department.mapper;

import com.management.department.dto.DepartmentDTO;
import com.management.department.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    Department dtoToEntity(DepartmentDTO departmentDTO);

    DepartmentDTO entityToDto(Department department);
}
