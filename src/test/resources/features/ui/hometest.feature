Feature: Google Search Home page

  @UITest
  Scenario: navigate to google search and find AI images
    Given open google search
    When search for "AI images"
    Then verify the results
    And Take Screen Shot "ScreenShot-verify the results"