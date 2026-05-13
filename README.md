# csc449
CSC449 — Mr. Coffee Coffee Maker
Object-Oriented Analysis & Design in Java
Solo Brew Team · Anthony Delatorre · National University

Project Overview
This project models a Mr. Coffee drip coffee maker as an object-oriented Java software system. It simulates core hardware and software interactions — power management, brew customization, and water level monitoring — using encapsulation, inheritance, and polymorphism.
ResourceLinkGitHub Repositoryhttps://github.com/MexWhey/csc449Agile Project Boardhttps://github.com/users/MexWhey/projects/1

Project Structure
csc449/
├── src/
│   ├── main/java/com/soloBrew/
│   │   ├── BrewStrength.java       # Enum: MILD, MEDIUM, STRONG
│   │   ├── BrewSettings.java       # Brew preferences (strength + cup count)
│   │   ├── WaterReservoir.java     # Water level tracking and low-water warnings
│   │   ├── BrewController.java     # Core brewing logic
│   │   └── CoffeeMaker.java        # Top-level device class
│   └── test/java/com/soloBrew/
│       ├── BrewControllerTest.java
│       └── BrewSettingsTest.java
├── .github/workflows/ci.yml        # Auto-runs tests on every push
└── pom.xml                         # Maven build with JUnit 5

Running the Project
Prerequisites: Java 17+, Maven
bash# Clone the repo
git clone https://github.com/MexWhey/csc449.git
cd csc449

# Run all unit tests
mvn test

# Or compile and package
mvn clean package
Expected output:
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS

Tests also run automatically via GitHub Actions on every push — check the Actions tab to see the latest results.


Technologies Used

Java 17
JUnit 5
Maven
GitHub Actions (CI/CD)
