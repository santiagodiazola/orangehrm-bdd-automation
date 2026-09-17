

# OrangeHRM BDD Automation Framework

An end-to-end automated testing framework built for the **OrangeHRM** application using industry-standard BDD and automation tools.

## 🚀 Tech Stack
* **Language:** Java
* **Automation Tool:** Selenium WebDriver
* **BDD Framework:** Cucumber (Gherkin syntax)
* **Test Runner & Assertions:** TestNG
* **Build Tool:** Maven
* **Design Pattern:** Page Object Model (POM)
* **Driver Management:** WebDriverManager

---

## 🛠️ Project Structure
```text
orangehrm/
├── src/
│   ├── main/java/ar/org/icaro/pages/     # Page Object Model classes (LoginPage, DashboardPage, PIMPage)
│   └── test/
│       ├── java/ar/org/icaro/           # Step definitions and Hooks configuration
│       └── resources/                   # Feature files (.feature) and TestNG runner config
├── pom.xml                              # Maven dependencies and build plugins
└── testng.xml                           # TestNG suite runner configuration
