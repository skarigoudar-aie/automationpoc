
Feature: Homepage Header and Footer section checks
    
@testRun
Scenario: FPR_TC483_AUTO-205: Verify the Sign 
  Given Go to homepage
  And Click on Sign in link
  And Enter user name "vijay@mail.com"	
	And I enter password "indian143."
	And I click on Sign in button
	And I verify succesfully sign in