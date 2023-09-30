package com.ssysemployees.employees.dto;

import java.time.OffsetDateTime;

import com.ssysemployees.employees.domain.Employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesDto {

    private Long id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private String email;

    @NotBlank
    @NotNull
    private String Department;

    @NotNull
    private Long salary;

    @NotNull
    private OffsetDateTime birthDate;

    public EmployeesDto(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.Department = employee.getDepartment();
        this.salary = employee.getSalary();
        this.birthDate = employee.getBirthDate();
    }
}
