package com.example.codeclan.employeeservice.repositories;
import com.example.codeclan.employeeservice.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

////A repository for doing database operations
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
