# ExecutiveAssistCo Test Suite

This repository contains a combined **UI automation suite** (Swag Labs checkout flow) and an **API automation suite** (CRUD tests against `restful-api.dev`) built with **Java**, **Maven**, **Selenium**, **RestAssured**, and **Cucumber**.

---

# 🚀 Setup Instructions (Windows)

## 1. Install Java

Download and install **Java JDK 17** or later.

Set `JAVA_HOME`:

```powershell
setx JAVA_HOME "C:\Program Files\Java\jdk-17"
setx PATH "%JAVA_HOME%\bin;%PATH%"
```

Verify the installation:

```powershell
java -version
```

---

## 2. Install Maven

Download **Apache Maven** from:

https://maven.apache.org/

Set `MAVEN_HOME`:

```powershell
setx MAVEN_HOME "C:\apache-maven-3.9.6"
setx PATH "%MAVEN_HOME%\bin;%PATH%"
```

Verify the installation:

```powershell
mvn -version
```

---

## 3. Install IntelliJ Plugins

Go to:

**Settings → Plugins**

Install the following plugins:

- Cucumber for Java
- Gherkin

---

# 🧪 How to Run

There are multiple ways to execute the test suites.

## Run as JUnit

Right-click the project folder and select:

```
Run As → JUnit Test
```

---

## Run UI Tests

Navigate to:

```
src/test/java/testAutomation/UI/CheckoutStepDefinitions.java
```

Right-click the file and select:

```
Run As → JUnit Test
```

---

## Run API Tests

Navigate to:

```
src/test/java/testAutomation/API/RestfulApiSteps.java
```

Right-click the file and select:

```
Run As → JUnit Test
```

---

## Run via Cucumber Feature Files

Navigate to either:

```
src/test/resources/UI
```

or

```
src/test/resources/API
```

Right-click the desired `.feature` file and click **Run**.

---

# 🛠 Tools Used

- **Java** – Programming language
- **Maven** – Build and dependency management
- **Selenium / Selenide** – UI automation
- **Cucumber (Java + JUnit)** – BDD framework
- **RestAssured** – API automation
- **IntelliJ IDEA** – Development environment

---

# ✅ Test Coverage

## UI Layer

### Scenarios Covered

- Login
- Add to Cart
- Remove from Cart
- Checkout Flow

### Negative Test
- Error message validation

**Reasoning**

UI tests validate complete end-to-end user journeys and verify that users receive the correct visual feedback.

---

## API Layer

### CRUD Operations

- Create
- Read
- Update
- Delete

### Negative Test Cases

- Invalid ID (`404`)
- Missing required field (`400`)

**Reasoning**

API tests verify business logic and backend functionality independently of the UI, making them faster and less brittle.

---

# 🔮 Improvements With More Time

- Enable parallel test execution
- Implement the Page Object Model (POM) for improved maintainability
- Expand negative test coverage (authentication failures, malformed payloads, edge cases)
- Integrate reporting tools such as Allure or Extent Reports

---

## 🤖 AI Tooling Disclosure

AI (Microsoft Copilot) was used as a development aid during this project to assist with portions of the API automation and the initial README structure.

### AI Assistance

- Generated initial RestAssured boilerplate and step definition templates
- Provided the initial README outline and formatting suggestions
- Implemented and validated request payloads, assertions, and test logic

### My Contributions

- Designed and implemented the complete UI automation suite from scratch
- Developed the API test scenarios and finalized the implementation
- Reviewed, corrected, and refined all AI-generated code before use
- Tested and debugged the application to verify functionality
- Reviewed, expanded, and finalized all project documentation

**Reasoning**
AI was used as a productivity tool to help generate initial boilerplate and documentation. The UI automation was developed entirely by me, while the API automation was implemented and refined through manual development, testing, and debugging. All AI-generated content was reviewed, corrected where necessary, and validated to ensure it accurately met the project requirements.

# 📂 Project Structure

```text
executiveAssistCo-Test/
│
├── pom.xml
│
└── src/
    ├── test/
    │   ├── java/
    │   │   └── testAutomation/
    │   │       ├── UI/
    │   │       │   └── CheckoutStepDefinitions.java
    │   │       └── API/
    │   │           └── RestfulApiSteps.java
    │   │
    │   └── resources/
    │       ├── UI/
    │       │   └── checkout.feature
    │       └── API/
    │           └── restful_api.feature
```

---

# 📦 Maven Dependencies

This project includes dependencies for:

- Selenium
- Selenide
- Cucumber (Java)
- Cucumber JUnit
- JUnit
- RestAssured

See `pom.xml` for the complete dependency list.

---

# ▶️ Quick Start

Clone the repository:

```bash
git clone https://github.com/marvvillaruel/ExecutiveAssistCo-Test.git
```

Navigate into the project:

```bash
cd executiveAssistCo-Test
```

Install dependencies and run the tests:

```bash
mvn clean test
```

---

## Author

**Marvin Villaruel**  
GitHub: https://github.com/marvvillaruel

Created as part of the ExecutiveAssistCo QA Automation Technical Assessment.he ExecutiveAssistCo QA Automation Technical Assessment.