package com.shivam.emp.service;

import java.util.List;
import java.util.Optional;

import com.shivam.emp.entity.Employee;

public interface EmployeeService {

	public Employee saveEmp(Employee employee);

	public List<Employee> getAllEMp();

	public Employee findByEmail(String email);

	public boolean authenticateUser(String email, String password);
}
