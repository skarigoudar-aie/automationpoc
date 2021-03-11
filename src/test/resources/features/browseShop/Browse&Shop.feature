Feature: Browse & Shop

  @loggedin @smoke @daily @dailySmoke @desktopOnly @buildSmoke
  Scenario: AutoSmoke_026: Verify add to bag from quick view
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click menu "HANDBAGS > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And SLP: I click on the product quick view
    And QV: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    #And I navigate to MK HomePage
    #And MENU: I click Sign Out link
    #Then I should be successfully logged out

  @loggedin @browseShop_wip @smoke_wip
  Scenario: AutoSmoke_029_A: Verify the display of Color, Size and limited availability status
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | product | category:limited-availability |
    And MENU: I click on search link
    And SLP: I type 'product:styleName' into the search box and press key enter
    Then SLP: the product name displayed should match product "product"
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select the color
    And PDP: I select the size
    Then PDP: Verify Limited availability text is displaying

  @loggedin @browseShop_wip @smoke_wip
  Scenario: AutoSmoke_029_B: Verify the display of Color, Size and out of stock status
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | product | category:out-of-stock |
    And MENU: I click on search link
    And SLP: I type 'product:styleName' into the search box and press key enter
    Then SLP: the product name displayed should match product "product"
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select the color
    And PDP: I select the size
    Then PDP: Verify out of stock text is displaying

  @guest @browseShop_wip @smoke_wip
  Scenario: AutoSmoke_030_A: Verify the display of size is classified with locale and also with US (EX: US12/UK16) as guest user
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "WOMEN > clothing"
    Then I am on the product listing page
    Then PLP: I click a random product in the product list
    And I am on the product detail page
    And PDP: I click on size guide
    Then PDP: Verify size is classified with local and US sizes

  @loggedin @browseShop_wip @smoke_wip
  Scenario: AutoSmoke_030_B: Verify the display of size is classified with locale and also with US (EX: US12/UK16) as a Register user
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "WOMEN > clothing"
    Then I am on the product listing page
    Then PLP: I click a random product in the product list
    And PDP: I click on size guide
    Then PDP: Verify size is classified with local and US sizes

  @guest @browseShop_wip @smoke_wip
  Scenario: AutoSmoke_033_A: Verify that Guest user able to view the individual product price and order total price in Mini bag and Cart page.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    And PLP: I click a product position 3 in the product list
    And I am on the product detail page
    And PDP: I verify item price field is displayed
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I hover over the mini bag and check product price is displaying
    And MENU: I hover over the mini bag and subtotal is displaying
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And ShoopingCart: I verify product price on cart page
    And ShoopingCart: I verify Total on cart page

  @loggedin @browseShop_wip @smoke_wip
  Scenario: AutoSmoke_033_B: Verify that register user is able to view the individual product price and order total price in Mini bag and Cart page.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    And PLP: I click a product position 3 in the product list
    And I am on the product detail page
    And PDP: I verify item price field is displayed
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I hover over the mini bag and check product price is displaying
    And MENU: I hover over the mini bag and subtotal is displaying
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And ShoopingCart: I verify product price on cart page
    And ShoopingCart: I verify Total on cart page


  @loggedin @smoke @daily @dailySmoke @monogram @excludeGlobal @excludeAU
  Scenario: AutoSmoke_062: Verify add to bag a monogrammed product from PDP
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | monogram bag | category:monogram bag |
    And HomePage: I click on search link
    And SLP: I type 'monogram bag:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I verify my custom monogrammed item has been added to the Shopping Bag
    #And I navigate to MK HomePage
    #And MENU: I click Sign Out link
    #Then I should be successfully logged out

  @loggedin @smoke @daily @dailySmoke @clickAndCollect @excludeGlobal @excludeEU @excludeNA
  Scenario: AutoSmoke_063: Verify click and collect from PDP
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | sunglasses | category:sunglasses |
    And MENU: I click on search link
    And SLP: I type 'sunglasses:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    #And I navigate to MK HomePage
    #And MENU: I click Sign Out link
    #Then I should be successfully logged out

  @guest @smoke @gbOnly @chOnly @deOnly @seOnly @flOnly @dkOnly @nrOnly @atOnly @nlOnly
  @excludeES
  @excludeFR
  @excludeIT
  @excludePT
  @excludeGlobal
  @excludeNA
  Scenario: AutoSmoke_064_A: Verify Klarna message widget text is displaying on PDP page
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > View All Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    When PLP: I click a product position 3 in the product list
    And I am on the product detail page
    Then PDP: I verify Klarna widget text displayed on product detail page

  @loggedin @browseShop_wip @shoppingBag_wip
  Scenario: Verify add to bag from PDP
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag |
    And MENU: I click on search link
    And SLP: I type 'bag:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I am on shopping bag page
    And SCP: I can see 1 product in the bag

  @loggedin @browseShop_wip @shoppingBag_wip
  Scenario: Verify add to bag a engrave product from PDP
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag |
    And MENU: I click on search link
    And SLP: I type 'bag:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And PDP: I click on Engrave It
    And ENGRAVE: I engrave and click add to bag
    And MENU: I click on Bag link
    And I am on shopping bag page
    And SCP: I can see 1 product in the bag
    And SCP: I can verify the engrave details


  @loggedin @browseShop_wip @shoppingBag_wip @desktopOnly_wip
  Scenario: Verify click and collect from quick view
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag|
    And MENU: I click on search link
    And SLP: I type 'bag:styleName' into the search box and press key enter
    And SLP: I click quick view for 'bag'
    And QV: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I click on Bag link
    And I am on shopping bag page
    And SCP: I can see the 1 product in the bag

  @loggedin @browseShop_wip @shoppingBag_wip @desktopOnly_wip
  Scenario: Verify add to bag a monogram product from quick view
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag|
    And MENU: I click on search link
    And SLP: I type 'bag:styleName' into the search box and press key enter
    And SLP: I click quick view for 'bag'
    And QV: I click on Monogram It
    And MONOGRAM: I monogram and click add to bag
    And MENU: I click on Bag link
    And I am on shopping bag page
    And SCP: I can see 1 product in the bag
    And SCP: I can verify the monogram details


  @loggedin @browseShop_wip @shoppingBag_wip @desktopOnly_wip
  Scenario: Verify add to bag a engrave product from quick view
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag|
    And MENU: I click on search link
    And SLP: I type 'bag:styleName' into the search box and press key enter
    And SLP: I click quick view for 'bag'
    And QV: I click on Engrave It
    And ENGRAVE: I engrave and click add to bag
    And MENU: I click on Bag link
    And I am on shopping bag page
    And SCP: I can see 1 product in the bag
    And SCP: I can verify the engrave details
    
  @browseShop @desktopOnly @excludeNA @Regression_AIE @regression_set1
  Scenario: FPR_TC080_AUTO-157_A: To verify the refinement clicked last by the shopper appear at the end of the list.
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    Then I am on the product listing page
    And SLP: I verify there are at least 1 products displayed
    When SLP: I select color filter 1
    When SLP: I select size filter 1
    When SLP: I select size filter 2
    Then I verify the refinement clicked last size by index 2 by the shopper appear at the end of the list.
    
  @browseShop @desktopOnly @excludeNA @Regression_AIE @regression_set1
  Scenario: FPR_TC080_AUTO-157_B: To verify the refinement clicked last by the shopper appear at the end of the list.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    Then I am on the product listing page
    And SLP: I verify there are at least 1 products displayed
    When SLP: I select color filter 1
    When SLP: I select size filter 1
    When SLP: I select size filter 2
    Then I verify the refinement clicked last size by index 2 by the shopper appear at the end of the list.
    
   @guest @browseShop @Regression_AIE @desktopOnly @regression_set1
   Scenario: FPR_TC086_AUTO-159: To verify the functionality and UI of Mini cart after adding product to the cart
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'wallets' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I verify recently added product should display top of the list in mini cart
    And MENU: I click on search link
    And SLP: I type 'handbags' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify recently added product should display top of the list in mini cart
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    Then SBP: I verify i am on shopping bag page
    
   @browseShop @Regression_AIE @mobileOnly @regression_set1
   Scenario: FPR_TC086_AUTO-159: To verify the functionality and UI of Mini cart after adding product to the cart
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'wallets' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
		And MENU: I click on search link
    And SLP: I type 'handbags' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag    
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    Then SBP: I verify i am on shopping bag page
    
  @browseShop @Regression_AIE @akamaiCache @regression_set1
  Scenario: FPR_TC082_AUTO-158: To verify whether size guide is displaying or not when shopper clicks on size guide link on PDP
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'pant' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on size guide
    And PDP: I can see size guide pop up
    And PDP: I verify defalut selected region in the dropdown
    And PDP: I verify default size measure
    And PDP: I change the size measure from default and verify the changes are reflecting
    And PDP: I change the size measure to default and verify the changes are reflecting
    And PDP: I verify Close mark and close the pop up
    And MENU: I click on search link
    And SLP: I type 'shoes' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on size guide
    And PDP: I can see size guide pop up
    And PDP: I verify the size guide pop up regions "EU > GB > IT > US" for shoes
    And PDP: I verify Close mark and close the pop up
    
  @browseShop @Regression_AIE @desktopOnly @regression_set1
  Scenario: FPR_TC083_AUTO-172: To Verify functional and UI in Quick View.
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click on the product quick view
    Then QV: I verify Brand Name is displayed
    Then QV: I verify product Name is displayed
    Then QV: I verify product strike price is displayed
    Then QV: I verify first color selected as default color
    Then QV: I select color and verify the color name
    Then QV: I verify favorite or wishlist link is displayed
    Then QV: I verify the arrow on quick view
    Then QV: I verify Find a Store link is not present on the quick view
    Then QV: I verify clicking on the arrow changes the image
    Then QV: I verify add to bag button is displayed
    Then QV: I verify Collect in store button is displayed
    And QV: I close the quick view
    
  @browseShop @excludeCA @Regression_AIE @lowerEnvOnly @regression_set1
  Scenario: FPR_TC290_AUTO-188: To Verify for all the members product message is displayed for quantity limit
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
 		And SLP: I type 'MSTR101745' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I Verify for all the members product message is displayed for quantity limit 5
     And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I Verify for all the non member product message is displayed for quantity limit 5
    
  @browseShop @caOnly @excludeEU @excludeUS @Regression_AIE @lowerEnvOnly @regression_set1
  Scenario: FPR_TC290_AUTO-188: To Verify for all the members product message is displayed for quantity limit
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
 		And SLP: I type 'MSTR101732' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I Verify for all the members product message is displayed for quantity limit 5
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I Verify for all the non member product message is displayed for quantity limit 5

   @browseShop @Regression_AIE @desktopOnly @regression_set1
   Scenario: FPR_TC462_AUTO-192_A: Verify mini bag is displayed with WAS / NOW price  when guest and Logged-In user hovers on Cart link in header section of Mk site
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "Women > Clothing > View All"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    Then PLP: I verify list and sale price displayed
    And PLP: I click on the product name which has list and sale price
    And I am on the product detail page
    Then PDP: I verify list and sale price displayed
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    Then MENU: I verify minicart product name displayed on mouse hover
    And MENU: I verify the color is displayed on mini cart
    And MENU: I verify size is displayed on mini cart
    And MENU: I verify was and now labels are displayed on mini cart
    And MENU: I verify product image is displayed on mini cart
    And MENU: I verify product qty is displayed

   @browseShop @Regression_AIE @desktopOnly @regression_set1
   Scenario: FPR_TC462_AUTO-192_B: Verify mini bag is displayed with WAS / NOW price  when guest and Logged-In user hovers on Cart link in header section of Mk site
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "Women > Clothing > View All"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    Then PLP: I verify list and sale price displayed
    And PLP: I click on the product name which has list and sale price
    And I am on the product detail page
    Then PDP: I verify list and sale price displayed
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    Then MENU: I verify minicart product name displayed on mouse hover
    And MENU: I verify the color is displayed on mini cart
    And MENU: I verify size is displayed on mini cart
    And MENU: I verify was and now labels are displayed on mini cart
    And MENU: I verify product image is displayed on mini cart
    And MENU: I verify product qty is displayed
    And SBP: my Shopping Bag is empty
    
   @browseShop @Regression_AIE @desktopOnly @regression_set1
   Scenario: FPR_TC265_AUTO-187_A: Verify mini bag is displayed with various product details when guest user and Loged-In user hovers on Cart link in header section of Mk site
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > Shoulder Bags"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    Then MENU: I verify minicart product name displayed on mouse hover
    And MENU: I verify the color is displayed on mini cart
    And MENU: I verify size is displayed on mini cart
    And MENU: I verify product price displayed on mini cart
    And MENU: I verify product image is displayed on mini cart
    And MENU: I verify product qty is displayed

   @browseShop @Regression_AIE @desktopOnly @regression_set1
   Scenario: FPR_TC265_AUTO-187_B: Verify mini bag is displayed with various product details when guest user and Loged-In user hovers on Cart link in header section of Mk site
    Given Login: I am mk logged in customer verifying "AUTO-187"
    And I navigate to MK HomePage
    Given Login: I Log In
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > Shoulder Bags"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    Then MENU: I verify minicart product name displayed on mouse hover
    And MENU: I verify the color is displayed on mini cart
    And MENU: I verify size is displayed on mini cart
    And MENU: I verify product price displayed on mini cart
    And MENU: I verify product image is displayed on mini cart
    And MENU: I verify product qty is displayed
    And SBP: my Shopping Bag is empty

  @browseShop @excludeNA @Regression_AIE @desktopOnly @regression_set1
  Scenario: FPR_TC488_AUTO-210: Verify the products count displayed on PLP Pages matches the products displayed
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify product total count matches with product displayed
        
  @browseShop @excludeNA @Regression_AIE @mobileOnly @regression_set1
  Scenario: FPR_TC488_AUTO-210: Verify the products count displayed on PLP Pages matches the products displayed
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify product total count matches with product displayed
    
  @browseShop @naOnly @Regression_AIE @desktopOnly @akamaiCache @smokeSuite @regression_set1
  Scenario: FPR_TC488_AUTO-210: Verify the products count displayed on PLP Pages matches the products displayed
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify product total count matches with product displayed   
        
  @browseShop @naOnly @Regression_AIE @mobileOnly @akamaiCache @smokeSuite @regression_set1
  Scenario: FPR_TC488_AUTO-210: Verify the products count displayed on PLP Pages matches the products displayed
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify product total count matches with product displayed
    
  @browseShop @Regression_AIE @excludeGlobal @regression_set1
  Scenario: FPR_TC497_AUTO-219: Verify PDP Page contents.
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I verify Brand Name is displayed
    Then PDP: I verify item name field is displayed
    Then PDP: I verify clicking on the arrow changes the image
    Then PDP: I verify item style ID field is displayed
    Then PDP: I verify Product Price in the country currency
    Then PDP: I verify item color field is displayed
    Then PDP: I verify first color selected as default color
    Then PDP: I select color and verify the color name
   # Then PDP: I verify size guide link and size option displayed
    Then PDP: I verify Add To Bag button displayed
    Then PDP: I verify favorite or wishlist link is displayed
    Then PDP: I verify Quantity drop down displayed
    Then PDP: I verify product image displayed
    And I am interested in following mk products
      | click and collect | category:click and collect |
    And HomePage: I click on search link
    And SLP: I type 'click and collect:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I verify click and collect button displayed
    And I am interested in following mk products
      | monogram bag | category:monogram bag |
    And HomePage: I click on search link
    And SLP: I type 'monogram bag:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I verify Customize section is displayed
    
  @browseShop @Regression_AIE @globalOnly @excludeEU @excludeNA @regression_set1
  Scenario: FPR_TC497_AUTO-219: Verify PDP Page contents.
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type '30S9GM9S2T' into the search box and press key enter
    And PLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I verify Brand Name is displayed
    Then PDP: I verify item name field is displayed
    Then PDP: I verify Product Price in the country currency
    Then PDP: I verify clicking on the arrow changes the image
    Then PDP: I verify item style ID field is displayed
    Then PDP: I verify Product Price in the country currency
    Then PDP: I verify item color field is displayed
    Then PDP: I verify first color selected as default color
    Then PDP: I select color and verify the color name
    #Then PDP: I verify size guide link and size option displayed
    Then PDP: I verify Add To Bag button displayed
    Then PDP: I verify favorite or wishlist link is displayed
    Then PDP: I verify Quantity drop down displayed
    Then PDP: I verify product image displayed
    
    
  @browseShop @Regression_AIE @desktopOnly @regression_set1
  Scenario: FPR_TC489_AUTO-211: Verify all the products displayed under categories has the Product Name and price details in country currency
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I verify product names displayed for all the products
    And PLP: I verify Product Price in the country currency
    And PLP: I verify Price Range Filters in the Country currency
    And PLP: I verify Color Swatches when multiple colors are available
    
  @browseShop @Regression_AIE @mobileOnly @regression_set1
  Scenario: FPR_TC489_AUTO-211: Verify all the products displayed under categories has the Product Name and price details in country currency
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I verify product names displayed for all the products
    And PLP: I verify Product Price in the country currency
    And PLP: I verify Price Range Filters in the Country currency
    And PLP: I verify Color Swatches when multiple colors are available
    
  @browseShop @Regression_AIE @regression_set1
  Scenario: FPR_TC208_AUTO-175: To Verify that user is able to apply price range when product has multiple  SKU prices
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I select price filter 2
    Then PLP: I verify products displayed are in the applied price range
    
  @browseShop @Regression_AIE @akamaiCache @regression_set1
  Scenario: FPR_TC490_AUTO-212: Verify all the products having multiple colours displays color swatches and are selectable
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I verify Color Swatches when multiple colors are available
		And PLP: I verify clicking on Color Swatches changes product image
		And PLP: I verify product name and Price not changed after changing the color swatches
		
	@browseShop @Regression_AIE @desktopOnly @regression_set1
  Scenario: FPR_TC491_AUTO-213: Verify Sort options and sort by Price options are functional on  the PLP Page
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    Then PLP: I select Sort Option "Price High to Low"
    Then PLP: I Verify selected sort option displayed
    And PLP: I verify Product displayed in High To Low order
    Then PLP: I select Sort Option "price low to high"
    Then PLP: I Verify selected sort option displayed
    And PLP: I verify Product displayed in Low To High order
    Then PLP: I select Sort Option "featured"
    Then PLP: I Verify selected sort option displayed
    Then PLP: I select Sort Option "new arrivals"
    Then PLP: I Verify selected sort option displayed
    
  @browseShop @Regression_AIE @mobileOnly @regression_set1
  Scenario: FPR_TC491_AUTO-213: Verify Sort options and sort by Price options are functional on  the PLP Page
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    Then PLP: I select Sort Option "Price High to Low"
    Then PLP: I Verify selected sort option displayed
    And PLP: I verify Product displayed in High To Low order
    Then PLP: I select Sort Option "Price Low to High"
    Then PLP: I Verify selected sort option displayed
    And PLP: I verify Product displayed in Low To High order
    Then PLP: I select Sort Option "Featured"
    Then PLP: I Verify selected sort option displayed
    Then PLP: I select Sort Option "New Arrivals"
    Then PLP: I Verify selected sort option displayed

  @browseShop @Regression_AIE @euOnly @desktopOnly @regression_set1
  Scenario: FPR_TC484_AUTO-206: Verify the Hero Banner Functionality
    #Given I am a mk customer
    And I navigate to MK HomePage
    And PLP: I verify hero banner
    And PLP: I verify the links displayed in the hero banner
    And PLP: I verify all links "HANDBAGS > CLOTHING > SHOES > ACCESSORIES > MENS > VIEW ALL" are functional in hero banner
    
	@browseShop @Regression_AIE @euOnly @mobileOnly @regression_set1
  Scenario: FPR_TC484_AUTO-206: Verify the Hero Banner Functionality
    #Given I am a mk customer
    And I navigate to MK HomePage
    And PLP: I verify hero banner
    And PLP: I verify the links displayed in the hero banner
    And PLP: I verify all links "HANDBAGS > CLOTHING > SHOES > ACCESSORIES > MENS > VIEW ALL" are functional in hero banner
    
   @browseShop @Regression_AIE @desktopOnly @regression_set1
   Scenario: FPR_TC487_AUTO-209: Verify the breadcrumb Links on the PLP page Navigates to the respective pages
    Given I am a mk customer
    And I navigate to MK HomePage
		When MENU: I click menu "Women > Clothing > Dresses"
    Then I am on the product listing page
    And PLP: I click on breadcrumb link and verify the breadcrumb link navigation
    
  @browseShop @Regression_AIE @naOnly @regression_set1
  Scenario: FPR_TC502_AUTO-224: Verify the user can add an Item to favorites from the PDP page by Signing Up
  	Given I am a mk customer
  	And MENU: I click on search link
 		And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on Add to Wishlist or Favorites link
    And PDP: I click on Join link in wishlist message section
   	And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter new email address
    And SignUp: I enter postal Code
    And SignUp: I enter birth Month
    And SignUp: I enter birth Day
    And SignUp: I choose gender
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I opt out marketing comms
    When SignUp: I click create account button
    And PDP : I navigate to the wishlist page
    And Profile: I verify product is added to the wishlist or favorites
    
  @browseShop @Regression_AIE @excludeNA @regression_set1
  Scenario: FPR_TC502_AUTO-224: Verify the user can add an Item to favorites from the PDP page by Signing Up
  	Given I am a mk customer
  	And MENU: I click on search link
 		And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on Add to Wishlist or Favorites link
    And PDP: I click on Sign up link in favorites message section
   	And SignUp: I enter new email address
    And SignUp: I enter confirm email address
    And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter phone Number
    And SignUp: I enter postal Code
    And SignUp: I select birth Month
    And SignUp: I select birth Day
    And SignUp: I select Gender
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I agree to the Terms and Conditions
    When SignUp: I click Register button
    When MENU: I click User Profile link
    And Profile: I click on 'favorites' link
    And Profile: I verify product is added to the wishlist or favorites
    
  @browseShop @Regression_AIE @naOnly @regression_set1
  Scenario: FPR_TC501_AUTO-223: Verify the user can add an Item to favorites from the PDP page by logging in with valid credentials
  	Given I am a mk customer
    Given Login: I Log In
    When MENU: I click User Profile link
    And Profile: I click on 'wishlist' link
    And Profile: I empty my wishlist
    And Login: I Log Out
    And I navigate to MK HomePage
  	And MENU: I click on search link
 		And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on Add to Wishlist or Favorites link
    And PDP: I click on Sign In link in wishlist message section
   	And Login: I enter email address
    And Login: I enter password
    When Login: I click Sign In button
    And PDP : I navigate to the wishlist page
    And Profile: I verify product is added to the wishlist or favorites
    
  @browseShop @Regression_AIE @excludeNA @regression_set1
  Scenario: FPR_TC501_AUTO-223: Verify the user can add an Item to favorites from the PDP page by logging in with valid credentials
  	Given I am a mk customer
  	Given Login: I Log In
  	When MENU: I click User Profile link
    And Profile: I click on 'favorites' link
    And Profile: I empty my favorites
    And Login: I Log Out
    And I navigate to MK HomePage
  	And MENU: I click on search link
 		And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on Add to Wishlist or Favorites link
    And PDP: I click on Sign In link in favorites message section
   	And Login: I enter email address
    And Login: I enter password
    When Login: I click Sign In button
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    And Profile: I click on 'favorites' link
    And Profile: I verify product is added to the wishlist or favorites

   @browseShop @Regression_AIE @desktopOnly @regression_set1
   Scenario: FPR_TC498_AUTO-220: Verify the breadcrumb Links on the PDP page for the navigates to the respective pages for
		1. PDP Page navigated via PLP page
		2. PDP Page navigated via SLP Page
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "Women > Clothing > Dresses"
    Then I am on the product listing page
    Then PLP: I verify the page name and url
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click a product position 1 in the product list
    And PDP: I click on breadcrumb link and verify the breadcrumb link navigation to "plp"
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on breadcrumb link and verify the breadcrumb link navigation to "slp"

   @browseShop @euOnly @Regression_AIE @excludeGlobal @regression_set1
   Scenario: FPR_TC500_AUTO-222: Verify the Click & Collect Popup contents
    Given I am a mk customer
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on click and collect
    Then CC: I verify store key text is displayed
    Then CC: I verify product Image is displayed
    Then CC: I verify style No is displayed
    Then CC: I verify currency Code as per the country is displayed
    Then CC: I verify product Price with WAS and NOW lable is displayed
    Then CC: I verify color is displayed
    Then CC: I verify quantity drop down is displayed
    Then CC: I verify distance Dropdown is displayed
    Then CC: I verify city or Postcode Text box is displayed
    Then CC: I verify find Stores Button is displayed
    Then CC: I verify exit button is displayed
    Then CC: I verify the translations for the translated Locales are as expected is displayed
    
   @browseShop @naOnly @Regression_AIE @regression_set1
   Scenario: FPR_TC500_AUTO-222: Verify the Click & Collect Popup contents
    Given I am a mk customer
    And MENU: I click on search link
    And SLP: I type '30T2GTVM3B' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on click and collect
    Then CC: I verify store key text is displayed
    Then CC: I verify product Image is displayed
    Then CC: I verify style No is displayed
    Then CC: I verify currency Code as per the country is displayed
    Then CC: I verify product Price with WAS and NOW lable is displayed
    Then CC: I verify color is displayed
    Then CC: I verify quantity drop down is displayed
    Then CC: I verify distance Dropdown is displayed
    Then CC: I verify city or Postcode Text box is displayed
    Then CC: I verify find Stores Button is displayed
    Then CC: I verify exit button is displayed
    Then CC: I verify the translations for the translated Locales are as expected is displayed
 
  @browseShop @Regression_AIE @desktopOnly @excludeCA @akamaiCache @smokeSuite @regression_set1
  Scenario: FPR_TC207_AUTO-174: To Verify that user can view the list (WAS) and sale price
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "SALE > Handbags"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    Then PLP: I verify list and sale price displayed
    And PLP: I click on the product name which has list and sale price
    And I am on the product detail page
    Then PDP: I verify list and sale price displayed
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I verify i am on shopping bag page
    Then SBP: I verify list and sale price displayed
     
  @browseShop @Regression_AIE @mobileOnly @excludeCA @akamaiCache @smokeSuite @regression_set1
  Scenario: FPR_TC207_AUTO-174: To Verify that user can view the list (WAS) and sale price
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "SALE > Handbags"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    Then PLP: I verify list and sale price displayed
    And PLP: I click on the product name which has list and sale price
    And I am on the product detail page
    Then PDP: I verify list and sale price displayed
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I verify i am on shopping bag page
    Then SBP: I verify list and sale price displayed on shopping bag for mobile
    
  @browseShop @Regression_AIE @desktopOnly @caOnly @akamaiCache @smokeSuite @regression_set1
  Scenario: FPR_TC207_AUTO-174: To Verify that user can view the list (WAS) and sale price
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "SALE > Handbags"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    Then PLP: I verify list and sale price displayed
    And PLP: I click on the product name which has list and sale price
    And I am on the product detail page
    Then PDP: I verify list and sale price displayed
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I verify i am on shopping bag page
    Then SBP: I verify list and sale price displayed
    
  @browseShop @Regression_AIE @mobileOnly @caOnly @akamaiCache @smokeSuite @regression_set1
  Scenario: FPR_TC207_AUTO-174: To Verify that user can view the list (WAS) and sale price
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "SALE > Handbags"
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    Then PLP: I verify list and sale price displayed
    And PLP: I click on the product name which has list and sale price
    And I am on the product detail page
    Then PDP: I verify list and sale price displayed
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I verify i am on shopping bag page
    Then SBP: I verify list and sale price displayed on shopping bag for mobile