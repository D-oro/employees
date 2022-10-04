package com.example.codeclan.employeeservice.controllers;

import com.example.codeclan.employeeservice.models.Department;
import com.example.codeclan.employeeservice.models.Project;
import com.example.codeclan.employeeservice.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping(value="/projects")
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }
}
