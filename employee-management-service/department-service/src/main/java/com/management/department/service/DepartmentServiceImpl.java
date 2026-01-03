package com.management.department.service;

import com.management.department.dto.DepartmentDTO;
import com.management.department.entity.Department;
import com.management.department.exception.DepartmentCodeAlreadyExistException;
import com.management.department.exception.ResourceNotFoundException;
import com.management.department.mapper.AutoDepartmentMapper;
import com.management.department.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        if(departmentDTO ==null){
            return null;
        }
        Optional<Department> checkDepartment = departmentRepository.findByDepartmentCode(departmentDTO.getDepartmentCode());
        if(checkDepartment.isPresent()){
            throw new DepartmentCodeAlreadyExistException("Department with departmentCode :"+departmentDTO.getDepartmentCode()+ " is already available.");
        }
        //convert DepartmentDTO to Department JPA entity
        Department department = AutoDepartmentMapper.MAPPER.dtoToEntity(departmentDTO);

        Department savedDepartment = departmentRepository.save(department);

        return AutoDepartmentMapper.MAPPER.entityToDto(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(AutoDepartmentMapper.MAPPER::entityToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", String.valueOf(id)));
    }

    @Override
    public DepartmentDTO getDepartmentByDepartmentCode(String departmentCode) {
        return departmentRepository.findByDepartmentCode(departmentCode)
                .map(AutoDepartmentMapper.MAPPER::entityToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "id", departmentCode));

    }

    @Override
    public List<DepartmentDTO> getDepartments() {
        List<Department> departments =  departmentRepository.findAll();

        return departmentRepository
                .findAll()
                .stream()
                .map(AutoDepartmentMapper.MAPPER::entityToDto)
                .collect(Collectors.toList());
    }
}
