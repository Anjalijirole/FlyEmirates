# Emirates Flight Search Automation

This repository contains a project for automating the flight searching process on Emirates website using Selenium.

# Problem Statement
The Flight Search Automation project aims to automate the process of searching flights on a travel website. It fills out the necessary details such as origin, destination, dates and completes the search process automatically.

# Exploration and Planning
* Explored the Emirates website to understand the search flow.
* Identified the need for data-driven testing due to multiple input data requirements.
* Adopted TestNG's data provider for data-driven testing.
  
# Development Steps
* Created a structured folder hierarchy for the project.
* Developed a mind map outlining necessary Page Object Models (POMs) based on website exploration.
* Implemented Page Object Models (POMs) for efficient test automation.
* Created test runners to initiate flight searches, passing required data through a JSON file.
* Developed utility files containing reusable methods such as generic date picker and waiting for web element visibility.
* Integrated TestListeners and generated comprehensive Extent Reports for detailed test reporting.

# What I liked
* Experience with Time-Bound Testing: Despite the time constraint, it was rewarding to apply my coding skills and testing knowledge to complete the task efficiently.

# Issues I faced
* Date Picker Complexity: One challenging aspect was dealing with the complexity of the date picker. I had to write custom recursive logic to handle this efficiently.
* Element Load Delays: I faced delays in element loading, which required explicit waiting to ensure elements were clickable before proceeding with actions.
  
# Features
* Automated Form Filling: Fills out the flight search form with details such as origin, destination, dates, and selects One way travel.
* Error Handling: Handles errors gracefully and provides informative messages in case of failures.
* Validation: Validates the search result with the search params.

# Installation
1. Clone the repository:
   git clone [https://github.com/your_username/flight-booking-automation.git](https://github.com/Anjalijirole/FlyEmirates.git)
2. Navigate to the project directry:
  cd FlyEmirates
3. Run the script:
   mvn clean test
  OR
   Open eclipse and project in it ,navigate to testng.xml and run the testng.xml file.

# Technologies Used
* Java: Programming language used for automation and scripting.
* Selenium: Web automation framework used for interacting with web elements and automating browser actions.
* TestNg : Unit Testing framework
* Extent Reports: Utilized for generating rich and informative test reports
* WebDriver: Interface used by Selenium to automate web browsers.
* ChromeDriver: WebDriver implementation used for automating Google Chrome.
* JSON: Used for storing and passing test data.

# Dependencies
|Library                        |Version    |
|-------------------------------|-----------|
|Testng                         |7.8.0      |                 
|com.aventstack(ExtentReports)  |5.1.1      |
|org.seleniumhq.selenium        | 4.16.1    |
|jackson-databind               | 2.16.0    |

# Test Output Screenshot
![image](https://github.com/Anjalijirole/FlyEmirates/assets/105169120/d829fbe4-cee8-4dc8-bef9-9d81e7a23e7e)


