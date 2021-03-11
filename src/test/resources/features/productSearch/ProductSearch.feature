Feature: Product Search

  @search @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmokTest_020: Do a color search and check products are displayed
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'green' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed

  @search @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_020: Do a style ID search and check products are displayed
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:monogram bag |
    And MENU: I click on search link
    And SLP: I type 'bag:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed

  @search @smoke @daily @dailySmoke @buildSmoke @Shiva
  Scenario: AutoSmoke_020: Do a item title search and check products are displayed 
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:monogram bag |
    And MENU: I click on search link
    And SLP: I type 'bag:productName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed

  @search @smoke
  Scenario: AutoSmoke_022: Verify the display of "No Results found" page.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'dgtrdrdyhtdytrytry' into the search box and press key enter
    Then SLP: I verify No Results Found For message is displaying

  @search @smoke
  Scenario: AutoSmoke_021: Verify that the department dropdown is removed in the search box
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    Then SLP: Verify search field is displaying
    And SLP: Verify close button is displaying
    
  @browseShop @Regression_AIE @desktopOnly @regression_set1
  Scenario: FPR_TC496_AUTO-218: Verify Sort options and sort by Price options are functional on  the SLP Page
   Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'purse' into the search box and press key enter
    And I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    Then SLP: I select Sort Option "Relevance"
    Then SLP: I Verify selected sort option displayed
    Then SLP: I select Sort Option "new arrivals"
    Then SLP: I Verify selected sort option displayed
    Then SLP: I select Sort Option "Price High to Low"
    Then SLP: I Verify selected sort option displayed
    And SLP: I verify Product displayed in High To Low order
    Then SLP: I select Sort Option "price low to high"
    Then SLP: I Verify selected sort option displayed
    And SLP: I verify Product displayed in Low To High order
    
  @browseShop @Regression_AIE @mobileOnly @regression_set1
  Scenario: FPR_TC496_AUTO-218: Verify Sort options and sort by Price options are functional on  the SLP Page
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'purse' into the search box and press key enter
    And I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    Then SLP: I select Sort Option "Relevance"
    Then SLP: I Verify selected sort option displayed
    Then SLP: I select Sort Option "New Arrivals"
    Then SLP: I Verify selected sort option displayed
    Then SLP: I select Sort Option "Price High to Low"
    Then SLP: I Verify selected sort option displayed
    And SLP: I verify Product displayed in High To Low order
    Then SLP: I select Sort Option "Price Low to High"
    Then SLP: I Verify selected sort option displayed
    And SLP: I verify Product displayed in Low To High order

  @browseShop @Regression_AIE @regression_set1
  Scenario: FPR_TC492_AUTO-214: Verify the products count displayed on SLP Pages matches the products displayed
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'purse' into the search box and press key enter
    And I am on the search listing page
    And SLP: I verify there are at least 1 products displayed 
    Then SLP: I verify product total count matches with product displayed
    
  @browseShop @Regression_AIE @desktopOnly @regression_set1
  Scenario: FPR_TC493_AUTO-215: Verify all the products displayed under categories has the Product Name and price details
   	Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'purse' into the search box and press key enter
    And I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    And SLP: I verify product names displayed for all the products
    And SLP: I verify Product Price in the country currency
    And SLP: I verify Color Swatches when multiple colors are available

  @browseShop @Regression_AIE @mobileOnly @regression_set1
  Scenario: FPR_TC493_AUTO-215: Verify all the products displayed under categories has the Product Name and price details
   	Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'purse' into the search box and press key enter
    And I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    And SLP: I verify product names displayed for all the products
    And SLP: I verify Product Price in the country currency
    And SLP: I verify Color Swatches when multiple colors are available
    
  @browseShop @Regression_AIE @regression_set1
  Scenario: FPR_TC494_AUTO-216: Verify all the products having multiple colours displays color swatches and are selectable
   	Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'purse' into the search box and press key enter
    And I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    And SLP: I verify Color Swatches when multiple colors are available
    And SLP: I verify Color Swatches are clickable
		And SLP: I verify clicking on Color Swatches changes product image
		And SLP: I verify product name and Price not changed after changing the color swatches
		
	@browseShop @Regression_AIE @desktopOnly @regression_set1
  Scenario: FPR_TC495_AUTO-217: Verify the Product Recommendations display on the SLP 'No Results Found' page
   	Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'dgtrdrdyhtdytrytry' into the search box and press key enter
    And I am on the search listing page
    Then SLP: I Verify product recommendation container is displaying
    And SLP: I verify slider recommendations is displaying and is Functional
    And SLP: I verify Product Name is displaying and is clickable for all the products in product recommendation
    And SLP: I verify Quick View is displaying and is clickable for all the products in product recommendation
    And SLP: I verify product price is displaying for all the products in product recommendation
    And SLP: I verify color option is displaying and is clickable for all the products in product recommendation
 
	@browseShop @Regression_AIE @mobileOnly @regression_set1
  Scenario: FPR_TC495_AUTO-217: Verify the Product Recommendations display on the SLP 'No Results Found' page
   	Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'dgtrdrdyhtdytrytry' into the search box and press key enter
    And I am on the search listing page
    Then SLP: I Verify product recommendation container is displaying
    And SLP: I verify Product Name is displaying and is clickable for all the products in product recommendation
    And SLP: I verify product price is displaying for all the products in product recommendation
    And SLP: I verify color option is displaying and is clickable for all the products in product recommendation
 
