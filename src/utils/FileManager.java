package utils;

import models.Employee;
import models.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public void saveEmployees(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_data.txt"))) {
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," + employee.getName() + "," + employee.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    public void saveSkills(List<Skill> skills) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("skills_data.txt"))) {
            for (Skill skill : skills) {
                writer.write(skill.getId() + "," + skill.getEmployeeId() + "," + skill.getSkillName() + "," + skill.getLevel());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving skills: " + e.getMessage());
        }
    }

    public List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("employee_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String email = parts[2];
                employees.add(new Employee(id, name, email));
            }
        } catch (IOException e) {
            System.out.println("Error loading employees: " + e.getMessage());
        }
        return employees;
    }

    public List<Skill> loadSkills() {
        List<Skill> skills = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("skills_data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                int employeeId = Integer.parseInt(parts[1]);
                String skillName = parts[2];
                String level = parts[3];
                skills.add(new Skill(id, employeeId, skillName, level));
            }
        } catch (IOException e) {
            System.out.println("Error loading skills: " + e.getMessage());
        }
        return skills;
    }
}
