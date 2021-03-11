Feature: Order placement via Klarna as a logged-in user

  @loggedinOrderPlacement @orderPlacement @lowerEnvOnly @smoke @deOnly @seOnly @flOnly @dkOnly @nrOnly @atOnly @nlOnly
  @excludeCH
  @excludeES
  @excludeFR
  @excludeGB
  @excludeIT
  @excludePT
  @excludeGlobal
  @excludeNA
  Scenario: AutoSmoke_065_B1 : Verify logged-in user is able to place the order with any Klarna pay later in 14 days
    Given I am a logged-in mk customer with Klarna
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > View All Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    When PLP: I click a product position 2 in the product list
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    When MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And Payment: I select pay later with klarna
    And Payment: I choose pay in 14 days
    And Review & Pay: I click pay now
    And Klarna: Enter additional details and continue
    Then I verify Order confirmation page is displayed

  @loggedinOrderPlacement @orderPlacement @lowerEnvOnly @smoke @deOnly @seOnly @flOnly @dkOnly @nrOnly
  @excludeAT
  @excludeCH
  @excludeES
  @excludeFR
  @excludeGB
  @excludeIT
  @excludeNL
  @excludePT
  @excludeGlobal
  @excludeNA
  Scenario: AutoSmoke_065_B2 : Verify logged-in user is able to place the order with any Klarna pay later in 2 months
    Given I am a logged-in mk customer with Klarna
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > View All Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    When PLP: I click a product position 2 in the product list
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    When MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And Payment: I select pay later with klarna
    And Payment: I choose pay in 2 months
    And Review & Pay: I click pay now
    And Klarna: Enter additional details and continue
    Then I verify Order confirmation page is displayed

  @loggedinOrderPlacement @orderPlacement @lowerEnvOnly @gbOnly @chOnly
  @excludeAT
  @excludeDE
  @excludeDK
  @excludeES
  @excludeFL
  @excludeFR
  @excludeIT
  @excludeNL
  @excludeNR
  @excludePT
  @excludeSE
  @excludeGlobal
  @excludeNA
  Scenario: AutoSmoke_065_B3 : Verify logged-in user is able to place the order with any Klarna pay later in 30 days
    Given I am a logged-in mk customer with Klarna
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > View All Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    When PLP: I click a product position 2 in the product list
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    When MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And Payment: I select pay later with klarna
    And Payment: I choose pay in 30 days
    And Review & Pay: I click pay now
    And Klarna: Enter additional details and continue
    Then I verify Order confirmation page is displayed

	@loggedinOrderPlacement @orderPlacement @lowerEnvOnly @deOnly @chOnly @Regression_AIE
  @excludeES
  @excludeIT
  @excludeFI
  @excludeSE
  @excludeFR
  @excludeGB
  @excludeIT
  @excludeNL
  @excludePT
  @excludeGlobal
  @excludeNA @regression_set2
  Scenario: FPR_TC402_AUTO-197_A : Verify user able to place the order with Pay Now Online Bank Transfer Sofort payment option in MK site as Loggedin User.
    Given I am a logged-in mk customer with Klarna
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_monogram bag1 | category:EU_monogram bag1 |
    And HomePage: I click on search link
    And SLP: I type 'EU_monogram bag1:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    When MENU: I click on Bag link
		And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And Payment: I select pay now with klarna Sofort
    And I hold klarna Sofort account with "Demo Bank"
    And Klarna Sofort: Click on Pay Now and Enter additional details to continue
    Then I verify Order confirmation page is displayed 
    And ORDERCONFIRMATION: I write order number for "AUTO-197_A"

  @loggedinOrderPlacement @orderPlacement @lowerEnvOnly @deOnly @Regression_AIE
  @excludeES
  @excludeIT
  @excludeFI
  @excludeSE
  @excludeFR
  @excludeGB
  @excludeIT
  @excludeNL
  @excludePT
  @excludeGlobal
  @excludeNA @regression_set2 @checkout
  Scenario: FPR_TC402_AUTO-198_A : To Verify user able to place the order with Pay Now- Bank Account Direct Debit payment option in MK site as Logged-In User
    Given I am a logged-in mk customer with Klarna
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_monogram bag1 | category:EU_monogram bag1 |
    And HomePage: I click on search link
    And SLP: I type 'EU_monogram bag1:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    When MENU: I click on Bag link
		And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And Payment: I select pay now with klarna Direct Debit
    And Klarna DirectDebit: Click on Pay Now and Enter additional details to continue
    Then I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-198_A"
    
  @loggedinOrderPlacement @orderPlacement @lowerEnvOnly @gbOnly @Regression_AIE
  @excludeDE
  @excludeES
  @excludeIT
  @excludeFI
  @excludeSE
  @excludeFR
  @excludeIT
  @excludeNL
  @excludePT
  @excludeGlobal
  @excludeNA @regression_set2 @checkout
  Scenario: FPR_TC402_AUTO-199_A : To Verify user able to place the order with Pay Over time with Klarna Pay in 3 payment option in MK site as Logged-In User
    Given I am a logged-in mk customer with Klarna
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_monogram | category:EU_monogram |
    And HomePage: I click on search link
    And SLP: I type 'EU_monogram:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    When MENU: I click on Bag link
		And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And Payment: I select pay over time with klarna
    And I hold a "Visa" credit card
    And Payment: I fill card information on Pay in 3 klarna
    And Klarna Pay in 3: Click on Pay Now and Enter additional details to continue
    Then I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-199_A"
    
  @loggedinOrderPlacement @orderPlacement @lowerEnvOnly @deOnly @Regression_AIE
  @excludeES
  @excludeIT
  @excludeFI
  @excludeSE
  @excludeFR
  @excludeGB
  @excludeIT
  @excludeNL
  @excludePT
  @excludeGlobal
  @excludeNA @regression_set2 @checkout
  Scenario: FPR_TC402_AUTO-200_A_1 : To Verify user able to place the order with Pay Over time with Klarna - Slice It 6 months payment option in MK site both as Logged-In User
    Given I am a logged-in mk customer with Klarna
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_monogram bag1 | category:EU_monogram bag1 |
    And HomePage: I click on search link
    And SLP: I type 'EU_monogram bag1:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And I navigate to MK HomePage
     And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    When MENU: I click on Bag link
		And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And Payment: I select pay over time with klarna
    And Payment klarna Slice It: I choose pay in 6 months
    And Klarna Slice It: Click on Pay Now and Enter additional details to continue
    Then I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-200_A_1"
    
  @loggedinOrderPlacement @orderPlacement @lowerEnvOnly @deOnly @Regression_AIE
  @excludeES
  @excludeIT
  @excludeFI
  @excludeSE
  @excludeFR
  @excludeGB
  @excludeIT
  @excludeNL
  @excludePT
  @excludeGlobal
  @excludeNA @regression_set2 @checkout
  Scenario: FPR_TC402_AUTO-200_A_2 : To Verify user able to place the order with Pay Over time with Klarna - Slice It 12 months payment option in MK site both as Logged-In User
    Given I am a logged-in mk customer with Klarna
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_monogram bag1 | category:EU_monogram bag1 |
    And HomePage: I click on search link
    And SLP: I type 'EU_monogram bag1:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And I navigate to MK HomePage
     And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    When MENU: I click on Bag link
		And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And Payment: I select pay over time with klarna
    And Payment klarna Slice It: I choose pay in 12 months
    And Klarna Slice It: Click on Pay Now and Enter additional details to continue
    Then I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-200_A_2"
 
  @loggedinOrderPlacement @orderPlacement @lowerEnvOnly @deOnly @Regression_AIE
  @excludeES
  @excludeIT
  @excludeFI
  @excludeSE
  @excludeFR
  @excludeGB
  @excludeIT
  @excludeNL
  @excludePT
  @excludeGlobal
  @excludeNA @regression_set2 @checkout
  Scenario: FPR_TC402_AUTO-200_A_3 : To Verify user able to place the order with Pay Over time with Klarna - Slice It 24 months payment option in MK site both as Logged-In User
    Given I am a logged-in mk customer with Klarna
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_monogram bag1 | category:EU_monogram bag1 |
    And HomePage: I click on search link
    And SLP: I type 'EU_monogram bag1:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And I navigate to MK HomePage
    And MENU: I click on search link
     And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    When MENU: I click on Bag link
		And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And Payment: I select pay over time with klarna
    And Payment klarna Slice It: I choose pay in 24 months
    And Klarna Slice It: Click on Pay Now and Enter additional details to continue
    Then I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-200_A_3"