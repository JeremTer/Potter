@default_books
Feature: Calculate the price of a basket

  Scenario: Buying only one Harry Potter book
    Given My basket contains the books
      | Harry Potter and The Chamber of Secrets |
    When I proceed to checkout
    Then I should pay 8

  Scenario: Buying two different Harry Potter books
    Given My basket contains the books
      | Harry Potter and The Chamber of Secrets  |
      | Harry Potter and The Prisoner of Azkaban |
    When I proceed to checkout
    Then I should pay 15.2

  Scenario: Buying three different Harry Potter books
    Given My basket contains the books
      | Harry Potter and The Chamber of Secrets  |
      | Harry Potter and The Prisoner of Azkaban |
      | Harry Potter and The Goblet of Fire      |
    When I proceed to checkout
    Then I should pay 21.6

  Scenario: Buying four different Harry Potter books
    Given My basket contains the books
      | Harry Potter and The Chamber of Secrets  |
      | Harry Potter and The Prisoner of Azkaban |
      | Harry Potter and The Goblet of Fire      |
      | Harry Potter and The Philosopher s Stone |
    When I proceed to checkout
    Then I should pay 25.6

  Scenario: Buying all Harry Potter books
    Given My basket contains the books
      | Harry Potter and The Chamber of Secrets   |
      | Harry Potter and The Prisoner of Azkaban  |
      | Harry Potter and The Goblet of Fire       |
      | Harry Potter and The Philosopher s Stone  |
      | Harry Potter and The Order of the Phoenix |
    When I proceed to checkout
    Then I should pay 30

  Scenario: Buying same Harry Potter books
    Given My basket contains the books
      | Harry Potter and The Goblet of Fire      |
      | Harry Potter and The Goblet of Fire      |
      | Harry Potter and The Prisoner of Azkaban |
    When I proceed to checkout
    Then I should pay 23.2


