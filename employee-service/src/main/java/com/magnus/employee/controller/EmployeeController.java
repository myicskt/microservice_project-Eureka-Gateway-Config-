package com.magnus.employee.controller;

import com.magnus.employee.dto.APIResponseDTO;
import com.magnus.employee.dto.EmployeeDto;
import com.magnus.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {


    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){

        EmployeeDto emp = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getEmployeeById(@PathVariable("id") Long employeeId){

        APIResponseDTO apiResponseDTO =  employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(apiResponseDTO,HttpStatus.OK);
    }

}
