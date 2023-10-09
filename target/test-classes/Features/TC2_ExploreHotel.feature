@explore

Feature: Verifying OMR Branch Hotel Explore

  Scenario Outline: Enter all field and verify select hotel success message
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<roomType>","<checkIn>","<checkOut>","<numberOfRooms>","<adults>" and "<child>"
    Then User should verify the success message after search hotel "Select Hotel"

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType | checkIn    | checkOut   | numberOfRooms | adults | child |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Standard | 2023-08-30 | 2023-08-31 | 3-Three       | 5-Five |     2 |

  Scenario Outline: Enter only mandatory fields and verify select hotel success message
    Given User is on the OMRBranch Hotel page
    When User login using keyboard actions "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<checkIn>","<checkOut>","<numberOfRooms>" and "<adults>"
    Then User should verify the success message after search hotel "Select Hotel"

    Examples: 
      | UserName               | Password   | stateName  | cityName | checkIn    | checkOut   | numberOfRooms | adults |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | 2023-08-30 | 2023-08-31 | 3-Three       | 5-Five |

  Scenario Outline: Without enter any field click search and verify the error message
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User not enter the any details to perform search option
    Then User should verify the error message after search hotel "Please select state","Please select city","Please select Check-in date","Please select Check-out date","Please select no. of rooms" and "Please select no. of adults"

    Examples: 
      | UserName               | Password   |
      | boopathy2228@gmail.com | Unlucky@28 |

  @AllFields
  Scenario Outline: Enter all fields and select all types of room and also verify the select hotel message
    Given User is on the OMRBranch Hotel page
    When User login using keyboard actions "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<checkIn>","<checkOut>","<numberOfRooms>" and "<adults>"
    Then User should verify the success message after search hotel "Select Hotel"
    And User should verify the room type after search hotel "<roomType>"

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults | child |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Standard/Deluxe/Suite/Luxury/Studio | 2023-08-30 | 2023-08-31 | 3-Three       | 5-Five |     2 |
