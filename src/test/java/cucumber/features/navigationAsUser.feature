Feature: Navigating in app

  Scenario Outline: opening different url-s as user
    Given I opened homepage
    When I go to different pages "<page>"
    Then I should see correct div's on screen "<shown_div>"

    Examples:
      | page           | shown_div   |
      | products       | products    |
      | contact        | mapid       |
      | smart-id/login | countryCode |
      | sitemap        | sitemal_li  |
      | cart           | cart        |






