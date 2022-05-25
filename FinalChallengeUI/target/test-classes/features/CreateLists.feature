Feature: Create List in TMDB
  As a registered user, I want to create a list of movies, so that I can have a
  personalize list of movies to watch


  Scenario: Creating list of movies in TMDB
    Given Given I’m a logged in user
    When I create a list with name and description
    Then I have a list to add movies

  Scenario: Adding movies in a created list
    Given I’m a logged in user
    And I have a created list
    When I add a movie to the list
    Then the list has the added movie

  Scenario: Delete a movie from a created list
    Given I’m a logged in user
    And I have a created list
    And the list has items
    When I delete a movie from the list
    Then the list is updated without the deleted list