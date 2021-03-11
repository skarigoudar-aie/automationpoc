Feature: Site navigation via L1 menu category links

  @siteNavigation @menuChecks @siteChecks @daily @mobileOnly @smokeSuite
  Scenario Outline: Verify at least 10 products are displayed for the "<menu>" category
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"
    And MENU: I click explore link
    Then I am on the product listing page
    And PLP: I verify there are at least 10 products displayed

    Examples:
      | menu        |
      | HANDBAGS    |
      | SHOES       |

    @naOnly
    Examples:
      | menu        |
      | SALE    |


  @siteNavigation @menuChecks @siteChecks @daily @desktopOnly @smokeSuite
  Scenario Outline: Verify at least 10 products are displayed for the "<menu>" category
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"
    Then I am on the product listing page
    And PLP: I verify there are at least 10 products displayed

    Examples:
      | menu        |
      | HANDBAGS    |
      | SHOES       |

    @naOnly
    Examples:
      | menu        |
      | SALE    |


  @siteNavigation @menuChecks @categoryChecks @daily @mobileOnly @smokeSuite
  Scenario Outline: Verify clicking L1 menu "<menu>"
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"
    And MENU: I click explore link
    Then I am on the product listing page
    And PLP: I verify that promo sections are displayed

    Examples:
      | menu        |
      | WOMEN       |
      | MEN         |
      | COLLECTION  |
      | GIFTS       |


  @siteNavigation @menuChecks @categoryChecks @daily @desktopOnly @smokeSuite
  Scenario Outline: Verify clicking L1 menu "<menu>"
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"
    Then I am on the product listing page
    And PLP: I verify that promo sections are displayed

    Examples:
      | menu        |
      | WOMEN       |
      | MEN       |
      | COLLECTION  |
      | GIFTS       |


  @siteNavigation @menuChecks @categoryChecks @daily @mobileOnly @smokeSuite
  Scenario Outline: Verify clicking L1 menu "<menu>"
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"
    And MENU: I click explore link
    Then I am on the product listing page
    And PLP: I verify there are at least 10 products displayed

    Examples:
      | menu        |
      | WATCHES     |

    @siteChecks
    Examples:
      | menu        |
      | HANDBAGS    |
      | SHOES       |

    @excludeNA
    Examples:
      | menu        |
      | ACCESSORIES |

    @naOnly @siteChecks
    Examples:
      | menu       |
      | SALE        |

    @naOnly
    Examples:
      | menu       |
  #      | JEWELRY    |  //removed from Top Categories
      | WALLETS    |


  @siteNavigation @menuChecks @categoryChecks @daily @desktopOnly @smokeSuite
  Scenario Outline: Verify clicking L1 menu "<menu>"
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"
    Then I am on the product listing page
    And PLP: I verify there are at least 10 products displayed

    Examples:
      | menu        |
      | WATCHES     |

    @siteChecks
    Examples:
      | menu        |
      | HANDBAGS    |
      | SHOES       |

    @excludeNA
    Examples:
      | menu        |
      | ACCESSORIES |

    @naOnly @siteChecks
    Examples:
      | menu       |
      | SALE        |

    @naOnly
    Examples:
      | menu       |
  #      | JEWELRY    |  //removed from Top Categories
      | WALLETS    |


  @siteNavigation @menuChecks @siteChecks @mobileOnly @smokeSuite
  Scenario Outline: Verify target page of "<menu>" contains "<menu>" in url
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"
    And MENU: I click explore link
    Then I am on the product listing page
    And MENU: I verify the url contains "<menu>"

    Examples:
      | menu        |
      | WOMEN       |
      | MEN         |
      | COLLECTION  |
      | GIFTS       |
      | HANDBAGS    |
      | SHOES       |
      | WATCHES     |

    @excludeNA
    Examples:
      | menu        |
      | ACCESSORIES |

    @naOnly
    Examples:
      | menu       |
      | SALE        |
  #      | JEWELRY    |  //removed from Top Categories
      | WALLETS   |


  @siteNavigation @menuChecks @siteChecks @desktopOnly @smokeSuite
  Scenario Outline: Verify target page of "<menu>" contains "<menu>" in url
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "<menu>"
    Then I am on the product listing page
    And MENU: I verify the url contains "<menu>"

    Examples:
      | menu        |
      | WOMEN       |
      | MEN       |
      | COLLECTION  |
      | GIFTS       |
      | HANDBAGS    |
      | SHOES       |
      | WATCHES     |

    @excludeNA
    Examples:
      | menu        |
      | ACCESSORIES |

    @naOnly
    Examples:
      | menu       |
      | SALE        |
  #      | JEWELRY    |  //removed from Top Categories
      | WALLETS    |
