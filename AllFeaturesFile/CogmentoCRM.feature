Feature: Test Cogmento CRM Application

  Scenario: Validate the LoginAndHomePage Functionality  #parameters concept
    Given user open "edge" browser
    When user enters valid "prafulp1010@gmail.com" , "Pr@ful0812" and click on login button
    Then user validate Home Page title
    And user validate Home Page URL
    And user validate Home Page Logo

  Scenario Outline: Validate Contacts page Functionality  #data driven testing
    Given user click on Contacts button
    And user validate user is on Contacts Page URL
    And user click on create contacts button
    And user enter valid "<Firstname>","<Middlename>","<Lastname>" and click on save button
    And user delete the created contact by clicking on delete bin
    And user click on confirm delete button

    Examples: 
      | Firstname | Middlename | Lastname  |
      | Janki     | Shankar    | Mahadevan |
      | Parvati   | Hari       | Murari    |
      | Sita      | vishnu     | Mahesh    |
      | Laxmi     | krishna    | Hari      |

  Scenario: Validate Companies Page Functionality #dataTable
    Given user click on Companies link
    And user validate the Companies Page Url
      | companies |
    When user clicks on create new company button
    Then user enters valid company name
      | Dutch Bank |
    And user click on save button

  Scenario: Validate the Deals Page Functionality # normal scenario
    Given user is on Deals Page and validate the Deals Page url
    When user click on create deals button
    Then user enter valid title and amount
    And user delete the created deal
    And user again click on delete bin
    And user click on deals icon
    And user click on deleted deals name checkbox and then click on purge deleted button and then click on Ok button
    Then user click on settings icon and click on logout
