Feature: Site navigation to and from PLP and SLP listing pages

  @siteNavigation @listingPageNavigation @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_023_A: Verify a user is taken to product's PDP page by clicking the product's name from listing page
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "HANDBAGS > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click on the product name
    And I am on the product detail page

  @siteNavigation @listingPageNavigation @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_023_B: Verify a user is taken to product's PDP page by clicking the product's image from listing page    Given I am a mk customer
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "HANDBAGS > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click on the product price
    And I am on the product detail page

  @siteNavigation @listingPageNavigation @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_023_C: Verify a user is taken to product's PDP page by clicking the product's price from listing page    Given I am a mk customer
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "HANDBAGS > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click on the product image
    And I am on the product detail page

  @siteNavigation @listingPageNavigation @smoke
  Scenario: AutoSmoke_024: Verify that system is pointing to the same product in SLP, when user clicks on the browser back button from PDP page.
    Given I am a mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I capture the product name on PDP
    When I click on browser back button
    And SLP: I capture the product name on SLP
    Then SLP: I Verify same product is displaying on SLP as on PDP page
