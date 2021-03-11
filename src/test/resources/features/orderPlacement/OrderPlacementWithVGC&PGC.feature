Feature: OrderPlacementWithVGCAndPGC

  @guestOrderPlacement @checkout @euOnly @exludeGlobal @excludePT @Regression_AIE @regression_set2
  Scenario: FPR_TC537_AUTO-259_A: Verify the user can Place a Ship to Address Credit Card Order for Gift Cards (PGC + VGC) Purchase as an Anonymous and Registered User 
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "pgc" Gift Card
    And I navigate to MK HomePage
    And MENU: I verify the shopping bag counter is updated to 1
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "40"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-259_A"
    
  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @excludePT @Regression_AIE @regression_set2
  Scenario: FPR_TC537_AUTO-259_B: Verify the user can Place a Ship to Address Credit Card Order for Gift Cards (PGC + VGC) Purchase as an Anonymous and Registered User 
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "pgc" Gift Card
    And I navigate to MK HomePage
    And MENU: I verify the shopping bag counter is updated to 1
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "40"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required card fields for Loggedin
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-259_B"
    
  @guestOrderPlacement @checkout @naOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC538_AUTO-259_A: Verify the user can Place a Ship to Address Credit Card Order for mixed Order (Gift Card + Normal Products) Purchase as an Anonymous and Registered User
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I refresh the browser
    And I select Gift card amount as "40"
    And I select "pgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-259_A"
    
  @loggedinOrderPlacement @checkout @naOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC538_AUTO-259_B: Verify the user can Place a Ship to Address Credit Card Order for mixed Order (Gift Card + Normal Products) Purchase as an Anonymous and Registered User
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I refresh the browser
    And I select Gift card amount as "40"
    And I select "pgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I select shipping address for logged-in user
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    Then BILLIng: I select saved Card and enter card Security code
     And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-259_B"
    
  @guestOrderPlacement @checkout @euOnly @exludeGlobal @excludePT @Regression_AIE @regression_set2
  Scenario: FPR_TC536_AUTO-258_A: Verify the user can Place a Ship to Address Credit Card Order for a Gift Card(s) Purchase as an Anonymous and Registered User
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I refresh the browser
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And BILLING: I fill up billing address section
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-258_A"
    
   @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @excludePT @Regression_AIE @regression_set2
   Scenario: FPR_TC536_AUTO-258_B: Verify the user can Place a Ship to Address Credit Card Order for a Gift Card(s) Purchase as an Anonymous and Registered User
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I refresh the browser
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout Securely button for loggedIn user
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required card fields for Loggedin
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-258_B"
    
   @guestOrderPlacement @checkout @naOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC536_AUTO-258_A: Verify the user can Place a Ship to Address Credit Card Order for a Gift Card(s) Purchase as an Anonymous and Registered User
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I refresh the browser
    And I select Gift card amount as "40"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I fill up billing address
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-258_A"
    
   @loggedinOrderPlacement @checkout @naOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC536_AUTO-258_B: Verify the user can Place a Ship to Address Credit Card Order for a Gift Card(s) Purchase as an Anonymous and Registered User
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I refresh the browser
    And I select Gift card amount as "40"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    Then BILLIng: I select saved Card and enter card Security code
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-258_B"

  @guestOrderPlacement @checkout @euOnly @exludeGlobal @excludePT @Regression_AIE @regression_set2
  Scenario: FPR_TC538_AUTO-260_A: Verify the user can Place a Ship to Address Credit Card Order for mixed Order (Gift Card + Normal Products) Purchase as an Anonymous and Registered User 
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-260_A"
    
  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @excludeCatchAll @Regression_AIE @regression_set2
  Scenario: FPR_TC538_AUTO-260_B: Verify the user can Place a Ship to Address Credit Card Order for mixed Order (Gift Card + Normal Products) Purchase as an Anonymous and Registered User 
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required card fields for Loggedin
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-260_B"
    
  @guestOrderPlacement @checkout @naOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC538_AUTO-260_A: Verify the user can Place a Ship to Address Credit Card Order for mixed Order (Gift Card + Normal Products) Purchase as an Anonymous and Registered User
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-260_A"
    
  @loggedinOrderPlacement @checkout @naOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC538_AUTO-260_B: Verify the user can Place a Ship to Address Credit Card Order for mixed Order (Gift Card + Normal Products) Purchase as an Anonymous and Registered User
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    Then FOOTER: I click on gift card link
    And I am on the Gift Card landing page
    And I click on purchase now button for VGC PGC product
    And I am on the product detail page
    And I select Gift card amount as "20"
    And I select "vgc" Gift Card
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I select shipping address for logged-in user
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    Then BILLIng: I select saved Card and enter card Security code
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-260_B"