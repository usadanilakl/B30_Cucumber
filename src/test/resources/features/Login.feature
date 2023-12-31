@Library
Feature: Login function of the Library application
  As a user, I should be able to login with correct credentials to different accounts.
  AC: all typs of users successfully log in and have access to the dashboard.

  Background: Login Page
    When User is on Library Login Page


  Scenario: Librarian
    When "Librarian" and "Lib_password" are entered
    Then click submit button
    And verify page title is "Lib_dashboard"

  Scenario: Student
    When "Student" and "Stud_password" are entered
    Then click submit button
    And verify page title is "Stud_dashboard"

  Scenario: Admin
    When "Admin" and "Adm_password" are entered
    Then click submit button
    And verify page title is "Adm_dashboard"