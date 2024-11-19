Feature: Login
 @loginpage
  Scenario: Successful login with valid credentials
    Given User invoke chrome browser
    When user opens url  "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And user enters username as "Admin" and password as "admin123"
    And User click on the ligin button
    Then validate the title "OrangeHRMfhh"
    And close the browser using quit

