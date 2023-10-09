@login

Feature: Verifying OMR Branch Hotel Login Automation

  Scenario Outline: Verifing login with valid Credencials
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"

    Examples: 
      | UserName               | Password   |
      | boopathy2228@gmail.com | Unlucky@28 |

  Scenario Outline: Login with Robot
    Given User is on the OMRBranch Hotel page
    When User login using keyboard actions "<UserName>" and "<Password>"
    Then User should verify the success message after login "Welcome Boopathy"

    Examples: 
      | UserName               | Password   |
      | boopathy2228@gmail.com | Unlucky@28 |

  Scenario Outline: Verifing login with invalid Credencials
    Given User is on the OMRBranch Hotel page
    When User login "<UserName>" and "<Password>"
    Then User should verify the error message after login "Invalid Login details or Your Password might have expired."

    Examples: 
      | UserName               | Password    |
      | boopathy2228@gmail.com | Unlucky@283 |
