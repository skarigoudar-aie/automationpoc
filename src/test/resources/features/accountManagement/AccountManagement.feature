Feature: Account Management checks

  @guest @smoke @daily @dailySmoke @naOnly @buildSmoke @smokeSuite
  Scenario: AutoSmoke_010: Verify login to application through My Account link on the header
    Given I am a mk customer
    #And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And Login: I enter email address
    And Login: I enter password
    When Login: I click Sign In button
    And Login: I close zip code modal
    Then I should be successfully logged in

  @guest @smoke @daily @dailySmoke @excludeNA @buildSmoke
  Scenario: AutoSmoke_010: Verify login to application through My Account link on the header
    Given I am a mk customer
    #And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And Login: I enter email address
    And Login: I enter password
    When Login: I click Sign In button
    Then I should be successfully logged in

  @guest @smoke @daily @dailySmoke @naOnly @buildSmoke @smokeSuite @AIE
  Scenario: AutoSmoke_011: Verify a registered user can login and logout successfully
    Given I am a mk customer
    #And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And Login: I enter email address
    And Login: I enter password
    When Login: I click Sign In button
    And Login: I close zip code modal
    Then I should be successfully logged in
    When MENU: I click Sign Out link
    Then I should be successfully logged out

  @guest @smoke @daily @dailySmoke @excludeNA @buildSmoke
  Scenario: AutoSmoke_011: Verify a registered user can login and logout successfully
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And Login: I enter email address
    And Login: I enter password
    When Login: I click Sign In button
    Then I should be successfully logged in
    When MENU: I click Sign Out link
    Then I should be successfully logged out

  @guest @RegressionMK
  Scenario: Auto_100: Verify the functionality of the Forgot Password link on account creation page
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I select Sign In link
    Then Sign in flyout: I click on forgot password link
    And Forgot password: I verify forgot password page is displayed
    
  @loggedin @accounts_wip @smoke_wip
  Scenario: AutoSmoke_016: Verify that user able to add the payment to the profile
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    And Profile: I click on Payment Information link
    And Payment Info: I enter name on card
    Then Payment Info: I enter card number
    And Payment Info: I choose expiry date
    And Payment Info: I choose year
    Then Payment Info: I enter CVV code
    Then Payment Info:I click on make this my default payment method checkbox
    And Payment Info: I click on Add a new billing address link
    Then Payment Info: I click on Enter address manually
    And Payment Info: I Enter Address line1
    And Payment Info: I Enter Address line2
    And Payment Info: I enter city
    And Payment Info: I enter Country
    And Payment Info: I enter Postcode
    And Payment Info: I select the title
    And Payment Info: I add first name
    And Payment Info: I add last name
    And Payment Info: I add Phone number
    Then Payment Info: I select make this my Shipping address
    And Payment Info: I select make this my Billing address
    And Payment Info: I click on save address button
    Then Payment Info: I click on save payment button
    Then Payment Info: I verify new payment method is added

  @loggedin @accounts_wip @smoke_wip
  Scenario: AutoSmoke_017:  Verify that user is able to add Products/Articles to favorites
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And I remove all products from Favorites
    And I am interested in following mk products
      | bag | category:bag |
    And MENU: I click on search link
    And SLP: I type 'bag:styleName' into the search box and press key enter
    And SLP: I click on the product image
    And I am on the product detail page
    And PDP: I add the item to Favorites
    And MENU: I click on User Favorites link
    And I verify the product is added to Favorites

  @loggedin @accounts_wip @smoke_wip
  Scenario: AutoSmoke_018: Verify the display of preferences section display in Profile Page
    Given I am a logged-in mk customer
    And MENU: I click on User Profile link
    And Profile: I verify default language selection

  @loggedin @accounts_wip @smoke_wip
  Scenario: AutoSmoke_019: Verify the display of preferences section display in Profile Page
    Given I am a logged-in mk customer
    And MENU: I click on User Profile link
    And Profile: I select the default language
    And I place an order
    And I verify the email is in selected language

  @guest @smoke @excludeNA @smokeSuite
  Scenario: AutoSmoke_009: Verify a Guest User can Register Successfully
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
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
    Then I navigate to the profile Page
    Then MENU: I click Sign Out link

  @guest @smoke @naOnly
  Scenario: AutoSmoke_009: Verify a Guest User can Register Successfully
    Given I am a mk customer
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
    Then MENU: I click Sign Out link
    
  @guest @smoke @excludeNA
  Scenario: AutoSmoke_014: Verify that user is able to change password from profile page
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
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
    Then I navigate to the profile Page
    And Profile: I click on change password link
    And SignUp: I enter Current Password
    And SignUp: I enter New Change Password
    And SignUp: I enter Confirm Change Password
    And SignUp: I click Save Password button
    Then MENU: I click Sign Out link
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And Login: I enter new created email address
    And Login: I enter changed password
    When Login: I click Sign In button
    Then I should be successfully logged in

  @guest @smoke @naOnly
  Scenario: AutoSmoke_014: Verify that user is able to change password from profile page
    Given I am a mk customer
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
    And SignUp: I click create account button
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    And Profile: I click on change password link
    And SignUp: I enter Current Password
    And SignUp: I enter New Change Password
    And SignUp: I enter Confirm Change Password
    And SignUp: I click Save Password button
    Then MENU: I click Sign Out link
    And I navigate to MK HomePage
    And MENU: I click on Sign In link
    And Login: I enter new created email address
    And Login: I enter changed password
    When Login: I click Sign In button
    Then I verify I am successfully logged in

  @loggedin @smoke
  Scenario: AutoSmoke_013: Verify that user is able to edit the customer profile
    Given I am a logged-in mk customer
    #And I navigate to MK HomePage
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    And Profile: I click on edit link
    And Edit Profile: I modify lastname
    When Edit Profile: I click save changes
    And Edit Profile: I verify lastname updated
    And Profile: I click on edit link
    And Edit Profile: I resetback lastname
    When Edit Profile: I click save changes
    Then I navigate to the profile Page

  @guest @smoke
  Scenario: AutoSmoke_040: Verify that user is able to sign in from the cart page.
    Given I am a mk customer
    And I navigate to MK HomePage
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
    And I am on the Shopping Bag page
    And CHECKOUT MENU: I click on the My Account link
    And CHECKOUT LOGIN MODAL: I verify the checkout login modal is displayed
    And CHECKOUT LOGIN MODAL: I enter email address
    And CHECKOUT LOGIN MODAL: I enter password
    And CHECKOUT LOGIN MODAL: I click Sign In button
    Then I should be successfully logged in

  @loggedin @smoke
  Scenario: AutoSmoke_015: Verify that user able to add and edit the address to the profile
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    When Profile : I click on address book link
    Then Profile : I navigate to the Address book page
    And Address Book: I add new address
    And Address Book:I select make this my default Shipping address
    When Address Book: I click on save address button
    Then Address Book: I verify new address is saved
    And Profile Address:I click on edit shipping address
    And Address Book: I edit Address line1
    And Address Book: I edit Address line2
    And Address Book: I edit City
    And Address Book: I edit Postal code
    And Address Book: I enter Address first Name
    And Address Book: I enter Address last Name
    And Address Book: I enter Address Phone number
    When Address Book: I click on edit save address button
    Then Address Book: I verify new edited address is saved
    And Address Book:I click on delete shipping address
    And Address Book:I confirm delete shipping address
    
    @logedin @RegressionMK
    Scenario: Auto_97: Verify that user can only login with Region specific credentials
    Given I am a remote logged-in mk customer
    Then I verify the user is unable to login
    
    @loggedin @deOnly @esOnly @frOnly @itOnly @chOnly @RegressionMK
    @excludeGB
    @excludePT
    @excludeGlobal
    @excludeNA
    Scenario: Auto_101: Verify that user is able to save his preferred language 
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    And I select and submit on "CountrySpecificPreferredLanguage" language preference 
    When MENU: I click Sign Out link
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    And Profile: I verify "CountrySpecificPreferredLanguage" as language preference
    Then I select and submit on "English" language preference 
    And Profile: I verify "English" as language preference
    And MENU: I click Sign Out link
    
   @regression_set1 @accounts @euOnly @exludeGlobal @Regression_AIE
   Scenario: FPR_TC016_AUTO-155: To verify user is able to save the Debit/Credit card details
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    And I hold a "Visa" credit card
    And Profile: I click on Payment Information link
    And Payment Info: I Enter the Card Holder Name 'MkAutoTest'
    And Payment info: I Enter the Card Number
    And Payment Info: I select Card Expiration Date
    And Payment Info: I Enter Security Code
    And Payment Info: I click on Make Default Payment checkbox
    And Payment Info: I click On Save Card button
    And Payment Info: I Verify card is saved in profile 'MkAutoTest'
    And Payment Info: I Delete Saved Payment in profile
    And Payment Info: I verify card is deleted
    
   @regression_set1 @accounts @naOnly @Regression_AIE @lowerEnvOnly
   Scenario: FPR_TC016_AUTO-155: To verify user is able to save the Debit/Credit card details
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    And I hold a "Visa" credit card
    And Profile: I click on Payment Information link
    And Payment Info: I Enter the Card Holder Name 'MkAutoTest'
    And Payment info: I Enter the Card Number
    And Payment Info: I select Card Expiration Date
    And Payment Info: I click on Make Default Payment checkbox
    And Payment Info: I click On Save Card button
    And Payment Info: I Verify card is saved in profile 'MkAutoTest'
    And Payment Info: I Delete Saved Payment in profile
    And Payment Info: I verify card is deleted
    
    @regression_set1 @accounts @excludeNA @Regression_AIE
    Scenario: FPR_TC035_AUTO-156: Verify the account gets locked up after 7th unsuccessful login attempts.
    Given I am a mk customer
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
    Then MENU: I click Sign Out link
    And MENU: I click on Sign In link
    And Login: I enter new created email address
    And Login: I Verify Account locked after 7th Unsuccessful Login Attemps
    
    @regression_set1 @accounts @naOnly @Regression_AIE
    Scenario: FPR_TC035_AUTO-156: Verify the account gets locked up after 7th unsuccessful login attempts.
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on Sign Up link
    And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter new email address
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I enter postal Code 
    And SignUp: I click create account button
    When MENU: I click Sign Out link
    And MENU: I click on Sign In link
    And Login: I Verify Account locked after 7th Unsuccessful Login Attemps
    
   @regression_set1 @accounts @euOnly @excludeGlobal @lowerEnvOnly @Regression_AIE
   Scenario: FPR_TC020_AUTO-171: Verify that anonymous user is able to create an account from the Checkout page after placing an order.
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
    And SHIPPING: I input all required fields with new email
    And SHIPPING: I click Ship to this address
    And SHIPPING: I click Continue to review and pay
    And BILLING: I complete billing address section
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "3Ds" credit card
    And BILLING: I input all required fields
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    Then Order Confirmation: I Create an Account from Order Confrimation Page
    And Order Confirmation: I verify Account Creation Message Displayed on Order Confirmation Page
    And Order Confirmation: I login after account creation from Oder Confirmation
    Then I navigate to the profile Page
    
  @regression_set1 @accounts @usOnly @lowerEnvOnly @Regression_AIE
  Scenario: FPR_TC020_AUTO-171: Verify that anonymous user is able to create an account from the Checkout page after placing an order.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click menu "Handbags > View All Handbags"
    And I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    And PLP: I click a product position 1 in the product list
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
    And I hold a "Visa" credit card
    And BILLING: I input all required fields with new email
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    Then Order Confirmation: I Create an Account from Order Confrimation Page
    And Order Confirmation: I verify Account Creation Message Displayed on Order Confirmation Page
    And I navigate to MK HomePage
    And MENU: I click User Profile link
    Then I navigate to the profile Page
    
   @regression_set1 @accounts @euOnly @lowerEnvOnly @Regression_AIE
   Scenario: FPR_TC202_AUTO-170: To verify the display the order details for online orders.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'handbag' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    When SBP: I click on Checkout Securely button for loggedIn user
    And SHIPPING: I click Continue to review and pay
    And BILLING: I click on card payment option
    And I hold a "Visa" card type "non3Ds" credit card
    And BILLING: I input all required card fields for Loggedin
    And PayNow & Authenticate: I click pay now and if 3Ds page is visible authenticate with OTP as "1234"
    And I verify Order confirmation page is displayed
    And BILLING: I Expend View Order Details in Order Summary
    And Order Confirmation: I verify Shipping Address in Order Confirmation Page
    And Order Confirmation: I verify Billing Address in Order Confirmation Page
    And Order Confirmation: I verify Order Summary Prices in Order Confirmation Page
    And I navigate to MK HomePage
    And MENU: I click User Profile link
    And I navigate to the profile Page
    And Profile: I click On Order History Link
    Then Order_History: I click 1 order in the Order History Table
    Then Order Details: I verify Order Number is displayed and same as Order Confirmation page
    And Order Details: I verify Order submission date is displayed
    And Order Details: I verify Billing Address is displayed and same as Order Confirmation Page
    And Order Details: I verify Shipping Address is displayed and same as Order Confirmation Page
    And Order Details: I verify order summary container is displayed
    And Order Details: I verify subtotal is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify shipping is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify gift warp is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify discount is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify total is displayed and amount is same as Order Confirmation Page
      
  @regression_set1 @accounts @usOnly @lowerEnvOnly @Regression_AIE
  Scenario: FPR_TC202_AUTO-170: To verify the display the order details for online orders.
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
     And MENU: I click on search link
    And SLP: I type 'handbag' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And SBP: I click on Checkout
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And Order Confirmation: I verify Shipping Address in Order Confirmation Page
    And Order Confirmation: I verify Billing Address in Order Confirmation Page
    And Order Confirmation: I verify Order Summary Prices in Order Confirmation Page
    And I navigate to MK HomePage
    And MENU: I click User Profile link
    And I navigate to the profile Page
    And Profile: I click On Order History Link
    Then Order_History: I click 1 order in the Order History Table
    Then Order Details: I verify Order Number is displayed and same as Order Confirmation page
    And Order Details: I verify Order submission date is displayed
    And Order Details: I verify Billing Address is displayed and same as Order Confirmation Page
    And Order Details: I verify Shipping Address is displayed and same as Order Confirmation Page
    And Order Details: I verify order summary container is displayed
    And Order Details: I verify subtotal is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify shipping is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify gift warp is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify discount is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify tax is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify total is displayed and amount is same as Order Confirmation Page
    
  @regression_set1 @accounts @caOnly @lowerEnvOnly @Regression_AIE
  Scenario: FPR_TC202_AUTO-170: To verify the display the order details for online orders.
    Given I am a logged-in mk customer
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
    And I am on the Checkout page
    And SHIPPING: I input all required fields
    And SHIPPING: I click Continue to payment
    And BILLING: I click on card payment option
    And I hold a "Visa" credit card
    And BILLING: I input all required fields
    And BILLING: I click on Continue To Order Review button
    And Place Order: I click on Place Order button
    And Order Confirmation: I verify order confirmation page is displayed
    And Order Confirmation: I verify Shipping Address in Order Confirmation Page
    And Order Confirmation: I verify Billing Address in Order Confirmation Page
    And Order Confirmation: I verify Order Summary Prices in Order Confirmation Page
    And I navigate to MK HomePage
    And MENU: I click User Profile link
    And I navigate to the profile Page
    And Profile: I click On Order History Link
    Then Order_History: I click 1 order in the Order History Table
    Then Order Details: I verify Order Number is displayed and same as Order Confirmation page
    And Order Details: I verify Order submission date is displayed
    And Order Details: I verify Billing Address is displayed and same as Order Confirmation Page
    And Order Details: I verify Shipping Address is displayed and same as Order Confirmation Page
    And Order Details: I verify order summary container is displayed
    And Order Details: I verify subtotal is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify shipping is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify gift warp is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify discount is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify gst or hst is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify pst or qst is displayed and amount is same as Order Confirmation Page
    And Order Details: I verify total is displayed and amount is same as Order Confirmation Page
    
   @regression_set1 @accounts @lowerEnvOnly @Regression_AIE
   Scenario: FPR_TC550_AUTO-272: Verify the Order History page content display.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    And MENU: I click User Profile link
    And I navigate to the profile Page
    And Profile: I click On Order History Link
    Then Order History: I verify order history title is displayed
    Then Order History: I verify order submission date, order number, order status, store and order total is displayed
    
   @regression_set1 @accounts @Regression_AIE @naOnly
   Scenario: FPR_TC548_AUTO-270: Verify the User can Add to Bag and Add All to Bag (multiple favorites)  under Favourites section of the Profile page
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    And Profile: I click on 'wishlist' link
    And Profile: I empty my wishlist
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'watch' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on Add to Wishlist or Favorites link
    And MENU: I click on search link
    And SLP: I type 'pant' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I select size position 1
    And PDP: I click on Add to Wishlist or Favorites link
    And MENU: I click User Profile link
    And Profile: I add a product position 1 in the Wishlist or Favorites to bag
    And SBP: I can see 1 product in the bag
    And Profile: I save the wishlist products count
    And Profile: I click on Add all to Bag button
    And Profile: I verfiy all wishlist products added to cart from profile
    And Profile: I click on 'wishlist' link
    And Profile: I save the count of wishlist products in profile page
    And Wishlist: I verify wishlist page displaying all wishlist items saved
    
  @regression_set1 @accounts @Regression_AIE @excludeNA
  Scenario: FPR_TC548_AUTO-270: Verify the User can Add to Bag and Add All to Bag (multiple favorites)  under Favourites section of the Profile page
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    And Profile: I click on 'favorites' link
    And Profile: I empty my favorites
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'Handbags' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on Add to Wishlist or Favorites link
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on Add to Wishlist or Favorites link
    And MENU: I click User Profile link
    And Profile: I add a product position 1 in the Wishlist or Favorites to bag
    And SBP: I can see 1 product in the bag
    And Profile: I save the favorites products count
    And Profile: I click on Add all to Bag button
    And Profile: I verfiy all favorites products added to cart from profile
    And Profile: I click on view all link
    And Favorites: I verify favourites page displaying all Favorite items saved

  @regression_set1 @accounts @Regression_AIE @naOnly
  Scenario: FPR_TC549_AUTO-271: Verify the User can Add to Bag  Add All to Bag (multiple favorites) Edit, Remove  Favourites under Favourites Page
    Given I am a logged-in mk customer
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    And Profile: I click on 'wishlist' link
    And Profile: I empty my wishlist
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MU68W804NC' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I select size position 1
    And PDP: I click on Add to Wishlist or Favorites link
    When MENU: I click User Profile link
    And Profile: I click on 'wishlist' link
    And Wishlist: I edit product color or size and validate changes in wishlist page
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on Add to Wishlist or Favorites link
    And MENU: I click User Profile link
    And Profile: I click on 'wishlist' link
    And Profile: I add a product position 1 in the Wishlist or Favorites to bag
    And SBP: I can see 1 product in the bag
    And Profile: I save the wishlist products count
    And Profile: I click on Add all to Bag button
    And Profile: I verfiy all wishlist products added to cart from profile
    And Wishlist: I remove product positioned 1 in wishlist and verify wishlist count
   
  @regression_set1 @accounts @Regression_AIE @excludeNA
  Scenario: FPR_TC549_AUTO-271: Verify the User can Add to Bag  Add All to Bag (multiple favorites) Edit, Remove  Favourites under Favourites Page
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    And SBP: my Shopping Bag is empty
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    And Profile: I click on 'favorites' link
    And Profile: I empty my favorites
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I click on Add to Wishlist or Favorites link
    And MENU: I click on search link
    And SLP: I type '43S5IRFS2L' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And PDP: I select size position 1
    And PDP: I click on Add to Wishlist or Favorites link
    And MENU: I click User Profile link
    And Profile: I click on 'favorites' link
    And Profile: I add a product position 1 in the Wishlist or Favorites to bag
    And SBP: I can see 1 product in the bag
    And Profile: I save the favorites products count
    And Profile: I click on Add all to Bag button
    And Profile: I verfiy all favorites products added to cart from profile
    And Favorites: I remove product positioned 1 in favorites and verify favorites count
    #And Profile: I empty my favorites
    #And MENU: I click on search link
    #And SLP: I type '43S5IRFS2L' into the search box and press key enter
    #And I am on the search listing page
    #And SLP: I click on the product name
    #And PDP: I select size position 1
    #And PDP: I click on Add to Wishlist or Favorites link
    #When MENU: I click User Profile link
    #And Profile: I click on 'favorites' link
    #And Wishlist: I edit product color or size and validate changes in favorites page
    
   @regression_set1 @accounts @excludeGlobal @Regression_AIE
   Scenario: FPR_TC545_AUTO-267: Verify the My Account Page content for a Registered Use
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    And Profile: I verify User name in LHS
    When Profile: I click on Payment Information link
    Then I navigate to the Payment information page
    When Profile : I click on address book link
    Then Profile : I navigate to the Address book page
    When Profile: I click on Order History link
    Then I navigate to the Order history page
    And Profile: I click on Favorites Link
    Then I navigate to the Favorite page
    When Profile: I click on Profile link
    Then Profile: I am on Profile Page
    When Profile: I click on breadCrumb link
    Then I am on Homepage
    
   @regression_set1 @accounts @globalOnly @Regression_AIE
   Scenario: FPR_TC545_AUTO-267: Verify the My Account Page content for a Registered Use
    Given I am a logged-in mk customer
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    And Profile: I verify User name in LHS
    When Profile : I click on address book link
    Then Profile : I navigate to the Address book page
    When Profile: I click on Order History link
    Then I navigate to the Order history page
    When Profile: I click on Favorites Link
    Then I navigate to the Favorite page
    When Profile: I click on Profile link
    Then Profile: I am on Profile Page
    When Profile: I click on breadCrumb link
    Then I am on Homepage
    
   @regression_set1 @accounts @Regression_AIE
   Scenario: FPR_TC547_AUTO-269: Verify the User can Edit and Add new shipping address under ADDRESS BOOK section of the Profile page
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    And Profile: I click on Add New default shipping address
    And Address Book: I add new address
    And Address Book:I select make this my default Shipping address
    When Address Book: I click on save address button
    Then Address Book: I verify new address is saved
    When Profile: I click on Profile link
    Then I navigate to the profile Page
    And Profile: I click on Edit default shipping address
    And Address Book: I edit Address line1
    And Address Book: I edit Address line2
    And Address Book: I edit City
    And Address Book: I edit Postal code
    When Address Book: I click on edit save address button
    Then Address Book: I verify new edited address is saved
    When Profile: I click on Profile link
    Then I navigate to the profile Page
    And Profile: I click on ViewAll shipping address link
    And Address book: I verify all saved address displayed
    And Address Book:I click on delete shipping address
    And Address Book:I confirm delete shipping address
    
   @accounts @euOnly @excludeGlobal @Regression_AIE @regression_set1
   Scenario: FPR_TC546_AUTO-268: Verify the User can Edit and Add new billing address under PAYMENT INFORMATION section of the Profile page
    Given I am a mk customer
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
    And Profile: I click on Add New Billing address under Payment Information section
    And I hold a "Visa" credit card
    And Address Book: I add new address
    And Payment Info: I click On Save Card button
    And Payment Info: I Enter the Card Holder Name 'MkAutoTest'
    And Payment info: I Enter the Card Number
    And Payment Info: I select Card Expiration Date
    And Payment Info: I Enter Security Code
    And Payment Info: I click on Make Default Payment checkbox
    And Payment Info: I click On Save Card button
    And Payment Info: I Verify card is saved in profile 'MkAutoTest'
    And Payment Info: I verify new billing address is saved
    When Profile: I click on Profile link
    Then I navigate to the profile Page
    And Profile: I click on Edit Billing address under Payment Information section
    And Address Book: I edit Address line1
    And Address Book: I edit Address line2
    And Address Book: I edit City
    And Address Book: I edit Postal code
    When Address Book: I click on edit save address button
    Then Address Book: I verify new edited address is saved
   
   @accounts @naOnly @lowerEnvOnly @Regression_AIE @regression_set1
   Scenario: FPR_TC546_AUTO-268: Verify the User can Edit and Add new billing address under PAYMENT INFORMATION section of the Profile page
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on Sign Up link
    And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter new email address
    And SignUp: I enter New Password
    And SignUp: I enter Confirm Password
    And SignUp: I enter postal Code 
    And SignUp: I click create account button
    When MENU: I click User Profile link
    Then I navigate to the profile Page
    And Profile: I click on Add New Billing address under Payment Information section
    And I hold a "Visa" credit card
    And Payment Info: I Enter the Card Holder Name 'MkAutoTest'
    And Payment info: I Enter the Card Number
    And Payment Info: I select Card Expiration Date
    And Payment Info: I click on Make Default Payment checkbox
    And Address Book: I add new address
    And Payment Info: I click On Save Card button
    And Payment Info: I verify new billing address is saved
    When Profile: I click on Profile link
    Then I navigate to the profile Page
    And Profile: I click on Edit Billing address under Payment Information section
    And Address Book: I edit Address line1
    And Address Book: I edit Address line2
    And Address Book: I edit City
    And Address Book: I edit Postal code
    When Address Book: I click on edit save address button
    Then Address Book: I verify new edited address is saved

    
  @testRun
  Scenario: FPR_TC546_AUTO-Demo: Sign in to application
  Given Go to Mk Home page
    And click on Signin link
    And Enter username 'test99@gmail.com'
    And Enter password "test@123"
    And click on Signin button
    #Then user navigate to profile page
    
    
   @firstScript_Low_TC007
  Scenario:  To Verify that system restricts user to register if the user data is already exist in epicor and displays the proper error message.
    Given Go to Mk Home page
    And click on Signin link
    And Enter email address 'test99@gmail.com'
    And Enter confirm email address 'test99@gmail.com'
    And Enter firstname 'John'
    And Enter lastname 'Smith'
    And Enter password 'test@321'
    And Enter confirm password 'test@321'
    And click on terms and condition
    When click on register button
    Then verify email address already exist error message
   
    
    
    
    