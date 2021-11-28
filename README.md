# Clarify - Academic discussion forum
## Submission for Microsoft Engage 2022 🔥

![Tests](https://github.com/Satyam6623165/clarify/actions/workflows/maven.yml/badge.svg)
[![codecov](https://codecov.io/gh/Satyam6623165/clarify/branch/main/graph/badge.svg?token=8YX25N89DO)](https://codecov.io/gh/Satyam6623165/clarify)

<p align="center">
  <img  src="https://drive.google.com/uc?export=view&id=1e4hM-5jtJHVUl6NVACDFDB5e16UO1Fla" style="width: 50%;">
</p>

- This is the backend of the clarify web application made with Spring boot. 
- The application is containerised using docker to enable hassle free local dev setup. 
- For the database mongodb has been used and the application is connected to a Mongodb Atlas cluster (Use free mongodb Atlas cluster which provides 512Mb space). 

## Setting up Locally

* Install [docker](https://www.docker.com)
* Setup a mongodb [Atlas cluster](https://www.mongodb.com/cloud/atlas/register)
* Go the root directory of the system
* Change the application.yml file to point to the mongodb uri of your own cluster.
* Run `docker build -t ${imageName}`
* After the build process is complete , run `docker run -p 8080:8080 ${imageName}`.
* The tomcat server is up and running, we can use postman now to test the apis. 

