Feature: Country Switch Navigation

  @siteNavigation @countrySwitch @smoke @daily @dailySmoke @excludeNA	@excludeGlobal @buildSmoke
  Scenario: AutoSmoke_007: Verify a guest user can switch to random dedicated country
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I select random dedicated country from the country selector
    Then I can verify the switch to country


  @siteNavigation @countrySwitch @smoke @daily @dailySmoke @excludeNA	@excludeGlobal @buildSmoke
  Scenario: AutoSmoke_007: Verify a guest user can switch to random catch all country
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I select random catch all country from the country selector
    Then I can verify the switch to country


  @siteNavigation @countrySwitch @smoke @daily @dailySmoke @excludeNA	@excludeEU @buildSmoke
  Scenario: AutoSmoke_007: Verify a guest user can switch to random global country
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I select random global country from the country selector
    Then I can verify the switch to country


  @siteNavigation @countrySwitch @smoke @daily @dailySmoke @excludeEU @excludeGlobal @buildSmoke
  Scenario: AutoSmoke_007: Verify a guest user can switch to random NA country
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I select random NA country from the country selector
    Then I can verify the switch to country


  @siteNavigation_wip @countrySwitch_wip @smoke_wip
  Scenario: AutoSmoke_008: Verify that Geo IP popup is displayed when user changing the URL manually
    Given I am a mk customer
    And   I navigate to MK HomePage
    Then  I change the URL Manual to any random country
    And   I Verify Geo IP popup is displaying
    And   Geo Ip Popup: I Verify continue to michael kors and choose a differnt country buttons displaying


  @siteNavigation @countrySwitch @smoke
  Scenario: AutoSmoke_028_A: Verify a guest user can switch to random dedicated country from PLP
    Given I am a mk customer
    And I navigate to MK HomePage
    When MENU: I click menu "WOMEN > michael-kors-collection"
    Then I am on the product listing page
    When MENU: I select random dedicated country from the country selector
    Then I can verify the switch to country


  @siteNavigation @countrySwitch @smoke @desktopOnly @buildSmoke
  Scenario: AutoSmoke_028_B: Verify a guest user can switch to random dedicated country from SLP
    Given I am a mk customer
    And I navigate to MK HomePage
    And MENU: I click on search link
    And SLP: I type 'shoes' into the search box and press key enter
    Then I am on the search listing page
    When MENU: I select random dedicated country from the country selector
    Then I can verify the switch to country


  @siteNavigation @countrySwitch @smoke @euOnly
  Scenario: AutoSmoke_028_C: Verify a guest user can switch to random dedicated country from PDP
    Given I am a mk customer
    And I navigate to MK HomePage
    And I am interested in following mk products
       | watch | category:watch |
    And MENU: I click on search link
    And SLP: I type 'watch:styleName' into the search box and press key enter
    And SLP: I click on the product name
    And I am on the product detail page
    When MENU: I select random dedicated country from the country selector
    Then I can verify the switch to country


  @siteNavigation @countrySwitch @Func_Prioritized_Reg_TC_183
  Scenario: Verify the display and functionality of Country change decision box.
    Given I am a logged-in mk customer
    And I navigate to MK HomePage
    When MENU: I select random dedicated country from the country selector
    Then I can verify the switch to country