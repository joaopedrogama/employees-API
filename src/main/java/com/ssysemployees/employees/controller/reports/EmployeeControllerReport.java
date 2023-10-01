package com.ssysemployees.employees.controller.reports;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssysemployees.core.config.handler.ServiceException;
import com.ssysemployees.employees.domain.Employee;
import com.ssysemployees.employees.dto.EmployeesDto;
import com.ssysemployees.employees.dto.report.EmployeeSalaryReportDto;
import com.ssysemployees.employees.dto.report.EmployeesAgeReportDto;
import com.ssysemployees.employees.service.EmployeesService;

import lombok.AllArgsConstructor;

/**
 * Controller de relatórios dos emplooyes
 * 
 * @author
 */

@AllArgsConstructor
@RestController
@RequestMapping("reports/employees")
public class EmployeeControllerReport {

    private final EmployeesService employeesService;

    /**
     * Lista o mais novo employee e o mais velho
     * 
     * @return - Lista de employee contendo o mais novo e o mais velho employee
     * @throws ServiceException
     */
    @GetMapping("/age")
    public ResponseEntity<EmployeesAgeReportDto> ageReport() throws ServiceException {
        List<Employee> employees = employeesService.ageReport();
        EmployeesAgeReportDto employeesSalaryReportDto = new EmployeesAgeReportDto();
        EmployeesDto younger = new EmployeesDto();
        EmployeesDto older = new EmployeesDto();
        BeanUtils.copyProperties(employees.get(0), younger);
        BeanUtils.copyProperties(employees.get(1), older);
        employeesSalaryReportDto.setYounger(younger);
        employeesSalaryReportDto.setOlder(older);
        return ResponseEntity.ok(employeesSalaryReportDto);
    }

    /**
     * Lista o employee com o maior salário e o employee com menor salário
     * 
     * @return
     * @throws ServiceException
     */
    @GetMapping("/salary")
    public ResponseEntity<EmployeeSalaryReportDto> salaryReport() throws ServiceException {
        List<Employee> employees = employeesService.ageReport();
        EmployeeSalaryReportDto employeesSalaryReportDto = new EmployeeSalaryReportDto();
        EmployeesDto highest = new EmployeesDto();
        EmployeesDto lowest = new EmployeesDto();
        BeanUtils.copyProperties(employees.get(0), highest);
        BeanUtils.copyProperties(employees.get(1), lowest);
        employeesSalaryReportDto.setHighest(highest);
        employeesSalaryReportDto.setLowest(lowest);
        return ResponseEntity.ok(employeesSalaryReportDto);
    }
}
