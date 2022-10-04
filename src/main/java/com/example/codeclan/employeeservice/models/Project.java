package com.example.codeclan.employeeservice.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="projectName")
    private String projectName;

    @Column(name="daysToComplete")
    private int daysToComplete;

    @JsonIgnoreProperties({"projects"})
    @ManyToMany
    @JoinTable(
            name="employee_projects",
            joinColumns = {@JoinColumn(
                    name="project_id",
                    nullable=false,
                    updatable=false
            )},
            inverseJoinColumns = {@JoinColumn(
                    name="employee_id",
                    nullable=false,
                    updatable=false
            )}
    )

    private List<Employee> employees;

    public Project(String projectName, int daysToComplete){
        this.projectName = projectName;
        this.daysToComplete = daysToComplete;
        this.employees = new ArrayList<>();
    }

    public Project(){

    }

    public void addEmployeeToProject(Employee employee){
        this.employees.add(employee);
    }

    public void removeEmployeeToProject(Employee employee){
        this.employees.remove(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getDaysToComplete() {
        return daysToComplete;
    }

    public void setDaysToComplete(int daysToComplete) {
        this.daysToComplete = daysToComplete;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
