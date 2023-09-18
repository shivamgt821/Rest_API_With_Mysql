package com.shivam.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivam.emp.entity.Employee;
import com.shivam.emp.repository.EmpolyeeAppRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpolyeeAppRepo repo;

	@Override
	public Employee saveEmp(Employee employee) {
		Employee save = repo.save(employee);
		return save;
	}

	@Override
	public List<Employee> getAllEMp() {
		List<Employee> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public Employee findByEmail(String email) {
		Employee findByEmail = repo.findByEmail(email);
		return findByEmail;
	}
	
	public boolean authenticateUser(String email, String password) {
		Employee user = repo.findByEmail(email);
        return user != null && password.equals(user.getPass());
    }
}
