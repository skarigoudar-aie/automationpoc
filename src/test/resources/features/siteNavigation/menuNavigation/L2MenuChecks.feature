Feature: Site navigation via L2 menu category links

  @siteNavigation @menuChecks @smoke @daily @dailySmoke @desktopOnly @buildSmoke
  Scenario: AutoSmoke_025_A: Verify a guest user clicking a random L2 menu and navigate to product detail page
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click a random category in L2 menu
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    When PLP: I click a random product in the product list
    Then I am on the product detail page

  @siteNavigation @menuChecks @smoke @daily @dailySmoke @mobileOnly @buildSmoke
  Scenario: AutoSmoke_025_A: Verify a guest user clicking a random L2 menu and navigate to product detail page
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click a random menu from following category
      | Handbags > View All Handbags       |
      | Shoes > View All Shoes       |
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    When PLP: I click a random product in the product list
    Then I am on the product detail page

  @siteNavigation @menuChecks @smoke @daily @dailySmoke @desktopOnly @buildSmoke
  Scenario: AutoSmoke_025_B: Verify a logged-in user clicking a random L2 menu and navigate to product detail page
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click a random category in L2 menu
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    When PLP: I click a random product in the product list
    Then I am on the product detail page

  @siteNavigation @menuChecks @smoke @daily @dailySmoke @mobileOnly @buildSmoke
  Scenario: AutoSmoke_025_B: Verify a logged-in user clicking a random L2 menu and navigate to product detail page
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I click a random menu from following category
      | Handbags > View All Handbags       |
      | Shoes > View All Shoes       |
    Then I am on the product listing page
    And PLP: I verify there are at least 1 products displayed
    When PLP: I click a random product in the product list
    Then I am on the product detail page


  @siteNavigation @menuChecks @regression @desktopOnly @smokeSuite
  Scenario Outline: Verify clicking L2 menu "<menu>"
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"    
    And I am on the product listing page
    And PLP: I verify there are at least 10 products displayed

    Examples:
      | menu                            |
      | WOMEN > Clothing                |
      | WOMEN > Handbags                |
      | WOMEN > Wallets                 |
      | WOMEN > Shoes                   |
      | WOMEN > Watches                 |
      | WOMEN > Accessories             |
      | WOMEN > Michael Kors Collection |

    @excludeNA
    Examples:
      | menu                            |
      | WOMEN > Jewellery               |
      | WOMEN > View All Womens         |

    @naOnly
    Examples:
      | menu                            |
      | WOMEN > Jewelry                 |
      | WOMEN > Sale                    |
  
  
  @siteNavigation @menuChecks @regression @mobileOnly @smokeSuite
  Scenario Outline: Verify clicking L2 menu "<menu>"
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"    
    And I am on the product listing page
    And PLP: I verify there are at least 10 products displayed

    Examples:
      | menu                            |
      #| WOMEN > Clothing > All Clothing |
      | WOMEN > Handbags > All Handbags |
      | WOMEN > Wallets > All Wallets   |
      #| WOMEN > Shoes  > All Shoes      |
      #| WOMEN > Watches > All watches   |
      #| WOMEN > Accessories > All Accessories|
      | WOMEN > Michael Kors Collection |

    @excludeNA
    Examples:
      | menu                            |
      | WOMEN > Jewellery							  |
      | WOMEN > View All Womens         |

    @naOnly
    Examples:
      | menu                            |
      #| WOMEN > Jewelry > All Jewelry   |
      | WOMEN > Sale                    |
      