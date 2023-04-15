Feature: Service now Incidents

Scenario: Get incidents and print response with only sysparm field number

Given Endpoint is set
And Auth is added
When Send request with query params
|sysparm_fields|category,description|
|category|hardware|
Then Validate response