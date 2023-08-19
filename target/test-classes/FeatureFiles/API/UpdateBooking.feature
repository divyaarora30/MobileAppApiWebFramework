@Test_Api
Feature: To update a booking in restful-booker

  Background: create an auth token
    Given user has access to endpoint "/auth"
    When user creates a auth token with credential "admin" & "password123"
    Then user should get the response code 200

  @updateBookingFromExcel
  Scenario Outline: To create and update a new booking using Excel data
    Given user has access to endpoint "/booking"
    And user creates a booking using data "<createKey>" from Excel
    When user updates the booking details using data "<updateKey>" from Excel
    Then user should get the response code 200
    And user validates the response with JSON schema from Excel

    Examples:
      | createKey      | updateKey      |
      | createBooking1 | updateBooking1 |
      | createBooking2 | updateBooking2 |