package com.example.codeclan.employeeservice.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="department")
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="departmentName")
    private String departmentName;

    @JsonIgnoreProperties({"department"})
    @OneToMany(mappedBy="department", fetch=FetchType.LAZY)
    private List<Employee> employees;

    public Department(String departmentName){
        this.departmentName = departmentName;
        this.employees = new ArrayList<>();
    }

    public Department(){

    }

    public void addEmployees(Employee employee){
        this.employees.add(employee);
    }

    public void removeEmployees(Employee employee){
        this.employees.remove(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
