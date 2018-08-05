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
    
### Adding bootstrap theme

Adding Bootstrap

You can add basic Twitter Bootstrap features to make the app look a bit less dull (taken from this blog):

    npm install bootstrap@3 jquery --save

and update angular.json as follows:

    "styles": [
      "styles.css",
      "../node_modules/bootstrap/dist/css/bootstrap.min.css"
    ],
    "scripts": [
      "../node_modules/jquery/dist/jquery.min.js",
      "../node_modules/bootstrap/dist/js/bootstrap.min.js"
    ],

## advertising-api

The advertising-api application exposes a rest api to retrieve commercial banners.

    # run the app
    $ ./gradlew :advertising-api:bootRun

    # request the api   
    $ curl -i http://localhost:8095/v1/banners/001
    
      HTTP/1.1 200 
      Content-Type: application/json;charset=UTF-8
      ...
      {"id":"001","html":"Discover exceptional drinks on great-drinks.com !"}
      
The advertising api is called directly from the js application.
This requires the api to support the CORS protocol, which involves a "pre-flight" OPTIONS request and some headers to list the allowed behaviour of the caller.

## drinks-api

The drinks-api application exposes a rest api to retrieve whiskies.

    # run the server api
    $ ./gradlew :drinks-api:bootRun

    # request the api   
    $ curl -i http://localhost:8090/v1/whiskies
    
      HTTP/1.1 200 
      Content-Type: application/json;charset=UTF-8
      ...
      [{"id":"001","name":"Cardhu Special Cask Reserve", ... ]
    
    
## Resources

Whisky descriptions were picked from https://www.whiskyshop.com

https://blog.marcnuri.com/angular-spring-boot-integration-gradle/
https://github.com/dsyer/spring-boot-angular

bootstrap documentation: https://getbootstrap.com/docs/4.1/getting-started/introduction/

## TODO

- https
- logout
- zuul mapping (eg. /api/drinks/v1/whiskies/567 -> another-host/v1/whiskies/567)
- align spring boot versions
- test "/trace"
- restrict access with "server.address: 127.0.0.1"

