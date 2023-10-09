@selectHotel
Feature: Verifying OMR Branch Hotel Login Automation

  Scenario Outline: Select hotel and verify navigate to book hotel upon accepting the alert
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<roomType>","<checkIn>","<checkOut>","<numberOfRooms>","<adults>" and "<child>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User select first hotel and save the hotel name,price
    And User accept the alert for hotel booking
    Then User should verify the message after accepting alert "Book Hotel"

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType | checkIn    | checkOut   | numberOfRooms | adults | child |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Standard | 2023-07-30 | 2023-07-31 | 3-Three       | 5-Five |     2 |

  Scenario Outline: Select hotel and verify navigate in the same page upon cancel the alert
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<roomType>","<checkIn>","<checkOut>","<numberOfRooms>","<adults>" and "<child>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User select first hotel and save the hotel name,price
    And User dismiss the alert for cancel the selected hotel
    Then User should verify the message after cancel the alert "Select Hotel"

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType | checkIn    | checkOut   | numberOfRooms | adults | child |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Standard | 2023-07-30 | 2023-07-31 | 3-Three       | 5-Five |     2 |

  Scenario Outline: Verifying sorting functionality hotel price list displayed in low to high formation
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<roomType>","<checkIn>","<checkOut>","<numberOfRooms>","<adults>" and "<child>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User select price low to high option for filtering the hotel
    Then User should verify all the price range displayed in low to high order formation

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType | checkIn    | checkOut   | numberOfRooms | adults | child |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Standard | 2023-07-30 | 2023-07-31 | 3-Three       | 5-Five |     2 |

  Scenario Outline: Verifying sorting functionality hotel name displayed in descending order
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<roomType>","<checkIn>","<checkOut>","<numberOfRooms>","<adults>" and "<child>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User select Name Descending option for filtering the hotel
    Then User should verify all the hotel names displayed in descending order

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType | checkIn    | checkOut   | numberOfRooms | adults | child |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Standard | 2023-07-30 | 2023-07-31 | 3-Three       | 5-Five |     2 |

  Scenario Outline: Passing room type and verify filter is listed(verify each hotel name is endswith given roomtype)
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<roomType>","<checkIn>","<checkOut>","<numberOfRooms>","<adults>" and "<child>"
    Then User should verify the success message after search "Select Hotel"
    And User should verify all hotel names endswith selected roomtype "<roomType>"

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType | checkIn    | checkOut   | numberOfRooms | adults | child |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Standard | 2023-07-30 | 2023-07-31 | 3-Three       | 5-Five |     2 |
