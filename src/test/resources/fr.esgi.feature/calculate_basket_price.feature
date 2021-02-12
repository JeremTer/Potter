@default_books
Feature: Calculate the price of a basket

  Rule: One copy of any Harry Potter books costs 8 euros
    Scenario: Buying only one Harry Potter book
      Given My basket contains the books
        | Harry Potter and The Chamber of Secrets |
      When I proceed to checkout
      Then I should pay 8

  Rule: Buying two different copies of Harry Potter books will generate a 5% discount on those two books
    Scenario: Buying two different Harry Potter books
      Given My basket contains the books
        | Harry Potter and The Chamber of Secrets  |
        | Harry Potter and The Prisoner of Azkaban |
      When I proceed to checkout
      Then I should pay 15.2

  Rule: Buying three different copies of Harry Potter book will generate a 10% discount on those three books
    Scenario: Buying three different Harry Potter books
      Given My basket contains the books
        | Harry Potter and The Chamber of Secrets  |
        | Harry Potter and The Prisoner of Azkaban |
        | Harry Potter and The Goblet of Fire      |
      When I proceed to checkout
      Then I should pay 21.6

  Rule: Buying four different copies of Harry Potter books will generate a 20% discount on those four books
    Scenario: Buying four different Harry Potter books
      Given My basket contains the books
        | Harry Potter and The Chamber of Secrets  |
        | Harry Potter and The Prisoner of Azkaban |
        | Harry Potter and The Goblet of Fire      |
        | Harry Potter and The Philosopher s Stone |
      When I proceed to checkout
      Then I should pay 25.6

  Rule: Buying all different copies of Harry Potter books will generate a 25% discount on those books
    Scenario: Buying all Harry Potter books
      Given My basket contains the books
        | Harry Potter and The Chamber of Secrets   |
        | Harry Potter and The Prisoner of Azkaban  |
        | Harry Potter and The Goblet of Fire       |
        | Harry Potter and The Philosopher s Stone  |
        | Harry Potter and The Order of the Phoenix |
      When I proceed to checkout
      Then I should pay 30

  Rule: Buying three copies with 2 different titles of Harry Potter books will generate a 5% discount only for the two different copies
    Scenario: Buying same Harry Potter books
      Given My basket contains the books
        | Harry Potter and The Goblet of Fire      |
        | Harry Potter and The Goblet of Fire      |
        | Harry Potter and The Prisoner of Azkaban |
      When I proceed to checkout
      Then I should pay 23.2


