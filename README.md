# QA Final Project – Saucedemo Web UI & DummyAPI Testing
This is the final project for QA Engineering, combining **Web UI testing** for [saucedemo.com](https://www.saucedemo.com/) and **API testing** using [dummyapi.io](https://dummyapi.io/).

## Initial Project Setup
- Language: java
- Build System: Gradle
- JDK: Temurin 20
- Gradle DSL: Groovy

## Tools & Libraries Used
### Web UI Testing:
- Selenium WebDriver
- Cucumber (Gherkin BDD)
- JUnit
- ChromeDriver (headless or regular mode)

### API Testing:
- RestAssured
- Hamcrest Matchers

## Test Descriptions
### Web UI Test Scenarios:
1. End to End test
2. Login with invalid credentials
3. Login with empty credentials
4. Cart badge increases when adding an item
5. Logout from menu

### API Test Scenarios:
Using dummyapi.io to:
1. fetch all user data
2. fetch full data from known user ID
3. Fetch user by invalid ID format
4. Fetch user by non-existent valid ID
5. Fetch users with limit parameter set to 0

## How To Run Test Locally
### Run Web UI Tests:
./gradlew webTests

### Run API Tests:
./gradlew apiTests

## note
the web tests may still not be stable. meaning the tests can return the error message about "TimeoutException" or "NoSuchElementException". as far as i know, this happen because the element take too many time to load properly. i already add the wait function in order to make sure the element is properly loaded first before interacting with the automation code, but it seems didnt give enough stability of tests that we need. but i do have the proof that this tests is successfully ran sometimes locally on my computer
