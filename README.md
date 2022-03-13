

# risk-profile-api


This project is a single container using:

Java 17 </br>
MAVEN 3.8.4</br>
Spring boot 2.6.4 </br>


The structure of the project is divide in package by feature strategy: 

ºriskengine feature</br>
ºuserprofile feature

I decide to choose it thinking in future split in new microservices. 
It can be easier to apply strangler pattern when we are using package by feature layers. 

### build

To build the project use: 

mvn clean install</br>

### test

The test strategy was developing using spring embedded container. 
Following this strategy, its possible test all integrations between layers. 

I choose rest template strategy in controller layer to run a server side perspective. 


To execute all tests, just use: 

mvn test

To see code coverage report: 

/target/site/jacoco/index.html 

### run

You can run this project as a single container: 

java -jar build/risk-profile-api.jar

or using docker-compose: 

docker-compose up 
