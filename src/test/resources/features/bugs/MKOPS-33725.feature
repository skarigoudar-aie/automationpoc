Feature: Logged in customer is unable to Navigate to Search page from Profile Page

  @bug @bug555
  Scenario: MKOPS-33725 Verify if Logged-In User is able to search from user profile page
    Given I am a logged-in mk customer
    And MENU: I click on search link
    Then I am able to see the Search Page