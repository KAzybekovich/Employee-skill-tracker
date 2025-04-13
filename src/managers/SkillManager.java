
package managers;

import models.Skill;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SkillManager {
    private List<Skill> skills;

    public SkillManager() {
        skills = new ArrayList<>();
    }

    // Create
    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    // Read
    public List<Skill> getSkillsByEmployee(int employeeId) {
        List<Skill> employeeSkills = new ArrayList<>();
        for (Skill skill : skills) {
            if (skill.getEmployeeId() == employeeId) {
                employeeSkills.add(skill);
            }
        }
        return employeeSkills;
    }

    // Update
    public void updateSkill(int id, String newSkillName, String newLevel) {
        for (Skill skill : skills) {
            if (skill.getId() == id) {
                skill.setSkillName(newSkillName);
                skill.setLevel(newLevel);
            }
        }
    }

    // Delete
    public void deleteSkill(int id) {
        skills.removeIf(skill -> skill.getId() == id);
    }

    // Получение всех навыков
    public List<Skill> getAllSkills() {
        return skills;
    }

    // Сохранение навыков в файл
    public void saveSkillsToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Skill skill : skills) {
                writer.write(skill.getId() + "," + skill.getEmployeeId() + "," + skill.getSkillName() + "," + skill.getLevel());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving skills: " + e.getMessage());
        }
    }

    // Загрузка навыков из файла
    public void loadSkillsFromFile(String fileName) {
        skills.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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
    }

    // Сеттер для списка навыков
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
}
