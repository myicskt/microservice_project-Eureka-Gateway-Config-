package com.magnus.employee.service;

import com.magnus.employee.dto.APIResponseDTO;
import com.magnus.employee.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDTO getEmployeeById(Long empId);

}
