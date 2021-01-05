package com.ayan.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayan.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.ayan.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		this.employeeRepository = theEmployeeRepository;
	}

	@Transactional
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Transactional
	public Employee findById(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			// we did not find the employee
			throw new RuntimeException("Did not find Employee Id - " + theId);
		}
		return theEmployee;
	}

	
	@Transactional
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
