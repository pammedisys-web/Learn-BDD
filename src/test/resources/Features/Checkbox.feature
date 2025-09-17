Feature: Checkbox Automation
  As a QA engineer
  I want to perform actions on Checkbox automatically
  So that I can test Checkbox functionalities with Single or multiple or Enable/Disable

  Background:
    Given I am on Dashboard page "https://testing.qaautomationlabs.com/form.php"

  @SmokeTest1
  Scenario: user click on Single Checkbox
    When I hover mouse to the Checkbox page and click on it
    Then it get checked successfully on single click