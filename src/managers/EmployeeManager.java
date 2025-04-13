package managers;

import models.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
    }

    // Create
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Read
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Update
    public void updateEmployee(int id, String newName, String newEmail) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(newName);
                employee.setEmail(newEmail);
            }
        }
    }

    // Delete
    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    // Сеттер для сотрудников (для загрузки списка сотрудников)
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
