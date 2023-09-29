package com.ssysemployees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssysemployees.employees.domain.Employee;

public interface EmpolyeeRepository extends JpaRepository<Employee, Long> {
    
    
}
