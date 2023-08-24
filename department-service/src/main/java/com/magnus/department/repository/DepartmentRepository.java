package com.magnus.department.repository;

import com.magnus.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

Department findByDepartmentCode(String deptCode);
}
