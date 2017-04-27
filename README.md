# RESTfulSum

## Description 
This is an implmentation of a RESTful API that takes in integers through POST requests sums them thorugh GET requests and deletes all values through DELETE requests. 

## Running
In the root directory of the project type:   
`mvn package`   
`cp target/api.war <Your tomcat installation dir>/webapps`
 
 You must have Maven, Tomcat9, and java 8 installed.

## Useage

GET sum  
`$ curl http://localhost:8080/api/sum/values`  

POST values  
`$ curl -X POST http://localhost:8080/api/values --data "value=11"`  

DELETE values  
`$ curl -X DELETE http://localhost:8080/api/values`  




