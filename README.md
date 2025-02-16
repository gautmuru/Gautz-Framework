# Automation Framework for Web, API, and Mobile Testing

This project is a **comprehensive automation framework** designed to automate tests for **web applications**, **APIs**, and **mobile applications**. It is built using **Java**, **TestNG**, **Selenium**, **RestAssured**, and **Appium**, and follows industry best practices such as the **Page Object Model (POM)**, **Extent Reports**, and **Maven** for dependency management.

---

## **Key Features**

1. **Web Automation**:
   - Automates web application workflows using **Selenium WebDriver**.
   - Supports **cross-browser testing** (e.g., Chrome, Firefox).
   - Implements the **Page Object Model (POM)** for better maintainability.

2. **API Automation**:
   - Automates REST API testing using **RestAssured**.
   - Supports **GET**, **POST**, **PUT**, and **DELETE** requests.
   - Validates API responses and status codes.

3. **Mobile Automation**:
   - Automates mobile app testing using **Appium**.
   - Supports both **Android** and **iOS** platforms.
   - Tests mobile app workflows on emulators and real devices.

4. **Reporting**:
   - Generates detailed test reports using **Extent Reports**.
   - Includes screenshots for failed tests.

5. **Data-Driven Testing**:
   - Uses **JSON files** to store test data (e.g., credentials, API payloads).
   - Supports dynamic data fetching for tests.

6. **Configuration Management**:
   - Centralized configuration using **Constants.java**.
   - Easy to update URLs, file paths, and other configurations.

7. **TestNG Integration**:
   - Uses **TestNG** for test execution and parallel testing.
   - Supports **test suites**, **groups**, and **dependencies**.

8. **Maven Build Tool**:
   - Manages dependencies and builds the project using **Maven**.
   - Easy to integrate with CI/CD pipelines.

---

## **Technologies Used**

- **Programming Language**: Java
- **Test Framework**: TestNG
- **Web Automation**: Selenium WebDriver
- **API Automation**: RestAssured
- **Mobile Automation**: Appium
- **Reporting**: Extent Reports
- **Build Tool**: Maven
- **Data Management**: JSON
- **Version Control**: Git

---

## **Project Structure**
AutomationFramework/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── base/ # Base classes for Web, API, and Mobile
│ │ │ ├── constants/ # Constants and configurations
│ │ │ ├── pages/ # Page classes for Web automation
│ │ │ ├── utilities/ # Utility classes (e.g., JSON parsing, reporting)
│ │ ├── resources/ # Test data and configuration files
│ ├── test/
│ │ ├── java/
│ │ │ ├── web/ # Web automation tests
│ │ │ ├── api/ # API automation tests
│ │ │ ├── mobile/ # Mobile automation tests
│ │ ├── resources/ # TestNG XML files
├── pom.xml # Maven build configuration
├── testng.xml # TestNG suite configuration
├── reports/ # Extent Reports output
├── screenshots/ # Screenshots for failed tests
