# scoreboard-obs-quarkus

This project retrieves every second the latest game info from the RPI basketball scoreboard and dumps it into text files so OBS can include the details in the video stream.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
sdk install java 21.0.1-zulu

sdk user java 21.0.1-zulu
    
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

Install Graal
```shell script
sdk install java 21-graalce

sdk use java 21-graalce
 
export GRAALVM_HOME=$HOME/Development/graalvm/Contents/Home/
```

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/scoreboard-obs-quarkus-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Scheduler ([guide](https://quarkus.io/guides/scheduler)): Schedule jobs and tasks

