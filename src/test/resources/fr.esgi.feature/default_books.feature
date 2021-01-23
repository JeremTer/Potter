Feature: default books definition

  Scenario: Default books
    Given default books are used
    Then the available books should be at least:
      | title                                     | price |
      | Harry Potter and The Philosopher s Stone  | 8     |
      | Harry Potter and The Chamber of Secrets   | 8     |
      | Harry Potter and The Prisoner of Azkaban  | 8     |
      | Harry Potter and The Goblet of Fire       | 8     |
      | Harry Potter and The Order of the Phoenix | 8     |
