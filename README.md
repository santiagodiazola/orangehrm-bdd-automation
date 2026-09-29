

#  **OrangeHRM BDD Automation Framework**
![Java CI with Maven](https://github.com/santiagodiazola/orangehrm-bdd-automation/actions/workflows/maven.yml/badge.svg)


**Project Goal:** To build a behavior-driven test automation framework validating authentication, user administration, and security workflows on the OrangeHRM platform.

![OrangeHRM Test Execution Success](./evidence/orangehrm-execution.png)

---

## 📊 **Executive Summary**
This repository houses a comprehensive end-to-end test automation suite built using **Java, Selenium WebDriver, Cucumber (BDD), and TestNG**. The framework implements the **Page Object Model (POM)** design pattern to ensure clean separation of concerns, high code reusability, and long-term maintainability.

### **Key Execution Metrics**
* **Total Scenarios:** 5 automated user flows.
* **Pass Rate:** 100% execution success across positive and negative test suites.
* **Design Pattern:** Page Object Model (POM).

---

## 🏗️ **Architectural Framework & Design Patterns**

* **Behavior-Driven Development (BDD):** 
Gherkin syntax bridges the gap between technical automation and functional business requirements.
* **Page Object Model (POM):** 
UI locators and user actions are encapsulated inside dedicated page classes inheriting from a core `BasePage`.
* **Centralized Configuration:** 
Environment variables, application URLs, and global parameters are cleanly managed via `config.properties`.
* **Robust Synchronization:** 
Implements explicit waits within the framework to handle dynamic web elements reliably.

---

## 🛠️ **Tech Stack**
* **Language:** Java
* **Automation Engine:** Selenium WebDriver
* **BDD Parser:** Cucumber (Gherkin)
* **Test Runner & Assertions:** TestNG
* **Build Tool & Dependency Management:** Maven
* **IDE:** IntelliJ IDEA
* **Design Pattern:** Page Object Model (POM)

---

## **Project Structure**
```text
ProyectoFinal_DiazOla/
├── src/
│   ├── main/java/ar/org/icaro/
│   │   ├── pages/           # Page Object classes (BasePage, LoginPage, etc.)
│   │   └── ...
│   └── test/
│       ├── java/ar/org/icaro/ # Step definitions, hooks, and TestRunner classes
│       └── resources/       # Feature files (.feature) and config.properties
├── evidence/                # Execution screenshots and visual documentation
├── pom.xml                  # Maven dependencies and build profiles
└── testng.xml               # TestNG suite runner configuration

   ```
---

## **📊 Reports & Evidence**

This framework generates two types of execution reports for technical and executive analysis:

### **1. Allure Interactive Dashboard**
Visualize advanced metrics charts, test durations, and step breakdowns:
Test cases executed successfully with a 100% pass rate.*
![Allure Dashboard](evidence/allure-report.png)

### **Cucumber Test Execution**
*Detailed report of validated BDD features and steps.*
![Cucumber Report](evidence/cucumber-report.png)

---
