@BookHotel
Feature: Verifying OMR Branch Hotel Booking

  Scenario Outline: Book Hotel including GST and Card options with special request
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

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults  | child | salutation | first Name | last Name | mobile No  | email Id               | gst No     | companyName            | companyAddress | special Req         | card Option |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Luxury/Standard/Deluxe/Suite/Studio | 2023-07-04 | 2023-07-05 | 2-Two         | 3-Three |     2 | Mr.        | Boopathy   | R         | 8148866416 | Boopathy2228@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | I dont want a lunch | Debit       |

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults  | child | salutation | first Name | last Name | mobile No  | email Id               | gst No     | companyName            | companyAddress | special Req         | card Option |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Luxury/Standard/Deluxe/Suite/Studio | 2023-07-04 | 2023-07-05 | 2-Two         | 3-Three |     2 | Mr.        | Boopathy   | R         | 8148866416 | Boopathy2228@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | I dont want a lunch | Credit      |

  Scenario Outline: Book Hotel including GST and Card options without special request
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
    And User add payment details with card options "<card Option>"
      | card Type       | card No          | name | month    | year | cvv |
      | Debit Visa      | 5555555555552222 | Bala | May      | 2023 | 766 |
      | Debit Amex      | 5555555555552222 | Abu  | January  | 2024 | 776 |
      | Debit Master    | 5555555555552222 | Ram  | November | 2026 | 756 |
      | Debit Discover  | 5555555555552222 | Mani | December | 2028 | 466 |
      | Credit Visa     | 5555555555552223 | Bala | May      | 2023 | 766 |
      | Credit Amex     | 5555555555552223 | Abu  | January  | 2024 | 776 |
      | Credit Master   | 5555555555552223 | Ram  | November | 2026 | 756 |
      | Credit Discover | 5555555555552223 | Mani | December | 2028 | 466 |
    Then User should verify after booking success message "Booking is Confirmed" and save order id
    And User Should verify same selected hotel only booked

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults  | child | salutation | first Name | last Name | mobile No  | email Id            | gst No     | companyName            | companyAddress | card Option |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Luxury/Standard/Deluxe/Suite/Studio | 2023-07-04 | 2023-07-05 | 2-Two         | 3-Three |     2 | Mr.        | Boopathy   | R         | 8148866416 | BoopathyR@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Debit       |

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults  | child | salutation | first Name | last Name | mobile No  | email Id               | gst No     | companyName            | companyAddress | card Option |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Luxury/Standard/Deluxe/Suite/Studio | 2023-07-04 | 2023-07-05 | 2-Two         | 3-Three |     2 | Mr.        | Boopathy   | R         | 8148866416 | Boopathy2228@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | Credit      |

  Scenario Outline: Book Hotel Without GST and Card options (debit card -VISA) with special request
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<roomType>","<checkIn>","<checkOut>","<numberOfRooms>","<adults>" and "<child>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User select first hotel and save the hotel name,price
    And User accept the alert for hotel booking
    Then User should verify the message after accepting alert "Book Hotel"
    When User add the guest details "<salutation>","<first Name>","<last Name>","<mobile No>" and "<email Id>"
    And User add the special request "<special Req>"
    And User add payment details with card options "<card Option>"
      | card Type | card No          | name | month    | year | cvv |
      | Visa      | 5555555555552222 | Bala | May      | 2023 | 766 |
      | Amex      | 5555555555552222 | Abu  | January  | 2024 | 776 |
      | Master    | 5555555555552222 | Ram  | November | 2026 | 756 |
      | Discover  | 5555555555552222 | Mani | December | 2028 | 466 |
    Then User should verify after booking success message "Booking is Confirmed" and save order id
    And User Should verify same selected hotel only booked

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults  | child | salutation | first Name | last Name | mobile No  | email Id               | special Req         | card Option |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Luxury/Standard/Deluxe/Suite/Studio | 2023-07-04 | 2023-07-05 | 2-Two         | 3-Three |     2 | Mr.        | Boopathy   | R         | 8148866416 | Boopathy2228@gmail.com | I dont want a lunch | Debit       |

  Scenario Outline: Book Hotel Without GST and Card options (credit card -VISA) with special request
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"
    When User enter the "<stateName>","<cityName>","<roomType>","<checkIn>","<checkOut>","<numberOfRooms>","<adults>" and "<child>"
    Then User should verify the success message after search hotel "Select Hotel"
    When User select first hotel and save the hotel name,price
    And User accept the alert for hotel booking
    Then User should verify the message after accepting alert "Book Hotel"
    When User add the guest details "<salutation>","<first Name>","<last Name>","<mobile No>" and "<email Id>"
    And User add payment details with card options "<card Option>"
      | card Type | card No          | name | month    | year | cvv |
      | Visa      | 5555555555552223 | Bala | May      | 2023 | 766 |
      | Amex      | 5555555555552223 | Anu  | January  | 2024 | 776 |
      | Master    | 5555555555552223 | Ram  | November | 2026 | 756 |
      | Discover  | 5555555555552223 | Mani | December | 2028 | 466 |
    Then User should verify after booking success message "Booking is Confirmed" and save the order id
    And User Should verify same selected hotel only booked

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults  | child | salutation | first Name | last Name | mobile No  | email Id               | card Option |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Luxury/Standard/Deluxe/Suite/Studio | 2023-07-04 | 2023-07-05 | 2-Two         | 3-Three |     2 | Mr.        | Boopathy   | R         | 8148866416 | Boopathy2228@gmail.com | Credit      |

  Scenario Outline: Without Entering any field Book Hotel and verify Error message
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
    Then User with out entering any field in payment page should verify the all error message "Please select your card type","Please select your card","Please provide your card number","Please provide name on your card","Please provide your Card Expiry Date" and "Please provide your Card's security code"

    Examples: 
      | UserName               | Password   | stateName  | cityName | roomType                            | checkIn    | checkOut   | numberOfRooms | adults  | child | salutation | first Name | last Name | mobile No  | email Id               | gst No     | companyName            | companyAddress | special Req         |
      | boopathy2228@gmail.com | Unlucky@28 | Tamil Nadu | Chennai  | Luxury/Standard/Deluxe/Suite/Studio | 2023-07-04 | 2023-07-05 | 2-Two         | 3-Three |     2 | Mr.        | Boopathy   | R         | 8148866416 | Boopathy2228@gmail.com | 9043592058 | Greens Tech OMR Branch | Thoraipakkam   | I dont want a lunch |
