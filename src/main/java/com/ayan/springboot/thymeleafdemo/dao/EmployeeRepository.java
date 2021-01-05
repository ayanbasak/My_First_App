package com.ayan.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayan.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//add a method to sory by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
 