Single framework Web, API and Mobile Testing with Cucumber BDD feature.


WEB UI Automation Using - Selenium.

API Automation Using    - Rest Assured.

Mobile Testing using    - Appium.

//ToDo

execute the test using  -  mvn clean install -Dcucumber.filter.tags="<tagname>"  or mvn clean test  -Dcucumber.filter.tags="<tagname>
-------------------
Test Automation Framework Setup Guide
This guide provides setup instructions for three automation frameworks:

Cucumber-Selenium for Web Testing
REST Assured for API Testing
Appium for Mobile Testing


Cucumber-Selenium Setup
Prerequisites

Java JDK 11 or higher
Maven
IDE (Eclipse/IntelliJ)
Chrome/Firefox browser

----------
Appium Setup
Prerequisites

Install Node.js

Download from: https://nodejs.org/
Verify installation: node --version


Install Java JDK

Download JDK 11 or higher
Set JAVA_HOME environment variable


Install Android Studio

Download from: https://developer.android.com/studio
Install Android SDK
Set ANDROID_HOME environment variable


Install Appium
bashCopynpm install -g appium
npm install -g appium-doctor

Install Appium Inspector

Download from: https://github.com/appium/appium-inspector/releases

---

Running Tests

Start Appium server
Launch Android emulator
Run tests:
mvn clean test  -Dcucumber.filter.tags="<tagname>"
