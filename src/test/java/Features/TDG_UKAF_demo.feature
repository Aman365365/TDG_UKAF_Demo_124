Feature: Xspace test

  Background:
    * url 'https://dev-xtables.thedigitalgroup.com'
    * configure ssl = true
    * def result = { "username":"amandeep.chauhan@thedigitalgroup.com", "password":"tcb@1234" }

  Scenario: Insert WorkBook
    * path '/auth/getToken'
    * request result
    * method POST
    * status 201
    * print response
    * def testCooke = response.replace('"','').replace('"','')

    Given path '/elasticsearch/insertDoc'
    * header Accept = 'application/json'
    * header Cookie =  testCooke
    And request {"index":"workbook","doc":{"name":"Workbook (45)","user_id":"amandeep.chauhan@thedigitalgroup.com","user_email":"amandeep.chauhan@thedigitalgroup.com","shared_with":[],"remote_datasource":"Elastic"}}
    When method post
    Then status 201
    And print response