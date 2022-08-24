# Java + Playwright QA Automation Capstone Project
Front-end Automation

## Introduction

The purpose of this challenge is aimed to make the mentee to experiment a role play making a proposal with the client on a testing architecture, explaining What and Why was it designed that way.

# Saucedemo Front-End

## Tech Stack

* [Java](https://www.java.com/en/) - Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.
* [Playwright](https://playwright.dev/) - Playwright enables reliable end-to-end testing for modern web apps
* [dotenv](https://search.maven.org/artifact/com.harium/dotenv/1.0.8/jar) - Zero-dependency module that loads environment variables from a .env file into process.env
* [testNG](https://search.maven.org/artifact/org.testng/testng/7.6.1/jar) - A testing framework for Java

## Project structure
```
.
├──
├──capstoneProject
│    ├── .github
│    │   ├── workflows
│    │   │   └── integration.yml.js    # Gtihub Actions file
│    ├── src		
│    │   ├── main
│    │   │   └── java
│    │   │        └── pom     # Main Page Object Model folder.
│    │   │             ├── data		# Data providers, Roles.
│    │   │             │    └── constants.java
│    │   │             ├── pages		# All the pages.
│    │   │             │    ├── cartPage.java
│    │   │             │    ├── inventoryItemPage.java
│    │   │             │    ├── loginPage.java
│    │   │             │    └── productsPage.java
│    │   │             └── utils		# Playwright code
│    │   │                 └── playwrightBase.java
│    │   └── test		# Our test files are located here.
│    │       └── java
│    │            ├── cartTest.java
│    │	          ├── inventoryItemTest.java
│    │	          ├── loginTest.java
│    │            └── navigationTest.java 
│    ├── .env
│    ├── .gitignore
│    ├── pom.xml
│    └── README.md
```

## Pre-requisites

* [IntelliJDEA](https://www.jetbrains.com/idea/)
* [JDK](https://www.oracle.com/java/technologies/downloads/) 
* Git
* Browsers must be installed: Chrome.

## Installation

Clone this repository.
```
git clone https://github.com/wizeline/java-capstone-project
```
Open the folder on the IntelliJIDEA and run the following
```
mvn build
```

Finally, you will need a .env file in the root of the project. Create the file, name it .env, paste and save the following as content:
```
VALID_USERNAME=usernameExample
VALID_PASSWORD=passwordExample
```
Don't forget to replace in the .env file the fake credentials with your real credentials to access to the saucedemo web page.

Now you are ready to have fun.

## Execution 

To run all the tests in chrome, located in the root of the project, run in the terminal:
```
mvn clean test
```
To run the Smoke Testing suite, run in the terminal:
```
mvn test -Dgroups=smoke 
```


In order to see the report, after run each test, don't forget to run in the terminal:
```
allure serve allure-results
```
Apart from Allure reporter, surefire report is also running, in order to see the report, just go to the following path: target/surefire-reports/index.html and drag and drop the index.html file on a Chrome browser. On the github actions, this report is the one that is downloaded and zipped. Just open the FE-report folder and find this file, drag and drop it on a Chrome browser.


** This project was developed on MacOS Monterrey 12.5.1
