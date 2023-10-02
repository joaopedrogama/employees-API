package com.ssysemployees.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssysemployees.employees.domain.Employee;
import java.util.Optional;

public interface EmpolyeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findById(Long id);

    @Query(value = "SELECT * FROM employee e WHERE e.birth_date = (SELECT MIN(e2.birth_date) FROM employee e2 limit 1) limit 1", nativeQuery = true)
    Employee findYoungerEmployee();

    @Query(value = "SELECT * FROM employee e WHERE e.birth_date = (SELECT MAX(e2.birth_date) FROM employee e2 limit 1) limit 1", nativeQuery = true)
    Employee findOlderEmployee();

    @Query(value = "SELECT * FROM employee e WHERE e.salary = (SELECT MAX(e2.salary) FROM employee e2 limit 1) limit 1", nativeQuery = true)
    Employee findHighestSalary();

    @Query(value = "SELECT * FROM employee e WHERE e.salary = (SELECT MIN(e2.salary) FROM employee e2 limit 1) limit 1", nativeQuery = true)
    Employee findLowestEmployee();

}
