package com.ssysemployees.employees.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ssysemployees.core.config.handler.ServiceException;
import com.ssysemployees.employees.domain.Employee;
import com.ssysemployees.employees.repository.EmpolyeeRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeesService {

    private final EmpolyeeRepository repository;

    public Employee save(@Valid Employee employee) throws ServiceException {
        try {
            return repository.save(employee);
        } catch (Exception e) {
            throw new ServiceException("Não foi possível cadastrar o colaborador.");
        }
    }

    public List<Employee> findAll() throws ServiceException {
        try{
            return repository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Não foi possível buscar os colaboradores.");
        }
    }

    public Employee update(Employee employee) throws ServiceException {
        try {
            Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
            BeanUtils.copyProperties(employee, existingEmployee);
            return repository.save(existingEmployee);
        } catch (Exception e) {
            throw new ServiceException("Não foi possível atualizar o colaborador.");
        }
    }
    
}
