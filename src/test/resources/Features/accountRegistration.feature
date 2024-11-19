Feature: Account registration

 Background:
Given User launch chrome browser
    When user opens url 
    Then click on myaccount
    #And close the browser
  
 @regpage
  Scenario Outline: Successful registration with valid credentials
    And click on register
    Then give the first name as "<FName>"
    And give the last name as "<LName>"
    Then give the valid Email as "<Email>"
    And give the mobile number as "1234567890"
    Then give the password and then give the same to confirm pssword as "karthik123"
    And check the check box
    Then then click on the continue button
    And close the browser
    
Examples:
| FName | LName | Email |
| kiran | kakinada | kiran@email.com |
| pranavi | babbu | pranavi@email.com |

@regpage
Scenario: Successful login with valid credentials
    And click on login
    Then enter the email as "kiran@email.com"
    And then enter the password as "karthik123"
    Then click on the login button
    And close the browser

