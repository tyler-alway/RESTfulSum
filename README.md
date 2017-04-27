# RESTfulSum

## Description 
This is an implementation of a RESTful API that takes in integers through POST requests, sums them through GET requests, and deletes all values through DELETE requests. 

## Running
In the root directory of the project type:   
`mvn package`   
`cp target/api.war <your tomcat installation dir>/webapps`
 
 You must have Maven, Tomcat 9, and Java 8 installed.

## Useage

GET sum  
`$ curl http://localhost:8080/api/sum/values`  

POST values  
`$ curl -X POST http://localhost:8080/api/values --data "value=11"`  

DELETE values  
`$ curl -X DELETE http://localhost:8080/api/values`  




