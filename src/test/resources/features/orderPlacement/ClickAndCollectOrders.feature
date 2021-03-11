Feature: ClickAndCollectOrders
	
	@guestOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC517_AUTO-239: Verify the user can Place a Click & Collect Order Order with Credit Card as an Anonymous User with Promo code, Gift Wrap Applied
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
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And CC: I select checkbox to collect item from store
    #And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And BILLING: I fill up billing address section
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-239"
    
   @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC517_AUTO-239: Verify the user can Place a Click & Collect Order Order with Credit Card as an Anonymous User with Promo code, Gift Wrap Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
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
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I fill up billing address
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-239"
    
   @guestOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC518_AUTO-240: Verify the user can Place a Click & Collect Order with Split payment (Gift Card + Credit Card) as an Anonymous User with Promo code, Gift Wrap  Applied
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
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And CC: I select checkbox to collect item from store
    #And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And BILLING: I fill up billing address section
    And I hold a "AUTO-240" gift card
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
    And ORDERCONFIRMATION: I write order number for "AUTO-240"
    
   @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC518_AUTO-240: Verify the user can Place a Click & Collect Order with Split payment (Gift Card + Credit Card) as an Anonymous User with Promo code, Gift Wrap  Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
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
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-240" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I fill up billing address
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-240"
    
   @guestOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC519_AUTO-241: Verify the user can Place a Click & Collect Order with Split payment (Gift Card + PayPal) as an Anonymous User with Promo code, Gift Wrap Applied
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
    And I am on the product detail page
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
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
    And CC: I select checkbox to collect item from store
    #And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And BILLING: I fill up billing address section
    And I hold a "AUTO-241" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
   And ORDERCONFIRMATION: I write order number for "AUTO-241"
   
   @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC519_AUTO-241: Verify the user can Place a Click & Collect Order with Split payment (Gift Card + PayPal) as an Anonymous User with Promo code, Gift Wrap Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
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
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-241" gift card
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
    And ORDERCONFIRMATION: I write order number for "AUTO-241"  
	
   @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC530_AUTO-252: Verify the user can Place a Click & Collect Order Order with Credit Card as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
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
    And I hold a "5$OFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I enter CVV
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-252"
    
   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC530_AUTO-252: Verify the user can Place a Click & Collect Order Order with Credit Card as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 1
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And CC: I select checkbox to collect item from store
    #And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I enter CVV  
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-252"
    
   @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC531_AUTO-253: Verify the user can Place a Click & Collect Order with Split payment (Gift Card + Credit Card) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
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
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-253" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And I hold a "Visa" credit card
    And BILLING: I click on card payment option
    And BILLING: Add card details if no saved card, else enter CVV
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-253"
    
   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC531_AUTO-253: Verify the user can Place a Click & Collect Order with Split payment (Gift Card + Credit Card) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 1
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    And CC: I select checkbox to collect item from store
    #And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a 'AUTO-253' gift card
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify close option displayed on the expanded gift card panel
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: Add card details if no saved card, else enter CVV
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-253"
        
   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC532_AUTO-254: Verify the user can Place a Click & Collect Order with Split payment (Gift Card + PayPal) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 1
    And I navigate to MK HomePage
    And I am interested in following mk products
      | EU_click and collect | category:EU_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'EU_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout Securely button for loggedIn user
    And I am on the Checkout page
    And CC: I select checkbox to collect item from store
    #And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-254" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-254"
    
   @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC532_AUTO-254: Verify the user can Place a Click & Collect Order with Split payment (Gift Card + PayPal) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
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
    And I am on the product detail page
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 2
    And I hold a "15PERCENTOFFONORDER" Promotion type
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-254" gift card
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
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-254"
    