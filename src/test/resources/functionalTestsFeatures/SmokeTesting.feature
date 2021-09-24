Feature: Smoke Testing

  Background: A new browser is opened at "Carnival Cruise" and a search is made.
    Given The user gets into "Carnival Cruise" page
    When The user enters the needed information
    And Click on "SEARCH CRUISES" button


#Searching for cruises filtering by the duration.
  #As a user I want to search cruises to The Bahamas with duration
  #between 6 and 9 days so that I will visualize all the options to choose
  #one. Right now, I don’t care about departure port.

  @EXECUTE
  Scenario: User see result are displayed in a grid.
    Given User is  redirected to result page
    When user see result
    Then results are shown in a grid


  @EXECUTE
  Scenario: User see results are filtered by price
    Given results are shown
    When user use slider bar
    Then results varies in the range


  @EXECUTE
  Scenario: User see result are sorted by price.
    Given results are shown
    When The user clicks on "Sort By Price" button
    Then default value will be the cheapest

 #----------------------------------------------------------------------
# Selecting a cruise and getting more info about it.
    #As a user I want to choose one sail and learn more about the trip, so
    #that I will get more info about itinerary

#Not currently working, having some issues with the response time my machine
  Scenario: User see itinerary page load
    Given The user select a result from the list
    Then The user see "Itinerary" page loads


  Scenario: User can read "About" page of each day.
    Given The user selects one of the cruises of the result set
    And The user is redirected towards the "Itinerary" page
    Then The information of each day is displayed when clicked.


  Scenario: User see "BOOK NOW" button  in itinerary page.
    Given The user selects one of the cruises of the result set
    And The user is redirected towards the "Itinerary" page
    Then An "Book Now" button is  displayed.

