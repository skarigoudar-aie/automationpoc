Feature: Special characters checks

  @guestOrderPlacement @specialCharacters @euOnly @Regression_AIE @regression_set2
  Scenario Outline: FPR_TC458_AUTO-190: Very special characters are accepted  in  first name, last name, at checkout and at account level for a Guest User
    Given I am a mk customer having "specialcharacters" in my first and last name
    Given I have "<firstname>" and "<lastname>" special characters
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
 		And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields with "<firstname>" and "<lastname>" having special charecters
    And SHIPPING: I click Ship to this address
    Then SHIPPING: I verify new shipping address is saved with special characters first name and last name for "guest"
    And SHIPPING: I click Continue to review and pay
    And BILLING: I add new billing address for guest "<firstname>" and "<lastname>" containing special charecters
    And BILLING: I click save button to save new address
    Then BILLING: I verify new billing address is saved with special characters first name and last name for "guest"
 		
 		Examples:
 		|firstname| lastname 	|
		| 1_fname | 1_lname |
		| 2_fname | 2_lname |
#		| 3_fname | 3_lname |
#		| 4_fname | 4_lname |
#		| 5_fname | 5_lname |
#		| 6_fname | 6_lname |
#		| 7_fname | 7_lname |
#		| 8_fname | 8_lname |
#		| 9_fname | 9_lname |
#		| 10_fname |10_lname|
#		| 11_fname |11_lname|
#		| 12_fname |12_lname|
#		| 13_fname |13_lname|
#		| 14_fname |14_lname|
#		| 15_fname |15_lname|
#		| 16_fname |16_lname|
#		| 17_fname |17_lname|
#		| 18_fname |18_lname|
#		| 19_fname |19_lname|
#		| 20_fname |20_lname|
#		| 21_fname |21_lname|
#		| 22_fname |22_lname|
#		| 23_fname |23_lname|
#		| 24_fname |24_lname|
#		| 25_fname |25_lname|

    @guestOrderPlacement @specialCharacters @naOnly
  	Scenario Outline: FPR_TC458_AUTO-190: Very special characters are accepted  in  first name, last name, at checkout and at account level for a Guest User
    Given I am a mk customer having "specialcharacters" in my first and last name
    Given I have "<firstname>" and "<lastname>" special characters
    And I hold a "Visa" credit card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > View All Handbags"
    And I am on the product listing page
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    Then SHIPPING: I verify new shipping address is saved with special characters first name and last name for "guest"
    And BILLING: I click on card payment option
    And BILLING: I input all required fields
    And BILLING: I verify Billing Shipping Address is populated
    And BILLING: I click on Continue To Order Review button
    Then BILLING: I verify new billing address is saved with special characters first name and last name for "guest"
    
    Examples:
 		|firstname| lastname|
		| 1_fname | 1_lname |
		| 2_fname | 2_lname |
#		| 3_fname | 3_lname |
#		| 4_fname | 4_lname |
#		| 5_fname | 5_lname |
#		| 6_fname | 6_lname |
#		| 7_fname | 7_lname |
#		| 8_fname | 8_lname |
#		| 9_fname | 9_lname |
#		| 10_fname |10_lname|
#		| 11_fname |11_lname|
#		| 12_fname |12_lname|
#		| 13_fname |13_lname|
#		| 14_fname |14_lname|
#		| 15_fname |15_lname|
#		| 16_fname |16_lname|
#		| 17_fname |17_lname|
#		| 18_fname |18_lname|
#		| 19_fname |19_lname|
#		| 20_fname |20_lname|
#		| 21_fname |21_lname|
#		| 22_fname |22_lname|
#		| 23_fname |23_lname|
#		| 24_fname |24_lname|
#		| 25_fname |25_lname|

 	@loggedinOrderPlacement @specialCharcters @euOnly @Regression_AIE @regression_set2
  Scenario Outline: FPR_TC457_AUTO-189_Account: Very special characters are accepted  in  first name, last name, at checkout and at account level for a Loged-In user
    Given I am a mk customer having "specialcharacters" in my first and last name
    Given I have "<firstname>" and "<lastname>" special characters
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And SignUp: I enter new email address
    And SignUp: I enter confirm email address
    And SignUp: I enter "FirstName" and "LastName" with special charecters
    And SignUp: I enter postal Code
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I agree to the Terms and Conditions
    When SignUp: I click Register button
    And Profile: I verify firstname with special characters displayed
    And Profile: I verify lastname with special characters displayed
    When Profile : I click on address book link
    Then Profile : I navigate to the Address book page
    And Address Book: I click on enter address manually
    And Address Book: I input all required fields with specila character in fName and lName
    And Address Book: I enter Address "<firstname>" and "<lastname>" with special charecters
    And Address Book:I select make this my default Shipping address
    When Address Book: I click on save address button
    Then Address Book: I verify new address is saved with special characters first name and last name
    And I hold a "Visa" credit card
    Then Profile: I click on Payment Information link
    And Payment Info: I input all required fields and Billing address with special characters
    Then Payment Info: I verify new billing address is saved with special characters first name and last name
    
    Examples:
 		|firstname| lastname|
		| 1_fname | 1_lname |
		| 2_fname | 2_lname |
#		| 3_fname | 3_lname |
#		| 4_fname | 4_lname |
#		| 5_fname | 5_lname |
#		| 6_fname | 6_lname |
#		| 7_fname | 7_lname |
#		| 8_fname | 8_lname |
#		| 9_fname | 9_lname |
#		| 10_fname |10_lname|
#		| 11_fname |11_lname|
#		| 12_fname |12_lname|
#		| 13_fname |13_lname|
#		| 14_fname |14_lname|
#		| 15_fname |15_lname|
#		| 16_fname |16_lname|
#		| 17_fname |17_lname|
#		| 18_fname |18_lname|
#		| 19_fname |19_lname|
#		| 20_fname |20_lname|
#		| 21_fname |21_lname|
#		| 22_fname |22_lname|
#		| 23_fname |23_lname|
#		| 24_fname |24_lname|
#		| 25_fname |25_lname|
		
   @loggedinOrderPlacement @accounts @euOnly @Regression_AIE @regression_set2
   Scenario Outline: FPR_TC457_AUTO-189_Checkout: Very special characters are accepted  in  first name, last name, at checkout and at account level for a Loged-In user
    Given I am a mk customer having "specialcharacters" in my first and last name
    Given I have "<firstname>" and "<lastname>" special characters
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And SignUp: I enter new email address
    And SignUp: I enter confirm email address
    And SignUp: I enter "<firstname>" and "<lastname>" with special charecters
    And SignUp: I enter postal Code
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I agree to the Terms and Conditions
    When SignUp: I click Register button
    And Profile: I verify firstname with special characters displayed
    And Profile: I verify lastname with special characters displayed
    And I navigate to MK HomePage
 	  And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout Securely button for loggedIn user
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields for logged in user with "<firstname>" and "<lastname>" containing special charecters
    And SHIPPING: I click Ship to this address
    Then SHIPPING: I verify new shipping address is saved with special characters first name and last name for "loggedIn"
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Verify Add New Billing Address link is Displayed
    And BILLING: I input all required fields with firstname and lastname having special charecters
    And BILLING: I click save button to save new address
    Then BILLING: I verify new billing address is saved with special characters first name and last name for "loggedIn"
 		    
 		Examples:
 		|firstname| lastname|
		| 1_fname | 1_lname |
		| 2_fname | 2_lname |
#		| 3_fname | 3_lname |
#		| 4_fname | 4_lname |
#		| 5_fname | 5_lname |
#		| 6_fname | 6_lname |
#		| 7_fname | 7_lname |
#		| 8_fname | 8_lname |
#		| 9_fname | 9_lname |
#		| 10_fname |10_lname|
#		| 11_fname |11_lname|
#		| 12_fname |12_lname|
#		| 13_fname |13_lname|
#		| 14_fname |14_lname|
#		| 15_fname |15_lname|
#		| 16_fname |16_lname|
#		| 17_fname |17_lname|
#		| 18_fname |18_lname|
#		| 19_fname |19_lname|
#		| 20_fname |20_lname|
#		| 21_fname |21_lname|
#		| 22_fname |22_lname|
#		| 23_fname |23_lname|
#		| 24_fname |24_lname|
#		| 25_fname |25_lname|
		
	@loggedinOrderPlacement @specialCharacters @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC459_AUTO-191: Very special characters Should not  be accepted  in  first name, last name, at checkout and at account level for a Logged-In user
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    When Profile : I click on address book link
    Then Profile : I navigate to the Address book page
    And Address Book: I enter Fname Lname with special character and verify Error displayed
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout Securely button for loggedIn user
    And I am on the Checkout page
    And SHIPPING: I click add new address link
    And SHIPPING: I enter Fname Lname with special character and verify Error displayed
    And SBP: I click on Checkout Securely button for loggedIn user
    And I am on the Checkout page
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Verify Add New Billing Address link is Displayed
    And BILLING: I click add new address link
    And BILLING: I enter Fname Lname with special character and verify Error displayed
    
   @loggedinOrderPlacement @specialCharacters @naOnly
   Scenario: FPR_TC459_AUTO-191: Very special characters Should not  be accepted  in  first name, last name, at checkout and at account level for a Logged-In user
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    When Profile : I click on address book link
    Then Profile : I navigate to the Address book page
    And Address Book: I enter Fname Lname with special character and verify Error displayed
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click add new address link
    And SHIPPING: I enter Fname Lname with special character and verify Error displayed
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And BILLING: I click on edit billing address link
    And BILLING: I enter Fname Lname with special character and verify Error displayed
