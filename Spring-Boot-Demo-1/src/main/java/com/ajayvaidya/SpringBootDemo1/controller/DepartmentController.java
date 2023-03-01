package com.ajayvaidya.SpringBootDemo1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajayvaidya.SpringBootDemo1.entity.Department;
import com.ajayvaidya.SpringBootDemo1.error.DepartmentNotFoundException;
import com.ajayvaidya.SpringBootDemo1.service.DepartmentService;

//import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger logger1 = LoggerFactory.getLogger(DepartmentController.class);
	@PostMapping("/departments")
	public Department saveDepartment(@javax.validation.Valid @RequestBody Department department) {
		logger1.info("inside save department method");
		return departmentService.saveDepartment(department); 
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartments(){
		logger1.info("inside get departments method");
		return departmentService.getDepartments();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException{
		return departmentService.fetchDepartmentById(id);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted Successfully!!!";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long departmentId, 
			@RequestBody Department department) {
		return departmentService.updateDepartmentById(departmentId, department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.getDepartmentByName(departmentName);
	}
	
	@GetMapping("/departments/address/{address}")
	public List<Department> getDepartmentsByAddress(@PathVariable("address") String departmentAddress) {
		return departmentService.getDepartmentsByAddress(departmentAddress);
	}
}
