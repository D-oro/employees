package com.example.codeclan.employeeservice;
import com.example.codeclan.employeeservice.models.Department;
import com.example.codeclan.employeeservice.models.Employee;
import com.example.codeclan.employeeservice.models.Project;
import com.example.codeclan.employeeservice.repositories.DepartmentRepository;
import com.example.codeclan.employeeservice.repositories.EmployeeRepository;
import com.example.codeclan.employeeservice.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeserviceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartmentAndProject(){
		Department department = new Department("Software Development");
		departmentRepository.save(department);
		Project project = new Project("Traveline Scotland Website Improvement", 14);
		projectRepository.save(project);
		Employee employee = new Employee("12345", "Donald Duck", 30, "donald@duckburg.com", department);
		employee.addProject(project);
		employeeRepository.save(employee);
	}

}
