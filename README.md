# RESTfulSum

## Running
In the root directory of the project type: 
mvn package
cp target/api.war <Your tomcat installation dir>/webapps

## Useage

GET sum
$ curl http://localhost:8080/api/sum/values

POST values
$ curl -X POST http://localhost:8080/api/values --data "value=11"

DELETE values
$ curl -X DELETE http://localhost:8080/api/values




