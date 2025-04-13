import managers.EmployeeManager;
import managers.SkillManager;
import models.Employee;
import models.Skill;
import utils.FileManager;
import utils.InputValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager employeeManager = new EmployeeManager();
        SkillManager skillManager = new SkillManager();
        FileManager fileManager = new FileManager();

        // Загрузка данных из файлов
        employeeManager.setEmployees(fileManager.loadEmployees());
        skillManager.setSkills(fileManager.loadSkills());

        System.out.println("Welcome to Employee Skill Tracker!");

        boolean running = true;
        while (running) {
            // Menu
            System.out.println("\nMenu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Add Skill to Employee");
            System.out.println("4. View Employee Skills");
            System.out.println("5. Update Employee Info");
            System.out.println("6. Delete Employee");
            System.out.println("7. Exit");
            System.out.println("8. Generate Reports");
            System.out.println("9. Export Data (CSV)");
            System.out.println("10. Import Data (CSV)");
            System.out.println("11. Export Data (JSON)");
            System.out.println("12. Import Data (JSON)");

            System.out.print("Choose an action: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // Add Employee
                    System.out.print("Enter employee ID: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a number: ");
                        scanner.next();
                    }
                    int employeeId = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    while (!InputValidator.isValidName(name)) {
                        System.out.print("Invalid name. Enter again: ");
                        name = scanner.nextLine();
                    }

                    System.out.print("Enter employee email: ");
                    String email = scanner.nextLine();
                    while (!InputValidator.isValidEmail(email)) {
                        System.out.print("Invalid email. Enter again: ");
                        email = scanner.nextLine();
                    }

                    employeeManager.addEmployee(new Employee(employeeId, name, email));
                    break;

                case 2: // View Employees
                    System.out.println("Employees:");
                    for (Employee emp : employeeManager.getAllEmployees()) {
                        System.out.println(emp);
                    }
                    break;

                case 3: // Add Skill to Employee
                    System.out.print("Enter employee ID to add skill: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a number: ");
                        scanner.next();
                    }
                    int empIdForSkill = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter skill name: ");
                    String skillName = scanner.nextLine();
                    while (!InputValidator.isNotEmpty(skillName)) {
                        System.out.print("Skill name cannot be empty. Enter again: ");
                        skillName = scanner.nextLine();
                    }

                    System.out.print("Enter skill level: ");
                    String level = scanner.nextLine();
                    while (!InputValidator.isNotEmpty(level)) {
                        System.out.print("Skill level cannot be empty. Enter again: ");
                        level = scanner.nextLine();
                    }

                    skillManager.addSkill(new Skill(empIdForSkill, empIdForSkill, skillName, level));
                    break;

                case 4: // View Employee Skills
                    System.out.print("Enter employee ID to view skills: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a number: ");
                        scanner.next();
                    }
                    int empIdForSkills = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.println("Employee Skills:");
                    for (Skill skill : skillManager.getSkillsByEmployee(empIdForSkills)) {
                        System.out.println(skill);
                    }
                    break;

                case 5: // Update Employee Info
                    System.out.print("Enter employee ID to update: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a number: ");
                        scanner.next();
                    }
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter new employee name: ");
                    String newName = scanner.nextLine();
                    while (!InputValidator.isValidName(newName)) {
                        System.out.print("Invalid name. Enter again: ");
                        newName = scanner.nextLine();
                    }

                    System.out.print("Enter new employee email: ");
                    String newEmail = scanner.nextLine();
                    while (!InputValidator.isValidEmail(newEmail)) {
                        System.out.print("Invalid email. Enter again: ");
                        newEmail = scanner.nextLine();
                    }

                    employeeManager.updateEmployee(updateId, newName, newEmail);
                    break;

                case 6: // Delete Employee
                    System.out.print("Enter employee ID to delete: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a number: ");
                        scanner.next();
                    }
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    employeeManager.deleteEmployee(deleteId);
                    break;

                case 7: // Exit
                    fileManager.saveEmployees(employeeManager.getAllEmployees());
                    fileManager.saveSkills(skillManager.getAllSkills());
                    System.out.println("Data saved. Exiting.");
                    running = false;
                    break;

                case 8: // Generate Reports
                    boolean reportMenu = true;
                    while (reportMenu) {
                        System.out.println("\nReports:");
                        System.out.println("1. Total Employees");
                        System.out.println("2. Total Skills");
                        System.out.println("3. Average Skills per Employee");
                        System.out.println("4. Employee with Most Skills");
                        System.out.println("5. Back to Main Menu");

                        System.out.print("Choose report: ");
                        while (!scanner.hasNextInt()) {
                            System.out.print("Invalid input. Please enter a number: ");
                            scanner.next();
                        }
                        int reportChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        switch (reportChoice) {
                            case 1:
                                System.out.println("Total Employees: " + employeeManager.getAllEmployees().size());
                                break;

                            case 2:
                                System.out.println("Total Skills: " + skillManager.getAllSkills().size());
                                break;

                            case 3:
                                int totalEmployees = employeeManager.getAllEmployees().size();
                                int totalSkills = skillManager.getAllSkills().size();
                                double average = totalEmployees == 0 ? 0 : (double) totalSkills / totalEmployees;
                                System.out.printf("Average Skills per Employee: %.2f%n", average);
                                break;

                            case 4:
                                int maxCount = 0;
                                Employee topEmployee = null;
                                for (Employee emp : employeeManager.getAllEmployees()) {
                                    int count = skillManager.getSkillsByEmployee(emp.getId()).size();
                                    if (count > maxCount) {
                                        maxCount = count;
                                        topEmployee = emp;
                                    }
                                }
                                if (topEmployee != null) {
                                    System.out.println("Employee with Most Skills: " + topEmployee.getName() + " (" + maxCount + " skills)");
                                } else {
                                    System.out.println("No employees found.");
                                }
                                break;

                            case 5:
                                reportMenu = false;
                                break;

                            default:
                                System.out.println("Invalid choice. Try again.");
                        }
                    }
                    break;

                case 9:
                    exportToCSV();
                    break;

                case 10:
                    importFromCSV();
                    break;

                case 11:
                    exportToJSON();
                    break;

                case 12:
                    importFromJSON();
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Goodbye!");
    }

    private static void exportToCSV() {
        System.out.println("Exporting data to CSV...");
        // Реализуйте логику экспорта данных в CSV файл
    }

    private static void importFromCSV() {
        System.out.println("Importing data from CSV...");
        // Реализуйте логику импорта данных из CSV файла
    }

    private static void exportToJSON() {
        System.out.println("Exporting data to JSON...");
        // Реализуйте логику экспорта данных в JSON файл
    }

    private static void importFromJSON() {
        System.out.println("Importing data from JSON...");
        // Реализуйте логику импорта данных из JSON файла
    }
}


