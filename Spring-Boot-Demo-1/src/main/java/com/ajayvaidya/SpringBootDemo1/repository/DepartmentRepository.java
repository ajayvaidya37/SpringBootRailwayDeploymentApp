package com.ajayvaidya.SpringBootDemo1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ajayvaidya.SpringBootDemo1.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	public Department findByDepartmentName(String departmentName);
	
	public Department findByDepartmentNameIgnoreCase(String departmentName);
	
	@Query(value="select * from department where DEPARTMENT_ADDRESS = ?1", nativeQuery = true)
	public List<Department> getByDeptAddress(String address);
}
