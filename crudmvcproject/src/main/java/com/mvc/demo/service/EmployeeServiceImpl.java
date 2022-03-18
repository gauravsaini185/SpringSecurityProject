package com.mvc.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.demo.entity.Employee;
import com.mvc.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository repository;
	
	@Override
	public List<Employee> getAllEmployee() {
		return repository.findAll();
	}

	@Override
	public Employee getEmployee(long id) {
		Optional<Employee> optional = repository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;

	}

	@Override
	public void saveEmployee(Employee employee) {
		repository.save(employee);
		
	}

	@Override
	public void deleteEmployee(long id) {
		repository.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
		existingEmployee.setFirst_name(employee.getFirst_name());
		existingEmployee.setLast_name(employee.getLast_name());
		existingEmployee.setEmail(employee.getEmail());
		repository.save(existingEmployee);
		
	}

}
