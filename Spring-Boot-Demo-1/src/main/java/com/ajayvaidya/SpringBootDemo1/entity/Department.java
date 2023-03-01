package com.ajayvaidya.SpringBootDemo1.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentId;
	
	@NotBlank(message = "Please add departmentName!")
	private String departmentName;
	private String departmentAddress;
	private String departmentCode;
	
}
