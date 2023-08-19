@Test_Web
Feature: HK observatory

  Scenario: Navigate to observatory website
    Given the user navigates to hk observatory website
    Then the home page is displayed

  Scenario: Navigate to climate screens
    Given the user navigates to hk observatory website
    When the user clicks on "Climate" link
    When the user clicks on "Climate Change" link on climate page
    And the user clicks on "Climate Change in Hong Kong" link on climate page
    Then climate change in Hong kong page is displayed

  Scenario: No results found when clicking on invalid text in searchbox
    Given the user navigates to hk observatory website
    When the user enters invalid character in search box
    Then no results found page is displayed








