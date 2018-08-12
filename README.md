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
      
      curl -X POST --user 'frontend:secret' -d 'grant_type=password&username=bill&password=123' http://localhost:8090/oauth/token
      curl -i -H "Accept: application/json" -H "Authorization: Bearer f5e417ac-f4d3-480e-829f-cd4934126ec9" http://localhost:8090/v1/whiskies

    
## Resources

Whisky descriptions were picked from https://www.whiskyshop.com

https://blog.marcnuri.com/angular-spring-boot-integration-gradle/
https://github.com/dsyer/spring-boot-angular

bootstrap documentation: https://getbootstrap.com/docs/4.1/getting-started/introduction/

https://spring.io/guides/tutorials/spring-security-and-angular-js/
https://gigsterous.github.io/engineering/2017/03/01/spring-boot-4.html

https://www.baeldung.com/spring-security-oauth-jwt

## TODO

- httpsd
- logout
- test "/trace"
- restrict access with "server.address: 127.0.0.1"
- separate auth and resource server
  -> how will the resource server get the username, user groups, etc. jwt token store ?
  
  
- reduce resource visibility (eg. only my votes...)
- client implementation



