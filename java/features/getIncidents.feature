Feature: Servicenow Incidents

Scenario: Get all incidents

Given Endpoint is set
And Auth is added
When Request is sent
Then Validate response