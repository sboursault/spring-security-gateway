# spring-security-gateway

## frontend

"
In this case we are going to use angular-cli to prepare a bootstrapped empty Angular application.

The Angular application should be placed in the project’s directory ./src/main/webapp. The easiest way to achieve this is to open a terminal, navigate to ./src/main in the project’s root and execute the following Angular CLI command:
ng new webapp
	
    cd frontend/src/main
    ng new frontend-ui
    mv frontend-ui angular
    
"


    cd frontend/src/main
    ng new frontend-ui
    mv frontend-ui angular

in angular.json, change the "outputPath" to "dist/static"

in the build.gradle, declare the src/main/angular/dist as a resource folder:

    def angularAppDir = "$projectDir/src/main/angular"
    sourceSets {
        main {
            resources {
                srcDirs = ["$angularAppDir/dist", "$projectDir/src/main/resources"]
            }
        }
    }

## whisky-api

an api server provides a list of whiskies:

    # run the server api
    $ ./gradlew :whisky-api:bootRun

    # request the api   
    $ curl -i http://localhost:8090/v1/whiskies
    
      HTTP/1.1 200 
      Content-Type: application/json;charset=UTF-8
      ...
       [{"id":"penguin_1234","firstname":"Oswald","lastname":"Cobblepot"}, ... ]
    
    
## Resources

Whisky descriptions were picked from https://www.whiskyshop.com

https://blog.marcnuri.com/angular-spring-boot-integration-gradle/