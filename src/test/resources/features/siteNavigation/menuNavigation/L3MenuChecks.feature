Feature: Site navigation via L3 menu category links

	@siteNavigation @menuChecks @smoke @daily @dailySmoke @desktopOnly @buildSmoke
	Scenario: Verify clicking a random L3 menu and navigate to product detail page
		Given I am a mk customer
		And I navigate to MK HomePage
		When MENU: I click a random category in L3 menu
		Then I am on the product listing page
		And PLP: I verify there are at least 1 products displayed
		When PLP: I click a random product in the product list
		Then I am on the product detail page

	@siteNavigation @menuChecks @smoke @daily @dailySmoke @mobileOnly @buildSmoke
	Scenario: Verify clicking a random L3 menu and navigate to product detail page
		Given I am a mk customer
		And I navigate to MK HomePage
		When MENU: I click a random menu from following category
			| Women > Clothing > Dresses       |
			| Women > Handbags > Totes         |
			| Men   > Bags     > Briefcases    |
			| Watches > Women > Rose Gold-Tone |
		Then I am on the product listing page
		And PLP: I verify there are at least 2 products displayed
		When PLP: I click a random product in the product list
		Then I am on the product detail page


	@siteNavigation @menuChecks @categoryChecks @daily @smokeSuite
	Scenario Outline: Verify clicking L2 menu "<menu>"
		Given I am a mk customer
		And I navigate to MK HomePage
		When MENU: I click menu "<menu>"
		Then I am on the product listing page
		And PLP: I verify there are at least 1 products displayed

		Examples:
			| menu                          |
			#| WOMEN > Clothing > All Clothing |
			| WOMEN > Clothing > Dresses |
			#| WOMEN > Clothing > Jackets & Outerwear |
			#| WOMEN > Clothing > Tops |
			#| WOMEN > Handbags > All Handbags |
			#| WOMEN > Handbags > Crossbody Bags |
			#| WOMEN > Handbags > Totes |
			| WOMEN > Handbags > Shoulder Bags |
			#| WOMEN > Wallets > All Wallets |
			| WOMEN > Wallets > Slim & Trifold |
			#| WOMEN > Wallets > Card Cases & Coin Purses |
			#| WOMEN > Shoes > All Shoes |
			#| WOMEN > Shoes > Ankle Boots |
			| WOMEN > Shoes > Boots |
			#| WOMEN > Watches > All Watches |
			#| WOMEN > Watches > Rose Gold-Tone |
			#| WOMEN > Watches > Gold-Tone |
			#| WOMEN > Watches > Silver-Tone |
			#| WOMEN > Accessories > All Accessories |
			| WOMEN > Accessories > Sunglasses |
			#| WOMEN > Accessories > Fragrance |
			#| WOMEN > Accessories > Hats, Gloves & Scarves |

		@excludeNA
		Examples:
			| menu                          |
			| WOMEN > Handbags > Mini Bags |
			| WOMEN > Wallets > Continental |
			| WOMEN > Shoes > Trainers |
			| WOMEN > Shoes > Heels |
			| WOMEN > Watches > Leather |
			| WOMEN > Jewellery > View All |
			| WOMEN > Jewellery > Rings |
			| WOMEN > Accessories > Wallets |
			| WOMEN > Clothing > Sweaters |
			

		@naOnly
		Examples:
			| menu                          |
			#| WOMEN > Wallets > Wristlets & Convertible|
			| WOMEN > Shoes > Sneakers|
			| WOMEN > Watches > Smartwatches |
			#| WOMEN > Jewelry > View All |
			#| WOMEN > Jewelry > Necklaces |
			#| WOMEN > Jewelry > Bracelets |
			#| WOMEN > Jewelry > Earrings |
			#| WOMEN > Jewelry > Birthstones |
			#| WOMEN > Accessories > Phone Cases & Covers |

