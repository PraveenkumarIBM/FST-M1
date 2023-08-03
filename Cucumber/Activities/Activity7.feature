@activity7
Feature: Login Feature
  Verify the login module

  @RegressionTest
  Scenario Outline: Getting the BMI
    Given The user is on the homepage
    When The user verifies the page title
    And Clicks on the BMI Calculator link
    And Enters the "<age>","<height>" and "<weight>"
    And Clicks on the calculate button
    And Should get the corresponding BMI
    Then Close the Browsers

    Examples:
      |age|height|weight|
      |10|127|40|
      |30|156|70|
      |25|152|55|
      |20|160|45|
      |35|160|70|