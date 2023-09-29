package com.ssysemployees.employees.dto;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeesDto {

    private Long id;

    private String name;

    private String email;

    private String Department;

    private Long salary;

    private OffsetDateTime birthDate;
}
