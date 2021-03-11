Feature: PricingAndPromotion

   @guestOrderPlacement @pricingAndPromotion @Regression_AIE @excludeNA @lowerEnvOnly @regression_set1
   Scenario: FPR_TC219_AUTO-182: To Verify that discount amount is displayed in the shopping bag only when Order level promotion applied.
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
    And I am on the Shopping Bag page
    And I hold a "10PERCENTOFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    And I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then I verify the 10 "%OFF" promotion got applied
    And I hold a item level "ITEM10PEROFF" Promotion
    And SBP: I get the item total price
    When I apply a PromoCode on shopping bag page
    Then I verify the 10 "%OFF" item level promotion got applied
    And SBP: I verify promo message displayed at item level
    
   @guestOrderPlacement @pricingAndPromotion @Regression_AIE @naOnly @lowerEnvOnly @regression_set1
   Scenario: FPR_TC219_AUTO-182: To Verify that discount amount is displayed in the shopping bag only when Order level promotion applied.
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And MENU: I verify the shopping bag counter is updated to 1
    And PDP: I click on add to bag
    And MENU: I click on Bag link
    And I hold a "10$OFFONORDER" Promotion type
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then I verify the 10 "$OFF" promotion got applied
    And I hold a item level "ITEM10PEROFF" Promotion
    And SBP: I get the item total price
    When I apply a PromoCode on shopping bag page
    Then I verify the 10 "%OFF" item level promotion got applied
    And SBP: I verify promo message displayed at item level
    
   @guestOrderPlacement @pricingAndPromotion @Regression_AIE @excludeNA @lowerEnvOnly @regression_set1
   Scenario: FPR_TC216_AUTO-180: To Verify that user is able to add upto 5 promo codes in Promo Codes Applied section
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And I am on the Shopping Bag page
    And SBP: I click on Apply Promo Code Link
    And I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    And I hold a "10$OFFONORDER" Promotion type
    When I apply a PromoCode on shopping bag page
    And I hold a "10PERCENTOFFONORDER" Promotion type
    When I apply a PromoCode on shopping bag page
    And I hold a "15$OFFONORDER" Promotion type
    When I apply a PromoCode on shopping bag page
    And I hold a "5$OFFONORDER" Promotion type
    When I apply a PromoCode on shopping bag page
    Then I verify All the promotion got applied
    
   @guestOrderPlacement @pricingAndPromotion @Regression_AIE @naOnly @lowerEnvOnly @regression_set1
   Scenario: FPR_TC216_AUTO-180: To Verify that user is able to add upto 5 promo codes in Promo Codes Applied section
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "15PERCENTOFFONORDER" Promotion type
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    And I hold a "5PERCENTOFFONORDER" Promotion type
    When I apply a PromoCode on shopping bag page
    And I hold a "10$OFFONORDER" Promotion type
    When I apply a PromoCode on shopping bag page
    And I hold a "10PERCENTOFFONORDER" Promotion type
    When I apply a PromoCode on shopping bag page
    And I hold a "15$OFFONORDER" Promotion type
    When I apply a PromoCode on shopping bag page
    Then I verify All the promotion got applied

   @guestOrderPlacement @pricingAndPromotion @Regression_AIE @excludeNA @lowerEnvOnly @regression_set1
   Scenario: FPR_TC215_AUTO-179: To Verify that existing promotional conditions are still applicable to the order total  after updating the shopping bag
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "10PERCENTOFFONORDER" Promotion type
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And I am on the Shopping Bag page
    And SBP: I click on Apply Promo Code Link
    And I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then I verify the 10 "%OFF" promotion got applied
    And SBP: I verify Total Price Before Update the quantity
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 3
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I can verify quantity updated message
    And SBP: I can verify the number of quantity is 3
    And SBP: I click on Apply Promo Code Link
    And I verify Apply Promo Code section expanded
    Then I verify the 10 "%OFF" promotion got applied
    And SBP: I Verify Bag SubTotal price after updating product quantity 
    
   @guestOrderPlacement @pricingAndPromotion @Regression_AIE @naOnly @lowerEnvOnly @regression_set1
   Scenario: FPR_TC215_AUTO-179: To Verify that existing promotional conditions are still applicable to the order total  after updating the shopping bag
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "10$OFFONORDER" Promotion type
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I click on Apply Promo Code Link
    Then I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    And I hold a "10$OFFONORDER" Promotion type
    Then I verify the 10 "$OFF" promotion got applied
    And SBP: I verify Total Price Before Update the quantity
    And SBP: I click on Edit
    And EDIT PRODUCT: I set the quantity to 3
    And EDIT PRODUCT: I click update shopping bag
    And SBP: I can verify quantity updated message
    And SBP: I can verify the number of quantity is 3
    Then I verify the 10 "$OFF" promotion got applied
    And SBP: I Verify Bag SubTotal price after updating product quantity
    
   @guestOrderPlacement @pricingAndPromotion @excludeNA @Regression_AIE @lowerEnvOnly @regression_set1
   Scenario: FPR_TC212_AUTO-177: To Verify that user can view the Order Summary details in shopping bag page 
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "5PERCENTOFFONORDER" Promotion type
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I verify SubTotal and Total amount in Order summary detail
    And SBP: I click on Apply Promo Code Link
    And I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I verify Order Summary details after applying promotion
    
   @guestOrderPlacement @pricingAndPromotion @naOnly @Regression_AIE @lowerEnvOnly @regression_set1
   Scenario: FPR_TC212_AUTO-177: To Verify that user can view the Order Summary details in shopping bag page 
    Given I am a mk customer
    And SBP: my Shopping Bag is empty
    And I hold a "10PERCENTOFFONORDER" Promotion type
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'MK3190' into the search box and press key enter
    And I am on the search listing page
    And SLP: I click on the product name
    And I am on the product detail page
    And PDP: I click on add to bag
    And MENU: I verify the shopping bag counter is updated to 1
    And MENU: I click on Bag link
    And SBP: I verify SubTotal and Total amount in Order summary detail
    And SBP: I click on Apply Promo Code Link
    And I verify Apply Promo Code section expanded
    When I apply a PromoCode on shopping bag page
    Then SBP: I verify promotion got applied
    And SBP: I verify Order Summary details after applying promotion
