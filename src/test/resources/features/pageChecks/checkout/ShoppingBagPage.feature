Feature: Shopping Bag page checks

  @loggedin @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_032: Edit a standard product from shopping bag
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click menu "Handbags > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And PDP: I select 2 from the quantity dropdown
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I can verify the number of quantity is 2
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 4
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I can verify quantity updated message
    And SBP: I can verify the number of quantity is 4

  @guest @checkout_wip @shoppingBag_wip @smoke_wip
  Scenario: AutoSmoke_036_A: Verify user able to apply all Order,Item,Shipping level promotion together.
    Given I am a mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag |
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'sunglasses:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I am on shopping bag page
    And ShoppingCart: I click on Apply a Promo code link
    When ShoppingCart: I apply the promocode "item level promocode" on Shopping bag page
    When ShoppingCart: I apply the promocode "Shipping level promocode" on Shopping bag page
    When ShoppingCart: I apply the promocode "Order level promocode" on Shopping bag page
    Then ShoppingCart: I Verify all the promo codes applied

  @guest @checkout_wip @shoppingBag_wip @smoke_wip
  Scenario: AutoSmoke_036_B: Verify guest user is able to apply all Order,Item,Shipping level promotion together on cart page
    Given I am a mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag |
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'sunglasses:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I am on shopping bag page
    And SBP: I click on Checkout Securely button
    And SBP: I click on the Checkout As Guest button
    And I am on the Shipping page
    And Shipping:I Select Country
    And Shipping:I click on Enter address manually link
    And Shipping:I Enter Address line1
    And Shipping:I Enter Address line2
    And Shipping:I enter City
    And Shipping:I enter County
    And Shipping:I enter Postcode
    And Shipping:I select make this my billing address
    And Shipping:I Select title
    And Shipping: I enter first Name
    And Shipping: I enter last Name
    And Shipping: I enter Phone number
    And Shipping: I enter Email address
    And Shipping:I click on ship to this Address button
    And Checkout:I select the "Free" Shipping Option
    And Checkout:I click on Continue to Review and Pay button
    And Checkout:I click on Apply a Promo code link
    When Checkout: I apply the promocode "item level promocode" on Shopping bag page
    When Checkout: I apply the promocode "Shipping level promocode" on Shopping bag page
    When Checkout: I apply the promocode "Order level promocode" on Shopping bag page
    Then Checkout: I Verify all the promo codes applied

  @guest @checkout_wip @shoppingBag_wip @smoke_wip
  Scenario: AutoSmoke_037: Verify that user able to apply the max threshold limit of promotion in single order (5 Promo's)
    Given I am a mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag |
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'sunglasses:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And ShoppingCart: I am on shopping bag page
    And ShoppingCart: I click on Apply a Promo code link
    When ShoppingCart: I apply the promocode "item level promocode" on Shopping bag page
    When ShoppingCart: I apply the promocode "Shipping level promocode" on Shopping bag page
    When ShoppingCart: I apply the promocode "Order level promocode" on Shopping bag page
    Then ShoppingCart: I apply the promocode "Amount off promocode" on Shopping bag page
    Then ShoppingCart: I apply the promocode "Global promocode" on Shopping bag page
    Then ShoppingCart: I Verify all the promo codes applied

  @guest @checkout_wip @shoppingBag_wip @smoke_wip
  Scenario: AutoSmoke_038_A: Verify that Guest Users is able to apply Employee Promotion on Shopping Cart Page.
    Given I am a mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag |
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'sunglasses:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I am on shopping bag page
    When SBP: I apply the promocode "promocode" on Shopping bag page
    Then SBP: I see the message "Promo code applied to your Order" on the Shopping bag page

  @guest @checkout_wip @shoppingBag_wip @smoke_wip
  Scenario: AutoSmoke_038_B: Verify that Guest Users is able to apply Employee Promotion on Checkout Page.
    Given I am a mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag |
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'sunglasses:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I am on shopping bag page
    And SBP: I click on Checkout Securely button
    And SBP: I click on the Checkout As Guest button
    And I am on the Shipping page
    And Shipping: I Select Country
    And Shipping: I click on Enter address manually link
    And Shipping: I Enter Address line1
    And Shipping: I Enter Address line2
    And Shipping: I enter City
    And Shipping: I enter County
    And Shipping: I enter Postcode
    And Shipping: I select make this my billing address
    And Shipping: I Select title
    And Shipping: I enter first Name
    And Shipping: I enter last Name
    And Shipping: I enter Phone number
    And Shipping: I enter Email address
    And Shipping: I click on ship to this Address button
    And Checkout: I select the "Free" Shipping Option
    And Checkout: I click on Continue to Review and Pay button
    And Checkout: I click on Apply a Promo code link
    And Checkout: I apply the promocode "promocode" on Checkout page
    Then I see the message "Promo code applied to your Order" on the Checkout page

  @guest @checkout_wip @shoppingBag_wip @smoke_wip
  Scenario: AutoSmoke_039: Verify that employee cannot purchase more than 3 quantities of the same sku when the emp promotion is applied.
    Given I am a mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
      | bag | category:bag |
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'sunglasses:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And SLP: I click on the product name
    And PDP: I select 5 from the quantity dropdown
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I am on shopping bag page
    When SBP: I apply the promocode "promocode" on Shopping bag page
    Then SBP: I verify the promotion cannot be applied to the basket

  @guest @smoke @gbOnly @chOnly @deOnly @seOnly @flOnly @dkOnly @nrOnly @atOnly @nlOnly
  @excludeES
  @excludeFR
  @excludeIT
  @excludePT
  @excludeGlobal
  @excludeNA
  Scenario: AutoSmoke_064_B: Verify Klarna message widget text is displaying on Shopping Cart page
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > View All Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    When PLP: I click a product position 3 in the product list
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    When MENU: I click on Bag link
    Then SBP: I verify Klarna widget is displayed on Shopping bag page

  @loggedin @smoke @daily @dailySmoke @buildSmoke
  Scenario: Remove a standard product from shopping bag
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click menu "HANDBAGS > Shoulder Bags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Remove
    And SBP: my Shopping Bag is empty

    @guest @excludeNA @RegressionMK
    Scenario: Auto_109 verify product added as favorite in cart page is displayed in favorites page                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      Scenario: Func_Prioritized_Reg_TC_259: To verify product added as favorite in cart page is displayed in favorites page 
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And SignUp: I enter new email address
    And SignUp: I enter confirm email address
    And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I agree to the Terms and Conditions
    When SignUp: I click Register button
    Then I navigate to the profile Page
    And I navigate to MK HomePage
    When MENU: I click menu "Handbags > View All Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I capture Product Details
    And SBP: I click on Add To Favorite
    When MENU: I click User Profile link
    And Profile: I navigate to Favorites Page
    And I verify product detail on SBP page is same as on Favourite page
    
   @guestOrderPlacement @shoppingBag @Regression_AIE @regression_set1
   Scenario: FPR_TC261_AUTO-185: To verify subtotal field value of product after updating quantity in product details section of shopping cart page
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I verify Total Price Before Update the quantity
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 3
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I can verify quantity updated message
    And SBP: I can verify the number of quantity is 3
    And SBP: I Verify Bag SubTotal price after updating product quantity
    
   @guestCheckout @shoppingBag @Regression_AIE @euOnly @exludeGlobal @desktopOnly @regression_set1
   Scenario: FPR_TC510_AUTO-232: Verify the user can edit the Shopping bag via the 'Edit Shopping bag' link on the Shipping Page Order Summary Section
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I get the order summary detail before edit cart
    When SHIPPING: I click on Edit shopping bag link
    Then SBP: I verify i am on shopping bag page
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 2
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    Then SHIPPING: I verify the order summary section with the modified cart
    
   @guestCheckout @shoppingBag @Regression_AIE @naOnly @regression_set1
   Scenario: FPR_TC510_AUTO-232: Verify the user can edit the Shopping bag via the 'Edit Shopping bag' link on the Shipping Page Order Summary Section
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I get the order summary detail before edit cart
    When SHIPPING: I click on Edit shopping bag link
    Then SBP: I verify i am on shopping bag page
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 2
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    Then SHIPPING: I verify the order summary section with the modified cart
    
   @guestOrderPlacement @shoppingBag @Regression_AIE @regression_set1
   Scenario: FPR_TC261_AUTO-186: To verify subtotal is value of products before applying shipping, tax(es),order level discounts in 'Your Order' section of Cart page
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'handbag' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I verify subtotal is sum of all product price
    
   @guestOrderPlacement @shoppingBag @Regression_AIE @desktopOnly @excludeNA @regression_set1
   Scenario: FPR_TC211_AUTO-176_A: To Verify the order total of product in mini bag & cart when user added a product to cart for Anonymous User.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And SBP: I verify subtotal in miniBag
    And MENU: I click on Bag link
    Then SBP: I verify i am on shopping bag page
    And SBP: I verify Cart Total and MiniBag total price
    
   @loggedinOrderPlacement @shoppingBag @Regression_AIE @desktopOnly @excludeNA @regression_set1
   Scenario: FPR_TC211_AUTO-176_B: To Verify the order total of product in mini bag & cart when user added a product to cart for logged-in User.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I verify subtotal in miniBag
    And MENU: I click on Bag link
    Then SBP: I verify i am on shopping bag page
    And SBP: I verify Cart Total and MiniBag total price
    
   @guestOrderPlacement @shoppingBag @Regression_AIE @desktopOnly @naOnly @akamaiCache @smokeSuite @regression_set1
   Scenario: FPR_TC211_AUTO-176_A: To Verify the order total of product in mini bag & cart when user added a product to cart for Anonymous Users.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I verify subtotal in miniBag
    And MENU: I click on Bag link
    Then SBP: I verify i am on shopping bag page
    And SBP: I verify Cart Total and MiniBag total price
    
   @loggedinOrderPlacement @shoppingBag @Regression_AIE @desktopOnly @naOnly @smokeSuite @regression_set1
   Scenario: FPR_TC211_AUTO-176_B: To Verify the order total of product in mini bag & cart when user added a product to cart for logged-in Users.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I verify subtotal in miniBag
    And MENU: I click on Bag link
    Then SBP: I verify i am on shopping bag page
    And SBP: I verify Cart Total and MiniBag total price
    
   @guestOrderPlacement @browseShop @Regression_AIE @regression_set1
   Scenario: FPR_TC260_AUTO-184: To verify details for each product are displayed in cart page
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
		And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 1 product in the bag
    And MENU: I click on search link
    And SLP: I type 'tops' into the search box and press key enter
    And I am on the search listing page
		And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 2 product in the bag
    And MENU: I click on Bag link
    And SBP: I verify product name displayed
    And SBP: I verify product style is displayed
    And SBP: I verify the color is displayed
    And SBP: I verify size is displayed
    And SBP: I verify price is displayed
    And SBP: I verify product image is displayed
    And SBP: I verify product qty is displayed
    
   @guestOrderPlacement @shoppingBag @naOnly @Regression_AIE @regression_set1
   Scenario: FPR_TC503_AUTO-225: Verify the Full Cart Page content details for a Mixed basket Ship to Address and click and collect
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type '30T2GTVM3B' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And SBP: I can see 1 product in the bag
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
		And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 2 product in the bag
    And MENU: I click on Bag link
    And SBP: I verify product name displayed
    And SBP: I verify product style is displayed
    And SBP: I verify the color is displayed
    And SBP: I verify size is displayed
    And SBP: I verify price is displayed
    And SBP: I verify product image is displayed
    And SBP: I verify product qty is displayed
    Then SBP: I verify "COLLECT IN STORE" and "SHIP TO AN ADDRESS" details are displayed

   @guestOrderPlacement @shoppingBag @naOnly @Regression_AIE @regression_set1
   Scenario: FPR_TC507_AUTO-229: Verify the Edit Cart Page to change shipping Option from Collect in Store to Ship to Address
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Edit
    Then SBP: I change the shipping option to "ship to address"
    And EDIT PRODUCT: I click update shopping bag
    Then SBP: I verify "SHIP TO AN ADDRESS" is displayed
    
	 @guestOrderPlacement @shoppingBag @euOnly @Regression_AIE @excludeGlobal @regression_set1
   Scenario: FPR_TC503_AUTO-225: Verify the Full Cart Page content details for a Mixed basket Ship to Address and click and collect
   Given I am a mk customer
   And SBP: my Shopping Bag is empty
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
     And SBP: I can see 1 product in the bag
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
		And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
     And SBP: I can see 2 product in the bag
    And MENU: I click on Bag link
    And SBP: I verify product name displayed
    And SBP: I verify product style is displayed
    And SBP: I verify the color is displayed
    And SBP: I verify size is displayed
    And SBP: I verify price is displayed
    And SBP: I verify product image is displayed
    And SBP: I verify product qty is displayed
    Then SBP: I verify "COLLECT IN STORE" and "SHIP TO AN ADDRESS" details are displayed

   @guestOrderPlacement @shoppingBag @euOnly @excludeGlobal @Regression_AIE @regression_set1
   Scenario: FPR_TC507_AUTO-229: Verify the Edit Cart Page to change shipping Option from Collect in Store to Ship to Address
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
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
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Edit
    Then SBP: I change the shipping option to "ship to address"
    And EDIT PRODUCT: I click update shopping bag
    Then SBP: I verify "SHIP TO AN ADDRESS" is displayed
       
   @guestOrderPlacement @shoppingBag @Regression_AIE @regression_set1
   Scenario: FPR_TC505_AUTO-227: Verify the Edit Cart Page to change color, size and quantity
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
		And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 1 product in the bag
    And MENU: I click on Bag link
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 2
    And EDIT PRODUCT: I select different color
    #And EDIT PRODUCT: I select different size
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I can verify quantity updated message

   @guestOrderPlacement @shoppingBag @Regression_AIE @euOnly @excludeGlobal @regression_set1
   Scenario: FPR_TC504_AUTO-226: Verify the Edit Cart Page popup contents
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 1 product in the bag
    And MENU: I click on Bag link
    Then SBP: I click on Edit
    Then SBP: I verify display of EDIT PRODUCT Header text
    Then SBP: I verify display of Product Image and images displayed on clicking each thumbnail
    Then SBP: I verify display of Product Title
    Then SBP: I verify display of Store Style number
    Then SBP: I verify display of COLOR selected color highlighted
    Then SBP: I verify display of Quantity Dropdown with selected quantity displayed 
    Then SBP: I verify display of Ship to Address Radio button selected by defaults for Home delivery product
    Then SBP: I verify display of Collect in Store Details with Details link clickable selected by defaults for Home delivery product 
    Then SBP: I verify display of UPDATE SHOPPING BAG button
    Then SBP: I verify display of CANCEL button 
    Then SBP: I verify display of View Full Details link
    Then SBP: I verify display of Close option button
    Then SBP: I verify display of The Edit cart popup is closed
    And SBP: I click on Remove
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'CR84CLH61F' into the search box and press key enter
    And I am on the search listing page
		And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 1 product in the bag
    And MENU: I click on Bag link
    Then SBP: I click on Edit
    Then SBP: I verify display of EDIT PRODUCT Header text
    Then SBP: I verify display of Product Image and images displayed on clicking each thumbnail
    Then SBP: I verify display of Product Title
    Then SBP: I verify display of Store Style number
    Then SBP: I verify display of COLOR selected color highlighted
    Then SBP: I verify display of Size Guide link is functional
    Then SBP: I verify display of Size grid with selected size highlighted
    Then SBP: I verify display of Quantity Dropdown with selected quantity displayed 
    Then SBP: I verify display of Ship to Address Radio button selected by defaults for Home delivery product
    Then SBP: I verify display of Collect in Store Details with Details link clickable selected by defaults for Home delivery product 
    Then SBP: I verify display of UPDATE SHOPPING BAG button
    Then SBP: I verify display of CANCEL button 
    Then SBP: I verify display of View Full Details link
    Then SBP: I verify display of Close option button
    Then SBP: I verify display of The Edit cart popup is closed
    
	 @guestOrderPlacement @shoppingBag @Regression_AIE @globalOnly @regression_set1
   Scenario: FPR_TC504_AUTO-226: Verify the Edit Cart Page popup contents
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'CR84CLH61F' into the search box and press key enter
    And I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 1 product in the bag
    And MENU: I click on Bag link
    Then SBP: I click on Edit
    Then SBP: I verify display of EDIT PRODUCT Header text
    Then SBP: I verify display of Product Image and images displayed on clicking each thumbnail
    Then SBP: I verify display of Product Title
    Then SBP: I verify display of Store Style number
    Then SBP: I verify display of COLOR selected color highlighted
    Then SBP: I verify display of Quantity Dropdown with selected quantity displayed 
    Then SBP: I verify display of UPDATE SHOPPING BAG button
    Then SBP: I verify display of CANCEL button 
    Then SBP: I verify display of View Full Details link
    Then SBP: I verify display of Close option button
    Then SBP: I verify display of The Edit cart popup is closed
    And SBP: I click on Remove
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'CR84CLH61F' into the search box and press key enter
    And I am on the search listing page
		And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 1 product in the bag
    And MENU: I click on Bag link
    Then SBP: I click on Edit
    Then SBP: I verify display of EDIT PRODUCT Header text
    Then SBP: I verify display of Product Image and images displayed on clicking each thumbnail
    Then SBP: I verify display of Product Title
    Then SBP: I verify display of Store Style number
    Then SBP: I verify display of COLOR selected color highlighted
    Then SBP: I verify display of Size Guide link is functional
    Then SBP: I verify display of Size grid with selected size highlighted
    Then SBP: I verify display of Quantity Dropdown with selected quantity displayed 
    Then SBP: I verify display of UPDATE SHOPPING BAG button
    Then SBP: I verify display of CANCEL button 
    Then SBP: I verify display of View Full Details link
    Then SBP: I verify display of Close option button
    Then SBP: I verify display of The Edit cart popup is closed
    
   @guestOrderPlacement @shoppingBag @Regression_AIE @naOnly @regression_set1
   Scenario Outline: FPR_TC504_AUTO-226: Verify the Edit Cart Page popup contents
   Given I am a mk customer
   And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 1 product in the bag
    And MENU: I click on Bag link
    Then SBP: I click on Edit
    Then SBP: I verify display of EDIT PRODUCT Header text
    Then SBP: I verify display of Product Image and images displayed on clicking each thumbnail
    Then SBP: I verify display of Product Title
    Then SBP: I verify display of Store Style number
    Then SBP: I verify display of COLOR selected color highlighted
    Then SBP: I verify display of Quantity Dropdown with selected quantity displayed 
    Then SBP: I verify display of Ship to Address Radio button selected by defaults for Home delivery product
    Then SBP: I verify display of Collect in Store Details with Details link clickable selected by defaults for Home delivery product 
    Then SBP: I verify display of UPDATE SHOPPING BAG button
    Then SBP: I verify display of CANCEL button 
    Then SBP: I verify display of View Full Details link
    Then SBP: I verify display of Close option button
    Then SBP: I verify display of The Edit cart popup is closed
    And SBP: I click on Remove
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type "<product>" into the search box and press key enter
    And I am on the search listing page
		And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And SBP: I can see 1 product in the bag
    And MENU: I click on Bag link
    Then SBP: I click on Edit
    Then SBP: I verify display of EDIT PRODUCT Header text
    Then SBP: I verify display of Product Image and images displayed on clicking each thumbnail
    Then SBP: I verify display of Product Title
    Then SBP: I verify display of Store Style number
    Then SBP: I verify display of COLOR selected color highlighted
    Then SBP: I verify display of Size Guide link is functional
    Then SBP: I verify display of Size grid with selected size highlighted
    Then SBP: I verify display of Quantity Dropdown with selected quantity displayed 
    Then SBP: I verify display of Ship to Address Radio button selected by defaults for Home delivery product
    Then SBP: I verify display of Collect in Store Details with Details link clickable selected by defaults for Home delivery product 
    Then SBP: I verify display of UPDATE SHOPPING BAG button
    Then SBP: I verify display of CANCEL button 
    Then SBP: I verify display of View Full Details link
    Then SBP: I verify display of Close option button
    Then SBP: I verify display of The Edit cart popup is closed
    
    @usOnly
    Examples:
			| product    |
			| MH68WLE45G |
			
			@caOnly
    Examples:
			| product    |
			| MH68WN55ZV |
			

   @guestOrderPlacement @shoppingBag @naOnly @Regression_AIE @regression_set1
   Scenario: FPR_TC506_AUTO-228: Verify the Edit Cart Page to change shipping Option from Ship to Address to Collect in Store
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Edit
    Then SBP: I change the shipping option to "pick up in store"
    And PDP: I enter city and click find store
    And EDIT PRODUCT: I click update shopping bag
    Then SBP: I verify "COLLECT IN STORE" is displayed
    
   @guestOrderPlacement @shoppingBag @euOnly @excludeGlobal @Regression_AIE @regression_set1
   Scenario: FPR_TC506_AUTO-228: Verify the Edit Cart Page to change shipping Option from Ship to Address to Collect in Store
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Edit
    Then SBP: I change the shipping option to "pick up in store"
    And PDP: I enter city and click find store
    And EDIT PRODUCT: I click update shopping bag
    Then SBP: I verify "COLLECT IN STORE" is displayed
