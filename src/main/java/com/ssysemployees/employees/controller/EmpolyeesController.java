package com.ssysemployees.employees.controller;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@SecurityRequirement(name = "bearer-key")
@RestController("api/employees")
public class EmpolyeesController {
    
}
