@CancelBooking
Feature: Verifying OMR Branch Hotel Cancel Booking

  Scenario Outline: Cancel the hotel booking and verify the cancel success message
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<roomType>","<checkIn>","<checkOut>","<numberOfRooms>","<adults>" and "<child>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User select first hotel and save the hotel name,price
    And User accept the alert for hotel booking
    Then User should verify the message after accepting alert "Book Hotel"
    When User add the guest details "<salutation>","<first Name>","<last Name>","<mobile No>" and "<email Id>"
    And User add gst details "<gst No>","<companyName>" and "<companyAddress>"
    And User add the special request "<special Req>"
    And User add payment details with card options "<card Option>"
      | card Type       | card No          | name  | month    | year | cvv |
      | Debit Visa      | 5555555555552222 | Bala  | May      | 2023 | 766 |
      | Debit Amex      | 5555555555552222 | Anu   | January  | 2024 | 776 |
      | Debit Master    | 5555555555552222 | Ram   | November | 2026 | 756 |
      | Debit Discover  | 5555555555552222 | Mani  | December | 2028 | 466 |
      | Credit Visa     | 5555555555552223 | Bala  | May      | 2023 | 766 |
      | Credit Amex     | 5555555555552223 | Abu   | January  | 2024 | 776 |
      | Credit Master   | 5555555555552223 | Raman | November | 2026 | 756 |
      | Credit Discover | 5555555555552223 | Mani  | December | 2028 | 466 |
    Then User should verify after booking success message "Booking is Confirmed" and save order id
    And User Should verify same selected hotel only booked
    When User navigates to the My Booking page
    Then User should verify after navigate to My Booking page success message "Bookings"
    When User enter the Order id "<orderId>"
    Then User should verify same order id is displayed
    And User should verify same hotel name is present
    And User should verify same hotel  price is present
    When User modify the checkin date "<modifyCheckInDate>"
    Then User should verify after modify checkin date success message "Booking updated successfully"
    When User enter the Order id "<orderId>"
    Then User should verify same order id is displayed
    And User should verify same hotel name is present
    And User should verify same hotel  price is present
    When User cancel the order id
    Then User should verify after cancel the order id success message "Your booking cancelled successfully"

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults  | child | salutation | first Name | last Name | mobile No  | email Id               | gst No     | companyName            | companyAddress | special Req         | card Option | orderId    | modifyCheckInDate |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Luxury/Standard/Deluxe/Suite/Studio | 2023-07-04 | 2023-07-05 | 2-Two         | 3-Three |     2 | Mr.        | Boopathy   | R         | 8148866416 | Boopathy2228@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | I dont want a lunch | Debit       | NPYIZ40479 | 2023-07-22        |

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults  | child | salutation | first Name | last Name | mobile No  | email Id               | gst No     | companyName            | companyAddress | special Req         | card Option | orderId    | modifyCheckInDate |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Luxury/Standard/Deluxe/Suite/Studio | 2023-07-04 | 2023-07-05 | 2-Two         | 3-Three |     2 | Mr.        | Boopathy   | R         | 8148866416 | Boopathy2228@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | I dont want a lunch | Credit      | NPYIZ40479 | 2023-07-22        |

  Scenario Outline: Cancel the first booking order id
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User navigates to the My Booking page
    Then User should verify after navigate to My Booking page success message "Bookings"
    When User cancel the first booking hotel order id
    Then User should verify after cancel the order id success message "Your booking cancelled successfully"

    Examples: 
      | UserName               | Password   |
      | boopathy2228@gmail.com | Unlucky@28 |

  Scenario Outline: Cancel the existing hotel order id
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User navigates to the My Booking page
    Then User should verify after navigate to My Booking page success message "Bookings"
    When User enter existing order id for cancel the hotel booking "<orderID>"
    Then User should verify same order id is displayed
    And User should verify same hotel name is present
    And User should verify same hotel  price is present
    And User cancel the order id
    Then User should verify after cancel the order id success message "Your booking cancelled successfully"

    Examples: 
      | UserName               | Password   | orderId    |
      | boopathy2228@gmail.com | Unlucky@28 | NPYIZ40479 |
