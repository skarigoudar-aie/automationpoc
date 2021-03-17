@practice
Feature: Account Management checks

@testRun001
  Scenario: FPR_TC546_AUTO-Demo: Sign in to application
  Given Go to Mk Home page1
    And click on Signin link1
    And Enter usernme 'test99@gmail.com'
    And Enter pssword "test@123"
    And click on Signin btn
    #Then user navigate to profile page
    
    
   @firstScript_Low_TC007
  Scenario:  To Verify that system restricts user to register if the user data is already exist in epicor and displays the proper error message.
    Given Go to Mk Home page1
    And click on Signin link1
    And Enter email address 'test99@gmail.com'
    And Enter confirm email address 'test99@gmail.com'
    And Enter firstname 'John'
    And Enter lastname 'Smith'
    And Enter password 'test@321'
    And Enter confirm password 'test@321'
    And click on terms and condition
    When click on register button
    Then verify email address already exist error message
   