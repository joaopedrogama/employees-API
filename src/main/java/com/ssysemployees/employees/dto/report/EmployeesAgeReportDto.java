package com.ssysemployees.employees.dto.report;

import com.ssysemployees.employees.dto.EmployeesDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeesAgeReportDto {

    private EmployeesDto younger;
    private EmployeesDto older;

}
