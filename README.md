# verifone-sim-card-api

The code in this repository is submitted to Verifone's Hackerrank Challenge. sim-card-api is a REST api that is a basic CRUD application. 
I have used JPA, H2 Database and Spring Boot.
As part of challenge, the web service is supposed to be deployed on any server. We choose Heroku and it deployed to below link:
https://spring-boot-sim-card-api.herokuapp.com

Below Endpoints are supported
* (/) - GET -Return HTTP 200 Status
* (/add) 
  * POST - Create new SIM record in H2 Database
  *      - Request Structure
         `{
              "simCardNum":"abcd-1234-jkli-op123",
              "mobileNo":"1234567891",
              "status":"Disabled",
              "expiryDate":"2023-09-07",
              "stateOfRegistration":"MAHARASHTRA",
              "kyc":"Done",
              "teleComProvider":"BSNL updated",
              "fullName":"Bharat Sanchar Nigam Ltd."
           }`
* (/listall)
  * GET - Fetch all the records 
* (/:id) 
  * PUT - Update record with specific id.
  *     - Complete object with modified values should be resent.
* (/:id)
  * DELETE - Delete record with id




