Feature: Login to SauceDemo
  As a user of SauceDemo
  I want to be able to login with valid credentials
  So that I can access the products page

  Background:
    Given the user is on the SauceDemo login page

  @smoke @login
  Scenario: Successful login with valid credentials
    When the user logs in with standard credentials
    Then the user should be redirected to the products page
    And the products page should display the inventory

  @login @negative
  Scenario: Login attempt with invalid credentials
    When the user attempts to login with username "invalid_user" and password "wrong_password"
    Then an error message should be displayed
    And the user should remain on the login page
