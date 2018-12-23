Feature: Navigating in app as administrator

  Background: Administrator is logged in
    Given I opened homepage
    When I login
    Then I should be logged in

  Scenario Outline: can navigate to forbidden pages
    Given I opened homepage
    When I go to different pages "<page>"
    Then I should see correct div's on screen "<div>"

    Examples:
      | page               | div            |
      | products/add       | name           |
      | products/warehouse | searchInputBox |
      | stats              | oschart        |
