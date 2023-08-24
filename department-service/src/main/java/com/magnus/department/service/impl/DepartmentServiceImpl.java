package com.magnus.department.service.impl;


import com.magnus.department.dto.DepartmentDto;
import com.magnus.department.entity.Department;
import com.magnus.department.repository.DepartmentRepository;
import com.magnus.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(departmentDto.getId(),departmentDto.getDepartmentName(),departmentDto.getDepartmentDescription(),departmentDto.getDepartmentCode());

        Department dept = departmentRepository.save(department);
        DepartmentDto savedData = new DepartmentDto(dept.getId(),dept.getDepartmentName(), dept.getDepartmentDescription(),dept.getDepartmentCode() );
        return savedData;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String deptCode) {

        Department dept = departmentRepository.findByDepartmentCode(deptCode);
        DepartmentDto dto = new DepartmentDto(dept.getId(),dept.getDepartmentName(),dept.getDepartmentDescription(),dept.getDepartmentCode());

        return dto;
    }
}
