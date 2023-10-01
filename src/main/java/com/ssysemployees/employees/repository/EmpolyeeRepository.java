package com.ssysemployees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssysemployees.employees.domain.Employee;
import java.util.Optional;


public interface EmpolyeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long id);

    @Query("SELECT e FROM employee e WHERE e.birthDate = (SELECT MIN(e2.birthDate) FROM employee e2)")
    Employee findYoungerEmployee();

    @Query("SELECT e FROM employee e WHERE e.birthDate = (SELECT MAX(e2.birthDate) FROM employee e2)")
    Employee findOlderEmployee();
    
}
