Feature: Logged-in user home page checks

  @loggedin @homepageChecks @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_001: Verify the logo in the Header
    Given I am a logged-in mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see mk logo

  @loggedin @homepageChecks @smoke @daily @dailySmoke @naOnly @desktopOnly @buildSmoke
  Scenario: Verify user links in the Header
    Given I am a logged-in mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see following user links
      | Find A Store |
      | Bag |
      | Search |

  @loggedin @homepageChecks @smoke @daily @dailySmoke @naOnly @buildSmoke
  Scenario: Verify user links in the Header
    Given I am a logged-in mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see following user links
      | Wish List |

  @loggedin @homepageChecks @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_001: Verify country selection section in the Header
    Given I am a logged-in mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see country flag
    And HEADER: I can see country selected link

  @loggedin @homepageChecks @smoke @daily @dailySmoke @excludeNA  @desktopOnly @buildSmoke
  Scenario: Verify user links icons in the Header
    Given I am a logged-in mk customer
    When I navigate to MK HomePage
    And HEADER: I can see user icon

  @loggedin @homepageChecks @smoke @daily @dailySmoke @excludeNA @buildSmoke
  Scenario: Verify user links icons in the Header
    Given I am a logged-in mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see magnifying glass icon
    And HEADER: I can see shopping bag icon
    And HEADER: I can see store locator icon

  @loggedin @homepageChecks @smoke @daily @dailySmoke @naOnly @buildSmoke
  Scenario: Verify user links icons in the Header
    Given I am a logged-in mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see magnifying glass icon
    And HEADER: I can see shopping bag icon

  @loggedin @homepageChecks @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_004: Verify content in the Homepage body
    Given I am a logged-in mk customer
    When I navigate to MK HomePage
    Then HP: I verify content exists

  @loggedin @homepageChecks @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_001: Verify links in the footer
    Given I am a logged-in mk customer
    When I navigate to MK HomePage
    Then FOOTER: I can see Find a Store section
    And FOOTER: I can see Newsletter signup section
    And FOOTER: I can see Social media section
    And FOOTER: I can see Footer links section

  @guest @homepage @excludeNA @Regression_AIE @desktopOnly @regression_set1
	Scenario: FPR_TC191_AUTO-168: Verify that user remains in same page when logged in to application.
 		Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > CLOTHING > DRESSES"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And Login: I Log In from flyout
    Then I am on the product listing page
    When MENU: I click Sign Out link
    Then I should be successfully logged out
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > CLOTHING > DRESSES"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click on the product name
    And I am on the product detail page
    And Login: I Log In from flyout
    And I am on the product detail page
    
  @guest @homepage @naOnly @Regression_AIE @desktopOnly @regression_set1
	Scenario: FPR_TC191_AUTO-168: Verify that user remains in same page when logged in to application.
 		Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > CLOTHING > DRESSES"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And Login: I remote Log In
    Then I am on the product listing page
    When MENU: I click Sign Out link
    Then I should be successfully logged out
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > CLOTHING > DRESSES"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click on the product name
    And I am on the product detail page
    And Login: I remote Log In
    And I am on the product detail page
    
  @loggedin @homepage @euOnly @Regression_AIE @regression_set1
	Scenario: FPR_TC201_AUTO-169: To verify that Logout button is not  displayed on switching the country.
 		Given I am a logged-in mk customer
		And MENU: I click User Profile link
		When MENU: I select random NA country from the country selector
    Then I should be successfully logged out
    
  @loggedin @homepage @naOnly @Regression_AIE @akamaiCache @smokeSuite @regression_set1
	Scenario: FPR_TC201_AUTO-169: To verify that Logout button is not  displayed on switching the country.
 		Given I am a logged-in mk customer
		And MENU: I click User Profile link
		When MENU: I select random dedicated country from the country selector
    Then I should be successfully logged out
    
  @loggedin @homepage @excludeNA @Regression_AIE @desktopOnly @regression_set1
	Scenario: FPR_TC189_AUTO-167: Verify that after changing the country from the header user should logged out and cart should be empty.
 		Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click menu "Handbags > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And PDP: I select 1 from the quantity dropdown
    And PDP: I click on add to bag
    And HEADER: I Verify that shopping bag has item
    When MENU: I select random NA country from the country selector
    Then I should be successfully logged out
    And HEADER: I Verify that shopping bag has no item
    
  @loggedin @homepage @naOnly @Regression_AIE @desktopOnly @regression_set1
	Scenario: FPR_TC189_AUTO-167: Verify that after changing the country from the header user should logged out and cart should be empty.
 		Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click menu "Handbags > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And PDP: I select 1 from the quantity dropdown
    And PDP: I click on add to bag
    And HEADER: I Verify that shopping bag has item
    When MENU: I select random dedicated country from the country selector
    Then I should be successfully logged out
    And HEADER: I Verify that shopping bag has no item
    
    
  @loggedin @homepage @excludeNA @Regression_AIE @mobileOnly @regression_set1
	Scenario: FPR_TC189_AUTO-167: Verify that after changing the country from the header user should logged out and cart should be empty.
 		Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click menu "Handbags > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And PDP: I select 1 from the quantity dropdown in PDP Page for Mobile
    And PDP: I click on add to bag
    And HEADER: I Verify that shopping bag has item
    When MENU: I select random NA country from the country selector
    Then I should be successfully logged out
    And HEADER: I Verify that shopping bag has no item
    
  @loggedin @homepage @naOnly @Regression_AIE @mobileOnly @regression_set1
	Scenario: FPR_TC189_AUTO-167: Verify that after changing the country from the header user should logged out and cart should be empty.
 		Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click menu "Handbags > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And PDP: I select 1 from the quantity dropdown in PDP Page for Mobile
    And PDP: I click on add to bag
    And HEADER: I Verify that shopping bag has item
    When MENU: I select random dedicated country from the country selector
    Then I should be successfully logged out
    And HEADER: I Verify that shopping bag has no item