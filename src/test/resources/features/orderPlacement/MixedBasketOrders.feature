Feature: MixedBasketOrders.feature

   @guestOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC520_AUTO-242: Verify the user can Place a Mixed Order (Ship to Address + Click & Collect) with Credit Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
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
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
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
    And SHIPPING: I click on continue button for click & collect
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-242"
    
   @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC520_AUTO-242: Verify the user can Place a Mixed Order (Ship to Address + Click & Collect) with Credit Card as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I am interested in following mk products
      | NA_click and collect | category:NA_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'NA_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "L" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
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
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-242"
    
   @guestOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC521_AUTO-243_A: Verify the user can Place a  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Credit Card) as an Anonymous User and Registered User with Promo code, Gift Wrap and Gift Note Applied
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
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
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
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click on continue button for click & collect
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-243_A" gift card
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
    And ORDERCONFIRMATION: I write order number for "AUTO-243_A"
    
   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC521_AUTO-243_B: Verify the user can Place a  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Credit Card) as an Anonymous User and Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
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
      | watch | category:watch |
    And HomePage: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
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
    And SBP: I click on Checkout Securely button for loggedIn user
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click on continue button for click & collect as a logged-in user
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-243_B" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields for New card
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-243_B"
    
   @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: Scenario: FPR_TC521_AUTO-243_A: Verify the user can Place a  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Credit Card) as an Anonymous User and Registered User with Promo code, Gift Wrap and Gift Note Applied
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
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
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
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-243_A" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-243_A"
    
   @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: Scenario: FPR_TC521_AUTO-243_B: Verify the user can Place a  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Credit Card) as an Anonymous User and Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
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
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
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
    And SHIPPING: I select shipping address for logged-in user
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-243_B" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    Then BILLIng: I select saved Card and enter card Security code
    And BILLING: I fill up billing address
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-243_B"

   @guestOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC522_AUTO-244: Verify the Order details of a  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Credit Card) as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied are reflecting in Order Confirmation page
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
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
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
    And SHIPPING: I click on continue button for click & collect
    And CC: I select checkbox to collect item from store
    #And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-244" gift card
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
    And Order Confirmation: I verify Your header has been placed header message
    And Order Confirmation: I verify Thank you for shipping with Michael kors message
    And Order Confirmation: I verify Create an account container is displayed
    And Order Confirmation: I verify password, confirm password, and create account button is displayed
    And BILLING: I Expend View Order Details in Order Summary 
    And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for SHIP to home product
    And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for click and collect product  
    And Order Confirmation: I verify Shipping Address in Order Confirmation Page
    And Order Confirmation: I verify Shipping Method in Order Confirmation Page
    And Order Confirmation: I verify estimated delivery date in Order Confirmation Page
    And Order Confirmation: I verify Billing Address in Order Confirmation Page
    And Order Confirmation: I verify Payment Method in Order Confirmation Page
    And Order Confirmation: I verify Order Summary Prices in Order Confirmation Page
    And ORDERCONFIRMATION: I write order number for "AUTO-244"
    
   @guestOrderPlacement @checkout @usOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC522_AUTO-244: Verify the Order details of a  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Credit Card) as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied are reflecting in Order Confirmation page
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
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
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
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-244" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
		And Order Confirmation: I verify order confirmation message for NA
		And Order Confirmation: I verify password, confirm password and JOINkORSVIP button is displayed
		And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for SHIP to home product
    And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for click and collect product	
    And Order Confirmation: I verify Shipping Address in Order Confirmation Page
    And Order Confirmation: I verify Selected Store in Order Confirmation Page for NA
    And Order Confirmation: I verify Shipping Method in Order Confirmation Page for NA
    And Order Confirmation: I verify Billing Address in Order Confirmation Page
    And Order Confirmation: I verify Payment Method in Order Confirmation Page
    And Order Confirmation: I verify Order Summary Prices in Order Confirmation Page
    And ORDERCONFIRMATION: I write order number for "AUTO-244"
    
   @guestOrderPlacement @checkout @caOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC522_AUTO-244: Verify the Order details of a  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Credit Card) as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied are reflecting in Order Confirmation page
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
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
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
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-244" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
		And Order Confirmation: I verify order confirmation message for NA
		And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for SHIP to home product
    And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for click and collect product	
    And Order Confirmation: I verify Shipping Address in Order Confirmation Page
    And Order Confirmation: I verify Selected Store in Order Confirmation Page for NA
    And Order Confirmation: I verify Shipping Method in Order Confirmation Page for NA
    And Order Confirmation: I verify Billing Address in Order Confirmation Page
    And Order Confirmation: I verify Payment Method in Order Confirmation Page
    And Order Confirmation: I verify Order Summary Prices in Order Confirmation Page
    And ORDERCONFIRMATION: I write order number for "AUTO-244"
    
   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC523_AUTO-245: Verify the Order details of a Mixed Order with Split Payment (Gift Card + Credit Card) as a Registered User with Promo code, Gift Wrap and Gift Note Applied are reflecting in Order Confirmation page
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
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
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    When SBP: I click on Checkout Securely button for loggedIn user
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-245" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
	  And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required card fields for Loggedin
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And Order Confirmation: I verify Your header has been placed header message
    And Order Confirmation: I verify Thank you for shipping with Michael kors message
    And BILLING: I Expend View Order Details in Order Summary 
    And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for SHIP to home product
    And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for click and collect product  
    And Order Confirmation: I verify Shipping Address in Order Confirmation Page
    And Order Confirmation: I verify Shipping Method in Order Confirmation Page
    And Order Confirmation: I verify estimated delivery date in Order Confirmation Page
    And Order Confirmation: I verify Billing Address in Order Confirmation Page
    And Order Confirmation: I verify Payment Method in Order Confirmation Page
    And Order Confirmation: I verify Order Summary Prices in Order Confirmation Page
    And ORDERCONFIRMATION: I write order number for "AUTO-245"
    
   @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC523_AUTO-245: Verify the Order details of a Mixed Order with Split Payment (Gift Card + Credit Card) as a Registered User with Promo code, Gift Wrap and Gift Note Applied are reflecting in Order Confirmation page
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
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
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
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
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-245" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
		And Order Confirmation: I verify order confirmation message for NA
		And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for SHIP to home product
    And Order Confirmation: I verify product image, product title, store style, color, size, quantity and price was and now for click and collect product	
    And Order Confirmation: I verify Shipping Address in Order Confirmation Page
    And Order Confirmation: I verify Selected Store in Order Confirmation Page for NA
    And Order Confirmation: I verify Shipping Method in Order Confirmation Page for NA
    And Order Confirmation: I verify Billing Address in Order Confirmation Page
    And Order Confirmation: I verify Payment Method in Order Confirmation Page
    And Order Confirmation: I verify Order Summary Prices in Order Confirmation Page
    And ORDERCONFIRMATION: I write order number for "AUTO-245"

  @guestOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC524_AUTO-246_A: Verify the user can Place a Ship to Address  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + PayPal) as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'Mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And I am interested in following mk products
      | NA_click and collect | category:NA_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'NA_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I Select color 'black'
    Then PDP: I select "10" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And I hold a "15PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    And SBP: I verified promo is applied succesfully
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a "AUTO-246_A" gift card
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
    Then BILLING: I fill up email address field
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-246_A"

  @guestOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC524_AUTO-246_A: Verify the user can Place a Ship to Address  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + PayPal) as an Anonymous User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
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
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    And I verify Promotion is applied in shopping bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click continue guest CIS button
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-246_A" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-246_A"

  @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC524_AUTO-246_B: Verify the user can Place a Ship to Address  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + PayPal) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'Mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And I am interested in following mk products
      | NA_click and collect | category:NA_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'NA_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I Select color 'black'
    Then PDP: I select "10" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 2
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
    And I hold a "AUTO-246_B" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I close the pop up
    And BILLING: I verify gift card applied to the cart
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    And BILLING: I click on continue with paypal button
    And PAYMENT: I click on Pay Now button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-246_B"

  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC524_AUTO-246_B: Verify the user can Place a Ship to Address  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + PayPal) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
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
    And MENU: I verify the shopping bag counter is updated to 2
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
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-246_B" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
        And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    And PAYMENT: I click on Pay Now button
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-246_B"

   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC528_AUTO-250: Verify the user can Place a Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Credit Card) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
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
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    When SBP: I click on Checkout Securely button for loggedIn user
    And I am on the Checkout page
    And SHIPPING: I complete shipping section
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-250" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "non3Ds" credit card
    And BILLING: I input all required card fields for Loggedin
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-250"
    
   @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC528_AUTO-250: Verify the user can Place a Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Credit Card) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
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
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
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
    And I hold a "AUTO-250" gift card
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-250"

  @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC529_AUTO-251: Verify the user can Place a Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + PayPal) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'Mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
		And I am interested in following mk products
      | NA_click and collect | category:NA_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'NA_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I Select color 'black'
    Then PDP: I select "10" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 2
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
    And I hold a "AUTO-251" gift card
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
    And ORDERCONFIRMATION: I write order number for "AUTO-251"
      
  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC529_AUTO-251: Verify the user can Place a Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + PayPal) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
		Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
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
    And MENU: I verify the shopping bag counter is updated to 2
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
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "AUTO-251" gift card to place order
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And I hold a "Paypal" Payment type
    And BILLING: I select paypal payment option
    Then PAYMENT: I enter paypal Required details
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-251"

   @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC533_AUTO-255: Verify the user can Place a  Mixed Order (Ship to Address + Click & Collect) with Saved Credit Card as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And Profile: I click on 'payment-information' link
    And Payment Info: I add card if not available
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type '40F1MFMP2S' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I Select color 'black'
    Then PDP: I select "10" size of the product
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And I am interested in following mk products
      | NA_click and collect | category:NA_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'NA_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "10" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I apply promo code 'ORDER15OFF'
    And SBP: I verified promo is applied succesfully
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
    And ORDERCONFIRMATION: I write order number for "AUTO-255"
    
   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC533_AUTO-255: Verify the user can Place a Click & Collect Order Order with Credit Card as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And Profile: I click on 'payment-information' link
    And Payment Info: I add card if not available
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
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
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I apply promo code 'AUTO5OFFORDER'
    And I verify Promotion is applied in shopping bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I enter CVV  
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-255"

   @loggedinOrderPlacement @checkout @naOnly @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC534_AUTO-256: Verify the user can Place a Ship to Address  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Saved Credit Card) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And Profile: I click on 'payment-information' link
    And Payment Info: I add card if not available
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And HomePage: I click on search link
    And SLP: I type '40F1MFMP2S' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I Select color 'black'
    Then PDP: I select "10" size of the product
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And I am interested in following mk products
      | click and collect | category:NA_click and collect |
    And HomePage: I click on search link
    And SLP: I type 'NA_click and collect:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    Then PDP: I select "10" size of the product
    And PDP: I click on click and collect
    And CC: I enter city and click find store
    And CC: I click on Add to Bag & Collect from the first available store
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I apply promo code 'ORDER15OFF'
    And SBP: I verified promo is applied succesfully
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    And SHIPPING: I click Continue to payment
    And I hold a 'AUTO-256' gift card
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify close option displayed on the expanded gift card panel
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I enter CVV
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-256"
    
   @loggedinOrderPlacement @checkout @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC534_AUTO-256: Verify the user can Place a Ship to Address  Mixed Order (Ship to Address + Click & Collect) with Split Payment (Gift Card + Saved Credit Card) as an Registered User with Promo code, Gift Wrap and Gift Note Applied
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And Profile: I click on 'payment-information' link
    And Payment Info: I add card if not available
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
    And MENU: I verify the shopping bag counter is updated to 2
    And MENU: I click on Bag link
    And SBP: I apply promo code 'AUTO5OFFORDER'
    And I verify Promotion is applied in shopping bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    And SHIPPING: I click on continue button for click & collect for Loggedin
    And CC: I select checkbox to collect item from store
    And CC: I apply click and collect Gift Wrap
    And SHIPPING: I click Continue to review and pay
    And I hold a 'AUTO-256' gift card
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify close option displayed on the expanded gift card panel
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I enter CVV  
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And ORDERCONFIRMATION: I write order number for "AUTO-256"
    