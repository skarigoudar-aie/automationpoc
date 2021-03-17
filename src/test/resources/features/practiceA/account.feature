Feature: account
    
@practice1
  Scenario: Create Account
    Given I am a mk customer
    When I click on Join link
    And I enter First Name "Asifulla"
    And I enter Last Name "Buden"
    And I enter Email ID "abuden.160321.h@mailinator.com"
    And I enter Password "Test@123"
    And I enter Confirm Password "Test@123"
    And I enter Zipcode "07073"
    And I click on Create account button
    Then I validate Successfully Created Account
    