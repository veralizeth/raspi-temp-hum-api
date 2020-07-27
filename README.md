# Catapult Raspberry PI Environment Monitoring
### Capstone Project - Vera Rodriguez - Ada Developers' Academy

To execute this project there are three repositories: 

1. raspi-temp-hum -> [Raspberry PI4- AWS Iot and SQS configurations](https://github.com/veralizeth/raspi-temp-hum/blob/master/README.md)
1. raspi-temp-hum-api -> Java Spring boot API Server
1. raspi-temp-hum-frontEnd -> [React front-End](https://github.com/veralizeth/raspi-temp-hum-frontEnd)

## 2. raspi-temp-hum-api -> Java Spring boot API Server

## Table of Contents

* [Introduction and Technologies](#Introduction-and-Technologies)
* [AWS SQS Java SDK](#AWS-SQS-Java-SDK)
* [AWS SQS](#AWS-SQS)

## Introduction and Technologies
**The problem**: 

Connect SQS with Java Spring Boot to store the messages within AWS RDS PostgreQL database.
The React front-end should be able to access the information through 
api Restful routes. 

**The solution**: 
    
  * Using the AWS Java SDK to connnect SQS to the server. 
    * Built with Java spring boot 11.
    
  * Using Java Spring Boot, JPA Hibernate. To create the models and the 

**What is Java Spring Boot**: 

Spring Boot provides a good platform for Java developers to develop a stand-alone and production-grade spring application that you can just run. You can get started with minimum configurations without the need for an entire Spring configuration setup. 

**How does it work?**

Spring Boot automatically configures your application based on the dependencies you have added to the project by using @EnableAutoConfiguration annotation. For example, if PostgresQL database is on your classpath, but you have not configured any database connection, then Spring Boot auto-configures an in-memory database.

Installation
============

* Download and install latest version of Java Spring boot: 
1. [Spring Initilizr](https://start.spring.io/)
