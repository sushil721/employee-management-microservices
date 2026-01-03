package com.management.employee.service;

import com.management.employee.client.DepartmentClient;
import com.management.employee.dto.APIResponseDTO;
import com.management.employee.dto.DepartmentDTO;
import com.management.employee.dto.EmployeeDTO;
import com.management.employee.entity.Employee;
import com.management.employee.exception.EmailAlreadyExistException;
import com.management.employee.exception.ResourceNotFoundException;
import com.management.employee.mapper.AutoEmployeeMapper;
import com.management.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.function.Consumer;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private static final String DEPARTMENT_URL = "http://localhost:8081/api/departments";
    private static final String SLASH = "/";
    private EmployeeRepository employeeRepository;
//    private RestTemplate restTemplate;
//    private WebClient webClient;
      private DepartmentClient departmentClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        if(employeeDTO == null){
            return null;
        }
        //Check if employee with same email already exists
        Optional<Employee> existingEmployee = employeeRepository.findByEmail(employeeDTO.getEmail());
        if(existingEmployee.isPresent()){
            throw new EmailAlreadyExistException("Employee with email " + employeeDTO.getEmail() + " already exists");
        }

        Employee employee = AutoEmployeeMapper.MAPPER.dtoToEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);

        return AutoEmployeeMapper.MAPPER.entityToDto(savedEmployee);
    }

    @Override
    public APIResponseDTO getEmployeeById(Long id) {
        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        EmployeeDTO employeeDTO = employeeRepository.findById(id)
                .map(AutoEmployeeMapper.MAPPER::entityToDto)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id" , String.valueOf(id)));
        apiResponseDTO.setEmployee(employeeDTO);

//1. RestTemplate is in mentainence mode. Soon it will depricated.
/*        ResponseEntity<DepartmentDTO> departmentDTOResponseEntity = restTemplate.getForEntity(DEPARTMENT_URL+SLASH+employeeDTO.getDepartmentCode(), DepartmentDTO.class);
        try {
            DepartmentDTO departmentDTO = departmentDTOResponseEntity.getBody();
            apiResponseDTO.setDepartment(departmentDTO);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Department", " Department id", employeeDTO.getDepartmentCode());
        }
 */
//2. Use WebClient for Synchronous and Asynchronous and Stream call.
/*        DepartmentDTO departmentDTO = webClient.get()// GET is call method type.
                .uri(DEPARTMENT_URL+SLASH+employeeDTO.getDepartmentCode())
                .retrieve()
                .onStatus(status -> status.value() == 404,
                         response -> Mono.error(
                                        new ResourceNotFoundException("Department", " Department ID", employeeDTO.getDepartmentCode())))
                .bodyToMono(DepartmentDTO.class)
                .block();
        apiResponseDTO.setDepartment(departmentDTO);
        */
// 3.  Feign creates a dynamic implementation of an interface decorated with JAX-RS or Spring MVC annotations
        DepartmentDTO departmentDTO = departmentClient.getDepartmentByDepartmentId(employeeDTO.getDepartmentCode());
        apiResponseDTO.setDepartment(departmentDTO);

        return apiResponseDTO;
    }

/*      employeeReposetory
            .findAll()
            .stream()
            .map( AutoEmployeeMapper.MAPPER::entityToDto)
            .collect(toList());
*/
}
