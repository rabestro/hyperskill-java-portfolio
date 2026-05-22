# JetBrains Academy (Hyperskill) — Java Portfolio

[![Java Version](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)
[![Build System](https://img.shields.io/badge/Build-Gradle-blue.svg)](https://gradle.org)

Welcome! This repository is a cohesive, multi-module monorepo consolidating my practical Java project solutions from the
**JetBrains Academy (Hyperskill)** tracks.

Instead of maintaining dozens of isolated repositories, this project centralizes all solutions into a unified Gradle
ecosystem, ensuring clean dependency management, shared build logic, and enhanced maintainability.

---

## 🛠️ Tech Stack & Architecture

- **Language:** Java 21+
- **Build System:** Gradle (Kotlin DSL) structured as a multi-module project.
- **Testing Framework:** JUnit 5 (configured globally for all subprojects).
- **Design Philosophy:** Every challenge or application lives inside an isolated Gradle module. This allows individual
  modules to be developed, tested, and executed independently, while still benefiting from a centralized configuration.

---

## 📁 Project Portfolio

The following table lists the projects included in this monorepo, categorized by their focus and platform complexity:

| Project Module          | Complexity | Description / Core Concepts Covered                                                                           |
|:------------------------|:-----------|:--------------------------------------------------------------------------------------------------------------|
| `cinema-room-manager`   | Medium     | Seat booking system handling multi-dimensional arrays, loops, and conditional logic.                          |
| `encryption-decryption` | Medium     | Command-line utility implementing basic cryptographic algorithms (Shift and Caesar ciphers).                  |
| `contacts`              | Hard       | Interactive contact management app emphasizing OOP principles, search/regex functionality, and serialization. |

*(Note: Update this list as you migrate or finish more projects)*

---

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 21 or higher installed.

### Installation

Clone the repository locally:

```bash
git clone [https://github.com/your-username/hyperskill-java-portfolio.git](https://github.com/your-username/hyperskill-java-portfolio.git)
cd hyperskill-java-portfolio

```

### Building and Testing

Gradle wrapper handles everything automatically—no local Gradle installation is required.

* **Compile and run tests for all modules:**

```bash
  ./gradlew test

```

* **Run a specific module** (e.g., `cinema-room-manager` assuming the application plugin is configured):

```bash
  ./gradlew :cinema-room-manager:run

```

* **Clean the build directories:**

```bash
  ./gradlew clean

```

---

*Disclaimer: The source code shared here is intended solely for educational purposes, personal progress tracking, and
portfolio demonstration.*
