# Automation Project - AutomationExercise.com [Selenium | Java | TestNG | POM | Maven | Jenkins]

### 🌟 Project Title: 
Automation framework for testing of [Automation Exercise](https://automationexercise.com/)

### ⚡️ Project Overview:
This project demonstrates my automation testing skills using Selenium WebDriver with Java as the programming language and TestNG as the testing framework. The approach reflects real-world automation practices following a Page Object Model (POM) design pattern and a hybrid test structure for scalability and maintainability.

The target application for this automation framework is https://automationexercise.com, a popular practice site for automation testers.

Purpose This framework is developed for demonstration purposes only. AutomationExercise.com is a public website used solely to showcase automated UI test scenarios.<br>

<img width="1164" alt="" src="https://github.com/user-attachments/assets/14a095d8-57bd-444f-8dff-1d13bc1463f8">

## ⚙️ Tools, Languages Frameworks used:

The project uses the following tools, frameworks:

| # | Tech/Tools | Name | Version |
| -------- |-------- | -------- | -------- |
| 1 | Programming language    | Java    | 21.0.7    | 
| 2 | Automation tool    | Selenium webdriver     | 4.33.0     |
| 3 | Testing framework | TestNG | 7.11.0 |
| 4 | Build Tool | Maven | 3.9.9 |
| 5 | IDE | Eclipse | 2023-09(4.29.0) |
| 6 | Reporting tool | Extent Reports | 5.1.1 |
 
## 📜 Project Structure : 
Following is the folder structure for this project : <br>

<img width="500" alt="" src="https://github.com/user-attachments/assets/a64ae39a-ddd8-413b-bbd5-fa63ceff4530">

## 📜 Dependency using in the project:
Following are the dependencies added to the pom.xml for this project : <br>

| # | Name |  Version |
| -------- | -------- | -------- |
| 1 | Selenium java | 4.33.0 |
| 2 | TestNG | 7.11.0 |
| 3 | log4j-api | 2.24.3 |
| 4 | log4j-core | 2.24.3 |
| 5 | Extent Reports | 5.1.1 |
  
<img width="1200" alt="" src="https://github.com/user-attachments/assets/84cef64c-2f70-493b-b372-add6e63e0e47">

## 📜 Design Pattern used - Page Object Model:

**Page Object Model (POM)**: Implement the POM design pattern. This pattern involves creating separate classes for each distinct page or section of the website under test.<br>

**Page Classes**: Each page class encapsulates the web elements and methods required to interact with those elements on that specific page. This separation of concerns improves code maintainability.

Pages classes are saved under following path : "/hybrid-selenium-automation-framework-automationexercise.com/src/main/java/com/ae/pages" <br>

<img width="500" alt="" src="https://github.com/user-attachments/assets/7df29b5b-ac1e-4a7b-97c6-70850f82cbb4">

## 📜 Test cases :

**Test Classes:** Test classes that correspond to different test scenarios or functionalities are created. Tests classes are saved under following path : "/hybrid-selenium-automation-framework-automationexercise.com/src/main/java/com/ae/tests/ <br> 

<img width="500" alt="" src="https://github.com/user-attachments/assets/0b6e21ff-cfa7-48cf-88a3-e647dd2f3142">
<br>

Following are the test cases covered in the this Project:
- User registration  
- Login, logout, and validation flows  
- Searching for products  
- Adding products to cart  
- Placing orders with payment  
- Verifying cart behavior with login state  
- Subscription functionality  

**TestNG Annotations:** TestNG annotations like @Test, @BeforeMethod, and @AfterMethod are used to organize test methods, setup, and teardown logic. <br>

**Page Object Usage:** In your test methods, initialize and use the page objects to interact with web elements on the pages under test.

## 📜 Reporting:

**Test Reporting:** Implemented test reporting using third-party reporting frameworks - ExtentReports. <br>
Reports are saved in the following location : "/guru99bankdemo/Reports/"<br>
<img width="400" alt="" src="https://github.com/user-attachments/assets/9c803ff2-185c-4f68-a6b5-fe9ba893ebbb"> <br>

Extent Report opened automatically on the default browser after the execution is completed.<br>
<img width="1260" alt="chrome_S2hWiML0zU" src="https://github.com/user-attachments/assets/963f9f6c-434a-4283-bef0-a5903ff79650">
<img width="1260" alt="chrome_BniXRJRHB0" src="https://github.com/user-attachments/assets/45f32fc5-354a-40c8-bdd8-d3fd3f4e0a3a">

## 🏃 Running the project:

### 🧪 Cloning the repository:
1. Clone [selenium-automation-framework-automationexercise.com](https://github.com/amulsinfal/selenium-automation-framework-automationexercise.com.git) project from Github<br> 
  ```
    git clone https://github.com/amulsinfal/selenium-automation-framework-automationexercise.com.git
  ```
2. Navigate to the cloned directory<br> 
  ```
    cd selenium-automation-framework-automationexercise.com
  ```   
3. Compile maven dependencies<br> 
  ```
    $ mvn compile
  ```

### Running the Tests Locally:
Step 1. Navigate to the cloned directory<br> 
  ```
    cd selenium-automation-framework-automationexercise.com
  ```  
Step 2: Open command prompt and run the following command <br>
  ```
    mvn clean test
  ```  
  
Shown below is the execution screenshot triggered by the above command : <br>
<img width="900" alt="" src="https://github.com/user-attachments/assets/0903488d-c6af-4c25-808d-267489e811de">  

Step 3: Extent Report open automatically on the default browser after the execution is completed.<br>
<img width="1260" alt="" src="https://github.com/user-attachments/assets/eac4a394-17d9-4a7a-b67f-7be0f5a52e38">
