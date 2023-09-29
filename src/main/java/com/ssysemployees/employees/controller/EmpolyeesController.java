package com.ssysemployees.employees.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ssysemployees.core.config.handler.ServiceException;
import com.ssysemployees.employees.domain.Employee;
import com.ssysemployees.employees.dto.EmployeesDto;
import com.ssysemployees.employees.service.EmployeesService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@AllArgsConstructor
@SecurityRequirement(name = "bearer-key")
@RestController
@RequestMapping("/api/employees")
public class EmpolyeesController {

    private final EmployeesService employeesService;


    @PostMapping()
    public ResponseEntity<EmployeesDto> postMethodName(@RequestBody @Valid EmployeesDto employeeDto) throws ServiceException {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee = employeesService.save(employee);
        BeanUtils.copyProperties(employee, employeeDto);
        return ResponseEntity.ok(employeeDto);
    }
    
    
}
