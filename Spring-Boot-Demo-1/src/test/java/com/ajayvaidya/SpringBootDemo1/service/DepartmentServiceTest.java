package com.ajayvaidya.SpringBootDemo1.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ajayvaidya.SpringBootDemo1.entity.Department;
import com.ajayvaidya.SpringBootDemo1.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() throws Exception {
		Department dept =Department.builder()
				.departmentId(1l).departmentName("IT").departmentAddress("Pune")
				.departmentCode("IT-900").build();
		Mockito.when(departmentRepository.
				findByDepartmentNameIgnoreCase("IT")).thenReturn(dept);
		
	}
	
	@Test
	@DisplayName("Get Dept by passing valid name")
//	@Disabled
	public void whenValidDeptName_thenDeptFound() {
		String deptName = "IT";
		Department foundDept = departmentService.getDepartmentByName(deptName);
		assertEquals(deptName, foundDept.getDepartmentName());
	}

}
