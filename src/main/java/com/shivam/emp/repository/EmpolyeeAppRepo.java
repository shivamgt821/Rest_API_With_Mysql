package com.shivam.emp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shivam.emp.entity.Employee;

@Repository
public interface EmpolyeeAppRepo extends JpaRepository<Employee, Long> {

	public Employee findByEmail(String email);

}
