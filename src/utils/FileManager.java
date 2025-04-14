package utils;

import models.Employee;
import models.Skill;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String EMPLOYEE_CSV_FILE = "employee_data.csv";
    private static final String SKILL_CSV_FILE = "skills_data.csv";

    // Saves a list of employees to a .txt file
    public void saveEmployees(List<Employee> employees) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_data.txt", true))) {  // Appending to the file
            // Output the absolute path to confirm where the file is being saved
            System.out.println("Saving file: " + new File("employee_data.txt").getAbsolutePath());

            for (Employee employee : employees) {
                writer.write(employee.getId() + "," + employee.getName() + "," + employee.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving employees: " + e.getMessage());
        }
    }

    // Saves a list of skills to a .txt file
    public void saveSkills(List<Skill> skills) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("skills_data.txt", true))) {  // Appending to the file
            // Output the absolute path to confirm where the file is being saved
            System.out.println("Saving file: " + new File("skills_data.txt").getAbsolutePath());

            for (Skill skill : skills) {
                writer.write(skill.getId() + "," + skill.getEmployeeId() + "," + skill.getSkillName() + "," + skill.getLevel());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ Error saving skills: " + e.getMessage());
        }
    }

    // Loads a list of employees from a .txt file
    public List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();
        File file = new File("employee_data.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("⚠️ File employee_data.txt not found. It will be created upon saving.");
            return employees;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.out.println("⚠️ Skipped invalid employee line: " + line);
                    continue;
                }
                try {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    employees.add(new Employee(id, name, email));
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Skipped line with incorrect employee ID format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading employees: " + e.getMessage());
        }

        return employees;
    }

    // Loads a list of skills from a .txt file
    public List<Skill> loadSkills() {
        List<Skill> skills = new ArrayList<>();
        File file = new File("skills_data.txt");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("⚠️ File skills_data.txt not found. It will be created upon saving.");
            return skills;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.out.println("⚠️ Skipped invalid skill line: " + line);
                    continue;
                }
                try {
                    int id = Integer.parseInt(parts[0]);
                    int employeeId = Integer.parseInt(parts[1]);
                    String skillName = parts[2];
                    String level = parts[3];
                    skills.add(new Skill(id, employeeId, skillName, level));
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Skipped line with incorrect ID or employee ID format: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error loading skills: " + e.getMessage());
        }

        return skills;
    }

    // Exports employees and skills to CSV format
    public void exportToCSV(List<Employee> employees, List<Skill> skills) {
        try (PrintWriter empWriter = new PrintWriter(EMPLOYEE_CSV_FILE);
             PrintWriter skillWriter = new PrintWriter(SKILL_CSV_FILE)) {

            // Output the absolute paths to confirm where the files are being saved
            System.out.println("Saving employees to CSV: " + new File(EMPLOYEE_CSV_FILE).getAbsolutePath());
            System.out.println("Saving skills to CSV: " + new File(SKILL_CSV_FILE).getAbsolutePath());

            empWriter.println("ID,Name,Email");
            for (Employee emp : employees) {
                empWriter.printf("%d,%s,%s%n", emp.getId(), emp.getName(), emp.getEmail());
            }

            skillWriter.println("ID,EmployeeID,SkillName,Level");
            for (Skill skill : skills) {
                skillWriter.printf("%d,%d,%s,%s%n", skill.getId(), skill.getEmployeeId(), skill.getSkillName(), skill.getLevel());
            }

            System.out.println("✅ Data successfully exported to CSV.");
        } catch (IOException e) {
            System.out.println("❌ Error exporting to CSV: " + e.getMessage());
        }
    }

    // Imports employees from CSV file
    public List<Employee> importEmployeesFromCSV() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(EMPLOYEE_CSV_FILE))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String email = parts[2];
                    employees.add(new Employee(id, name, email));
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error importing employees from CSV: " + e.getMessage());
        }
        return employees;
    }

    // Imports skills from CSV file
    public List<Skill> importSkillsFromCSV() {
        List<Skill> skills = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(SKILL_CSV_FILE))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    int employeeId = Integer.parseInt(parts[1]);
                    String skillName = parts[2];
                    String level = parts[3];
                    skills.add(new Skill(id, employeeId, skillName, level));
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error importing skills from CSV: " + e.getMessage());
        }
        return skills;
    }
}
