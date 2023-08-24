package com.magnus.department.service.impl;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.magnus.department.dto.DepartmentDto;
import com.magnus.department.entity.Department;
import com.magnus.department.exceptionHandler.NullOrNotMatchPostRequest;
import com.magnus.department.exceptionHandler.ResourceAlreadyExist;
import com.magnus.department.exceptionHandler.ResourceNotFound;
import com.magnus.department.repository.DepartmentRepository;
import com.magnus.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        DepartmentDto savedData;
        Department department = new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode());

        //department name, department description and department  code must not be null
        if (departmentDto.getDepartmentName() != null && departmentDto.getDepartmentDescription() != null && departmentDto.getDepartmentCode()!=null ) {
            Department check = departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());
            if (check != null) {
                throw new ResourceAlreadyExist("Department is already exist in our record");
            }
            Department dept = departmentRepository.save(department);
            savedData = new DepartmentDto(dept.getId(), dept.getDepartmentName(), dept.getDepartmentDescription(), dept.getDepartmentCode());
        } else {
            throw new NullOrNotMatchPostRequest("Post object is null or not match data obje n/ please verify the post information");
        }
        return savedData;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String deptCode) {
        DepartmentDto dto;
        Department dept= departmentRepository.findByDepartmentCode(deptCode);
        if (dept != null) {
            dto = new DepartmentDto(dept.getId(), dept.getDepartmentName(), dept.getDepartmentDescription(), dept.getDepartmentCode());
        } else {
            throw new ResourceNotFound("Department not found in our record /n verify our department id example dp00x");
        }
        return dto;
    }
}

