Feature: Guest user home page checks

  @homepageChecks @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_001: Verify the logo in the Header
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see mk logo

  @homepageChecks @smoke @daily @dailySmoke @naOnly @desktopOnly @buildSmoke @smokeSuite @Shiva
  Scenario: Verify user links in the Header
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see following user links
      #| Find A Store |
      #| Sign In      |
      | Wish List    |
      

  @homepageChecks @smoke @daily @dailySmoke @naOnly @buildSmoke @smokeSuite
  Scenario: Verify user links in the Header
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see following user links
      | Wish List |

  @homepageChecks @smoke @daily @dailySmoke @usOnly @buildSmoke @smokeSuite
  Scenario: Verify user links in the Header
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see following user links
      | Join |

  @homepageChecks @smoke @daily @dailySmoke @caOnly @buildSmoke @smokeSuite
  Scenario: Verify user links in the Header
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see following user links
      | Sign Up |

  @homepageChecks @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_001: Verify country selection section in the Header
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see country flag
    And HEADER: I can see country selected link

  @homepageChecks @smoke @daily @dailySmoke @excludeNA  @desktopOnly @buildSmoke
  Scenario: Verify user links icons in the Header
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see magnifying glass icon
    And HEADER: I can see shopping bag icon
    And HEADER: I can see store locator icon
    And HEADER: I can see user icon

  @homepageChecks @smoke @daily @dailySmoke @naOnly @buildSmoke
  Scenario: Verify user links icons in the Header
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HEADER: I can see magnifying glass icon
    And HEADER: I can see shopping bag icon

  @homepageChecks @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_004: Verify content in the Homepage body
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HP: I verify content exists

  @homepageChecks @smoke @daily @dailySmoke @buildSmoke
  Scenario: AutoSmoke_001: Verify links in the footer
    Given I am a mk customer
    When I navigate to MK HomePage
    Then FOOTER: I can see Find a Store section
    And FOOTER: I can see Newsletter signup section
    And FOOTER: I can see Social media section
    And FOOTER: I can see Footer links section
    And FOOTER: I can see Additional footer links section

  @homepageChecks_wip @smoke_wip
  Scenario: Verify Cookie Pop has I Accept link
    Given I am a mk customer
    When I navigate to MK HomePage
    Then HP: I verify cookie popup I Accept exists

  @guest @homepageChecks_wip @smoke
  Scenario: AutoSmoke_048: Verify that System capturing the SEO URL in home page
    Given I am a mk customer
    And I navigate to MK HomePage
    Then I verify that canonical url for the accessed site exists

  @guest @homepageChecks_wip @smoke_wip
  Scenario: AutoSmoke_049: Verify that System capturing the Omniture parameter in home page.
    Given I am a mk customer
    And I navigate to MK HomePage
    And I navigate to page console through keyboard F12
    When I launch the Omnibug and verify the tags
    Then I see following tags and their values
      | evar28  | desktop:ecommerce |
      | evar29  | UK                |
      | evar35  | D=c14             |
      | channel | home page         |
      | prop1   | home page         |
      | prop2   | home page         |
      | prop3   | home page         |


  @guest @homepageChecks_wip @smoke_wip
  Scenario: AutoSmoke_054: Verify the account creation from light box pop up.
    Given I am a mk customer
    And I navigate to MK HomePage
    When I accept the cookie popup
    Then I verify the Lightbox popup display
    And Lightbox popup: I enter First name
    And Lightbox popup: I enter Last name
    And Lightbox popup: I enter Email address
    And Lightbox popup: I enter Confirm email address
    And Lightbox popup: I select country
    When Lightbox popup: I click on Sign up button
    Then I verify Its official popup displayed with options to Create Account and Start shopping
    When I click on Create Account button on Its official popup
    Then I verify I am on SignUp page
    And I Select Country on Sign Up Page
    And SignUp: I enter new email address
    And SignUp: I enter confirm email address
    And SignUp: I enter first Name
    And SignUp: I enter last Name
    And SignUp: I enter phone Number
    And SignUp: I enter postal Code
    And SignUp: I select birth Month
    And SignUp: I select birth Day
    And SignUp: I select Gender
    And SignUp: I enter Password
    And SignUp: I enter Confirm Password
    And SignUp: I agree to the Terms and Conditions
    When SignUp: I click Register button
    Then SignUp: I navigate to the Myaccount Page
