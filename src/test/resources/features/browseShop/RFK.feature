Feature: RFK

  @rfk_wip @smoke_wip
  Scenario: AutoSmoke_027_A: Verify the recommended products are coming from the RFK for guest user
    Given I am a mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | shoes | category:shoe |
    And MENU: I click on search link
    And SLP: I type 'shoes:productName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    When PDP: I verify products are displayed in recomendation section

  @rfk_wip @smoke_wip
  Scenario: AutoSmoke_027_B: Verify the recommended products are coming from the RFK for register user
    Given I am a logged-in mk customer
    And I am interested in following mk products
      | shoes | category:shoe |
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'shoes:styleName' into the search box and press key enter
    And SLP: I click on the product price
    And I am on the product detail page
    When PDP: I verify products are displayed in recomendation section

  @rfk @smoke @desktopOnly @excludeCatchAll @excludeGlobal 
  Scenario: AutoSmoke_034_A: Verify that Guest user able to add a product from "You may also like" section of Cart page
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > Watches"
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    And PLP: I click a product position 2 in the product list
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I verify You may also like widget is displaying
    When SBP: I click product 1 from You may also like widget
    And PDP: I select 2 from the quantity dropdown
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    Then SBP: I can see 2 product in the bag
    And SBP: I can see a Shopping Bag total quantity of 3

  @rfk @smoke @mobileOnly @excludeCatchAll @excludeGlobal
  Scenario: AutoSmoke_034_A: Verify that Guest user able to add a product from "You may also like" section of Cart page
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click a random menu from following category
       | Women > Handbags > Shoulder Bags |
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    And PLP: I click a product position 3 in the product list
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I verify You may also like widget is displaying
    When SBP: I click product 1 from You may also like widget
    And PDP: I select 2 from the quantity dropdown
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    Then SBP: I can see 2 product in the bag
    And SBP: I can see a Shopping Bag total quantity of 3

  @rfk @smoke @desktopOnly @excludeCatchAll @excludeGlobal
  Scenario: AutoSmoke_034_B: Verify that register user able to add a product from "You may also like" section of Cart page
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    And PLP: I click a product position 3 in the product list
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I verify You may also like widget is displaying
    When SBP: I click product 1 from You may also like widget
    And PDP: I select 2 from the quantity dropdown
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    Then SBP: I can see 2 product in the bag
    And SBP: I can see a Shopping Bag total quantity of 3

  @rfk @smoke @mobileOnly @excludeCatchAll @excludeGlobal
  Scenario: AutoSmoke_034_B: Verify that register user able to add a product from "You may also like" section of Cart page
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click a random menu from following category
      | Women > Handbags > All Handbags         |
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    And PLP: I click a product position 3 in the product list
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I verify You may also like widget is displaying
    When SBP: I click product 1 from You may also like widget
    And PDP: I select 2 from the quantity dropdown
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    Then SBP: I can see 2 product in the bag
    And SBP: I can see a Shopping Bag total quantity of 3
    
  @rfk @browseShop @desktopOnly @Regression_AIE @regression_set1
  Scenario: FPR_TC499_AUTO-221_A: Verify the Product Recommendations display on the PDP page for Loggedin User
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'handbag' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I Verify product recommendation container is displaying
    And PDP: I verify slider recommendations is displaying and is Functional
    And PDP: I verify Product Name is displaying and is clickable for all the products in product recommendation
    And PDP: I verify Quick View is displaying and is clickable for all the products in product recommendation
    And PDP: I verify product price is displaying for all the products in product recommendation
    And PDP: I verify color option is displaying and is clickable for all the products in product recommendation
    
  @rfk @browseShop @desktopOnly @Regression_AIE @regression_set1
  Scenario: FPR_TC499_AUTO-221_B: Verify the Product Recommendations display on the PDP page for Anonymous User
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'handbag' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I Verify product recommendation container is displaying
    And PDP: I verify slider recommendations is displaying and is Functional
    And PDP: I verify Product Name is displaying and is clickable for all the products in product recommendation
    And PDP: I verify Quick View is displaying and is clickable for all the products in product recommendation
    And PDP: I verify product price is displaying for all the products in product recommendation
    And PDP: I verify color option is displaying and is clickable for all the products in product recommendation
    
  @rfk @browseShop @mobileOnly @Regression_AIE @regression_set1
  Scenario: FPR_TC499_AUTO-221_A: Verify the Product Recommendations display on the PDP page for Loggedin User
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'handbag' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I Verify product recommendation container is displaying
    And PDP: I verify Product Name is displaying and is clickable for all the products in product recommendation
    And PDP: I verify product price is displaying for all the products in product recommendation
    And PDP: I verify color option is displaying and is clickable for all the products in product recommendation
    
  @rfk @browseShop @mobileOnly @Regression_AIE @regression_set1
  Scenario: FPR_TC499_AUTO-221_B: Verify the Product Recommendations display on the PDP page for Anonymous User
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'handbag' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I Verify product recommendation container is displaying
    And PDP: I verify Product Name is displaying and is clickable for all the products in product recommendation
    And PDP: I verify product price is displaying for all the products in product recommendation
    And PDP: I verify color option is displaying and is clickable for all the products in product recommendation