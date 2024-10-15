Feature: Login functionality for LeafTaps application

Scenario: Test login with positive credentials
Given enter username as demosalesmanager
And enter password as crmsfa
When click login button
Then homepage should display 