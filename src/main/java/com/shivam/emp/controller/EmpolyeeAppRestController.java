package com.shivam.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.emp.entity.Employee;
import com.shivam.emp.service.EmployeeService;

@RestController
public class EmpolyeeAppRestController {

	@Autowired
	private EmployeeService repo;
	private List<Employee> allEMp;

	@PostMapping(value = "/save")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee) {
		Employee saveEmp = repo.saveEmp(employee);
		System.out.println(employee);
		return new ResponseEntity<Employee>(saveEmp, HttpStatus.CREATED);

	}

	@GetMapping("/list")
	public ResponseEntity<List<Employee>> getEmpList() {
		try {
			allEMp = repo.getAllEMp();
			if (allEMp.size() > 0) {
				new ResponseEntity<List<Employee>>(allEMp, HttpStatus.OK);

			} else {
				new ResponseEntity<List<Employee>>(allEMp, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Employee>>(allEMp, HttpStatus.OK);
		}

		return new ResponseEntity<List<Employee>>(allEMp, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody() Employee profile) {

		System.out.println(" VALUES  " + profile.getEmail());

		System.out.println(" VALUES pass  " + profile.getPass());

		System.out.println(" repo.authenticateUser(email, pass)  " + repo.authenticateUser(profile.getEmail(), profile.getPass()));

		if (repo.authenticateUser(profile.getEmail(), profile.getPass())) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		} else {
//			// Authentication failed, display an error message
//			model.addAttribute("error", "Invalid email or password");
			return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);

		}
	}
}
