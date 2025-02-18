@apiTest
Feature: Post Call for Booking


  Scenario: Post Call for Booking
    Given Add booking details as request Payload
    When perform POST request for "/booking" endpoint
    Then response should have Status code 200
    And response body field "bookingid" should not be null