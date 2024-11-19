Feature: AdminPage
 
 #we use Background when we have common steps in the scenarios 
Background: below are the common steps for all the scenarios
    Given User invoke chrome browser
    When user opens url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" 
    And user enters username as "Admin" and password as "admin123"
    And User click on the ligin button
    Then validate the title "OrangeHRM"

@adminpage
Scenario: Successful added the user
    And click on admin button
    Then click on the add button
    And click on the dropdown of the role and select role as "Admin"
    Then click on the dropdown of the status and select status as "Disabled"
    And enter on the empname as "R" 
    Then enter the username as "sundharkl"
    And enter the password and confirm password as "sundhar13" 
    Then click on save button
    And close the browser using quit
    
 @adminpage   #if we are using exaples then we use Scenario Outline
Scenario Outline: Data driven
    And click on admin button
    Then click on the add button
    And click on the dropdown of the role and select role as "Admin"
    Then click on the dropdown of the status and select status as "Disabled"
    And enter on the empname as "R" 
    Then enter the username as "<AdminUserName>"
    And enter the password and confirm password as "<AdminPass>" 
    Then click on save button
    And close the browser using quit
    #for data driven we use examples
    Examples:
            |AdminUserName|AdminPass|
            |kartick|kartick123|
            |kiran|kiran123|


