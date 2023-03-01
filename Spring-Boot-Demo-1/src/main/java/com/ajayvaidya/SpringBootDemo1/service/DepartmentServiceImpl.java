package com.ajayvaidya.SpringBootDemo1.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajayvaidya.SpringBootDemo1.entity.Department;
import com.ajayvaidya.SpringBootDemo1.error.DepartmentNotFoundException;
import com.ajayvaidya.SpringBootDemo1.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long id)  throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department = departmentRepository.findById(id);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department not found!");
		}
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmentById(Long departmentId, Department department) {
		Department depDB = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName()) &&
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentAddress()) &&
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode()) &&
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepository.save(depDB);
	}

	@Override
	public Department getDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

	@Override
	public List<Department> getDepartmentsByAddress(String departmentAddress) {
		// TODO Auto-generated method stub
		return departmentRepository.getByDeptAddress(departmentAddress);
	}

	@Override
	public Department getDepartmentfByName(String departmentName) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
}
