Feature: Sign in check

  @onlyNA @rajesh
  Scenario: Sign in to application
    Given Go to Home page
    And Click on Signin link
    And I Enter username "rajeshchinna.t@gmail.com"
    And I Enter password "rajesh91"
    And I Click on sign in button
    Then I verify successfully sign in

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
