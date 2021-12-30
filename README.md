# :fire: Fire-Alarm-Monitoring-System
![Open Source Love svg1](https://badges.frapsoft.com/os/v1/open-source.svg?v=103) 
![Repo Size](https://img.shields.io/github/repo-size/Hasindu1/Fire-Alarm-Monitoring-System-Spring-boot-React-Js-RMI-Java-Swing) 

## Technology stack

### Languages 
![Java](https://img.shields.io/badge/Language-Java-red) 
![javaScript](https://img.shields.io/badge/Language-javaScript-red) 
![HTML5](https://img.shields.io/badge/Language-HTML5-red) 
![CSS](https://img.shields.io/badge/Language-CSS-red) 



### Frameworks and Libs
![Spring](https://img.shields.io/badge/Framework-Spring-blue) 
![Hibernate](https://img.shields.io/badge/Framework-Hibernate-blue) 
![Bootstrap](https://img.shields.io/badge/Framework-Bootstrap-blue) 
![ReactJs](https://img.shields.io/badge/Library-ReactJs-blue) 
![Axios](https://img.shields.io/badge/Library-Axios-blue) 
![JavaMailAPI](https://img.shields.io/badge/Library-JavaMailAPI-blue) 


### Technologies and APIs
![SpringBoot](https://img.shields.io/badge/Technology-SpringBoot-blue) 
![JavaSwing](https://img.shields.io/badge/Technology-JavaSwing-blue) 
![JavaRMI](https://img.shields.io/badge/Technology-JavaRMI-blue) 
![JavaMultiThreading](https://img.shields.io/badge/Technology-JavaMultiThreading-blue) 
![JAXRSClient](https://img.shields.io/badge/Technology-JAXRSClient-blue) 
![API](https://img.shields.io/badge/Technology-TwilloSMSAPI-blue) 


### Tools ,Databases and servers
![Intelij](https://img.shields.io/badge/Technology-Intelij-blue) 
![NetBeans](https://img.shields.io/badge/Technology-NetBenas-blue) 
![Eclipse](https://img.shields.io/badge/Technology-Eclipse-blue) 
![Postman](https://img.shields.io/badge/Technology-Postman-blue) 
![MySQLWoekbench](https://img.shields.io/badge/Database-MySQLWorkbench-blue) 
![ApacheTomcat9](https://img.shields.io/badge/Database-ApacheTomcat9-blue) 



## Introduction

This system was developed to help the administration of the fire alarm system to easily handle and monitor fire alarm sensor details such as adding a new sensor to the system update or delete an existing sensor and to display or send all sensor details with respective alerts to end users who are registered in the system for a given time. (if there is a fire detected by sensor alert will be send as an email and a SMS ,Web application users will get updated sensor details for every 40 seconds ,desktop users will receive the updated data for every 30 seconds and all kind of users get updated alerts for every 15 seconds) .So to cater these functionalities ,this system contains with 5 different applications , one REST API one web application one RMI server one desktop client who is using the services of RMI Server and a Sensor Application who provide sensor details by working as multiple sensors(This application consists different threads for every single sensor in the system .These threads work as sensors in runtime to produce sensor details for every 10 seconds ).

## Overview Diagram

<p align="middle">
  <img src="../master/ui-images/overview.jpg"/>
 </p>

 ## Some interface of the system
 
 <p align="middle">
  <img src="../master/ui-images/splash.PNG"/>
 </p>
 <p align="middle">
  <img src="../master/ui-images/UI1.PNG"/>
 </p>
 <p align="middle">
  <img src="../master/ui-images/UI2.PNG"/>
 </p>
 <p align="middle">
  <img src="../master/ui-images/UI3.PNG"/>
 </p>
 <p align="middle">
  <img src="../master/ui-images/UI4.PNG"/>
 </p>
 <p align="middle">
  <img src="../master/ui-images/UI5.PNG"/>
 </p>
 <p align="middle">
  <img src="../master/ui-images/UI6.PNG"/>
 </p>
 
 
 ## Configurations
 
 ### Steps
 
 #### 1)Download and extract the zip file 
 
 ***Steps to follow for the rest-services-provider project(Rest API + web Client)***
 
 *  This project contains the rest-services-provider(Rest API) and the web client application.
 *  Open project using an IDE(Tested with Intelij IDE) then resolve the dependencies of spring boot and react js applications suing the maven and npm.
 *  After resolving the dependenicies , first run the RestServicesProviderApplication(Spring boot project) class then the REST API will be started.
 *  Then go to the  directory src->webapp->front-end ,open a terminal and tyoe npm start command then the web client will start in the port 3000.
 
 
 ***Steps to follow for DS_Project(RMI server + desktop client)  project***
 
 *  Open the DS_Project in a IDE ,after that add jaxrs-ri and jersey-media-moxy all jar files as external jar files to the project.
 *  Then go to the root directory of the project through a command line and start the rmi registry by typing the command of start rmiregistry on the commandLine.
 *  After that move to com.dsassignement.server package and run the RmiServer class to start the RMI Server.
 *  Then to start the desktop client move to com.dsassignment.client package and run the splash class.
 
 ***Steps to follow for fire-alarm-sensor  project***
 
 *  Open the fire-alarm-sensor project using an IDE and resolve the maven dependencies please import the project as a maven project to the IDE.
 *  Run the SensorHandling class inside com.programmingfoundation.fire_alarm_sensor.controller package to start the application.
 

 ## 👨🏼‍💻 Contributors
 
 ### System designing and complete source code written by
* Hasindu Dahanayake(My self)


 
 ### Final report documentation work
 
 * My self and other three members
   


You can also follow my GitHub Profile to stay updated about my latest projects: [![GitHub Follow](https://img.shields.io/badge/Connect-Hasindu1-blue.svg?logo=Github&longCache=true&style=social&label=Follow)](https://github.com/Hasindu1)

If you liked the repo then please support it by giving it a star ⭐!
 
 
 ## License
[![MIT](https://img.shields.io/cocoapods/l/AFNetworking.svg?style=style&label=License&maxAge=2592000)](../master/LICENSE)


Copyright (c) 2020-present,Hasindu Dahanayake

 
 
