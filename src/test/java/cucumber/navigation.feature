Feature: Navigating in app

  Scenario Outline: opening different url-s
    Given I opened homepage
    When I go to different pages "<page>"
    Then I should see correct div's on screen "<shown_div>"

    Examples:
      | page | shown_div |
         
