# spring-security-gateway


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
