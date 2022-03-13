

# risk-profile-api


This project is a single container using:

Java 17 </br>
MAVEN 3.8.4</br>
Spring boot 2.6.4 </br>


The structure of the project is divide in package by feature strategy: 

1) riskengine feature</br>
2) userprofile feature

I decide to choose it thinking in future split in new microservices. 
It can be easier to apply strangler pattern when we are using package by feature layers. 


Here we have a sequece diagram with a big picture of calculate risk profile flow: 

![Alt text](docs/UserProfileController_calculateRiskProfile.png?raw=true "Title")

The InsuranceRulesService define a base contract for all kind of insurance. 
Follow this strategy its possible define the way of working for all contract. 

Here we have a AutoInsrance implementation in detail, The Interface rule define the base contracts to build new rules. 

![Alt text](docs/AutoRulesService_getRateFromProfile.png?raw=true "Title")

Following this strategy, we have a factory of rules, witch it is controled by specific enums, where we can add, remove or edit without break the main core of risk engine.  


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
