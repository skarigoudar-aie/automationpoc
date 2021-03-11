Feature: Listing page checks

  @listingPageChecks @smoke 
  @excludeGlobal
  Scenario: AutoSmoke_056_A : Verify the display of filter values and count when user selects multiple filters across different filter types in PLP Page.
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I get the count of products for the selected filter facet
    When PLP: I select size filter 1
    Then PLP: I verify the count of products is updated on adding the next filter facet
    And PLP: I get the count of products for the selected filter facet
    When PLP: I select size filter 2
    Then PLP: I verify the count of products is updated on adding the next filter facet
    And PLP: I get the count of products for the selected filter facet
    When PLP: I select color filter 1
    Then PLP: I verify the count of products is updated on adding the next filter facet
    And PLP: I get the count of products for the selected filter facet
    When PLP: I select color filter 2
    Then PLP: I verify the count of products is updated on adding the next filter facet

  @listingPageChecks @smoke
  @excludeNA @excludeEU
  Scenario: AutoSmoke_056_A: Verify the display of filter values and count when user selects multiple filters across different filter types in PLP Page.
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Shoes > View All Shoes"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I get the count of products for the selected filter facet
    When PLP: I select size filter 1
    Then PLP: I verify the count of products is updated on adding the next filter facet
    And PLP: I get the count of products for the selected filter facet
    When PLP: I select size filter 2
    Then PLP: I verify the count of products is updated on adding the next filter facet
    And PLP: I get the count of products for the selected filter facet
    When PLP: I select color filter 1
    Then PLP: I verify the count of products is updated on adding the next filter facet
    And PLP: I get the count of products for the selected filter facet
    When PLP: I select color filter 2
    Then PLP: I verify the count of products is updated on adding the next filter facet

  @search @smoke @excludeGlobal @Shiva
  Scenario: AutoSmoke_056_B: Verify the display of filter values and count when user selects multiple filters across different filter types in SLP Page.
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'tops' into the search box and press key enter
    Then I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    And SLP: I get the count of products for the selected filter facet
    When SLP: I select size filter 1
    Then SLP: I verify the count of products is updated on adding the next filter facet
    And SLP: I get the count of products for the selected filter facet
    When SLP: I select size filter 2
    Then SLP: I verify the count of products is updated on adding the next filter facet
    And SLP: I get the count of products for the selected filter facet
    When SLP: I select color filter 1
    Then SLP: I verify the count of products is updated on adding the next filter facet
    And SLP: I get the count of products for the selected filter facet
    When SLP: I select color filter 2
    Then SLP: I verify the count of products is updated on adding the next filter facet

  @search @smoke @excludeNA @excludeEU
  Scenario: AutoSmoke_056_B: Verify the display of filter values and count when user selects multiple filters across different filter types in SLP Page.
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'shoes' into the search box and press key enter
    Then I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    And SLP: I get the count of products for the selected filter facet
    When SLP: I select size filter 1
    Then SLP: I verify the count of products is updated on adding the next filter facet
    And SLP: I get the count of products for the selected filter facet
    When SLP: I select size filter 2
    Then SLP: I verify the count of products is updated on adding the next filter facet
    And SLP: I get the count of products for the selected filter facet
    When SLP: I select color filter 1
    Then SLP: I verify the count of products is updated on adding the next filter facet
    And SLP: I get the count of products for the selected filter facet
    When SLP: I select color filter 2
    Then SLP: I verify the count of products is updated on adding the next filter facet

  @listingPageChecks @smoke @desktopOnly
  Scenario: AutoSmoke_057 : Verify the ability to allow the shopper to sort by �New Arrivals�.
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "WOMEN > Clothing"
    Then I am on the product listing page
    Then PLP: I select Sort Option "new arrivals"
    Then PLP: I Verify selected sort option displayed
    
