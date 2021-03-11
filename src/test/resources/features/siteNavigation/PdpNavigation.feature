Feature: Site navigation to and from product's PDP page

  @siteNavigation @pdpPageNavigation @smoke @daily @dailySmoke @buildSmoke
  Scenario: Verify return to PDP page from Shopping Bag by browser back button
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    When I click on browser back button
    Then I am on the product detail page

  @smoke  @desktopOnly
  Scenario: AutoSmoke_060: To verify the Look PDP functionality
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click trends "WOMEN > Kors Style"
    Then I am on the product listing page
    And PLP: I click a product position 1 in the product list
    And Look: I get the look product count
    And Look: I click on buy all button
    And Look: I verify Shop this look window pop us is displayed
    And Look: Add all the items to bag
    And Look: I check the product count in basket

  @smoke  @mobileOnly @Shiva
  Scenario: AutoSmoke_060: To verify the Look PDP functionality
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > Kors Style"
    Then I am on the product listing page
    And PLP: I click a product position 1 in the product list
    And Look: I get the look product count
    And Look: I click on buy all button
    And Look: I verify Shop this look window pop us is displayed
    And Look: Add all the items to bag
    And Look: I check the product count in basket
       