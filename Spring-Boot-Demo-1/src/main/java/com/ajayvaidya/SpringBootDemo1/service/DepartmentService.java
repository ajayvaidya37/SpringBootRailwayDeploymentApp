package com.ajayvaidya.SpringBootDemo1.service;

import java.util.List;

//import com.ajayvaidya.SpringBootDemo1.controller.List;
import com.ajayvaidya.SpringBootDemo1.entity.Department;
import com.ajayvaidya.SpringBootDemo1.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getDepartments();

	public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartmentById(Long departmentId, Department department);

	public Department getDepartmentfByName(String departmentName);

	public List<Department> getDepartmentsByAddress(String departmentAddress);

	Department getDepartmentByName(String departmentName);

}
