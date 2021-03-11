Feature: Order placement

  @guestOrderPlacement @orderPlacement @siteChecks @daily @desktopOnly @euOnly 
  Scenario: Verify a user can checkout after adding the third product listed
    from the 'Handbags' category to the Shopping Bag

    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    And PLP: I click a product position 3 in the product list
    And I am on the product detail page
    And PDP: I verify item name field is displayed
    And PDP: I verify item style ID field is displayed
    And PDP: I verify item price field is displayed
    And PDP: I verify item color field is displayed
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay

  @guestOrderPlacement @orderPlacement_wip @siteChecks_wip @daily_wip @desktopOnly_wip @globalOnly_wip
  Scenario: Verify a user can checkout after adding the third product listed
  from the 'Handbags' category to the Shopping Bag
	  And I clear browser cache
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    And PLP: I click a product position 3 in the product list
    And I am on the product detail page
    And PDP: I verify item name field is displayed
    And PDP: I verify item style ID field is displayed
    And PDP: I verify item price field is displayed
    And PDP: I verify item color field is displayed
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay

  @guestOrderPlacement @orderPlacement @siteChecks @daily @desktopOnly @naOnly
  Scenario: Verify a user can checkout after adding the third product listed
    from the 'Handbags' category to the Shopping Bag

    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "WOMEN > Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 3 products displayed
    And PLP: I click a product position 3 in the product list
    And I am on the product detail page
    And PDP: I verify item name field is displayed
    And PDP: I verify item style ID field is displayed
    And PDP: I verify item price field is displayed
    And PDP: I verify item color field is displayed
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment  
    
   @guestOrderPlacement @orderPlacement @excludeGlobal @euOnly @RegressionMK
   Scenario: Auto_104: Verify user is able to apply promotion on payment section.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click menu "Handbags > View All Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click a product position 1 in the product list
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section 
    And BILLING: I click on Apply a promo code link
    And BILLING: I enter promo code 
    And BILLING: I click on Apply button 
    And BILLING: I verified promo is applied succesfully

   @guestOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC511_AUTO-233: Verify the user can Place a Ship to Address Order with Split Payment (Gift Card  + Paypal) as an Anonymous User  by switching the payment method from ( Gift Card + Credit Card) to  (Gift Card + Paypal).
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I hold a "AUTO-233" gift card
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 3
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And I hold a "Paypal" Payment type
		And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
    And Order Confirmation: I click on View order details link
    Then Order Confirmation: I verify split payment methods are displayed in Order summary
		And ORDERCONFIRMATION: I write order number for "AUTO-233"
		
   @guestOrderPlacement @checkout @naOnly @Regression_AIE @lowerEnvOnly @regression_set2
   Scenario: FPR_TC511_AUTO-233: Verify the user can Place a Ship to Address Order with Split Payment (Gift Card  + Paypal) as an Anonymous User  by switching the payment method from ( Gift Card + Credit Card) to  (Gift Card + Paypal).
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I hold a "AUTO-233" gift card
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 3
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And I hold a "Visa" credit card
    And BILLING: I click on card payment option
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And BILLING: I click on edit payment Link
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    And BILLING: I click on continue with paypal button
    Then PAYMENT: I enter paypal required details
    Then BILLING: I fill up email address field
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    Then Order Confirmation: I verify split payment methods are displayed in Order summary
		And ORDERCONFIRMATION: I write order number for "AUTO-233"

  @guestOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC512_AUTO-234: Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 2
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
		And ORDERCONFIRMATION: I write order number for "AUTO-234"
		
	 @loggedinOrderPlacement @orderPlacement @globalOnly @lowerEnvOnly @Regression_AIE @regression_set2 @checkout
   Scenario: FPR_TC512_AUTO-234: Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type '30F6GM9T3L' into the search box and press key enter
    And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout Securely button for loggedIn user
    And I hold a "Visa" Payment type
    And I am on the Checkout page
    And I enter card payment details
    And I click on Pay button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-234"
		
  @guestOrderPlacement @checkout @naOnly @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: FPR_TC512_AUTO-234: Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 2
    And EDIT PRODUCT: I click update shopping bag
     And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "Visa" credit card
    And BILLING: I click on card payment option
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-234"
    
  @guestOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC513_AUTO-235: Verify the user can Place a Ship to Address Order with Gift Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-235" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart
    And BILLING: I click on PayNow button
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-235"
    
  @guestOrderPlacement @checkout @naOnly @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: FPR_TC513_AUTO-235: Verify the user can Place a Ship to Address Order with Gift Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-235" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart
    And BILLING: I close the pop up
    Then BILLING: I fill up email address field
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
		And ORDERCONFIRMATION: I write order number for "AUTO-235"
	
   @guestOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC514_AUTO-236: Verify the user can Place a Ship to Address Order with Split payment (Gift Card + Credit Card) as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 3
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-236" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-236"
     
  @guestOrderPlacement @checkout @naOnly @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: FPR_TC514_AUTO-236: Verify the user can Place a Ship to Address Order with Split payment (Gift Card + Credit Card) as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 3
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-236" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And I hold a "Visa" credit card
    And BILLING: I click on card payment option
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-236"
	
	@guestOrderPlacement @checkout @naOnly @Regression_AIE @smokeSuite @regression_set2
  Scenario: FPR_TC515_AUTO-237: Verify the user can Place a Ship to Address Order with PayPal  as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    #And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And SLP: I type 'MS18033BVC' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    #And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 2
    And EDIT PRODUCT: I click update shopping bag
    #And SBP: I click on Apply Promo Code Link
    #Then I verify Apply Promo Code section expanded
    #When I apply a PromoCode on shopping bag page
    #Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    #Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    #And I hold a "Paypal" Payment type
    #And BILLING: I select paypal payment option
    #And BILLING: I click on continue with paypal button
    #Then PAYMENT: I enter paypal required details
    #Then BILLING: I fill up email address field
    #And BILLING: I click on Continue To Order Review button
    #And Place Order: I click on Place Order button
    #And Order Confirmation: I verify order confirmation page is displayed
    #And ORDERCONFIRMATION: I write order number for "AUTO-237"
    
  @guestOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC515_AUTO-237: Verify the user can Place a Ship to Address Order with PayPal  as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 2
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-237"
    
   @guestOrderPlacement @orderPlacement @globalOnly @lowerEnvOnly @Regression_AIE @regression_set2 @checkout
   Scenario: FPR_TC515_AUTO-237: Verify the user can Place a Ship to Address Order with PayPal  as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type '30F6GM9T3L' into the search box and press key enter
    And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And I hold a "Paypal" Payment type
    And I enter all required Billing address details
    And I select Paypal payment
    And I click on use this button
    And I click on Pay button
    Then PAYMENT: I enter paypal Required details
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-237"
	
	 @guestOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC516_AUTO-238: Verify the user can Place a Ship to Address Order with Split payment (Gift Card + PayPal) as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
     And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 2
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-238" gift card to place order
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-238"
    
  @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC516_AUTO-238: Verify the user can Place a Ship to Address Order with Split payment (Gift Card + PayPal) as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '31F4TBLA3P' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 2
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-238" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    And BILLING: I click on continue with paypal button
    Then PAYMENT: I enter paypal required details
    Then BILLING: I fill up email address field
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-238"

   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC525_AUTO-247: Verify the user can Place a Ship to Address Order with Credit Card as a Registered User with ENGRAVING + MONOGRAM SKUs and Normal SKUs in the basket
    Given I am a logged-in mk customer
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
    And MENU: I verify the shopping bag counter is updated to 1
    And I am interested in following mk products
      | EU_engrave | category:EU_engrave |
    And HomePage: I click on search link
    And SLP: I type 'EU_engrave:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on The Fluid PDP
    And ENGRAVE: I engrave "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 3
    And MENU: I click on Bag link
    And I am on the Shopping Bag page
    And SBP: I click on Checkout Securely button for loggedIn user
    And I am on the Checkout page
    And SHIPPING: I click Continue to review and pay
    And BILLING: I get Order Total amount in Order summary
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields for New card
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    Then Order Confirmation: I verify Order Total amount in order details
    And Order Confirmation: I click on View order details link
    Then Order Confrimation: I Verify Custom Product displayed in Order summary
    Then Order Confirmation: I verify Payment method displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-247"
   
   @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC525_AUTO-247: Verify the user can Place a Ship to Address Order with Credit Card as a Registered User with ENGRAVING + MONOGRAM SKUs and Normal SKUs in the basket
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | NA_monogram | category:NA_monogram |
    And HomePage: I click on search link
    And SLP: I type 'NA_monogram:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      | NA_engrave | category:NA_engrave |
    And HomePage: I click on search link
    And SLP: I type 'NA_engrave:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on The Fluid PDP
    And ENGRAVE: I engrave "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 3
    And MENU: I click on Bag link
    And I am on the Shopping Bag page
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I select shipping address for logged-in user
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I get Order Total amount in Order summary
    Then BILLIng: I select saved Card and enter card Security code
    And BILLING: I fill up billing address
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    Then Order Confrimation: I Verify Custom Product displayed in Order summary
    Then Order Confirmation: I verify Order Total amount in order details
    Then Order Confirmation: I verify Payment method displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-247"

  @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC526_AUTO-248: Verify the user can Place a Ship to Address Order with Multiple Gift Cards as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'Mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And I hold a "15PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    And SBP: I verified promo is applied succesfully
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a 'AUTO-248_A' gift card
   	And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I close the pop up
    And BILLING: I verify gift card applied to the cart
    And I hold a 'AUTO-248_B' gift card
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I close the pop up
    And BILLING: I verify order total is zero
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-248"
    
   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC526_AUTO-248: Verify the user can Place a Ship to Address Order with Multiple Gift Cards as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    And I verify Promotion is applied in shopping bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I Verify RemoveNote Link
    And SHIPPING: I click Continue to review and pay
    And I hold a 'AUTO-248_A' gift card
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I click on add a new gift card link
    And BILLING: I verify gift card applied to the cart
    And I hold a 'AUTO-248_B' gift card
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify order total is zero
    And Review & Pay: I click pay now
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-248"

  @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC527_AUTO-249: Verify the user can Place a Ship to Address Order with Split payment (Gift Card + PayPal) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
   Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'Mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And I hold a "15PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    And SBP: I verified promo is applied succesfully
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-249" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I close the pop up
    And BILLING: I verify gift card applied to the cart 
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    And BILLING: I click on continue with paypal button
    Then PAYMENT: I enter paypal required details
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-249"
      
  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC527_AUTO-249: Verify the user can Place a Ship to Address Order with Split payment (Gift Card + PayPal) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
		Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    And I verify Promotion is applied in shopping bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-249" gift card to place order
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-249"
    
   @loggedinOrderPlacement @checkout @globalOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC527_AUTO-249: Verify the REgistered user can Place a Ship to Address Order with Paypal payment.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type '30F6GM9T3L' into the search box and press key enter
    And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Checkout Securely button for loggedIn user
    And I am on the Checkout page
    And I hold a "Paypal" Payment type
    And I select Paypal payment
    And I click on Pay button
    Then PAYMENT: I enter paypal Required details
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-249"
    
  @loggedinOrderPlacement @orderPlacement @excludeGlobal @euOnly @Regression_AIE @regression_set2 @checkout
  Scenario: FPR_TC535_AUTO-257: Verify the user can Place a Ship to Address Order with New Credit Card as a Registered User and can save the Payment details to the profile from Review & Pay section of Checkout page.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link   
    When SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "non3Ds" credit card
    And BILLING: I input card holder name as "Saurabh Tripathi"
    And BILLING: I input card number
    And BILLING: I select Card Expiration Date
    And BILLING: I input card security code
    And BILLING: I click on save card details check box
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-257"
    And I navigate to MK HomePage
    And MENU: I click User Profile link
    And I navigate to the profile Page
    And Profile: I click on Payment Information link
    And Payment Info: I Verify credit card is saved in profile with card holder name as "Saurabh Tripathi"
    And Payment Info: I Delete Saved Payment in profile with card holder name as "Saurabh Tripathi" and verify if card deleted
    
   @loggedinOrderPlacement @orderPlacement @globalOnly @Regression_AIE @regression_set2 @checkout
   Scenario: FPR_TC535_AUTO-257: Verify the user can Place a Ship to Address Order with New Credit Card as a Registered User
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type '30F6GM9T3L' into the search box and press key enter
    And SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Checkout Securely button for loggedIn user
    And I hold a "Visa" Payment type
    And I am on the Checkout page
    And I enter card payment details
    And I click on Pay button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-257"
    
  @loggedinOrderPlacement @orderPlacement @naOnly @Regression_AIE @regression_set2 @checkout
  Scenario: FPR_TC535_AUTO-257: Verify the user can Place a Ship to Address Order with New Credit Card as a Registered User and can save the Payment details to the profile from Review & Pay section of Checkout page.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I click on Add a new card button
    And BILLING: I input card holder name as "Saurabh Tripathi"
    And BILLING: I input card number
    And BILLING: I select Card Expiration Date
    And BILLING: I input card security code
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
		And Order Confirmation: I verify order confirmation page is displayed
		And ORDERCONFIRMATION: I write order number for "AUTO-257"
    And I navigate to MK HomePage
    And MENU: I click User Profile link
    And I navigate to the profile Page
    And Profile: I click on Payment Information link
    And Payment Info: I Verify credit card is saved in profile with card holder name as "Saurabh Tripathi"
    And Payment Info: I Delete Saved Payment in profile with card holder name as "Saurabh Tripathi" and verify if card deleted
    
   @guestOrderPlacement @orderPlacement @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2 @checkout
   Scenario: FPR_TC539_AUTO-261: Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied for a Monogram product in the basket
    Given I am a mk customer
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
      | EU_monogram bag1 | category:EU_monogram bag1 |
    And HomePage: I click on search link
    And SLP: I type 'EU_monogram bag1:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "non3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-261"
    
   @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC539_AUTO-261: Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied for a Monogram product in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | NA_monogram | category:NA_monogram |
    And HomePage: I click on search link
    And SLP: I type 'NA_monogram:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And I navigate to MK HomePage
    And I am interested in following mk products
      | NA_monogram bag1 | category:NA_monogram bag1 |
    And HomePage: I click on search link
    And SLP: I type 'NA_monogram bag1:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-261"

   @guestOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC540_AUTO-262: Verify the user can Place a Ship to Address Order with Paypal as an Anonymous User with Promo code, Gift Wrap Applied for a Monogram + Normal product in the basket 
    Given I am a mk customer
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
    And MENU: I verify the shopping bag counter is updated to 1
    And I am interested in following mk products
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-262"
    
   @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC540_AUTO-262:Verify the user can Place a Ship to Address Order with Paypal as an Anonymous User with Promo code, Gift Wrap Applied for a Monogram + Normal product in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | NA_monogram  | category:NA_monogram |
    And HomePage: I click on search link
    And SLP: I type 'NA_monogram :styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And I am interested in following mk products
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    And BILLING: I click on continue with paypal button
    Then PAYMENT: I enter paypal required details
    Then BILLING: I fill up email address field
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
	  And ORDERCONFIRMATION: I write order number for "AUTO-262"
	 
	 @guestOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC541_AUTO-263:Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap Applied for a Monogram + Normal + C&C products product in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
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
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      |EU_monogram | category:EU_monogram |
    And HomePage: I click on search link
    And SLP: I type 'EU_monogram:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And I am interested in following mk products
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 3
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click on continue button for click & collect
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And BILLING: I get Order Total amount in Order summary
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    Then Order Confirmation: I verify Order Total amount in order details
    And Order Confirmation: I click on View order details link
    Then Order Confirmation: I verify Payment method displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-263"
    
   @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC541_AUTO-263:Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap Applied for a Monogram + Normal + C&C products product in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | NA_click and collect | category:NA_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'NA_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      | NA_monogram | category:NA_monogram |
    And HomePage: I click on search link
    And SLP: I type 'NA_monogram:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on the customize page
    And CUSTOMIZE: I monogram "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 3
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And BILLING: I get Order Total amount in Order summary
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    Then Order Confirmation: I verify Payment method displayed
    Then Order Confirmation: I verify Order Total amount in order details
    And ORDERCONFIRMATION: I write order number for "AUTO-263"
	
	 @guestOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC542_AUTO-264: Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied for a Engrave product in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
     And I am interested in following mk products
      | EU_engrave | category:EU_engrave |
    And HomePage: I click on search link
    And SLP: I type 'EU_engrave:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on The Fluid PDP
    And ENGRAVE: I engrave "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 1
     And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
     And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-264"

   @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC542_AUTO-264: Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied for a Engrave product in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I am interested in following mk products
      | NA_engrave | category:NA_engrave |
    And HomePage: I click on search link
    And SLP: I type 'NA_engrave:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on The Fluid PDP
    And ENGRAVE: I engrave "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 1
   And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-264"
	
	 @guestOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC543_AUTO-265: Verify the user can Place a Ship to Address Order with Paypal as an Anonymous User with Promo code, Gift Wrap Applied for a Engrave + Normal products in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_engrave | category:EU_engrave |
    And HomePage: I click on search link
    And SLP: I type 'EU_engrave:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on The Fluid PDP
    And ENGRAVE: I engrave "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-265"
    
   @guestOrderPlacement @checkout @naOnly @Regression_AIE @lowerEnvOnly @regression_set2
   Scenario: FPR_TC543_AUTO-265: Verify the user can Place a Ship to Address Order with Paypal as an Anonymous User with Promo code, Gift Wrap Applied for a Engrave + Normal products in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I am interested in following mk products
      | NA_engrave | category:NA_engrave |
    And HomePage: I click on search link
    And SLP: I type 'NA_engrave:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on The Fluid PDP
    And ENGRAVE: I engrave "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to payment
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    And BILLING: I click on continue with paypal button
    Then PAYMENT: I enter paypal required details
    Then BILLING: I fill up email address field
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-265"
	
	 @guestOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC544_AUTO-266: Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap Applied for a Engrave + Normal + C&C products in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
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
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_engrave | category:EU_engrave |
    And HomePage: I click on search link
    And SLP: I type 'EU_engrave:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on The Fluid PDP
    And ENGRAVE: I engrave "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 3
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click on continue button for click & collect
    And CC: I select checkbox to collect item from store
    #And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And BILLING: I get Order Total amount in Order summary
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    Then Order Confirmation: I verify Order Total amount in order details
    And Order Confirmation: I click on View order details link
    Then Order Confirmation: I verify Payment method displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-266"
    
     @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC544_AUTO-266: Verify the user can Place a Ship to Address Order with Credit Card as an Anonymous User with Promo code, Gift Wrap Applied for a Engrave + Normal + C&C products in the basket
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | NA_click and collect | category:NA_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'NA_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      | NA_engrave | category:NA_engrave |
    And HomePage: I click on search link
    And SLP: I type 'NA_engrave:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on Monogram It
    And I am on The Fluid PDP
    And ENGRAVE: I engrave "MOM" and click add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 3
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to payment
    And BILLING: I get Order Total amount in Order summary
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    Then Order Confirmation: I verify Payment method displayed
    Then Order Confirmation: I verify Order Total amount in order details
    And ORDERCONFIRMATION: I write order number for "AUTO-266"
