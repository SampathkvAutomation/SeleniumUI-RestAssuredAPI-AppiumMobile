Feature:Test Mobileapp Login.

  @mobileapptest
  Scenario: login to Mobile App with credentials
    Given Open Login page in App
    When Emter username "testuser" and password "password123"
    Then home screen should be visible