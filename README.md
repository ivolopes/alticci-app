# alticci Project

The application was developed using Quarkus. The application is using Java 17, then the computer where it will be 
compiled needs to have this java's version installed. 

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Application information

- The application was set up to run in the 8080 port.
- The URL to access the swagger is http://localhost:8080/swagger-ui/
- And if wanting to get the alticci sequence, it is possible through 
this API endpoint (http://localhost:8080/alticci/{n}).