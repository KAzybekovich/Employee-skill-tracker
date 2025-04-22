# Employee Skill Tracker

**Developed by:** [Saliev Yntymak]  
**Course:** Programming Language  
**University:** Ala-Too International University  
**Date:** April 2025

---

## 📘 Project Description

The **Employee Skill Tracker** is a Java-based console application designed to manage employees and their skills. It enables users to:

- Add, update, delete, and view employee records.
- Track skills associated with each employee.
- Generate reports and export/import data in CSV and JSON formats.

The project uses **Object-Oriented Programming (OOP)** principles and follows a **modular design** for scalability and maintainability.

---

## 🎯 Objectives

| Objective                                            | Status           |
| ---------------------------------------------------- | ---------------- |
| **Implement CRUD operations**                        | ✅ Fully Implemented |
| **Provide command-line interface**                   | ✅ Fully Implemented |
| **Validate input data**                              | ✅ Fully Implemented |
| **Persist data in text files**                       | ✅ Fully Implemented |
| **Generate meaningful reports**                      | ✅ Fully Implemented |
| **Support data export/import in CSV and JSON formats**| ✅ Fully Implemented |
| **Follow modular design principles**                | ✅ Fully Implemented |

---

## ⚙️ Features

### 🔄 CRUD Operations

- **Create Employee**: `addEmployee()` → Option 1
- **Read Employee Info**: `viewEmployees()` → Option 2
- **Update Employee Info**: `updateEmployee()` → Option 3
- **Delete Employee**: `deleteEmployee()` → Option 4

### 🖥️ Command Line Interface (CLI)

**Main Menu:**

1. **Add New Employee**
2. **View Employees**
3. **Update Employee Info**
4. **Delete Employee Record**
5. **Generate Reports**
6. **Export Data (CSV)**
7. **Import Data (CSV)**

### 🧪 Input Validation

- Validates employee names, emails, and other fields.
- Ensures valid data formats for emails and skill entries.

### 💾 Persistent Data

- **employees.txt**: Stores employee records.
- **skills.txt**: Stores employee skills.
- **reports.txt**: Stores generated reports.

### 🧩 Modular Design

```plaintext
classDiagram
    class Employee {
        +id
        +name
        +email
        +skills[]
        +display()
    }

    class Skill {
        +id
        +name
        +level
        +assignToEmployee()
    }

    class Main {
        +main()
    }
## 📊 Report Generation
generateEmployeeReport(): Displays total employees, total skills, average skills per employee, and more.

## ⚠️ Error Handling
Try-catch blocks for invalid input and file I/O errors.

🔐 Data Export/Import
CSV Export/Import: For saving and loading employee and skill data.

## 🧠 Algorithms
📊 Report Generation
Employee Report: Calculates total number of employees, total number of skills, and average number of skills per employee.

🧩 Data Processing
Uses ArrayList for storing employee records and skills.

## 💾 Data Structures
ArrayList: For employee and skill records.

HashMap: For managing employee skill assignments.

File: For storing persistent data in text files.

## 🧩 Modules Overview
Module                    Description
Employee Management	      CRUD operations, file I/O, display
Skill Management	         Assigning and managing employee skills
Report Generation	        Generating employee and skill reports
Data Export/Import	       Exporting and importing data to/from CSV

## 🔍 Example Use Cases
🧪 Add New Employee
ADD EMPLOYEE - 1
Name: John Doe
Email: johndoe@example.com
Skills: Java, C++

🧪 View Employee Information
VIEW EMPLOYEE - 2
Employee ID: 1
Skills: Java, C++, Python

🧪 Export Data (CSV/JSON)
EXPORT DATA - 6
Format: CSV
File: employees.csv


## 📁 Files Used
employees.txt — Stores employee records.

skills.txt — Stores employee skills.

reports.txt — Stores generated reports.

## ✅ Run Instructions
Open the project in your IDE (e.g., IntelliJ IDEA).

Run Main.java.

Interact via CLI:

Choose options to add, update, view, or delete employee records.

Export and import data using CSV/JSON options.

## 📌 Notes
Ensure that the text files (employees.txt, skills.txt, reports.txt) are located in the same directory as the program.

Preloaded data (e.g., employee records) can be modified directly in the text files.

Feel free to fork, contribute, or suggest improvements!


