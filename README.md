# lbc_fizzbuzz
Take home project whose objective is to build a production ready fizzbuzz
web server. 


# Run application
To run the application locally:
- install docker
- navigate to the project folder
- open a terminal and type the following : 'docker-compose up'
- open a browser and go to http://localhost:8080/swagger-ui/index.html#/

Alternatively
- install and config Maven 3.8 (or later)
- install mysql 8.0
- install and config a Jdk version 17 (or later)
- modify the application.properties of the project to include your mysql configs
- build the project using maven from a terminal or ide (type: 'mvn clean package')
- from a terminal or ide type: 'mvn spring-boot:run'

# Routes
Two routes have been developed.
- /fizzbuzz It generates the requested fizzbuzz
- /fizzbuzz/statistics It returns the most commonly requested fizzbuzz