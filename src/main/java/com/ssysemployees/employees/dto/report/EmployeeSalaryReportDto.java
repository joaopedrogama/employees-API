package com.ssysemployees.employees.dto.report;

import com.ssysemployees.employees.dto.EmployeesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSalaryReportDto {

    private EmployeesDto highest;
    private EmployeesDto lowest;

}
