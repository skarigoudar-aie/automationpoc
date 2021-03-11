Feature: BV Ratings and Reviews

  @smoke @naOnly
  Scenario: AutoSmoke_061_A: Verify the ability to post product review in product details page from ratings section
    Given I am a mk customer
    #And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    When PLP: I click a product position 1 in the product list
    And I am on the product detail page
    When I click the Write a review link from ratings section
    Then I verify the submit button in the Post Review lightbox


  @smoke @naOnly
  Scenario: AutoSmoke_061_B: Verify the ability to post product review in product details page from Reviews section
    Given I am a mk customer
    #And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    When PLP: I click a product position 1 in the product list
    And I am on the product detail page
    When I click the Write a review link from Reviews section
    Then I verify the submit button in the Post Review lightbox