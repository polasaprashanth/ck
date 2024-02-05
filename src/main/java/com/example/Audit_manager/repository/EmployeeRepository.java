package com.example.Audit_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Audit_manager.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
