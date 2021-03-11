Feature: Checkout Page Checks

  @checkout_wip @checkoutPage_wip @smoke_wip
  Scenario: AutoSmoke_041_A: Verify that the delete address/ delete payment method should not be present in shipping and billing page for a Guest User.
    Given I am a mk customer
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
    When SBP: I click on Checkout Securely button
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
    When Shipping: I click on ship to this Address button
    Then Shipping: I am on the Shipping page
    And Shipping: I verify delete address link doesn't exist on Shipping page
    And Shipping: I select the "Free" Shipping Option
    When Shipping: I click on Continue to Review and Pay button
    Then I am on Checkout page
    And Checkout: I verify delete payment link doesn't exist on Checkout page


  @checkout_wip @checkoutPage_wip @smoke_wip
  Scenario: AutoSmoke_041_B: Verify that the delete address/ delete payment method should not be present in shipping and billing page for a Logged In User.
    Given I am a logged-in mk customer
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
    When SBP: I click on Checkout Securely button
    Then Shipping: I am on the Shipping page
    And Shipping: I verify delete address link doesn't exist on Shipping page
    And Shipping: I select the "Free" Shipping Option
    When Shipping: I click on Continue to Review and Pay button
    Then I am on Checkout page
    And Checkout: I verify delete payment link doesn't exist on Checkout page


  @checkoutPage @smoke @euOnly
  Scenario: AutoSmoke_042_A : Verify that the check gift card balance option should not be present in the payment page for a Guest User
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | sunglasses | category:sunglasses |
    And MENU: I click on search link
    And SLP: I type 'sunglasses:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click Apply a Giftcard
    Then BILLING: I verify Check Gift Card Balance is not displayed


  @checkoutPage @smoke @euOnly
  Scenario: AutoSmoke_042_B : Verify that the check gift card balance option should not be present in the payment page for a Logged in user
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
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click Apply a Giftcard
    Then BILLING: I verify Check Gift Card Balance is not displayed


  @checkoutPage @smoke @euOnly
  Scenario: AutoSmoke_043: Verify that the user able to enter email address in the Shipping page for guest user.
    Given I am a mk customer
    And I hold a "Visa" credit card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I verify the Email address field is displayed


  @checkoutPage @smoke @globalOnly
  Scenario: AutoSmoke_043: Verify that the user able to enter email address in the Shipping page for guest user.
    Given I am a mk customer
    And I hold a "Visa" credit card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And BILLING: I verify the Email address field is displayed


  @checkoutPage @smoke @naOnly @Shiva
  Scenario: AutoSmoke_043: Verify that the user able to enter email address in the Shipping page for guest user.
    Given I am a mk customer
    And I hold a "Visa" credit card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And BILLING: I verify the Email address field is displayed


  @checkoutPage @smoke @euOnly
  Scenario: AutoSmoke_044_A : Verify that user able to Edit shipping and billing address from check out page as a Guest User
    Given I am a mk customer
    And I hold a "Visa" credit card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
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
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    And SHIPPING: I verify Edit Shipping Address link is displayed
    And SHIPPING: I click Continue to review and pay
    And BILLING: I verify Edit Billing Address link is displayed


  @checkoutPage @smoke @naOnly @Shiva
  Scenario: AutoSmoke_044_A : Verify that user able to Edit shipping address from check out page as a Guest User
    Given I am a mk customer
    And I hold a "Visa" credit card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And SHIPPING: I verify Edit Shipping Address link is displayed


  @checkoutPage @smoke @euOnly 
  Scenario: AutoSmoke_044_B: Verify that user able to Edit shipping and billing address from check out pages as a Logged-in User
    Given I am a logged-in mk customer
    And I hold a "Visa" credit card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I verify Edit Shipping Address link is displayed
    And SHIPPING: I click Continue to review and pay
    And BILLING: I verify Edit Billing Address link is displayed


  @checkoutPage @smoke @naOnly @Shiva
  Scenario: AutoSmoke_044_B: Verify that user able to Edit shipping and billing address from check out pages as a Logged-in User
    Given I am a logged-in mk customer
    And I hold a "Visa" credit card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I select shipping address for logged-in user
    And SHIPPING: I verify Edit Shipping Address link is displayed
    And SHIPPING: I click Continue to payment


  @checkout_wip @checkoutPage_wip @smoke_wip
  Scenario: AutoSmoke_045: Verify the functionality of "Find address" and "Ship to this address" in Shipping step.
    Given I am a mk customer
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
    When SBP: I click on Checkout Securely button
    And SBP: I click on the Checkout As Guest button
    And I am on the Shipping page
    And Shipping: I Select Country
    When Shipping: I enter "Postcode" in the Address field
    Then Shipping: I verify the list of addresses displayed for the entered postcode
    And  Shipping: I select an address from the list of addresses displayed
    And Shipping: I select make this my billing address
    And Shipping: I Select title
    And Shipping: I enter first Name
    And Shipping: I enter last Name
    And Shipping: I enter Phone number
    And Shipping: I enter Email address
    When Shipping: I click on ship to this Address button
    Then Shipping: I am on the Shipping page
    
  @smoke @euOnly
  Scenario: AutoSmoke_046: Verify that user is able to add addresses from Manual address form in shipping page.
    Given I am a mk customer
    And I hold a "Visa" credit card
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > View All Handbags"
    And I am on the product listing page
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
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
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And BILLING: I verify Billing Shipping Address is populated

  @smoke @naOnly @Shiva
  Scenario: AutoSmoke_046: Verify that user is able to add addresses from Manual address form in shipping page.
    Given I am a mk customer
    And I hold a "Visa" credit card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "HANDBAGS > View All Handbags"
    And I am on the product listing page
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And BILLING: I verify Billing Shipping Address is populated


  @checkout_wip @checkoutPage_wip @smoke_wip
  Scenario: AutoSmoke_047: Verify the saving address functionality in Shipping and billing address page.
    Given I am a logged-in mk customer
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
    When SBP: I click on Checkout Securely button
    Then Shipping: I am on the Shipping page
    And Shipping: I verify Add new shipping address link exists on the Shipping page
    When Shipping: I click on Add new shipping address link
    Then Shipping: Add a new address page is displayed
    And Shipping: I Select Country
    And Shipping: I click on Enter address manually link
    And Shipping: I Enter Address line1
    And Shipping: I Enter Address line2
    And Shipping: I enter City
    And Shipping: I enter County
    And Shipping: I enter Postcode
    And Shipping: I Select title
    And Shipping: I enter first Name
    And Shipping: I enter last Name
    And Shipping: I enter Phone number
    And Shipping: I select make this my default shipping address
    And Shipping: I opt-in for marketing
    When Shipping: I click on save button
    Then Shipping: I verify newly added address selected for shipping address
    
  @guestCheckout @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC133_AUTO-164_A: To Verify Add Note and Remove functionalities as anonymous user.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    When SBP: I click on checkout Securely button
    Then SBP: I click on checkout as guest button
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
   # When SHIPPING: I Select Gift Wrap Note
    #Then SHIPPING: I Verify AddNote Link
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I Verify RemoveNote Link
    And SHIPPING: I Remove the GiftWrap Note
    #Then SHIPPING: I Verify AddNote Link

	@loggedinOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC133_AUTO-164_B: To Verify Add Note and Remove functionalities as login user.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I am on the Shopping Bag page
    And SBP: I click on Checkout Securely button for loggedIn user
   # When SHIPPING: I Select Gift Wrap Note
   # Then SHIPPING: I Verify AddNote Link
   # When SHIPPING: I Select Gift Wrap Note
   # And SHIPPING: I Verify RemoveNote Link
   # And SHIPPING: I Remove the GiftWrap Note
   # Then SHIPPING: I Verify AddNote Link
    And I navigate to MK HomePage

   @guestCheckout @checkout @naOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC133_AUTO-164_A: To Verify Add Note and Remove functionalities as guest user.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    #Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    #And SHIPPING: I Remove the GiftWrap Note
    #Then SHIPPING: I Verify Text is Removed

  @loggedinOrderPlacement @checkout @naOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC133_AUTO-164_B: To Verify Add Note and Remove functionalities as login user.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    #And SHIPPING: I ADD Gift Wrap Note
    #Then SHIPPING: I Verify user able to enter Note and RemoveNote Link displayed
    #And SHIPPING: I Remove the GiftWrap Note
    #Then SHIPPING: I Verify Text is Removed

	@guestCheckout @checkout @Regression_AIE @euOnly @exludeGlobal @regression_set2
  Scenario: Func_Prioritized_Reg_TC_129: Verify the functionality of "YES, CONTINUE TO MK  *(Country name)" link during basket porting exception  as Anonymous user.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I want to change the country from the dropdown
    And SHIPPING: I click on YES, CONTINUE button
    And SHIPPING: I select language and click on continue
    And I accept cookie message and country change popup
    Then SBP: I verify "ORDER TO BE DELIVERED TO" [Selected Country] message is displayed
    And SBP: I verify "Click checkout securely to proceed with shipping to" [Selected Country]. "Click CANCEL to stay and ship to an address in" [former country]. message is displayed at order summary
      
  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: Func_Prioritized_Reg_TC_127_A: To verify whether add a new billing address and edit the address is displayed in Review & Pay step under billing address for a Registered User.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    When SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Continue to review and pay
    And BILLING: I verify Edit Billing Address link is displayed
    And BILLING: I Verify Add New Billing Address link is Displayed
     
  @guestCheckout @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: Func_Prioritized_Reg_TC_127_B: To verify whether add a new billing address and edit the address is displayed in Review & Pay step under billing address for a Guest User.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I verify Edit Billing Address link is displayed
    And BILLING: I Verify Add New Billing Address link is Displayed
    
  @loggedinOrderPlacement @checkout @naOnly @Regression_AIE @regression_set2
  Scenario: Func_Prioritized_Reg_TC_127_A: To verify whether add a new billing address and edit the address is displayed in Review & Pay step under billing address for a Registered User.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And BILLING: I verify Edit Billing Address link is displayed
    And BILLING: I Verify Add New Billing Address link is Displayed

  @guestCheckout @checkout @euOnly @excludeGlobal @Regression_AIE @regression_set2
  Scenario: Func_Prioritized_Reg_TC_110: Verify the display of address when user enters postal code and click on find address button
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'Mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I am on the Shopping Bag page
    When SBP: I click on checkout Securely button
    Then SBP: I click on checkout as guest button
    And SHIPPING: I am on the Shipping page
    When SHIPPING: I enter postcode in Address field
    And SHIPPING: I verify the QAS address result
    
  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: FPR_TC141_AUTO-166_A: Verify the functionality of "Apply a gift card" link in Review&Pay Step.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And I hold a "AUTO-233" gift card
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    When SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Continue to review and pay
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I click on remove gift card
    And BILLING: I verify gift card removed successfully
    
  @guestCheckout @checkout @euOnly @exludeGlobal @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: FPR_TC141_AUTO-166_B: Verify the functionality of "Apply a gift card" link in Review&Pay Step.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I hold a "AUTO-233" gift card
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
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
    And BILLING: I click on remove gift card
    And BILLING: I verify gift card removed successfully
        
  @loggedinOrderPlacement @checkout @Regression_AIE @naOnly @lowerEnvOnly @regression_set2
  Scenario: FPR_TC141_AUTO-166_A: Verify the functionality of "Apply a gift card" link in Review&Pay Step.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And I hold a "AUTO-233" gift card
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
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click Continue to payment
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I click on remove gift card
    And BILLING: I verify gift card removed successfully
    
  @guestCheckout @checkout @Regression_AIE @naOnly @lowerEnvOnly @regression_set2
  Scenario: FPR_TC141_AUTO-166_B: Verify the functionality of "Apply a gift card" link in Review&Pay Step.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "AUTO-233" gift card
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
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
    And BILLING: I click on remove gift card
    And BILLING: I verify gift card removed successfully

 @guestCheckout @checkout @Regression_AIE @euOnly @exludeGlobal @regression_set2
  Scenario: Func_Prioritized_Reg_TC_128_A: Verify the functionality of "NO, I WANT TO STAY ON MK *(Country name)" link during basket porting exception as Anonymous user.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I want to change the country from the dropdown
    Then SHIPPING: I verify No I WANT TO STAY button displayed
    And SHIPPING: I click on NO, I WANT TO STAY button
    And I am on the Checkout page

  @loggedinOrderPlacement @checkout @Regression_AIE @euOnly @exludeGlobal @regression_set2
  Scenario: Func_Prioritized_Reg_TC_128_B: Verify the functionality of "NO, I WANT TO STAY ON MK *(Country name)" link during basket porting exception as Logged-In user.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And SBP: I empty my Shopping Bag
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click add new address link
    And SHIPPING: I want to change the country from the dropdown
    Then SHIPPING: I verify No I WANT TO STAY button displayed
    And SHIPPING: I click on NO, I WANT TO STAY button
    And I am on the Checkout page
    And I navigate to MK HomePage
    And MENU: I click on Bag link

  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC140_AUTO-165_A: Verify the functionality of "Apply a gift card" link in Review&Pay Step for a Logged-In User.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    When SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Continue to review and pay
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I verify close option displayed on the expanded gift card panel
    
  @guestCheckout @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC140_AUTO-165_B: Verify the functionality of "Apply a gift card" link in Review&Pay Step for a Guest User.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
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
    And BILLING: I verify close option displayed on the expanded gift card panel
    
  @loggedinOrderPlacement @checkout @Regression_AIE @naOnly @regression_set2
  Scenario: FPR_TC140_AUTO-165_A: Verify the functionality of "Apply a gift card" link in Review&Pay Step for a Logged-In User.
    Given I am a logged-in mk customer
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
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click Continue to payment
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And BILLING: I verify close option displayed on the expanded gift card panel
    And BILLING: I click on cancel link

  @guestCheckout @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC213_AUTO-178_A: To Verify that a Guest user and Anonymous user can view the pricing details of Order in shipping page after Gift wrap is applied..
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    When SBP: I click on checkout Securely button
    Then SBP: I click on checkout as guest button
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
		And SHIPPING: I click Continue to review and pay
		Then SHIPPING: I verify the order summary pricing details
		
	@loggedinOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC213_AUTO-178_B: To Verify that a Guest user and Anonymous user can view the pricing details of Order in shipping page after Gift wrap is applied..
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I am on the Shopping Bag page
    And SBP: I click on Checkout Securely button for loggedIn user
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    Then SHIPPING: I verify the order summary pricing details

   @guestCheckout @checkout @naOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC213_AUTO-178_A: To Verify that a Guest user and Anonymous user can view the pricing details of Order in shipping page after Gift wrap is applied..
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I can see 1 product in the bag
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to payment
    Then SHIPPING: I verify the order summary pricing details

  @loggedinOrderPlacement @checkout @naOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC213_AUTO-178_B: To Verify that a Guest user and Anonymous user can view the pricing details of Order in shipping page after Gift wrap is applied..
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to payment
    Then SHIPPING: I verify the order summary pricing details

  @guestCheckout @checkout @naOnly @excludeEU @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: Func_Prioritized_Reg_TC_181: Verify that promo code is not applicable for Gift wrap amount.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to payment
    And Billing: Save giftwrap amount before applying promocode
    And BILLING: I apply promo code 'ORDER15OFF'
    And BILLING: I verified promo is applied succesfully 
    And BILLING: I verify the promo code not applied to the gift wrap amount
    
  @guestCheckout @checkout @euOnly @excludeNA @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: Func_Prioritized_Reg_TC_181: Verify that promo code is not applicable for Gift wrap amount.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    When SBP: I click on checkout Securely button
    Then SBP: I click on checkout as guest button
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Make billing address
    And SHIPPING: I click Ship to this address
    #When SHIPPING: I Select Gift Wrap Note
    And SHIPPING: I click Continue to review and pay
    And Billing: Save giftwrap amount before applying promocode
    And BILLING: I apply promo code 'AUTO5OFFORDER'
    And BILLING: I verified promo is applied succesfully
    And BILLING: I verify the promo code not applied to the gift wrap amount
      
  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC119_AUTO-173_A: Verify whether the order summary section displayed with selected shipping method and shipping address for Logged-In Users
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    When SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I Verify Selected Shipping Address
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Expend View Order Details in Order Summary
    Then BILLING: I Verify Shipping Address in Order Summary is Same as Selected Shipping Address in Shipping Page
    And BILLING: I Verify Shipping Method in Order Summary is Same as Selected Shipping Method in Shipping Page
    
   @guestCheckout @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
   Scenario: FPR_TC119_AUTO-173_B: Verify whether the order summary section displayed with selected shipping method and shipping address for Anonymous Users
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Ship to this address
    And SHIPPING: I Verify Selected Shipping Address for Guest User
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Expend View Order Details in Order Summary
    Then BILLING: I Verify Shipping Address in Order Summary is Same as Selected Shipping Address in Shipping Page
    And BILLING: I Verify Shipping Method in Order Summary is Same as Selected Shipping Method in Shipping Page

  @guestOrderPlacement @checkout @usOnly @excludeCA @excludeEU @excludeGlobal @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: FPR_TC220_AUTO-183: Verify that Employee discount amount in shopping bag or payment page on applying the employee promo code and place the order
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "Visa" credit card
    And I navigate to MK HomePage
   	And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '30S6GAPT9L' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I apply promo code 'EMP98957119960411'
    And SBP: I verified promo is applied succesfully
    And SBP: I verify max product limit for 'MK3190' in the quantity dropdown is 3 after applying Employee promo
    And SBP: I verify max product limit for '30S6GAPT9L' in the quantity dropdown is 3 after applying Employee promo
    And SBP: I verify Employee discount amount for sale item '30S6GAPT9L'
    And SBP: I verify Employee discount amount for non sale item 'MK3190'
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment 
    And BILLING: I click on card payment option
    And BILLING: I enter card details as per employee code
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    
  @guestOrderPlacement @checkout @caOnly @excludeUS @excludeEU @excludeGlobal @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: FPR_TC220_AUTO-183: Verify that Employee discount amount in shopping bag or payment page on applying the employee promo code and place the order
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "Visa" credit card
    And I navigate to MK HomePage
   	And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I apply promo code 'EMP98957119960411'
    And SBP: I verified promo is applied succesfully
    And SBP: I verify max product limit for 'MK3190' in the quantity dropdown is 3 after applying Employee promo
    And SBP: I verify Employee discount amount for non sale item 'MK3190'
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment 
    And BILLING: I click on card payment option
    And BILLING: I enter card details as per employee code
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    
   @guestOrderPlacement @checkout @euOnly @excludeGlobal @excludeNA @lowerEnvOnly @Regression_AIE @regression_set2
   Scenario: FPR_TC220_AUTO-183: Verify that Employee discount amount in shopping bag or payment page on applying the employee promo code and place the order
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "Visa" card type "3Ds" credit card
    And I navigate to MK HomePage
    And MENU: I click on search link
 		And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on search link
    And SLP: I type '30F9GZ5L6L' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I apply promo code 'EMP98957119960411'
    And SBP: I verified promo is applied succesfully
    And SBP: I verify max product limit for 'MK3190' in the quantity dropdown is 3 after applying Employee promo
    And SBP: I verify max product limit for '30F9GZ5L6L' in the quantity dropdown is 3 after applying Employee promo
    And SBP: I verify Employee discount amount for sale item 'MK3190'
    And SBP: I verify Employee discount amount for non sale item '30F9GZ5L6L'
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields with new email
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And BILLING: I click on card payment option
    And BILLING: I enter card details as per employee code
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed

   @guestCheckout @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
   Scenario: FPR_TC012_AUTO-193_A: To Verify the UI of postcode selection form displayed after selecting an address in the postcode look up form QAS for Anonymous user.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    When SHIPPING: I enter postcode in Address field
    And SHIPPING: I verify the QAS address result
    When SHIPPING: I select the Address from QAS Response
    Then SHIPPING: I verify Address details are Prepopulated as a "Guest"
    And SHIPPING: I verify the Prepopulated Postcode is same as Address Lookup as a "Guest"
    And SHIPPING: I verify Text field labels are displayed as a "Guest"
    And SHIPPING: I verify text field of profile details as a "Guest"
    And SHIPPING: I verify the Address fields max length no more than the 35 characters as a "Guest"
    
   @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
   Scenario: FPR_TC012_AUTO-193_B: To Verify the UI of postcode selection form displayed after selecting an address in the postcode look up form QAS for Registered user.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click add new address link
    When SHIPPING: I enter postcode in Address field
    And SHIPPING: I verify the QAS address result
    When SHIPPING: I select the Address from QAS Response
    Then SHIPPING: I verify Address details are Prepopulated as a "Registered"
    And SHIPPING: I verify the Prepopulated Postcode is same as Address Lookup as a "Registered"
    And SHIPPING: I verify Text field labels are displayed as a "Registered"
    And SHIPPING: I verify text field of profile details as a "Registered"
    And SHIPPING: I verify the Address fields max length no more than the 35 characters as a "Registered"

  @guestOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC137_AUTO-194_A: Verify that system reflects the delivery address in the order summary section along with a Edit shipping address link when logged-In User selects a different delivery address
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And SignUp: I enter new email address
    And SignUp: I enter confirm email address
    And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter postal Code
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I agree to the Terms and Conditions
    When SignUp: I click Register button
    Then I navigate to the profile Page
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    When SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required address field for Loggedin User
    And SHIPPING: I click Ship to this address
    And SHIPPING: I Select Shipping Address from Drop Down
    And SHIPPING: I Verify Selected Shipping Address
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Expend View Order Details in Order Summary
    And BILLING: I Verify Edit Shipping Address link is visible on Order Summary
    And BILLING: I Verify Change Shipping Method link is visible on Order Summary
    Then BILLING: I Verify Shipping Address in Order Summary is Same as Selected Shipping Address in Shipping Page
    And BILLING: I click on Edit Shipping Address link
    And SHIPPING: I input all required edit address field for Loggedin User
    And SHIPPING: I click on save after editing the address
    And SHIPPING: I Verify Selected Shipping Address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Expend View Order Details in Order Summary
    Then BILLING: I Verify Shipping Address in Order Summary is Same as Selected Shipping Address in Shipping Page
    And BILLING: I Verify Shipping Method in Order Summary is Same as Selected Shipping Method in Shipping Page
    And BILLING: I click on Change Shipping Method link and change the Shipping Option
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Expend View Order Details in Order Summary
    And BILLING: I Verify Shipping Method in Order Summary is Same as Selected Shipping Method in Shipping Page
    
  @guestCheckout @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC137_AUTO-194_B: Verify that system reflects the delivery address in the order summary section along with a Edit shipping address link when Anonymous User gives a different delivery address
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And SBP: I click Checkout as guest
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields
    And SHIPPING: I click Ship to this address
    And SHIPPING: I Verify Selected Shipping Address for Guest User
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Expend View Order Details in Order Summary
    And BILLING: I Verify Edit Shipping Address link is visible on Order Summary
    And BILLING: I Verify Change Shipping Method link is visible on Order Summary
    Then BILLING: I Verify Shipping Address in Order Summary is Same as Selected Shipping Address in Shipping Page
    And BILLING: I click on Edit Shipping Address link
    And SHIPPING: I input all required edit address field for Anonymous User
    And SHIPPING: I click on save after editing the address
    And SHIPPING: I Verify Selected Shipping Address for Guest User
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Expend View Order Details in Order Summary
    Then BILLING: I Verify Shipping Address in Order Summary is Same as Selected Shipping Address in Shipping Page
    And BILLING: I Verify Shipping Method in Order Summary is Same as Selected Shipping Method in Shipping Page
    And BILLING: I click on Change Shipping Method link and change the Shipping Option Anonymous
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I click Continue to review and pay
    And BILLING: I Expend View Order Details in Order Summary
    And BILLING: I Verify Shipping Method in Order Summary is Same as Selected Shipping Method in Shipping Page
  
   @guestOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
   Scenario: FPR_TC138_AUTO-195: Verify the system behavior when logged-In user opts to add a new delivery address from QAS dropdown by typing the part of address
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And SignUp: I enter new email address
    And SignUp: I enter confirm email address
    And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter postal Code
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I agree to the Terms and Conditions
    When SignUp: I click Register button
    Then I navigate to the profile Page
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required fields for new user
    And SHIPPING: I click Ship to this address
    And SHIPPING: I verify Edit Shipping Address link is displayed
    And SHIPPING: I click add new address link
    And SHIPPING: I verify enter address manually link displayed
    When SHIPPING: I enter address in QAS field
    Then SHIPPING: I verify the QAS address result
    When SHIPPING: I select the Address from QAS Response
    Then SHIPPING: I verify Address details are Prepopulated as a "Registered"
    And SHIPPING: I add new shipping address
    And SHIPPING: I verify Edit Shipping Address link is displayed
    And SHIPPING: I verify New shipping address added
    
  @guestOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC508_AUTO-230: Verify the user can edit the Shipping address on the Shipping page
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And SignUp: I enter new email address
    And SignUp: I enter confirm email address
    And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter postal Code
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I agree to the Terms and Conditions
    When SignUp: I click Register button
    Then I navigate to the profile Page
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    When SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Enter Address Manually link
    And SHIPPING: I input all required address field for Loggedin User
    And SHIPPING: I click Ship to this address
    And SHIPPING: I Verify Selected Shipping Address
    And SHIPPING: I verify Edit Shipping Address link is displayed    
    And SHIPPING: I click on edit shipping address link
    And SHIPPING: I input all required edit address field for Loggedin User
    And SHIPPING: I click on save after editing the address
    And SHIPPING: I Verify Selected Shipping Address
    And SHIPPING: I verify new edited shipping address is saved
    
  @guestOrderPlacement @checkout @naOnly @desktopOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC508_AUTO-230: Verify the user can edit the Shipping address on the Shipping page
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on Sign Up link
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
    And I navigate to MK HomePage
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
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And SHIPPING: I Verify Selected Shipping Address
    And BILLING: I click on Edit shipping section from Payment page
    And SHIPPING: I click on edit shipping address link
    And SHIPPING: I input all required fields for Edit Address
    And SHIPPING: I click Continue to payment
	  And SHIPPING: I Verify Selected Shipping Address
    And SHIPPING: I verify new edited shipping address is saved
    
  @guestOrderPlacement @checkout @naOnly @mobileOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC508_AUTO-230: Verify the user can edit the Shipping address on the Shipping page
     Given I am a mk customer
     And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on Sign Up link
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
    And I navigate to MK HomePage
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
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And BILLING: I click on Edit shipping section from Payment page
    And SHIPPING: I Verify Selected Shipping Address
    And SHIPPING: I click on edit shipping address link
    And SHIPPING: I input all required fields for Edit Address
    And SHIPPING: I click Continue to payment
    And BILLING: I click on Edit shipping section from Payment page
    And SHIPPING: I Verify Selected Shipping Address
    And SHIPPING: I verify new edited shipping address is saved
        
  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @regression_set2
  Scenario: FPR_TC509_AUTO-231: Verify the user can switch between shipping Options and the selected shipping option charge is added to the Order and reflected under Order Summary section
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'mk3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    When SBP: I click on Checkout Securely button for loggedIn user
    And BILLING: I change the Shipping Option to "SLOW"
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I get shipping charge from shipping option 
    And SHIPPING: I click Continue to review and pay
    Then SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected
    And BILLING: I Expend View Order Details in Order Summary
    And BILLING: I click on Change Shipping Method link
    And BILLING: I change the Shipping Option to "EXP"
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I get shipping charge from shipping option
    And SHIPPING: I click Continue to review and pay
    Then SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected
  
  @loggedinOrderPlacement @checkout @usOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC509_AUTO-231: Verify the user can switch between shipping Options and the selected shipping option charge is added to the Order and reflected under Order Summary section
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And BILLING: I change the Shipping Option to "USAG::0.0"
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I get shipping charge from shipping option
    And SHIPPING: I click Continue to payment
    Then SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected
    And BILLING: I click on Edit shipping section from Payment page
    And BILLING: I change the Shipping Option to "USA2::20.0"
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I get shipping charge from shipping option
    And SHIPPING: I click Continue to payment
    Then SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected
    
  @loggedinOrderPlacement @checkout @caOnly @Regression_AIE @regression_set2
  Scenario: FPR_TC509_AUTO-231: Verify the user can switch between shipping Options and the selected shipping option charge is added to the Order and reflected under Order Summary section
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And I am interested in following mk products
      | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    Then SLP: I verify there are at least 1 products displayed
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And BILLING: I change the Shipping Option to "CANG::0.0"
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I get shipping charge from shipping option
    And SHIPPING: I click Continue to payment
    Then SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected
    And BILLING: I click on Edit shipping section from Payment page
    And BILLING: I change the Shipping Option to "CAN2::20.0"
    And SHIPPING: I Verify Selected Shipping Option
    And SHIPPING: I get shipping charge from shipping option
    And SHIPPING: I click Continue to payment
    Then SHIPPING: I verify the shipping charge in order summary is updated according to shipping method selected
    
  @loggedinOrderPlacement @checkout @euOnly @exludeGlobal @Regression_AIE @lowerEnvOnly @regression_set2
  Scenario: FPR_TC139_AUTO-196: Verify the display and functionality when logged in user clicks on 'Manage gift cards' link in review and pay step of checkout process after applying Multiple Gift cards
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
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    When SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Continue to review and pay
    And BILLING: I verify gift card payment option is displayed
    And I hold a "AUTO-233" gift card
    And BILLING: I click Apply a Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And I hold a "AUTO-245" gift card
    And BILLING: I click Add a new Giftcard
		And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify last four digits of applied gift card is displayed for "AUTO-233" and "AUTO-245"
    And BILLING: I verify remove link displayed
    And BILLING: I verify gift card amount displayed
    And BILLING: I click on remove gift cards
    And BILLING: I verify gift card removed successfully

  @loggedinOrderPlacement @checkout @Regression_AIE @naOnly @lowerEnvOnly @regression_set2
  Scenario: FPR_TC139_AUTO-196: Verify the display and functionality when logged in user clicks on 'Manage gift cards' link in review and pay step of checkout process after applying Multiple Gift cards
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
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
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I click Continue to payment
    And BILLING: I verify gift card payment option is displayed
    And BILLING: I click Apply a Giftcard
    And I hold a "AUTO-233" gift card
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I click Apply a Giftcard
    And I hold a "AUTO-245" gift card
    And BILLING: I enter gift card number and pin
    And BILLING: I click on apply button
    And BILLING: I verify gift card applied to the cart 
    And BILLING: I close the pop up
    And BILLING: I verify last four digits of applied gift card is displayed for "AUTO-233" and "AUTO-245"
    And BILLING: I verify remove link displayed
    And BILLING: I verify gift card amount displayed
    And BILLING: I click on remove gift cards link
    And BILLING: I verify gift card removed successfully
