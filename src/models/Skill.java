
package models;

public class Skill {
    private int id;
    private int employeeId;
    private String skillName;
    private String level;

    public Skill(int id, int employeeId, String skillName, String level) {
        this.id = id;
        this.employeeId = employeeId;
        this.skillName = skillName;
        this.level = level;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getLevel() {
        return level;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Skill ID: " + id + ", Employee ID: " + employeeId + ", Skill Name: " + skillName + ", Level: " + level;
    }
}

