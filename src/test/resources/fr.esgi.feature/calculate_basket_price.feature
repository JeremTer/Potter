@default_properties
Feature: Calculate the price of a basket

  Scenario: Buying only one Harry Potter book
    Given My basket contains the book “Harry Potter and The Chamber of Secrets” that costs 8
    When I proceed to checkout
    Then I should pay 8

