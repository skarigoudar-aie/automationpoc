
Feature: Homepage Header and Footer section checks

  @homepageChecks @smoke
  Scenario: AutoSmoke_002: To verify the system behaviour when user search for the store from footer section
    Given I am a mk customer
    And I navigate to MK HomePage
    When FOOTER: I click on find a store link
    Then I am on store locator page
    When STORE LOCATOR: I input all required fields
    And STORE LOCATOR: I click on search button
    And STORE LOCATOR: I verify there are at least 1 store displayed
    And STORE LOCATOR: I verify map is displaying

  @homepageChecks @smoke @excludeNA
  Scenario: AutoSmoke_003: To verify the system behaviour when user subscribe to newsletter from footer section.
    Given I am a mk customer
    And I navigate to MK HomePage
    When FOOTER: I populate the email id for signup
    And FOOTER: I click on signup button
    Then I am on newsletter signup page
    And NEWS LETTER SIGNUP: I enter confirm email address
    And NEWS LETTER SIGNUP: I enter first name
    And NEWS LETTER SIGNUP: I enter last name
    And I verify user is on Thanks for signing up page

  @homepageChecks @smoke @caOnly
  Scenario: AutoSmoke_003: To verify the system behaviour when user subscribe to newsletter from footer section.
    Given I am a new mk customer
    And I navigate to MK HomePage
    When FOOTER: I enter the email id for signup
    And FOOTER: I click on signup button
    Then I am on newsletter signup page
    And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter postal Code
    And SignUp: I enter birth Month
    And SignUp: I enter birth Day
    And SignUp: I choose gender
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I opt out marketing comms
    When SignUp: I click create account button
    Then I should be successfully logged in

  @homepageChecks @smoke @usOnly
  Scenario: AutoSmoke_003: To verify the system behaviour when user subscribe to newsletter from footer section.
    Given I am a new mk customer
    And I navigate to MK HomePage
    When FOOTER: I enter the email id for signup
    And FOOTER: I click on signup button
    And I verify You Are On The List Modal is dispalying

  @homepageChecks @obsolete @excludeNA
  Scenario: AutoSmoke_006: To verify that cookie usage notification is displaying
    Given I am a mk customer
    And I navigate to MK HomePage
    And I clear browser cache
    And I refresh the browser
    And I Check cookie message is displaying
    And I Accept cookie message

	@homepageChecks @RegressionMK
	Scenario: Auto_98: Verify that user can navigate to order history page from Home Page Footer
    Given I am a mk customer
    When FOOTER: I click on the trackMyOrder link
    And Login: I enter email address in account page
    And Login: I enter password in account page
    When Login: I click Sign In button in account page
    Then I verify Order History page is displayed   
   
  @guest @homepage @excludeNA @Regression_AIE @desktopOnly @regression_set1
  Scenario: FPR_TC485_AUTO-207: Verify that all the L1, L2 and L3 Category links navigation
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click on each L1 menu and verify the title tag and product display
    When MENU: I click on each L2 menu and verify the title tag and product displayed
    When MENU: I click on each L3 menu and verify the title tag and product displayed
    
  @guest @homepage @Regression_AIE @mobileOnly @regression_set1
  Scenario: FPR_TC485_AUTO-207: Verify that all the L1, L2 and L3 Category links navigation
    Given I am a mk customer
    And I navigate to MK HomePage
   	When MENU: I click on each L1 menu and verify the title tag and product display
    When MENU: I click on each L2 menu and verify the title tag and product displayed
    #When MENU: I click on each L3 menu and verify the title tag and product displayed
       
  @guest @homepage @naOnly @Regression_AIE @desktopOnly @regression_set1
  Scenario: FPR_TC485_AUTO-207: Verify that all the L1, L2 and L3 Category links navigation
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click on each L1 menu and verify the title tag and product display
    When MENU: I click on each L2 menu under and verify the title tag and product displayed
      | WOMEN 		 |
      | MEN 			 |
      | COLLECTION |
      | HANDBAGS   |
      | SHOES      |
      | WALLETS		 |
      | WATCHES    |
	 	  | GIFTS      |
    When MENU: I click on each L3 menu under and verify the title tag and product displayed
      | WOMEN 		 |
      | MEN 			 |
      | COLLECTION |
      | HANDBAGS   |
      | SHOES      |
      | WALLETS		 |
      | WATCHES    |
	 	  | GIFTS      |
	 	  | SALE			 |
  
  @guest @homepage @Regression_AIE @naOnly @akamaiCache @smokeSuite @regression_set1
	Scenario: Auto_202: Verify the Homepage Header content
    Given I am a mk customer
    And HEADER: I verify PPH banner
    And HEADER: I verify MK Logo
    And MENU: I verify search icon
    And HEADER: I verify Mini Cart icon
    And HEADER: I verfiy country selector
    And MENU: I verify Find A Store icon
    And MENU: I verify Sign In link
    And HEADER: I verify selected country and currency

  @guest @homepage @Regression_AIE @excludeNA @regression_set1
	Scenario: Auto_202: Verify the Homepage Header content
    Given I am a mk customer
    And HEADER: I verify PPH banner
    And HEADER: I verify MK Logo
    And HEADER: I verify Mini Cart icon
    And HEADER: I verfiy country selector
    And HEADER: I verify selected country and currency
    And MENU: I verify search icon
    And MENU: I verify Find A Store icon
    And MENU: I verify Sign In link
    And HEADER: I verify Mini Cart icon
    
  @guest @homepage @Regression_AIE @excludeNA @regression_set1
  Scenario: FPR_TC481_AUTO-203: To verify that cookie usage notification is displaying
    Given I am a mk customer
    And I clear browser cache
    And I refresh the browser
    And COOKIE BANNER: I verify cookie banner
    And COOKIE BANNER: I verify Accept all button in cookie banner
    And COOKIE BANNER: I verify Manage cookie preferences button in cookie banner
    And COOKIE BANNER: I verify one trust policy text
    And COOKIE BANNER: I accept cookies  
    And COOKIE BANNER: I verify saved cookies
    And COOKIE BANNER: I verify the oneTrustActiveGroups "C0004 > C0003 > C0002 > C0001" in cookies

	@guest @homepage @Regression_AIE @excludeNA @regression_set1
  Scenario: FPR_TC482_AUTO-204 : Verify the Manage Cookie Preferences functionality on Cookie Banner
    Given I am a mk customer
    And I clear browser cache
    And I refresh the browser
    And COOKIE BANNER: I verify cookie banner
    And COOKIE BANNER: I Select Manage Preferences on the Cookie Banner
    And I Click on Accept All button in One Trust PC Panel
    And I clear browser cache
    And I refresh the browser
    And COOKIE BANNER: I verify cookie banner
    And COOKIE BANNER: I Select Manage Preferences on the Cookie Banner
    And I Enable and Disable Target cookies
    And I save the cookie preference changes     

  @guest @homepage @Regression_AIE @excludeNA @regression_set1
  Scenario: FPR_TC483_AUTO-205: Verify the Cookie Banner is displayed in the respective Languages
    Given I am a mk customer
    And I clear browser cache
    And I refresh the browser
    And COOKIE BANNER: I verify cookie banner
    And COOKIE BANNER: I verify Cookie Banner is displayed in the respective Languages
    
  @guest @homepage @Regression_AIE @excludeGB @excludeES @excludeGlobal @akamaiCache @smokeSuite @regression_set1
	Scenario: FPR_TC486_AUTO-208: Verify all the Homepage Footer Links are functional and User can submit comments through Contact Us form for Anonymous User
    Given I am a mk customer
    And I navigate to MK HomePage
    And FOOTER: I click on 'faq' link in footer
    And I verify page redirection
    And FOOTER: I click on 'returns-exchanges' link in footer
    And I verify page redirection
    And FOOTER: I click on 'shipping-terms' link in footer
    And I verify page redirection
    And FOOTER: I click on 'payment-policy' link in footer
    And I verify page redirection
    And FOOTER: I click on 'gift-cards' link in footer
    And I verify page redirection
    And FOOTER: I click on 'contact-us' link in footer
    And I verify page redirection
    And FOOTER: I click on 'warranty-repair' link in footer
   	And I verify page redirection
   	And FOOTER: I click on 'accounts' link in footer
    And I verify page redirection
    And FOOTER: I click on 'create-account' link in footer
    And I verify page redirection
     And I navigate to MK HomePage
    And FOOTER: I click on 'track-my-order' link in footer
    And I verify page redirection
    And I navigate to MK HomePage
    And I Click bottom footer links
    #And I submit contact us form
    
  @loggedin @homepage @Regression_AIE @excludeGB @excludeES @excludeGlobal @regression_set1
	Scenario: FPR_TC486_AUTO-208_A: Verify all the Homepage Footer Links are functional and User can submit comments through Contact Us form for Registered User
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And FOOTER: I click on 'faq' link in footer
    And I verify page redirection
    And FOOTER: I click on 'returns-exchanges' link in footer
    And I verify page redirection
    And FOOTER: I click on 'shipping-terms' link in footer
    And I verify page redirection
    And FOOTER: I click on 'payment-policy' link in footer
    And I verify page redirection
    And FOOTER: I click on 'gift-cards' link in footer
    And I verify page redirection
    And FOOTER: I click on 'contact-us' link in footer
    And I verify page redirection
    And FOOTER: I click on 'warranty-repair' link in footer
   	And I verify page redirection
   	And FOOTER: I click on 'accounts' link in footer
    And I verify page redirection
    And FOOTER: I click on 'track-my-order' link in footer
    And I verify page redirection
    And I navigate to MK HomePage
    And I Click bottom footer links
    #And I submit contact us form
    
  @guest @homepage @Regression_AIE @excludeNA @excludeEU @globalOnly @regression_set1
	Scenario: FPR_TC486_AUTO-208_B: Verify all the Homepage Footer Links are functional and User can submit comments through Contact Us form for Anonymous User
    Given I am a mk customer
    And I navigate to MK HomePage
    And FOOTER: I click on 'faq' link in footer
    And I verify page redirection
    And FOOTER: I click on 'returns-exchanges' link in footer
    And I verify page redirection
    And FOOTER: I click on 'shipping-terms' link in footer
    And I verify page redirection
    And FOOTER: I click on 'payment-policy' link in footer
    And I verify page redirection
    And FOOTER: I click on 'contact-us' link in footer
    And I verify page redirection
    And FOOTER: I click on 'warranty-repair' link in footer
   	And I verify page redirection
   	And FOOTER: I click on 'accounts' link in footer
    And I verify page redirection
    And FOOTER: I click on 'create-account' link in footer
    And I verify page redirection
    And FOOTER: I click on 'track-my-order' link in footer
    And I verify page redirection
    And I navigate to MK HomePage
    And I Click bottom footer links
    #And I submit contact us form
    
  @loggedin @homepage @Regression_AIE @excludeNA @excludeEU @globalOnly @regression_set1
	Scenario: FPR_TC486_AUTO-208_A: Verify all the Homepage Footer Links are functional and User can submit comments through Contact Us form for Anonymous User
   	Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And FOOTER: I click on 'faq' link in footer
    And I verify page redirection
    And FOOTER: I click on 'returns-exchanges' link in footer
    And I verify page redirection
    And FOOTER: I click on 'shipping-terms' link in footer
    And I verify page redirection
    And FOOTER: I click on 'payment-policy' link in footer
    And I verify page redirection
    And FOOTER: I click on 'contact-us' link in footer
    And I verify page redirection
    And FOOTER: I click on 'warranty-repair' link in footer
   	And I verify page redirection
   	And FOOTER: I click on 'accounts' link in footer
    And I verify page redirection
    And FOOTER: I click on 'track-my-order' link in footer
    And I verify page redirection
    And I navigate to MK HomePage
    And I Click bottom footer links
    #And I submit contact us form
    
  @guest @homepage @Regression_AIE
  @excludeFR
  @excludeIT
  @excludePT
  @excludeDE
  @excludeCH
  @excludeGlobal
  @excludeNA @excludeUS @excludeCA @gbOnly @esOnly @regression_set1
	Scenario: FPR_TC486_AUTO-208_B: Verify all the Homepage Footer Links are functional and User can submit comments through Contact Us form for Anonymous User
    Given I am a mk customer
    And I navigate to MK HomePage
    And FOOTER: I click on 'faq' link in footer
    And I verify page redirection
    And FOOTER: I click on 'returns-exchanges' link in footer
    And I verify page redirection
    And FOOTER: I click on 'shipping-terms' link in footer
    And I verify page redirection
    And FOOTER: I click on 'payment-policy' link in footer
    And I verify page redirection
    And FOOTER: I click on 'klarna' link in footer
    And I verify page redirection
    And FOOTER: I click on 'gift-cards' link in footer
    And I verify page redirection
    And FOOTER: I click on 'contact-us' link in footer
    And I verify page redirection
    And FOOTER: I click on 'warranty-repair' link in footer
   	And I verify page redirection
    And FOOTER: I click on 'create-account' link in footer
    And I verify page redirection
    And FOOTER: I click on 'accounts' link in footer
    And I verify page redirection
    And FOOTER: I click on 'track-my-order' link in footer
    And I verify page redirection
    And I navigate to MK HomePage
    And I Click bottom footer links
    #And I submit contact us form
    
  @loggedin @homepage @Regression_AIE
  @excludeFR
  @excludeIT
  @excludePT
  @excludeDE
  @excludeCH
  @excludeGlobal
  @excludeNA @excludeUS @excludeCA @gbOnly @esOnly @regression_set1
	Scenario: FPR_TC486_AUTO-208_A: Verify all the Homepage Footer Links are functional and User can submit comments through Contact Us form for Registered User
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And FOOTER: I click on 'faq' link in footer
    And I verify page redirection
    And FOOTER: I click on 'returns-exchanges' link in footer
    And I verify page redirection
    And FOOTER: I click on 'shipping-terms' link in footer
    And I verify page redirection
    And FOOTER: I click on 'payment-policy' link in footer
    And I verify page redirection
    And FOOTER: I click on 'klarna' link in footer
    And I verify page redirection
    And FOOTER: I click on 'gift-cards' link in footer
    And I verify page redirection
    And FOOTER: I click on 'contact-us' link in footer
    And I verify page redirection
    And FOOTER: I click on 'warranty-repair' link in footer
   	And I verify page redirection
    And FOOTER: I click on 'accounts' link in footer
    And I verify page redirection
    And FOOTER: I click on 'track-my-order' link in footer
    And I verify page redirection
    And I navigate to MK HomePage
    And I Click bottom footer links
    #And I submit contact us form
