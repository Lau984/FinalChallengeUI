Feature: Create List in TMDB
  In order to test the creating lists flow
  As a registered user
  I want to verify the list is created and contains the added movies


  Scenario: Creating list of movies in TMDB
    Given Laura is a registered user who wants to create a list
    When Laura create a list with some movies to watch then
    Then The list is already created and is displayed in the lists view
