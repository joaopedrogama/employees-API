package com.ssysemployees.employees.controller;

import org.springframework.web.bind.annotation.RestController;
import com.ssysemployees.core.config.handler.ServiceException;
import com.ssysemployees.employees.domain.Employee;
import com.ssysemployees.employees.dto.EmployeesDto;
import com.ssysemployees.employees.service.EmployeesService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmpolyeesController {

    private final EmployeesService employeesService;


    @PostMapping
    public ResponseEntity<EmployeesDto> create(@RequestBody @Valid EmployeesDto employeeDto) throws ServiceException {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee = employeesService.save(employee);
        BeanUtils.copyProperties(employee, employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeesDto>> list() throws ServiceException {
        List<Employee> employees = employeesService.findAll();
        List<EmployeesDto> employeesDto = employees.stream().map(EmployeesDto::new).toList();
        
        if (employeesDto.isEmpty()) {
            throw new ServiceException("Não foi possível buscar os colaboradores.");
        }

        return ResponseEntity.ok(employeesDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeesDto> update(@RequestBody @Valid EmployeesDto employeeDto, @PathVariable Long id) throws ServiceException {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setId(id);
        employee = employeesService.update(employee);
        BeanUtils.copyProperties(employee, employeeDto);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) throws ServiceException {
        try {
            employeesService.delete(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    
}
