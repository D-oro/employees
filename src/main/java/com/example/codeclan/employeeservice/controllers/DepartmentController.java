package com.example.codeclan.employeeservice.controllers;

import com.example.codeclan.employeeservice.models.Department;
import com.example.codeclan.employeeservice.models.Employee;
import com.example.codeclan.employeeservice.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value="/departments")
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
}
