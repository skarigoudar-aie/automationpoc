Feature: Example Search for a multiple product 
				
	@example
	Scenario: check product name 1
		Given I am a logged-in mk customer
		And SBP: my Shopping Bag is empty
		And I navigate to MK HomePage
		And I am interested in following mk products
			| bag  | category:bag        |
			| spec | category:sunglasses |
		And MENU: I click on search link
		And SLP: I type 'bag:styleName' into the search box and press key enter
		Then SLP: the product name displayed should match product "bag"
		And SLP: I type 'spec:styleName' into the search box and press key enter
		Then SLP: the product name displayed should match product "spec"

	@example
	Scenario: check product name 1
		Given I am a logged-in mk customer
		And SBP: my Shopping Bag is empty
		And I navigate to MK HomePage
		And I am interested in following mk products
			| shoes | category:bag |
		And MENU: I click on search link
		And SLP: I type 'shoes:styleName' into the search box and press key enter
		Then SLP: the product name displayed should match product "shoes"

	@example
	Scenario: check product name 2
		Given I am a mk customer
		And I am interested in following mk products
			| product | category:sunglasses |
		And I navigate to MK HomePage
		And MENU: I click on search link
		And SLP: I type 'product:styleName' into the search box and press key enter
		Then SLP: the product name displayed should match product "product"