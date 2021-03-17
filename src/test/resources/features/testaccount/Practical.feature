#Author: sajkumar@aienterprise.com

@Practice
Feature: Title of your feature
  I want to use this template for my feature file
  
  @Sajay
   Scenario: FPR_TC011 : Verify if user is able to signin
    #Given Go to MK Home page
    And Click on MK Signin button from header
    And Enter username 'mktester.int.us@gmail.com' in the Signin poup
    And Enter Password 'Tester1*' in the Signin poup
    Then Click on Signin button to login on the MK Site
    And I have signed in successfully 
