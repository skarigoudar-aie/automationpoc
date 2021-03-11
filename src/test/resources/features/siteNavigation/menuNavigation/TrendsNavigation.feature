Feature: Site navigation via Trends menu category links

 @siteNavigation @menuChecks @siteChecks @daily @smokeSuite
 Scenario Outline: Verify at least 1 products is displayed for each trend '<menu>' page
  Given I am a mk customer
  And I navigate to MK HomePage
  When MENU: I click trends "<menu>"
  Then I am on the product listing page
  And PLP: I verify there are at least 1 products displayed

  @excludeNA
  Examples:
   | menu |
   | HANDBAGS > Mother's Day Gifts |
   | HANDBAGS > New Arrivals |
   | HANDBAGS > Best Sellers |
   | HANDBAGS > The Logo Shop |
   | HANDBAGS > The Monogram Shop |
   | HANDBAGS > Staple Styles |

  @usOnly
  Examples:
   | menu |
   #| HANDBAGS > Best Sellers |
   | HANDBAGS > New Arrivals |
   | HANDBAGS > The Signature Logo Shop |
   | HANDBAGS > The Monogram Shop |

  @caOnly
  Examples:
   | menu |
   | HANDBAGS > New Arrivals |
   | HANDBAGS > The Signature Logo Shop |
   | HANDBAGS > The Monogram Shop |


 @siteNavigation @menuChecks @siteChecks @daily
 Scenario Outline: Verify content is displayed for each trend '<menu>' page
  Given I am a mk customer
  And I navigate to MK HomePage
  When MENU: I click trends "<menu>"
  And PLP: I verify that promo sections are displayed

  @excludeNA
  Examples:
   | menu |
   | HANDBAGS > Watch Hunger Stop |


 @siteNavigation_wip @menuChecks_wip @smoke_wip @daily
 Scenario: Verify new tab navigation to Trends page from the Menu flyout
  Given I am a mk customer
  And I navigate to MK HomePage
  When MENU: I open trends "WOMEN > New Arrivals" in new tab
  Then I am on the product listing page
  And PLP: I verify there are at least 10 products displayed


 @siteNavigation @menuChecks @categoryChecks @daily @akamaiCache @smokeSuite
 Scenario Outline: Verify content is displayed for each l2 menu trends '<menu>' category
  Given I am a mk customer
  And I navigate to MK HomePage
  When MENU: I click trends "<menu>"
  Then I am on the product listing page
  And PLP: I verify there are at least 1 products displayed

  Examples:
   | menu |
   | WOMEN > New Arrivals |
   #| WOMEN > Kors Style |
   | MEN > New Arrivals |
   | MEN > The Signature Logo Shop |

  @naOnly
  Examples:
   | menu |
   | WOMEN > The Signature Logo Shop |

  @usOnly
  Examples:
   | menu |
   #| WOMEN > Vacation Shop |
   #| MEN > Vacation Shop |
   #| MEN > Runway Styles |
   | MEN > Engraving Shop|
   | WOMEN > Kors Style |

  @caOnly
  Examples:
   | menu |
   #| WOMEN > The Travel Shop |
   #| WOMEN > The Limited Edition Edit |
   #| WOMEN > Lunar New Year |


 @siteNavigation @menuChecks @categoryChecks @daily @smokeSuite
 Scenario Outline: Verify content is displayed for each l2 menu trends '<menu>' category
  Given I am a mk customer
  And I navigate to MK HomePage
  When MENU: I click trends "<menu>"
  And PLP: I verify that promo sections are displayed

  Examples:
   | menu |
#   | WOMEN > Watch Hunger Stop |

  @excludeNA
  Examples:
   | menu |
   | MEN > Hypebeast |
   | MEN > Watch Hunger Stop |

  @naOnly
  Examples:
   | menu |
   #| MEN > Wearable Technology |