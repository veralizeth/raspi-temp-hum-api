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
  
  Installation
============

* Download and install latest version of Java Spring:

```bash
    pip install django-jet
    # or
    easy_install django-jet
```

