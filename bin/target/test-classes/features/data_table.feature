Feature: This is data table

  # data table examples
  Scenario: data table
    Given the url
    When user enters username and password
      | allensmith@gmail.com | smith@123 |
      | albertgrey@gmail.com | albert@345|
    Then validate profile page