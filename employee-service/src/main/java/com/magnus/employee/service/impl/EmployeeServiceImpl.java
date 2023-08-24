package com.magnus.employee.service.impl;

import com.magnus.employee.dto.APIResponseDTO;
import com.magnus.employee.dto.DepartmentDto;
import com.magnus.employee.dto.EmployeeDto;
import com.magnus.employee.entity.Employee;
import com.magnus.employee.exceptionHandler.NullOrNotMatchPostRequest;
import com.magnus.employee.exceptionHandler.ResourceAlreadyExist;
import com.magnus.employee.exceptionHandler.ResourceNotFound;
import com.magnus.employee.repository.EmployeeRepository;
import com.magnus.employee.service.APIClient;
import com.magnus.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;
    //private WebClient webClient;
    APIClient apiClient;


    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        EmployeeDto dto = null;
        Employee employee = new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
                employeeDto.getEmail(), employeeDto.getDepartmentCode());

        if (employeeDto.getFirstName() != null && employeeDto.getLastName() != null && employeeDto.getEmail() != null) {
            Employee check = employeeRepository.findByEmail(employeeDto.getEmail());
            if (check != null) {
                throw new ResourceAlreadyExist("Employee is already exist with " + employeeDto.getEmail() + " in our record");
            }
            Employee emp = employeeRepository.save(employee);
            dto = new EmployeeDto(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail(), emp.getDepartmentCode());

        }else {
            throw new NullOrNotMatchPostRequest("Post date is null or not match with data form please verify  your information");
        }

        return dto;
    }

    @Override
    public APIResponseDTO getEmployeeById(Long empId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new ResourceNotFound("Employee data is not Found found in our record "));
        //Employee employee = employeeOptional.get();
        DepartmentDto department = apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentCode());
        APIResponseDTO apiResponseDTO = new APIResponseDTO(employeeDto, department);
        return apiResponseDTO;
    }





     /*
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee =  new Employee(employeeDto.getId(),employeeDto.getFirstName(),employeeDto.getLastName(),employeeDto.getEmail(),employeeDto.getDepartmentCode());
        Employee emp = employeeRepository.save(employee);
        EmployeeDto dto =  new EmployeeDto(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail(),emp.getDepartmentCode());
        return dto;
    }*/

    /*@Override
    public APIResponseDTO getEmployeeById(Long empId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
        Employee employee = employeeOptional.get();
       *//* ResponseEntity<DepartmentDto> forEntity = restTemplate.getForEntity("http://localhost:8081/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = forEntity.getBody();
*//*

     *//* DepartmentDto department = webClient.get()
                .uri("http://localhost:8081/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class).block();*//*
        DepartmentDto department = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto =  new EmployeeDto(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode());

        APIResponseDTO apiResponseDTO = new APIResponseDTO(employeeDto,department);

        return apiResponseDTO;
    }*/
}
