package com.ssysemployees.employees.service;

import java.util.ArrayList;
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

    /**
     * Criar um novo employee no banco
     * 
     * @param employee - objeto com as proriedades que serão salvas
     * @return
     * @throws ServiceException
    */ 
    public Employee save(@Valid Employee employee) throws ServiceException {
        try {
            return repository.save(employee);
        } catch (Exception e) {
            throw new ServiceException("Não foi possível cadastrar o colaborador.");
        }
    }

    /**
     * Retorna uma lista de employees do banco
     * 
     * @return
     * @throws ServiceException
     */
    public List<Employee> findAll() throws ServiceException {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new ServiceException("Não foi possível buscar os colaboradores.");
        }
    }

     /**
     * Atualiza employee no banco
     * 
     * @param employee - objeto com as proriedades que serão atualizadas
     * @return
     * @throws ServiceException
    */ 
    public Employee update(Employee employee) throws ServiceException {
        try {
            Employee existingEmployee = repository.findById(employee.getId()).orElse(null);
            BeanUtils.copyProperties(employee, existingEmployee);
            return repository.save(existingEmployee);
        } catch (Exception e) {
            throw new ServiceException("Não foi possível atualizar o colaborador.");
        }
    }

    /**
     * Deleta um employee do banco
     * 
     * @param id - ID do employee que será deletado
     * @throws ServiceException
     */
    public void delete(Long id) throws ServiceException {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ServiceException("Não foi possível deletar o colaborador.");
        }
    }

    /**
     * retorna uma lista com os employees mais jovens e mais velhos
     * 
     * @return
     * @throws ServiceException
     */
    public List<Employee> ageReport() throws ServiceException {
        try {
            List<Employee> employees = new ArrayList<>();
            employees.add(repository.findYoungerEmployee());
            employees.add(repository.findOlderEmployee());
            return employees;
        } catch (Exception e) {
            throw new ServiceException("Não foi possível buscar os colaboradores.");
        }
    }

    /**
     * retorna uma lista com o employee com maior salário e o employee com menor salário
     * 
     * @return
     * @throws ServiceException
     */
    public List<Employee> salaryReport() throws ServiceException {
        try {
            List<Employee> employees = new ArrayList<>();
            employees.add(repository.findHighestSalary());
            employees.add(repository.findLowestEmployee());
            return employees;
        } catch (Exception e) {
            throw new ServiceException("Não foi possível buscar os colaboradores.");
        }
    }

    /**
     * Encontra um employee por ID
     * 
     * @return
     * @throws ServiceException
     */
    public Employee findById(Long id) throws ServiceException {
        return repository.findById(id)
                .orElseThrow(() -> new ServiceException("Não foi possível buscar o colaborador de id: " + id));
    }

}
