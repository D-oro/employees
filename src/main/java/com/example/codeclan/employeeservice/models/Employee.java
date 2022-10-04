package com.example.codeclan.employeeservice.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//An Employee class that conforms to POJO and is annotated with fields name, age, employeeNumber and email.

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="employeeNumber")
    private String employeeNumber;

    @Column(name="name")
    private String name;

    @Column(name="age")
    private int age;

    @Column(name="email")
    private String email;

    @JsonIgnoreProperties({"employees"})
    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;

    @JsonIgnoreProperties({"employees"})
    @ManyToMany
    @JoinTable(
            name="employee_projects",
            joinColumns = {@JoinColumn(
                    name="employee_id",
                    nullable = false,
                    updatable = false
            )},
            inverseJoinColumns = {@JoinColumn(
                    name="project_id",
                    nullable=false,
                    updatable=false
            )}
    )

    private List<Project> projects;

    public Employee(String employeeNumber, String name, int age, String email, Department department){
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.age = age;
        this.email = email;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public Employee(){

    }


    public void addProject(Project project){
        this.projects.add(project);
    }

    public void removeProject(Project project){
        this.projects.remove(project);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
