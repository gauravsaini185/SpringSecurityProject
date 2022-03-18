package com.mvc.demo.service;

import java.util.List;

import com.mvc.demo.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();
	Employee getEmployee(long id);
	void saveEmployee(Employee employee);
	void deleteEmployee(long id);
	void updateEmployee(Employee employee);
}
