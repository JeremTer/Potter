@default_books
Feature: Calculate the price of a basket

  Scenario: Buying only one Harry Potter book
    Given My basket contains the books
      | Harry Potter and The Chamber of Secrets |
    When I proceed to checkout
    Then I should pay 8

